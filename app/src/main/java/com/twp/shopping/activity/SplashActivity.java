package com.twp.shopping.activity;

import android.app.Activity;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.preference.PreferenceManager;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.ImageView.ScaleType;

import com.twp.frame.util.Logger;
import com.twp.shopping.R;
import com.twp.shopping.ui.ads.CircleFlowIndicator;
import com.twp.shopping.ui.ads.ViewFlow;
import com.twp.shopping.ui.ads.ViewFlow.ViewSwitchListener;
import com.twp.shopping.util.Constants;

//第一次进入判断是否是应用第一次使用，来判断是否展示引导页。
public class SplashActivity extends Activity {

	private static final String TAG = "SplashActivity"; 
	private ViewFlow splashViewFlow ;
	private Button enterMain;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		SharedPreferences sp = PreferenceManager
				.getDefaultSharedPreferences(this);
		boolean isFirst = sp.getBoolean(Constants.KEY_SP_ISFIRST_START, true);
		if(isFirst){
			//1.TODO 展现引导页
			showSplash();
			//2.设置第一次启动为false
			sp.edit().putBoolean(Constants.KEY_SP_ISFIRST_START, false).commit();
		}else{
			//跳转首页
			jumpMainActivity();
		}
	}
	
	private void showSplash(){
		setContentView(R.layout.activity_splash);
		splashViewFlow = (ViewFlow)findViewById(R.id.splashViewFlow);
		enterMain = (Button)findViewById(R.id.enterMain);
		splashViewFlow.setAdapter(new SplashAdapter());
		CircleFlowIndicator circeFlowIndicator = (CircleFlowIndicator)findViewById(R.id.splashCircleInicator);
//		circeFlowIndicator.setViewFlow(splashViewFlow);
		splashViewFlow.setFlowIndicator(circeFlowIndicator);
		splashViewFlow.setOnViewSwitchListener(new ViewSwitchListener() {
			
			@Override
			public void onSwitched(View view, int position) {
				if(view instanceof ImageView){
					Logger.i("TAG"," adapter View is IamgeView . ");
					if(position == SPLASH_RESID.length-1){
						//最后一页显示跳转按钮
						enterMain.setVisibility(View.VISIBLE);
					}else{
						//其他页隐藏
						if(enterMain.getVisibility() == View.VISIBLE){
							enterMain.setVisibility(View.GONE);
						}
					}
				}
			}
		});
		
		enterMain.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View v) {
				jumpMainActivity();
			}
		});
	}
	private void jumpMainActivity(){
		startActivity(new Intent(SplashActivity.this,MainTabActivity.class));
		finish();
	}
	private static final int[] SPLASH_RESID = new int[]{R.drawable.splash_01,R.drawable.splash_02,R.drawable.splash_03,R.drawable.splash_04};
	private class SplashAdapter extends BaseAdapter{
		@Override
		public int getCount() {
			return SPLASH_RESID.length;
		}

		@Override
		public Object getItem(int position) {
			return SPLASH_RESID[position];
		}

		@Override
		public long getItemId(int position) {
			return position;
		}

		@Override
		public View getView(int position, View convertView, ViewGroup parent) {
			ImageView image = new ImageView(SplashActivity.this);
			image.setScaleType(ScaleType.FIT_XY);
			image.setLayoutParams(new LayoutParams(LayoutParams.MATCH_PARENT, LayoutParams.MATCH_PARENT));
			image.setImageResource(SPLASH_RESID[position]);
			return image;
		}
		
	}
}
