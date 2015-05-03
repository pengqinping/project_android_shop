/*
 * 版       权:  Royal.k.peng@gmail.com, All rights reserved
 * 作       者:  Royal
 * 座 右  铭:  Never give up, adhere to in the end.
 */
package com.twp.shopping.activity;

import android.app.ActionBar;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.Toast;

import com.twp.frame.util.Logger;
import com.twp.frame.util.NetWorkCheck;
import com.twp.shopping.R;
import com.twp.shopping.ui.WaitDialog;

/**
 * fragment基类。必须依附于MainTabActivity.如果没有依附于MainTabActivity 不要使用里面的属性，mActivity.
 * <p>
 * 所有fragment子类的设计，在调用
 * {@link BaseFragment#onChileCreateView(LayoutInflater, ViewGroup, Bundle)}
 * 的时候先返回一个 空的布局。然后根据请求结果再，先填充进去然后在add到空布局中。
 * 
 * @author Royal
 * @Email Royal.k.peng@gmail.com
 */
public abstract class BaseFragment extends Fragment {

	private static final String TAG = "BaseFragment";

	protected MainTabActivity mActivity;

	// UI Handler constant
	protected static final int HANDLER_RESULT_REQ = 10000;
	protected static final int HANDLER_RESULT_NODATA = 10001;
	protected static final int HANDLER_RESULT_ERROR = 10002;
	protected static final int HANDLER_RESULT_FNISH = 10003;
	protected static final int HANDLER_RESULT_NEXT = 10004;
	protected static final int HANDLER_RESULT_NOCONNCTION = 10005;
	protected UIHandler uiHandler;

	// netWorkSetting back result CODE
	protected static final int ACTIVITYR_ESULTCODE_NONETWORK = 1;

	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container,
			Bundle savedInstanceState) {
		Logger.i("------Base onCreateView-------"+NetWorkCheck.isOpenNetwork(getActivity()));
		if (NetWorkCheck.isOpenNetwork(getActivity())) {
			return onChileCreateView(inflater, container, savedInstanceState);
		}
		return getNoNetWorkView();
	}

	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setHasOptionsMenu(true);
		Logger.i("------Base onCreate-------");
		uiHandler = new UIHandler();
		mActivity = (MainTabActivity) getActivity();
	}

	@Override
	public void onResume() {
		super.onResume();
	}

	@Override
	public void onCreateOptionsMenu(Menu menu, MenuInflater inflater) {
		super.onCreateOptionsMenu(menu, inflater);
		Logger.i(TAG, ">>>>>>  onCreateOptionsMenu  <<<<<");
		ActionBar actionbar = getActivity().getActionBar();
		actionbar.setDisplayHomeAsUpEnabled(true);
		actionbar.setTitle(getResources().getString(getActionTitle()));
	}

	public abstract int getActionTitle();

	// child override this method;
	public abstract View onChileCreateView(LayoutInflater inflater,
			ViewGroup container, Bundle savedInstanceState);

	public static void proccessWaitDialog(WaitDialog waitdialog, boolean isShow) {
		if (isShow) {
			if (null != waitdialog && !waitdialog.isShowing()) {
				waitdialog.show();
			}
		} else {
			if (null != waitdialog && waitdialog.isShowing()) {
				waitdialog.cancel();
				waitdialog.dismiss();
			}
		}

	}

	/**
	 * 
	 * @author Royal
	 * @Email Royal.k.peng@gmail.com
	 * @return 没有网络连接的时候返回一个
	 */
	protected View getNoNetWorkView() {
		View view = LayoutInflater.from(mActivity).inflate(
				R.layout.common_nonetwork, null);
		view.findViewById(R.id.btnNoNetWork).setOnClickListener(
				new OnClickListener() {

					@Override
					public void onClick(View v) {
						startActivityForResult(new Intent(
								android.provider.Settings.ACTION_SETTINGS),
								ACTIVITYR_ESULTCODE_NONETWORK);
					}
				});
		return view;
	}

	// 网络设置回调
	@Override
	public void onActivityResult(int requestCode, int resultCode, Intent data) {

		super.onActivityResult(requestCode, resultCode, data);
		mActivity.isNetConnect = NetWorkCheck.isOpenNetwork(mActivity);
		onNetWorkSettingActivityResult(requestCode, resultCode, data);
	}

	public abstract void onNetWorkSettingActivityResult(int requestCode,
			int resultCode, Intent data);

	protected View getNoDataView() {
		return LayoutInflater.from(mActivity).inflate(R.layout.common_nodata,
				null);
	}

	protected abstract void handleUIMessage(Message msg);

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

	public static void toastLong(Context context, String msg) {
		Toast.makeText(context, msg, Toast.LENGTH_LONG).show();
	}

	public static void toastShort(Context context, String msg) {
		Toast.makeText(context, msg, Toast.LENGTH_SHORT).show();
	}

}
