/*
 * 文  件  名:  HttpAsyncTask.java
 * 创建日期:  2014-1-28/下午2:32:45
 * 版       权:  pengqinping@mail.com, All rights reserved
 * 作       者:  pengqinping
 * 座 右  铭:  想要看到璀璨的星空，就要忘记平趟的大地
 */
package com.jd.open.sdk.android.util;

import org.json.JSONException;
import org.json.JSONObject;

import android.content.Context;
import android.os.AsyncTask;
import android.os.Bundle;
import android.text.TextUtils;

import com.jd.open.sdk.android.JdException;
import com.jd.open.sdk.android.JdListener;
import com.jd.open.sdk.android.api.InvokeError;
import com.twp.frame.util.Logger;
import com.twp.frame.util.NetWorkCheck;

/**
 * $功能描述 : $创建时间 : 2014-1-28/下午2:32:45 $创建人 : Administrator
 */
public class HttpAsyncTask extends AsyncTask<Bundle, Integer, Object> {

	private static final String TAG = "HttpAsyncTask";

	private JdListener.RequestListener mJdlistener;
	private String transitionId;
	private Context mContext;

	public HttpAsyncTask(Context mContext,
			JdListener.RequestListener mJdlistener, String transitionId) {
		super();
		this.mJdlistener = mJdlistener;
		this.transitionId = transitionId;
		this.mContext = mContext;
	}

	@Override
	protected void onPreExecute() {
		Logger.i(TAG, "begin asyncTask ----- transitionId=" + transitionId);
	}

	@Override
	protected Object doInBackground(Bundle... params) {
		if (!NetWorkCheck.isOpenNetwork(mContext)) {
			return new JdException("no network connection .",
					JdException.ERRORCODE_RESQUEST_NETWORK_ERROR);
		}
		return request(params);
	}

	@Override
	protected void onPostExecute(Object result) {
		Logger.i(TAG, "end asyncTask ----- transitionId = " + transitionId);
		handleResponse(result);
	}

	@Override
	protected void onCancelled() {
		Logger.i(TAG, "Cancelled asyncTask ----- transitionId=" + transitionId);
	}

	/**
	 * 处理接口返回的数据
	 * 
	 * @param response
	 *            调用api接口返回的数据
	 * @param listener
	 *            请求回调的监听器
	 */
	public void handleResponse(Object response) {
		// listener不能为空
		if (mJdlistener == null) {
			Logger.e(TAG, "RequestListener must not be null.");
			throw new IllegalArgumentException(
					"RequestListener must not be null.");
		}

		// API调用过程出现异常
		if (response instanceof Exception) {
			mJdlistener.onJdError(transitionId, ((JdException) response));
		}

		// API调用成功
		else if (response instanceof String) {
			try {
				JSONObject json = new JSONObject((String) response);
				InvokeError error = parseJson(json);
				// 接口调用失败
				if (error != null) {
					mJdlistener.onError(transitionId, error);
				} else {
					mJdlistener.onComplete(transitionId, json);
				}
			} catch (JSONException e) {
				JdException ex = new JdException(e.toString(),
						JdException.ERRORCODE_RESPONSE_FORMAT_ERROR);
				mJdlistener.onJdError(transitionId, ex);
			}
		} else {
			JdException ex = new JdException("Impossible result!",
					JdException.ERRORCODE_RESPONSE_FORMAT_ERROR);
			mJdlistener.onJdError(transitionId, ex);
		}
	}

	/**
	 * 请求API数据
	 * 
	 * @param params
	 *            请求所需要的参数
	 * @return 请求返回的数据
	 */
	public Object request(Bundle... params) {
		try {
			Bundle requestParam = params[0];
			Bundle systemParam = params[1];
			return WebUtils.request(requestParam, systemParam);
		} catch (Exception e) {
			JdException ex = new JdException(e.toString(),
					JdException.ERRORCODE_RESQUEST_NETWORK_ERROR);
			return ex;
		}
	}

	/**
	 * 解析json格式的数据，封装成APIError对象
	 * 
	 * @param json
	 *            json格式的数据
	 * @throws JSONException
	 * @return InvokeError
	 */
	private InvokeError parseJson(JSONObject json) throws JSONException {
		JSONObject jsonObject = json.optJSONObject("error_response");
		if (jsonObject == null) {
			return null;
		}

		String code = jsonObject.optString("code");
		String zhDesc = jsonObject.optString("zh_desc");
		String enDesc = jsonObject.optString("en_desc");

		if (TextUtils.isEmpty(code)) {
			return null;
		}

		InvokeError error = new InvokeError();
		error.setErrorCode(code);
		error.setErrorZHMessage(zhDesc);
		error.setErrorENMessage(enDesc);
		return error;
	}

}
