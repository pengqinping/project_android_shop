/*
 * 版       权:  Royal.k.peng@gmail.com, All rights reserved
 * 作       者:  Royal
 * 座 右  铭:  Never give up, adhere to in the end.
 */
package com.twp.shopping.activity;

import java.util.ArrayList;
import java.util.List;

import org.json.JSONObject;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnTouchListener;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.GridView;
import android.widget.TextView;

import com.haarman.listviewanimations.swinginadapters.AnimationAdapter;
import com.haarman.listviewanimations.swinginadapters.prepared.ScaleInAnimationAdapter;
import com.jd.open.sdk.android.JdException;
import com.jd.open.sdk.android.JdListener;
import com.jd.open.sdk.android.api.InvokeError;
import com.twp.frame.util.Logger;
import com.twp.shopping.R;
import com.twp.shopping.activity.MainTabActivity.ViewPagerSelectedListener;
import com.twp.shopping.adapter.HomeAdsFlowViewAdapter;
import com.twp.shopping.adapter.HomePromotionGridViewAdapter;
import com.twp.shopping.http.jd.APIInvoker;
import com.twp.shopping.http.jd.model.ResponseJd;
import com.twp.shopping.http.jd.model.ResponseResult;
import com.twp.shopping.http.jd.model.ResultListData;
import com.twp.shopping.http.jd.model.ware.Activity;
import com.twp.shopping.http.jd.model.ware.CmsPromotions;
import com.twp.shopping.http.jd.util.GsonUtil;
import com.twp.shopping.ui.JazzyViewPager;
import com.twp.shopping.ui.ads.CircleFlowIndicator;
import com.twp.shopping.ui.ads.ViewFlow;
import com.twp.shopping.util.Constants;

/**
 * 把 广告的自动播放放到 fragment 中来做，如果嵌套在View里面，
 * 
 * @author Royal
 * @Email Royal.k.peng@gmail.com
 */
