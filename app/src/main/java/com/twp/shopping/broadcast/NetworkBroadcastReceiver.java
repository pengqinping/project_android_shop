/*
 * 文  件  名:  NetworkBroadcastReceiver.java
 * 创建日期:  2014-10-13/上午1:20:10
 * 版       权:  Royal.k.peng@gmail.com, All rights reserved
 * 作       者:  Royal
 * 座 右  铭:  Never give up, adhere to in the end.
 */
package com.twp.shopping.broadcast;

import com.twp.frame.util.NetWorkCheck;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.net.ConnectivityManager;
import android.widget.Toast;

/**
 * @Ctime 2014-10-13/上午1:20:10
 * @author Royal
 * @DESC 
 */
public class NetworkBroadcastReceiver extends BroadcastReceiver {

	@Override
	public void onReceive(Context context, Intent intent) {
		String action = intent.getAction();
		if (ConnectivityManager.CONNECTIVITY_ACTION.equals(action)) {
			if (!NetWorkCheck.isOpenNetwork(context)) {
				String tip = "没有网络连接";
				Toast.makeText(context, tip, Toast.LENGTH_LONG).show();
			} else {
				if (NetWorkCheck.isMoblieNet(context)) {
					Toast.makeText(context, "当前使用的是数据流量!", Toast.LENGTH_LONG).show();
				}
			}
		}

	}
}
