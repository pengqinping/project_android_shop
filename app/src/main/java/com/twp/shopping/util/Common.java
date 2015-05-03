/*
 * 文  件  名:  Common.java
 * 创建日期:  2014-3-2/上午9:48:12
 * 版       权:  Royal.k.peng@gmail.com, All rights reserved
 * 作       者:  Royal
 * 座 右  铭:  Never give up, adhere to in the end.
 */
package com.twp.shopping.util;

import android.content.Context;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;

import com.twp.shopping.MyApplication;

/**
 * 
 * @author Royal
 * @Email Royal.k.peng@gmail.com
 */
public final class Common {
	/**
	 * 获取版本号。
	 * 
	 * @param cls
	 * @return
	 */
	public static String getVersionName() {

		try {
			Context context = MyApplication.getContext();

			PackageInfo pinfo = context.getPackageManager()
					.getPackageInfo(context.getPackageName(),
							PackageManager.GET_CONFIGURATIONS);

			return pinfo.versionName;
		} catch (Exception e) {
			return "1.0";
		}
	}

}