public class MainFragmentHome extends BaseFragment implements
		JdListener.RequestListener, ViewPagerSelectedListener {

	private static final String TAG = MainFragmentHome.class.getSimpleName();
	private static final String TRA_PROMOTIONS_ADS = "jingdong.ware.promotions.ads";
	private static final String TRA_PROMOTIONS_LIST_GET = "jingdong.ware.promotions.list.get";
	private static final long DEFAUL_DELAY_TIME = 3000l;
	// 判读请求
	private final int REQ_ADS = 1;
	private final int REQ_LIST = 2;
	// 是否开始广告循环，主要是在OnResume中 需要拿到数组后在开始切换
	private boolean isSwitch = false;
	private long mSwitchDelayTime = DEFAUL_DELAY_TIME;
	// view
	private ViewFlow homeAdsViewFlow;
	private CircleFlowIndicator homeAdsCircleIndicator;
	private GridView homePromotionGridView;
	private View contentView;

	// adapter
	private HomeAdsFlowViewAdapter homeAdsViewFlowAdapter;
	private HomePromotionGridViewAdapter homePromotionListViewAdapter;
	private AnimationAdapter animAdapter;

	// data
	private List<Activity> homeAdsList = new ArrayList<Activity>();
	private List<CmsPromotions> homePromotionsList = new ArrayList<CmsPromotions>();

	private Handler mPlayHandler = new Handler();

	private Runnable mPlayRunnable = new Runnable() {

		@Override
		public void run() {
			if (null != homeAdsViewFlow && homeAdsList.size() >= 1) {
				homeAdsViewFlow.playAds();
				postAdsDelayed();
			}
		}
	};

	private void postAdsDelayed() {
		mPlayHandler.removeCallbacks(mPlayRunnable);
		mPlayHandler.postDelayed(mPlayRunnable, mSwitchDelayTime);
	}

	public static MainFragmentHome newInstance() {
		MainFragmentHome home = new MainFragmentHome();
		Bundle arg = new Bundle();
		home.setArguments(arg);
		return home;
	}

	public MainFragmentHome() {
	}

	@Override
	protected void handleUIMessage(Message msg) {

		switch (msg.what) {
		case HANDLER_RESULT_REQ: {
			initData();
			break;
		}
		case HANDLER_RESULT_FNISH: {
			// 不管是那个请求都先把布局加载出来。
			if (msg.arg1 == REQ_LIST) {
				buildPromotionListView4Data((List<CmsPromotions>) msg.obj);
			} else if (msg.arg1 == REQ_ADS) {
				buildAdsViewPager4Data((List<Activity>) msg.obj);
			}
			break;
		}
		case HANDLER_RESULT_NOCONNCTION: {
			// 没有网络连接,全部移除
			break;
		}
		case HANDLER_RESULT_NODATA: {

			// 判断是那个请求没有数据。
			break;
		}
		default:
			break;
		}
	}

	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		Logger.d(TAG, ">>> oncreate <<<");
	}

	@Override
	public void onCreateOptionsMenu(Menu menu, MenuInflater inflater) {
		super.onCreateOptionsMenu(menu, inflater);
		Logger.d(TAG, ">>> onCreateOptionsMenu <<<");
		// inflater.inflate(R.menu.main, menu);
	}

	@Override
	public View onChileCreateView(LayoutInflater inflater, ViewGroup container,
			Bundle savedInstanceState) {
		Logger.d(TAG, ">>> oncreateView <<<<");
		initView(contentView);

		return contentView;
	}

	@Override
	public void onResume() {
		super.onResume();
		Logger.d(TAG, "enter onResume");
		// 如果广告切换开始了，onResume 的时候在开始开始切换
		if (isSwitch) {
			postAdsDelayed();
		}
	}

	@Override
	public void onStart() {
		super.onStart();
		Logger.d(TAG, "enter onStart");
	}

	@Override
	public void onPause() {
		super.onPause();
		Logger.d(TAG, "enter onPause");
		if (isSwitch) {
			// 如果广告切换开始了，停止切换
			mPlayHandler.removeCallbacks(mPlayRunnable);
		}
	}

	@Override
	public void onDestroyView() {
		super.onDestroyView();
		Logger.d(TAG, "enter onDestroyView");
		mActivity.unRegisterViewPagerListener(Constants.FRAGMENT_IDENTIFY[0]);
		// reset value
		if (isSwitch) {
			mPlayHandler.removeCallbacks(mPlayRunnable);
			isSwitch = false;
		}
	}

	private void initView(View view) {
		mActivity.registerViewPagerListener(Constants.FRAGMENT_IDENTIFY[0],
				this);
		if (null == contentView) {
			contentView = LayoutInflater.from(mActivity).inflate(
					R.layout.fragment_home, null);
			uiHandler.sendEmptyMessage(HANDLER_RESULT_REQ);
		}
		ViewGroup parent = (ViewGroup) contentView.getParent();
		if (parent != null) {
			parent.removeView(contentView);
		}
		view = contentView;
		// init viewFlow.
		// ads indicator
		homeAdsCircleIndicator = (CircleFlowIndicator) view
				.findViewById(R.id.homeAdsViewflowCircleInicator);
		// ads viewFlow.
		homeAdsViewFlow = (ViewFlow) view.findViewById(R.id.homeAdsViewflow);
		homeAdsViewFlowAdapter = new HomeAdsFlowViewAdapter(homeAdsList,
				mActivity);
		homeAdsViewFlow.setAdapter(homeAdsViewFlowAdapter);
		homeAdsViewFlow.setFlowIndicator(homeAdsCircleIndicator);

		// init listview of promotion
		homePromotionGridView = (GridView) view
				.findViewById(R.id.homePromotionGridView);
		homePromotionListViewAdapter = new HomePromotionGridViewAdapter(
				mActivity, homePromotionsList);
		animAdapter = new ScaleInAnimationAdapter(homePromotionListViewAdapter);
		animAdapter.setAbsListView(homePromotionGridView);
		homePromotionGridView.setAdapter(animAdapter);

		homePromotionGridView.setOnItemClickListener(new OnItemClickListener() {

			@Override
			public void onItemClick(AdapterView<?> arg0, View arg1, int arg2,
					long arg3) {
				// 跳转促销详情。
				Logger.i("gridView goto promosion list .position = " + arg2);
				if (null != homePromotionsList
						&& homePromotionsList.size() >= 1) {
					CmsPromotions cmsPromotion = homePromotionsList.get(arg2);
					Intent intent = new Intent(mActivity,
							HomeCmsActivityList.class);
					intent.putExtra("title", cmsPromotion.getPromotionName());
					intent.putExtra("mPromotionId",
							cmsPromotion.getPromotionId());
					startActivity(intent);
				}
			}
		});

		homeAdsViewFlow.setOnItemClickListener(new OnItemClickListener() {

			@Override
			public void onItemClick(AdapterView<?> parent, View view,
					int position, long id) {
				Logger.i(TAG, "goto ads detial ,position = " + position);
				if (null != homeAdsList && homeAdsList.size() >= 1) {
					Activity showDetailActivity = homeAdsList.get(position);
					Logger.i(TAG, "showDetailActivity.getTitle() = "
							+ showDetailActivity.getTitle());
					Intent intent = new Intent(mActivity,
							HomeAdsDetailList.class);
					intent.putExtra("title", showDetailActivity.getTitle());
					intent.putExtra("adsID", showDetailActivity.getActivityId());
					startActivity(intent);
				}
			}
		});

		homeAdsViewFlow.setOnTouchListener(new OnTouchListener() {
			ViewParent viewParent = homeAdsViewFlow.getParent();

			@Override
			public boolean onTouch(View v, MotionEvent event) {
				switch (event.getAction()) {
				case MotionEvent.ACTION_DOWN:
					mPlayHandler.removeCallbacks(mPlayRunnable);
					break;
				case MotionEvent.ACTION_MOVE:
					while (!(viewParent instanceof JazzyViewPager)) {
						viewParent = viewParent.getParent();
					}
					viewParent.requestDisallowInterceptTouchEvent(true);
					break;
				case MotionEvent.ACTION_UP:
				case MotionEvent.ACTION_CANCEL:
					postAdsDelayed();
					viewParent.requestDisallowInterceptTouchEvent(false);
					break;
				}
				return false;
			}
		});

	}

	private void initData() {

		// reqeust a ads
		APIInvoker.getPromotionIndexactivityList(mActivity, TRA_PROMOTIONS_ADS,
				MainTabActivity.client, Constants.PARAM_CLIENT_ANDROID, this);

		// request the promotion data
		APIInvoker.getPromotionPromotionsList(mActivity,
				TRA_PROMOTIONS_LIST_GET, MainTabActivity.client,
				Constants.PARAM_CLIENT_ANDROID, this);

	}

	private void buildAdsViewPager4Data(List<Activity> lists) {
		homeAdsList.clear();
		homeAdsList.addAll(lists);
		homeAdsViewFlowAdapter.notifyDataSetChanged();
		// 获取到数据后再去播放
		postAdsDelayed();
		isSwitch = true;
	}

	private void buildPromotionListView4Data(List<CmsPromotions> list) {
		homePromotionsList.clear();
		homePromotionsList.addAll(list);
		homePromotionListViewAdapter.notifyDataSetChanged();
		animAdapter.notifyDataSetChanged();
	}

	@Override
	public void onComplete(String transitionId, JSONObject result) {

		// 请求分开处理
		if (TRA_PROMOTIONS_LIST_GET.equals(transitionId)) {
			ResponseJd<ResponseResult<ResultListData<CmsPromotions>>> reponse = GsonUtil
					.getWarePromotionsListResponse(result.toString());
			if (null != reponse) {

				Logger.d(TAG, "get ware promotion is success!");
				List<CmsPromotions> lists = reponse.getResponseJd()
						.getResultJd().getResultListData();

				uiHandler.sendMessage(uiHandler.obtainMessage(
						HANDLER_RESULT_FNISH, REQ_LIST, 0, lists));
			} else {
				// 返回结果为空，
				uiHandler.sendEmptyMessage(HANDLER_RESULT_NODATA);
				Logger.d(TAG, "get ware promotion response is null. ");
			}
		} else if (TRA_PROMOTIONS_ADS.equals(transitionId)) {
			ResponseJd<ResponseResult<ResultListData<Activity>>> reponse = GsonUtil
					.getWarePromotionIndexActivityListResponse(result
							.toString());
			List<Activity> lists = reponse.getResponseJd().getResultJd()
					.getResultListData();
			uiHandler.sendMessage(uiHandler.obtainMessage(HANDLER_RESULT_FNISH,
					REQ_ADS, 0, lists));

		}

	}

	@Override
	public void onError(String transitionId, InvokeError e) {
		Logger.d(TAG, "request Error!transitionId = " + transitionId
				+ "error Msg = " + e.getErrorZHMessage());
		uiHandler.sendMessage(uiHandler.obtainMessage(HANDLER_RESULT_ERROR,
				e.getErrorZHMessage()));
	}

	@Override
	public void onJdError(String transitionId, JdException e) {

		Logger.d(TAG, "request Exception! exception Msg = " + e.toString());
		int errorCode = e.getErrorCode();
		switch (errorCode) {
		// 没有网络连接
		case JdException.ERRORCODE_RESQUEST_NETWORK_ERROR:
			uiHandler.sendEmptyMessage(HANDLER_RESULT_NOCONNCTION);
			break;
		// FIXME 请求错误。
		case JdException.ERRORCODE_RESPONSE_FORMAT_ERROR:
			uiHandler.sendMessage(uiHandler.obtainMessage(HANDLER_RESULT_ERROR,
					e.getMessage()));
			break;
		default:
			break;
		}

	}

	@Override
	public void onNetWorkSettingActivityResult(int requestCode, int resultCode,
			Intent data) {
	}

	@Override
	public int getActionTitle() {
		return R.string.tab_home;
	}

	@Override
	public void onPageSelected(int arg0) {
		//
	}
}
