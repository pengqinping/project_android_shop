/*
 * 文  件  名:  FeedbackActivity.java
 * 创建日期:  2014-7-1/上午10:46:19
 * 版       权:  Royal.k.peng@gmail.com, All rights reserved
 * 作       者:  Royal
 * 座 右  铭:  Never give up, adhere to in the end.
 */
package com.twp.shopping.activity;

import android.app.ActionBar;
import android.content.Intent;
import android.os.Bundle;
import android.os.Message;
import android.view.MenuItem;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;

import com.twp.frame.util.EmptyUtil;
import com.twp.shopping.R;

/**
 * @Ctime 2014-7-1/上午10:46:19
 * @author Royal
 * @DESC  描述反馈
 */
public class FeedbackActivity extends BaseActivity {

	private EditText etTitle;
	private EditText etContent;
	private Button btncanel;
	private Button btnSend;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_feedback);
		ActionBar actionBar = getActionBar();
		actionBar.setDisplayHomeAsUpEnabled(true);
		etTitle = (EditText) findViewById(R.id.feedbackTitle);
		etContent = (EditText) findViewById(R.id.feedbackContent);
		btncanel = (Button) findViewById(R.id.feedbackCanel);
		btnSend = (Button) findViewById(R.id.feedbackSendMail);

		btnSend.setOnClickListener(new OnClickListener() {

			@Override
			public void onClick(View v) {
				//主题可以为空，但是内容不能为空
				String conetnt = etContent.getText().toString();
				if (EmptyUtil.isStringEmpty(conetnt) || conetnt.length() < 10) {
					toastShort("输入内容不符合条件!不能发送");
				} else {
					String title = etTitle.getText().toString();
					sendMail(title, conetnt);
				}
			}
		});

		btncanel.setOnClickListener(new OnClickListener() {

			@Override
			public void onClick(View v) {
				back();
			}
		});
	}

	@Override
	public boolean onOptionsItemSelected(MenuItem item) {
		if(item.getItemId() == android.R.id.home){
			back();
		}
		return super.onOptionsItemSelected(item);
	}
	
	public void back() {
		finish();
	}

	public void sendMail(String title, String content) {
		//建立Intent对象
		Intent intent = new Intent();
		//设置对象动作
		intent.setAction(Intent.ACTION_SEND);
		intent.setType("plain/text");
		//设置对方邮件地址
		intent.putExtra(Intent.EXTRA_EMAIL, new String[] {
				"pengqinping@hotmail.com", "737692932@qq.com" });
		//设置标题内容
		intent.putExtra(Intent.EXTRA_SUBJECT, "【Shopping】" + title);
		//设置邮件文本内容
		intent.putExtra(Intent.EXTRA_TEXT, "" + content);
		/* 启动一个新的ACTIVITY,"Sending mail..."是在启动这个 
		  ACTIVITY的等待时间时所显示的文字*/
		startActivity(Intent.createChooser(intent, "选择发送"));
	}

	@Override
	public void handleUIMessage(Message msg) {

	}

}
