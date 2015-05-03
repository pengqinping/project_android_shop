/*
 * 版       权:  Royal.k.peng@gmail.com, All rights reserved
 * 作       者:  Royal
 * 座 右  铭:  Never give up, adhere to in the end.
 */
package com.twp.shopping.activity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.os.Message;
import android.preference.PreferenceManager;
import android.view.ContextMenu;
import android.view.ContextMenu.ContextMenuInfo;
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.TextView;

import com.twp.frame.util.Logger;
import com.twp.shopping.R;
import com.twp.shopping.ui.JazzyViewPager.TransitionEffect;
import com.twp.shopping.util.ConfigDataUtil;
import com.twp.shopping.util.Constants;

/**
 * 
 * @author Royal
 * @Email Royal.k.peng@gmail.com
 */
public class MainFragmentSetting extends BaseFragment implements
		OnClickListener {

	private static final String TAG = "MainFragmentSetting";

	private TextView tvFeedback;
	private TextView tvAboutUs;
	private TextView tvClearCache;
	private TextView tvSetChangMode;
	private TextView txUseOrder;

	public static MainFragmentSetting newInstance() {
		MainFragmentSetting home = new MainFragmentSetting();
		Bundle arg = new Bundle();
		home.setArguments(arg);
		return home;
	}
	
	@Override
	public View onChileCreateView(LayoutInflater inflater, ViewGroup container,
			Bundle savedInstanceState) {
		Logger.i(TAG, ">>>> onChileCreateView <<<<");
		View rootView = inflater.inflate(R.layout.fragment_setting, null);
		tvFeedback = (TextView) rootView.findViewById(R.id.feedbook);
		tvAboutUs = (TextView) rootView.findViewById(R.id.aboutUs);
		tvClearCache = (TextView) rootView.findViewById(R.id.clearImageCache);
		txUseOrder = (TextView) rootView.findViewById(R.id.txUseOrder);
		tvSetChangMode = (TextView) rootView
				.findViewById(R.id.setViewPagerChangeMode);
		registerForContextMenu(tvSetChangMode);
		tvFeedback.setOnClickListener(this);
		tvAboutUs.setOnClickListener(this);
		tvClearCache.setOnClickListener(this);
		tvSetChangMode.setOnClickListener(this);
		txUseOrder.setOnClickListener(this);
		return rootView;
	}

	@Override
	public void onResume() {
		super.onResume();
	}

	@Override
	public void onNetWorkSettingActivityResult(int requestCode, int resultCode,
			Intent data) {

	}

	@Override
	protected void handleUIMessage(Message msg) {

	}

	@Override
	public int getActionTitle() {

		return R.string.tab_setting;
	}

	private void sendFeedback() {
		Intent intent = new Intent(getActivity(), FeedbackActivity.class);
		startActivity(intent);
	}

	private void clearImageCache() {
		ConfigDataUtil.getInstance().clearCache(getActivity());
		toastShort(getActivity(), "缓存清除成功!");
	}

	private void aboutUs() {
		Intent intent = new Intent(getActivity(), AboutUsActivity.class);
		startActivity(intent);
	}

	@Override
	public void onClick(View v) {
		switch (v.getId()) {
		case R.id.feedbook:
			sendFeedback();
			break;
		case R.id.clearImageCache:
			clearImageCache();
			break;
		case R.id.aboutUs:
			aboutUs();
			break;
		case R.id.setViewPagerChangeMode:
			break;
		case R.id.txUseOrder:
			SharedPreferences sp = PreferenceManager
					.getDefaultSharedPreferences(getActivity());
			//2.设置第一次启动为false
			sp.edit().putBoolean(Constants.KEY_SP_ISFIRST_START, true).commit();
			startActivity(new Intent(getActivity(), SplashActivity.class));
			break;
		default:
			break;
		}
	}

	/**
	 * 长按tvSetChangMode 触发这个菜单创建
	 */
	@Override
	public void onCreateContextMenu(ContextMenu menu, View v,
			ContextMenuInfo menuInfo) {
		Logger.i(TAG, ">>>> onCreateContextMenu");
		String[] effects = getResources().getStringArray(R.array.jazzy_effects);
		for (String effect : effects) {
			menu.add(effect);
		}
		super.onCreateContextMenu(menu, v, menuInfo);
	}

	@Override
	public boolean onContextItemSelected(MenuItem item) {
		SharedPreferences sp = PreferenceManager
				.getDefaultSharedPreferences(getActivity());
		String title = item.getTitle().toString();
		sp.edit().putString(Constants.KEY_SP_JAZZYVIEW_EFFECT, title).commit();
		TransitionEffect effect = TransitionEffect.valueOf(title);
		if (null != mActivity) {
			mActivity.changeViewPagerEffect(effect);
		}
		return super.onContextItemSelected(item);
	}

}