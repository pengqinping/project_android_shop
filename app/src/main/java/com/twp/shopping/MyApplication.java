/*
 * 版       权:  Royal.k.peng@gmail.com, All rights reserved
 * 作       者:  Royal
 * 座 右  铭:  Never give up, adhere to in the end.
 */
package com.twp.shopping;

import android.app.Application;

import com.twp.frame.util.Logger;
import com.twp.shopping.util.ConfigDataUtil;

/**
 * @author Royal
 * @Email Royal.k.peng@gmail.com
 */
public class MyApplication extends Application {

	private static final String TAG = "MyApplication";

	private static MyApplication instance;

	public static MyApplication getContext() {
		return instance;
	}

	/**
	 * 应用开启时调用这个方法
	 */
	@Override
	public void onCreate() {
		super.onCreate();
		ConfigDataUtil.getInstance().init(this);
		Logger.d(TAG, "leval Oncreate()");
	}

	@Override
	public void onLowMemory() {
		super.onLowMemory();
		Logger.i(TAG, "===onLowMemory===");
	}
	

}
