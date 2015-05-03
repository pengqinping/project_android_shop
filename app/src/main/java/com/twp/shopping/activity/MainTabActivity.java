/*
 * 版       权:  Royal.k.peng@gmail.com, All rights reserved
 * 作       者:  Royal
 * 座 右  铭:  Never give up, adhere to in the end.
 */
package com.twp.shopping.activity;

import java.util.HashMap;
import java.util.Map;

import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.os.Bundle;
import android.preference.PreferenceManager;
import android.support.v4.app.FragmentActivity;
import android.support.v4.view.ViewPager.OnPageChangeListener;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.TextView;
import android.widget.Toast;

import com.jd.open.sdk.android.Constants;
import com.jd.open.sdk.android.JdAndroidClient;
import com.jd.open.sdk.android.JdException;
import com.jd.open.sdk.android.JdListener.DialogListener;
import com.jd.open.sdk.android.auth.DialogError;
import com.twp.frame.util.EmptyUtil;
import com.twp.frame.util.Logger;
import com.twp.frame.util.NetWorkCheck;
import com.twp.shopping.R;
import com.twp.shopping.adapter.ViewPagerAdapter;
import com.twp.shopping.http.jd.APIInvoker;
import com.twp.shopping.ui.JazzyViewPager;
import com.twp.shopping.ui.JazzyViewPager.TransitionEffect;
import com.twp.shopping.ui.menu.MenuDrawer;
import com.twp.shopping.ui.menu.Position;

/**
 * 
 * @author Royal
 * @Email Royal.k.peng@gmail.com
 */
