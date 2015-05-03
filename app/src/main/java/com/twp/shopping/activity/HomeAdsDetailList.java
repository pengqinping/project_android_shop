package com.twp.shopping.activity;

import java.util.ArrayList;
import java.util.List;

import org.json.JSONObject;

import android.app.ActionBar;
import android.content.Intent;
import android.os.Bundle;
import android.os.Message;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;

import com.haarman.listviewanimations.swinginadapters.AnimationAdapter;
import com.haarman.listviewanimations.swinginadapters.prepared.ScaleInAnimationAdapter;
import com.jd.open.sdk.android.JdException;
import com.jd.open.sdk.android.JdListener;
import com.jd.open.sdk.android.api.InvokeError;
import com.twp.frame.util.Logger;
import com.twp.shopping.R;
import com.twp.shopping.adapter.SearchListViewAdapter;
import com.twp.shopping.http.jd.APIInvoker;
import com.twp.shopping.http.jd.model.ResponseJd;
import com.twp.shopping.http.jd.model.ResponseResult;
import com.twp.shopping.http.jd.model.product.WareInfo;
import com.twp.shopping.http.jd.model.ware.ActivityProductsList;
import com.twp.shopping.http.jd.util.GsonUtil;
import com.twp.shopping.ui.listview.XListView;
import com.twp.shopping.util.Constants;

/**
 * @author Royal.K 展示详细列表。
 */
public class HomeAdsDetailList extends BaseActivity implements
		JdListener.RequestListener, XListView.IXListViewListener {

	private static final String TAG = "HomeAdsDetailList";
	private static final String REQ_TAG_ADS = "jingdong.ware.promotion.indexactivity.get";
	private static final int PRE_REQUEST_SIZE = 20;
	private int currentPager = 0;
	private int adsID = 0;
	//
	private XListView xAdsListView;

	// listview adapter
	private SearchListViewAdapter mAdsListAdapter;
	private AnimationAdapter animAdapter;

	// listview data
	private ArrayList<WareInfo> mAdsDetailList = new ArrayList<WareInfo>();

	@Override
	public void handleUIMessage(Message msg) {
		switch (msg.what) {
		case HANDLER_RESULT_FNISH:
			buildData2View((ArrayList<WareInfo>) msg.obj);
			break;

		default:
			break;
		}
	}

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		Intent intent = getIntent();
		String title = intent.getStringExtra("title");
		adsID = intent.getIntExtra("adsID", 0);
		Logger.i(TAG, "Oncreate " + title + " , adsId = " + adsID);
		showActionBar(title);
		initView();
		requestAdsList(currentPager);
	}

	@Override
	public boolean onOptionsItemSelected(MenuItem item) {
		switch (item.getItemId()) {
		case android.R.id.home: {
			super.onBackPressed();
			break;
		}
		default:
			break;
		}
		return super.onOptionsItemSelected(item);
	}

	private void showActionBar(String titleName) {
		ActionBar actionBar = getActionBar();
		if (null != actionBar) {
			actionBar.setDisplayHomeAsUpEnabled(true);
			actionBar.setDisplayShowHomeEnabled(false);
			actionBar.setTitle(titleName.equals("") ? "NO TITLE" : titleName);
		}
	}

	private void requestAdsList(int currentPager) {
		APIInvoker.getPromotionIndexactivityGet(this, REQ_TAG_ADS, client,
				Constants.PARAM_CLIENT_ANDROID, String.valueOf(adsID),
				String.valueOf(currentPager + 1),
				String.valueOf(PRE_REQUEST_SIZE), this);
	}

	private void initView() {
		setContentView(R.layout.activity_ads_detail_list);
		xAdsListView = (XListView) findViewById(R.id.xAdsListView);
		xAdsListView.setPullRefreshEnable(false);
		xAdsListView.setPullLoadEnable(true);
		xAdsListView.setXListViewListener(this);// 设置上啦下拉回调方法。

		mAdsListAdapter = new SearchListViewAdapter(this, mAdsDetailList);
		animAdapter = new ScaleInAnimationAdapter(mAdsListAdapter);
		animAdapter.setAbsListView(xAdsListView);
		xAdsListView.setAdapter(animAdapter);

		// 事件
		xAdsListView.setOnItemClickListener(new OnItemClickListener() {

			@Override
			public void onItemClick(AdapterView<?> parent, View view,
					int position, long id) {
				// 因为listView 添加了headerView 所以这里的postion 包括了 headerview.
				int listPosition = (int) parent.getAdapter()
						.getItemId(position);
				Logger.i(" position = " + listPosition);
				WareInfo wareInfo = mAdsDetailList.get(listPosition);
				// 调整商品详情页面
				Intent intent = new Intent(HomeAdsDetailList.this,
						WareDetailActivity.class);
				intent.putExtra("skuId", wareInfo.getSkuId());
				intent.putExtra("Title", wareInfo.getWareName());
				startActivity(intent);

			}
		});

	}

	// start xListView callback
	@Override
	public void onRefresh() {

	}

	@Override
	public void onLoadMore() {
		requestAdsList(currentPager);
	}

	@Override
	public void onNoMoreData() {

	}

	// end XListView callBack

	private void buildData2View(ArrayList<WareInfo> mAdsDetailList) {
		this.mAdsDetailList = mAdsDetailList;
		mAdsListAdapter.notifyDataSetChanged();
		animAdapter.notifyDataSetChanged();
	}

	// start request callBack
	@Override
	public void onComplete(String transitionId, JSONObject result) {
		ResponseJd<ResponseResult<ActivityProductsList>> response = GsonUtil
				.getWarePromotionIndexActivityResponse(result.toString());
		Logger.i(TAG, "success transitionId = " + transitionId);
		List<WareInfo> mList = response.getResponseJd().getResultJd()
				.getActivityProducts();
		// 如果请求的数据不满足最大的每页的记录，没有数据返回了。
		if (mList.size() < PRE_REQUEST_SIZE || mList.size() < 1) {
			// 如果请求到的数据不满一页，设置listView显示没有更多数据。
			xAdsListView.setPullLoadNoMoreData();
			Logger.d(TAG,
					"activity ads detaillist mList.size()=" + mList.size());
		}
		// 第一次请求数据
		if (currentPager == 0) {
			mAdsDetailList.addAll(mList);
		} else {
			// add 进去
			mAdsDetailList.addAll(mAdsDetailList.size(), mList);
			xAdsListView.stopRefresh();
			xAdsListView.stopLoadMore();
		}

		currentPager++;

		uiHandler.sendMessage(uiHandler.obtainMessage(HANDLER_RESULT_FNISH, 0,
				0, mAdsDetailList));
	}

	@Override
	public void onError(String transitionId, InvokeError e) {

	}

	@Override
	public void onJdError(String transitionId, JdException e) {

	}
	// end request callBack
}
