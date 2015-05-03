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
import com.twp.shopping.adapter.HomeCmsActivityAdapter;
import com.twp.shopping.http.jd.APIInvoker;
import com.twp.shopping.http.jd.model.ResponseJd;
import com.twp.shopping.http.jd.model.ResponseResult;
import com.twp.shopping.http.jd.model.recommend.CmsActivityWare;
import com.twp.shopping.http.jd.model.ware.CmsActivityWareList;
import com.twp.shopping.http.jd.util.GsonUtil;
import com.twp.shopping.ui.listview.XListView;
import com.twp.shopping.util.Constants;

/**
 * @author Royal.K 展示详细列表。
 */
public class HomeCmsActivityDetail extends BaseActivity implements
		JdListener.RequestListener, XListView.IXListViewListener {

	private static final String TAG = "HomeCmsActivityDetail";
	private static final String REQ_TAG_ADS = "jingdong.ware.promotion.activityware.list.get";
	private static final int PRE_REQUEST_SIZE = 20;
	private int mCurrentPager = 0;
	private String mCmsActivityId;
	//
	private XListView xListViewCmsActivity;

	// listview adapter
	private HomeCmsActivityAdapter mCmsActivityAdapter;
	private AnimationAdapter animAdapter;

	// listview data
	private ArrayList<CmsActivityWare> mCmsActivityDetailList = new ArrayList<CmsActivityWare>();

	@Override
	public void handleUIMessage(Message msg) {
		switch (msg.what) {
		case HANDLER_RESULT_FNISH:
			buildData2View((ArrayList<CmsActivityWare>) msg.obj);
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
		mCmsActivityId = intent.getStringExtra("activityID");
		Logger.i(TAG, "Oncreate " + title + " , mCmsActivityId = "
				+ mCmsActivityId);
		showActionBar(title);
		initView();
		requestAdsList(mCurrentPager);
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
		APIInvoker.getPromotionActivitywareList(this, REQ_TAG_ADS, client,
				Constants.PARAM_CLIENT_ANDROID, mCmsActivityId,
				String.valueOf(currentPager + 1),
				String.valueOf(PRE_REQUEST_SIZE), this);
	}

	private void initView() {
		setContentView(R.layout.activity_cmsactivity_wareinfo);
		xListViewCmsActivity = (XListView) findViewById(R.id.xAdsListView);
		xListViewCmsActivity.setPullRefreshEnable(false);
		xListViewCmsActivity.setPullLoadEnable(true);
		xListViewCmsActivity.setXListViewListener(this);// 设置上啦下拉回调方法。

		mCmsActivityAdapter = new HomeCmsActivityAdapter(
				mCmsActivityDetailList, this);
		animAdapter = new ScaleInAnimationAdapter(mCmsActivityAdapter);
		animAdapter.setAbsListView(xListViewCmsActivity);
		xListViewCmsActivity.setAdapter(animAdapter);

		// onitemclick
		xListViewCmsActivity.setOnItemClickListener(new OnItemClickListener() {

			@Override
			public void onItemClick(AdapterView<?> arg0, View arg1, int arg2,
					long arg3) {
				int position = (int) arg0.getAdapter().getItemId(arg2);
				Logger.i("position = " + position);
				CmsActivityWare wareInfo = mCmsActivityDetailList.get(position);
				// 调整商品详情页面
				Intent intent = new Intent(HomeCmsActivityDetail.this,
						WareDetailActivity.class);
				int skuId = 0;
				try {
					skuId = Integer.parseInt(wareInfo.getSkuId());
				} catch (NumberFormatException e) {
					Logger.e(TAG,"skuId parse exception ." + e.toString());
				}
				intent.putExtra("skuId", skuId);
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
		requestAdsList(mCurrentPager);
	}

	@Override
	public void onNoMoreData() {

	}

	// end XListView callBack

	private void buildData2View(ArrayList<CmsActivityWare> mCmsActivityWareList) {
		this.mCmsActivityDetailList = mCmsActivityWareList;
		mCmsActivityAdapter.notifyDataSetChanged();
		animAdapter.notifyDataSetChanged();
	}

	// start request callBack
	@Override
	public void onComplete(String transitionId, JSONObject result) {
		ResponseJd<ResponseResult<CmsActivityWareList>> response = GsonUtil
				.getWarePromotionsActiviWareListResponse(result.toString());
		Logger.i(TAG, "success transitionId = " + transitionId);
		List<CmsActivityWare> mList = response.getResponseJd().getResultJd()
				.getCmsActivityWareList();
		// 如果请求的数据不满足最大的每页的记录，没有数据返回了。
		if (mList != null && mList.size() < PRE_REQUEST_SIZE
				|| mList.size() < 1) {
			// 如果请求到的数据不满一页，设置listView显示没有更多数据。
			xListViewCmsActivity.setPullLoadNoMoreData();
			Logger.d(TAG,
					"activity ads detaillist mList.size()=" + mList.size());
		}
		// 第一次请求数据
		if (mCurrentPager == 0) {
			mCmsActivityDetailList.addAll(mList);
		} else {
			// add 进去
			mCmsActivityDetailList.addAll(mCmsActivityDetailList.size(), mList);
			xListViewCmsActivity.stopRefresh();
			xListViewCmsActivity.stopLoadMore();
		}

		mCurrentPager++;

		uiHandler.sendMessage(uiHandler.obtainMessage(HANDLER_RESULT_FNISH, 0,
				0, mCmsActivityDetailList));
	}

	@Override
	public void onError(String transitionId, InvokeError e) {

	}

	@Override
	public void onJdError(String transitionId, JdException e) {

	}
	// end request callBack
}