public class MainTabActivity extends FragmentActivity implements
		OnPageChangeListener {

	private static final String TAG = "MainTabActivity";
	private static final String STATE_ACTIVE_POSITION = "MainTabActivity.activePosition";
	private static final String TOKENFILE = "Token";

	//Menu
	protected MenuDrawer mMenuDrawer;
	private int mActivePosition = 0;
	private int mPagerOffsetPixels;
	private int mPagerPosition;
	private OnMenuSeletedListener mMenuSletedListener;
	private TextView mMenuHome;
	private TextView mMenuSearch;
	private TextView mMenuCollect;
	private TextView mMenuSetting;

	// jd request client
	public static JdAndroidClient client = JdAndroidClient.getInstance();

	// init view
	protected JazzyViewPager viewPager;
	private ViewPagerAdapter viewPagerAdapter;

	private int mCurrentScreenPosition;

	//保存Viewpagerselected事件
	private Map<String, ViewPagerSelectedListener> mViewPagerSeletedListener = new HashMap<String, ViewPagerSelectedListener>();

	//network connect
	protected boolean isNetConnect;

	//	private NetworkReceiver networkReceiver;

	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		Logger.v(TAG, "Enter into oncreate.");
		if (savedInstanceState != null) {
			mActivePosition = savedInstanceState.getInt(STATE_ACTIVE_POSITION);
		}
		//		networkReceiver = new NetworkReceiver();
		//		IntentFilter intentFilter = new IntentFilter(
		//				ConnectivityManager.CONNECTIVITY_ACTION);
		//		registerReceiver(networkReceiver, intentFilter);
		//TODO 1.检测网络连接
		// 1-2-1 不可用 --> 对话框提示用户
		// 1-2-2 可用     --> 提示网络类型 ，并且跳转
		checkNetConnectState();
		initData();
		//isAuthoSuccess();
		initView();
		Logger.v(TAG, "Leave oncreate.");
	}

	protected void checkNetConnectState() {
		if (isNetConnect = NetWorkCheck.isOpenNetwork(this)) {
			String type = NetWorkCheck.getNetWorkType(this);
			String key = getResources().getString(R.string.currentNetWork);
			Toast.makeText(this, key + type, Toast.LENGTH_LONG).show();
		} else {
			showNoConnectionTip();
		}
	}

	protected void showNoConnectionTip() {
		String title = "提示";
		String message = "当前网络不可用，应用的数据不准确是否退出应用程序?";
		String ok = "退出应用";
		String cancel = "继续进入";
		AlertDialog dialog = new AlertDialog.Builder(this)
				.setIcon(android.R.drawable.ic_dialog_alert)
				.setTitle(title)
				.setMessage(message)
				.setPositiveButton(ok, new DialogInterface.OnClickListener() {

					@Override
					public void onClick(DialogInterface dialog, int which) {
						dialog.dismiss();
						MainTabActivity.this.finish();
						android.os.Process.killProcess(android.os.Process
								.myPid());
					}
				})
				.setNegativeButton(cancel,
						new DialogInterface.OnClickListener() {

							@Override
							public void onClick(DialogInterface dialog,
									int which) {
								dialog.cancel();
								dialog.dismiss();
							}
						}).create();
		dialog.setCancelable(false);
		dialog.show();
	}

	@Override
	protected void onStart() {
		super.onStart();
	}

	@Override
	protected void onPause() {
		super.onPause();
	}

	@Override
	protected void onDestroy() {
		super.onDestroy();
		isNetConnect = false;
		//		if (null != networkReceiver) {
		//			unregisterReceiver(networkReceiver);
		//		}
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		return super.onCreateOptionsMenu(menu);
	}

	@Override
	public boolean onMenuOpened(int featureId, Menu menu) {
		return super.onMenuOpened(featureId, menu);
	}

	@Override
	public boolean onMenuItemSelected(int featureId, MenuItem item) {
		return super.onMenuItemSelected(featureId, item);
	}

	@Override
	public boolean onOptionsItemSelected(MenuItem item) {
		Logger.i(TAG, "enter into onOptionItemSelected ;");
		if (item.getItemId() == android.R.id.home) {
			mMenuDrawer.toggleMenu();
		}
		return super.onOptionsItemSelected(item);
	}

	@Override
	protected void onSaveInstanceState(Bundle outState) {
		super.onSaveInstanceState(outState);
		outState.putInt(STATE_ACTIVE_POSITION, mActivePosition);
	}

	// FIXME 发布版本请修改
	private boolean isAuthoSuccess() {
		// 判断是否需要鉴权，如果需要鉴权就去请求接口，如果不需要的话。就直接拿到Token去初始化页面。
		final SharedPreferences sp = getSharedPreferences(TOKENFILE,
				Context.MODE_PRIVATE);

		boolean isNeedAutho = false;
		// 是否保存了Token,
		if (sp.getBoolean("hasToken", false)) {
			// 对比时间是否到期
			// 授权时间点
			long time = sp.getLong(Constants.EXPIRES_TIME, 0l);

			// 失效时间
			long expires_in = sp.getLong(Constants.EXPIRES_IN, 0l);

			if (System.currentTimeMillis() < time) {
				Logger.i(TAG, "system timeMillis < autho time.");
				isNeedAutho = true;
			}
			if (System.currentTimeMillis() - time > expires_in) {
				Logger.i(TAG, "need to autho .");
				isNeedAutho = true;
			}

		} else {
			isNeedAutho = true;
		}

		if (!isNeedAutho) {
			String authToken = sp.getString(Constants.TOKEN, "");
			if (EmptyUtil.isStringNotEmpty(authToken)) {
				client.setAccessToken(authToken);
				initView();
				return true;
			}
		}

		String[] str = { "read" };
		APIInvoker.authorize(this, client, str, new DialogListener() {
			@Override
			public void onJdError(JdException e) {
				Logger.i(TAG, "onJdError " + e.toString());
			}

			@Override
			public void onError(DialogError e) {
				Logger.i(TAG, "onError " + e.toString());
			}

			@Override
			public void onComplete(Bundle values) {
				// 请求完成后 ，setToken 刷新布局
				String token = values.getString(Constants.TOKEN);
				client.setAccessToken(token);
				initView();

				Editor et = sp.edit();
				et.putBoolean("hasToken", true).commit();
				et.putString(Constants.REFRESH_TOKEN,
						values.getString(Constants.REFRESH_TOKEN)).commit();
				et.putString(Constants.TOKEN, token);
				et.putString(Constants.USER_NICK,
						values.getString(Constants.USER_NICK));
				String lTime = values.getString(Constants.EXPIRES_TIME);
				long time = 0;
				try {
					time = Long.parseLong(lTime);
				} catch (NumberFormatException e) {
					Logger.e(TAG, "NumberFormatException = e" + e.toString());
				}
				et.putLong(Constants.EXPIRES_TIME, time).commit();

				String sExpires_in = values.getString(Constants.EXPIRES_IN);
				long expires_in = 0;
				try {
					expires_in = Long.parseLong(sExpires_in);
				} catch (NumberFormatException e) {
					Logger.e(TAG, "NumberFormatException = e" + e.toString());
				}
				et.putLong(Constants.EXPIRES_IN, expires_in).commit();

			}

			@Override
			public void onCancel() {

			}
		});
		return true;
	}

	private void initData() {
		// 在线上环境测试
		client.setSandBoxEnv(false);
		client.setAppKey("A026340C56E3A377C826C81F9466B326");
		client.setAppSecret("d5c1e80bac6041089be1bc85dde79c6b");
		client.setAccessToken("3a734708-0fdf-42ee-b159-41ca27693b9a");
	}

	private void initView() {

		//menu 
		mMenuDrawer = MenuDrawer.attach(this, MenuDrawer.Type.BEHIND,
				getDrawerPosition(), getDragMode());

		mMenuDrawer.setContentView(R.layout.main_tab_layout);
		mMenuDrawer.setSlideDrawable(R.drawable.ic_drawer);
		mMenuDrawer.setDrawerIndicatorEnabled(true);

		mMenuDrawer.setMenuView(R.layout.app_menu_left);
		View menuView = mMenuDrawer.getMenuView();

		mMenuHome = (TextView) menuView.findViewById(R.id.menuHome);
		mMenuSearch = (TextView) menuView.findViewById(R.id.menuSearch);
		mMenuCollect = (TextView) menuView.findViewById(R.id.menuCollet);
		mMenuSetting = (TextView) menuView.findViewById(R.id.menuSetting);
		mMenuSletedListener = new OnMenuSeletedListener();
		mMenuHome.setOnClickListener(mMenuSletedListener);
		mMenuSearch.setOnClickListener(mMenuSletedListener);
		mMenuCollect.setOnClickListener(mMenuSletedListener);
		mMenuSetting.setOnClickListener(mMenuSletedListener);
		//view pager
		viewPager = (JazzyViewPager) findViewById(R.id.viewPager);
		viewPager.setFadeEnabled(false);
		SharedPreferences sp = PreferenceManager
				.getDefaultSharedPreferences(this);
		String effectString = sp.getString(
				com.twp.shopping.util.Constants.KEY_SP_JAZZYVIEW_EFFECT,
				"Tablet");
		TransitionEffect effect = TransitionEffect.valueOf(effectString);
		viewPager.setTransitionEffect(effect);
		viewPagerAdapter = new ViewPagerAdapter(getSupportFragmentManager(),
				viewPager);

		viewPager.setAdapter(viewPagerAdapter);
		viewPager.setOnPageChangeListener(this);

		getActionBar().setDisplayHomeAsUpEnabled(true);
		mMenuDrawer.setTouchMode(MenuDrawer.TOUCH_MODE_FULLSCREEN);
		mMenuDrawer
				.setOnInterceptMoveEventListener(new MenuDrawer.OnInterceptMoveEventListener() {
					@Override
					public boolean isViewDraggable(View v, int dx, int x, int y) {
						if (v == viewPager) {
							return !(mPagerPosition == 0 && mPagerOffsetPixels == 0)
									|| dx < 0;
						}

						return false;
					}
				});

	}

	protected int getDragMode() {
		return MenuDrawer.MENU_DRAG_CONTENT;
	}

	protected Position getDrawerPosition() {
		return Position.LEFT;
	}

	/**
	 * View Change called event.viewpager滑动切换的时候调用
	 */
	// #start
	@Override
	public void onPageScrollStateChanged(int arg0) {
	}

	@Override
	public void onPageScrolled(int position, float arg1,
			int positionOffsetPixels) {
		mPagerPosition = position;
		mPagerOffsetPixels = positionOffsetPixels;
	}

	@Override
	public void onPageSelected(int arg0) {

		mCurrentScreenPosition = arg0;
		String key = com.twp.shopping.util.Constants.FRAGMENT_IDENTIFY[arg0];
		if (EmptyUtil.isStringNotEmpty(key)) {
			if (mViewPagerSeletedListener.containsKey(key)) {
				mViewPagerSeletedListener.get(key).onPageSelected(arg0);
			}
			return;
		}
		Logger.i(TAG, ">>>> viewpagerSelected listener not exits , ");
	}

	// #end

	/**
	 * 当viewpager切换的时候，在fragment中能够通过这个接口收到消息
	 * @author Royal
	 * @Email Royal.k.peng@gmail.com
	 */
	public interface ViewPagerSelectedListener {
		void onPageSelected(int arg0);
	}

	/**
	 * 提供注册ViewpagerListener事件,
	 * 在fragment onCreateView 的时候调用，
	 * @author Royal
	 * @Email Royal.k.peng@gmail.com
	 * @param tag ,fragment 标识
	 * @param mListener ,实现 ViewPagerSelectedListener 接口的实例
	 */
	public void registerViewPagerListener(String tag,
			ViewPagerSelectedListener mListener) {
		if (!mViewPagerSeletedListener.containsKey(tag)) {
			mViewPagerSeletedListener.put(tag, mListener);
		}
	}

	/**
	 * 提供反注册ViewpagerListener事件,
	 * @author Royal 
	 * @Email Royal.k.peng@gmail.com
	 * @param tag fragment 标识
	 */
	public void unRegisterViewPagerListener(String tag) {
		if (mViewPagerSeletedListener.containsKey(tag)) {
			mViewPagerSeletedListener.remove(tag);
		}
	}

	@Override
	public void onBackPressed() {
		final int drawerState = mMenuDrawer.getDrawerState();
		if (drawerState == MenuDrawer.STATE_OPEN
				|| drawerState == MenuDrawer.STATE_OPENING) {
			mMenuDrawer.closeMenu();
			return;
		}

		super.onBackPressed();
	}

	private class OnMenuSeletedListener implements OnClickListener {

		@Override
		public void onClick(View v) {
			int seletedItem = 0;
			switch (v.getId()) {
			case R.id.menuHome:
				seletedItem = 0;
				break;
			case R.id.menuCollet:
				seletedItem = 2;
				break;
			case R.id.menuSearch:
				seletedItem = 1;
				break;
			case R.id.menuSetting:
				seletedItem = 3;
				break;
			default:
				break;
			}
			mMenuDrawer.closeMenu();
			if (mCurrentScreenPosition != seletedItem) {
				viewPager.setCurrentItem(seletedItem);
			}
		}

	}

	public void changeViewPagerEffect(TransitionEffect effect) {
		Logger.i(TAG,
				" >>> changeViewpagerEffect , effect = " + effect.toString());
		if (viewPager != null) {
			viewPager.setTransitionEffect(effect);
			if (null != viewPagerAdapter) {
				viewPager.setAdapter(viewPagerAdapter);
				viewPager.setCurrentItem(3);
				viewPagerAdapter.notifyDataSetChanged();
			}
		}
	}

	//局部广播，
	//	private class NetworkReceiver extends BroadcastReceiver {
	//
	//		@Override
	//		public void onReceive(Context context, Intent intent) {
	//			String action = intent.getAction();
	//			if (ConnectivityManager.CONNECTIVITY_ACTION.equals(action)) {
	//				if (NetWorkCheck.isOpenNetwork(context)) {
	//					Logger.i("net connect success");
	//					if (null != viewPagerAdapter) {
	//						for (int i = 0; i < viewPagerAdapter.getCount(); i++) {
	//							BaseFragment base = (BaseFragment) viewPagerAdapter
	//									.getItem(i);
	//							if(base != null)
	//							{
	//							base.netWorkConnect();
	//							}
	//						}
	//					}
	//				}else{
	//					Logger.i("net connect disable");
	//					if (null != viewPagerAdapter) {
	//						for (int i = 0; i < viewPagerAdapter.getCount(); i++) {
	//							BaseFragment base = (BaseFragment) viewPagerAdapter
	//									.getItem(i);
	//							base.netWorkDown();
	//						}
	//					}
	//				}
	//			}
	//
	//		}
	//	}

}
