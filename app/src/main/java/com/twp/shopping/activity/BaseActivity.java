/*
 * 文  件  名:  BaseActivity.java
 * 创建日期:  2014-3-2/下午11:06:02
 * 版       权:  Royal.k.peng@gmail.com, All rights reserved
 * 作       者:  Royal
 * 座 右  铭:  Never give up, adhere to in the end.
 */
package com.twp.shopping.activity;

import com.jd.open.sdk.android.JdAndroidClient;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.widget.Toast;

/**
 * Activity base类
 * @Ctime 2014-3-2/下午11:06:02
 * @author Royal
 * @DESC 
 */
public abstract class BaseActivity extends Activity {

	
	protected UIHandler uiHandler;
	protected static final int HANDLER_RESULT_REQ = 10000;
	protected static final int HANDLER_RESULT_NODATA = 10001;
	protected static final int HANDLER_RESULT_ERROR = 10002;
	protected static final int HANDLER_RESULT_FNISH = 10003;
	protected static final int HANDLER_RESULT_NEXT = 10004;
	protected static final int HANDLER_RESULT_NOCONNCTION = 10005;
	public static JdAndroidClient client = JdAndroidClient.getInstance();
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		uiHandler = new UIHandler();
		
		client.setSandBoxEnv(false);
		client.setAppKey("A026340C56E3A377C826C81F9466B326");
		client.setAppSecret("d5c1e80bac6041089be1bc85dde79c6b");
		client.setAccessToken("b04c77ee-18eb-4c14-9b1e-c5861ec097e9");
	}
	
	/**
	 * 处理界面变化处理。
	 * 
	 * @author Royal
	 * @Email Royal.k.peng@gmail.com
	 */
	class UIHandler extends Handler {
		@Override
		public void handleMessage(Message msg) {
			super.handleMessage(msg);
			handleUIMessage(msg);
		}
	}
	
	public abstract void handleUIMessage(Message msg);
	
	
	//
	//
	public void toastLong(Context context, String msg) {
		Toast.makeText(context, msg, Toast.LENGTH_LONG).show();
	}

	public void toastShort(Context context, String msg) {
		Toast.makeText(context, msg, Toast.LENGTH_SHORT).show();
	}
	
	protected void toastShort(String msg){
		toastLong(this, msg);
	}
	
	protected void toastLong(String msg){
		toastLong(this, msg);
	}
	
}
