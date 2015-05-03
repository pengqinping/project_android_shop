/*
 * 文  件  名:  AboutUsActivity.java
 * 创建日期:  2014-7-1/下午12:41:06
 * 版       权:  Royal.k.peng@gmail.com, All rights reserved
 * 作       者:  Royal
 * 座 右  铭:  Never give up, adhere to in the end.
 */
package com.twp.shopping.activity;

import android.app.ActionBar;
import android.os.Bundle;
import android.os.Message;
import android.view.MenuItem;
import android.webkit.WebView;

import com.twp.shopping.R;

/**
 * @Ctime 2014-7-1/下午12:41:06
 * @author Royal
 * @DESC 
 */
public class AboutUsActivity extends BaseActivity {

	@Override
	public void handleUIMessage(Message msg) {

	}

	private WebView webView;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_about_us);
		webView = (WebView) findViewById(R.id.wvAboutUs);
		webView.loadUrl("file:///android_asset/AboutUs.html");

		ActionBar actionBar = getActionBar();
		actionBar.setDisplayHomeAsUpEnabled(true);
	}

	@Override
	public boolean onOptionsItemSelected(MenuItem item) {
		if (item.getItemId() == android.R.id.home) {
			finish();
		}
		return super.onOptionsItemSelected(item);
	}

}
