package com.twp.shopping.activity;

import com.twp.shopping.R;

import android.app.Activity;
import android.app.ProgressDialog;
import android.content.Intent;
import android.graphics.Bitmap;
import android.os.Bundle;
import android.view.Window;
import android.webkit.WebView;
import android.webkit.WebViewClient;

/**
 * 跳转m端购买页面
 * 使用webView 加载
 */
public class WareBuyWebViewActivity extends Activity {

    ProgressDialog mDialog;

    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.ware_buy_webview);

        mDialog = new ProgressDialog(this);
        mDialog.requestWindowFeature(Window.FEATURE_NO_TITLE);
        mDialog.setMessage("加载中，请稍后...");
        WebView view = (WebView) findViewById(R.id.ware_buy_webview);
        Intent intent = getIntent();
        String url = intent.getStringExtra("url");
        view.loadUrl(url);

        view.setWebViewClient(new WebViewClient(){
            @Override
            public boolean shouldOverrideUrlLoading(WebView view, String url) {
                view.loadUrl(url);
                return true;
            }

            @Override
            public void onPageStarted(WebView view, String url, Bitmap favicon) {
                super.onPageStarted(view, url, favicon);
                mDialog.show();
            }

            @Override
            public void onPageFinished(WebView view, String url) {
                super.onPageFinished(view, url);
                mDialog.dismiss();
            }
        });
    }
}