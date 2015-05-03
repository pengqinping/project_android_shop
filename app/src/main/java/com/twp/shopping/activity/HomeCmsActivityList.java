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
import com.twp.shopping.adapter.HomeCmsActivityListAdapter;
import com.twp.shopping.http.jd.APIInvoker;
import com.twp.shopping.http.jd.model.ResponseJd;
import com.twp.shopping.http.jd.model.ResponseResult;
import com.twp.shopping.http.jd.model.product.ResultIITData;
import com.twp.shopping.http.jd.model.union.CmsActivity;
import com.twp.shopping.http.jd.util.GsonUtil;
import com.twp.shopping.ui.listview.XListView;
import com.twp.shopping.util.Constants;

/**
 * @author Royal.K 展示详细列表。
 */
public class HomeCmsActivityList extends BaseActivity implements
		JdListener.RequestListener, XListView.IXListViewListener {

	private static final String TAG = "HomePromotionsDetailList";
	private static final String REQ_TAG_ADS = "jingdong.ware.promotion.activities.list.get";
	private static final int PRE_REQUEST_SIZE = 20;
	private int mCurrentPager = 0;
	private String mPromotionId;
	//
	private XListView xListViewCmsActivityWareInfo;

	// listview adapter
	private HomeCmsActivityListAdapter mCmsActivityAdapter;
	private AnimationAdapter animAdapter;

	// listview data
	private ArrayList<CmsActivity> mCmsActivityDetailList = new ArrayList<CmsActivity>();

	@Override
	public void handleUIMessage(Message msg) {
		switch (msg.what) {
		case HANDLER_RESULT_FNISH:
			buildData2View((ArrayList<CmsActivity>) msg.obj);
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
		mPromotionId = intent.getStringExtra("mPromotionId");
		Logger.i(TAG, "Oncreate " + title + " , mPromotionId = " + mPromotionId);
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
		APIInvoker.getPromotionActivitiesList(this, REQ_TAG_ADS, client,
				Constants.PARAM_CLIENT_ANDROID, mPromotionId,
				String.valueOf(currentPager + 1),
				String.valueOf(PRE_REQUEST_SIZE), this);
	}

	private void initView() {
		setContentView(R.layout.activity_cmsactivity_list);
		xListViewCmsActivityWareInfo = (XListView) findViewById(R.id.xAdsListView);
		xListViewCmsActivityWareInfo.setPullRefreshEnable(false);
		xListViewCmsActivityWareInfo.setPullLoadEnable(true);
		xListViewCmsActivityWareInfo.setXListViewListener(this);// 设置上啦下拉回调方法。

		mCmsActivityAdapter = new HomeCmsActivityListAdapter(mCmsActivityDetailList,this);
		animAdapter = new ScaleInAnimationAdapter(mCmsActivityAdapter);
		animAdapter.setAbsListView(xListViewCmsActivityWareInfo);
		xListViewCmsActivityWareInfo.setAdapter(animAdapter);
		
		xListViewCmsActivityWareInfo.setOnItemClickListener(new OnItemClickListener() {

			@Override
			public void onItemClick(AdapterView<?> parent, View view,
					int position, long id) {
				int listPosition = (int)parent.getAdapter().getItemId(position);
				Logger.i("goto CmsActivityDetailList . position = "+position+" , listPosition = "+listPosition);
				if(null != mCmsActivityDetailList && mCmsActivityDetailList.size()>=1){
					Intent intent = new Intent(HomeCmsActivityList.this,HomeCmsActivityDetail.class);
					intent.putExtra("title", mCmsActivityDetailList.get(listPosition).getTitle());
					intent.putExtra("activityID",String.valueOf(mCmsActivityDetailList.get(listPosition).getActivityId()));
					startActivity(intent);
				}
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

	
	private void buildData2View(ArrayList<CmsActivity> mAdsDetailList){
		this.mCmsActivityDetailList = mAdsDetailList;
		mCmsActivityAdapter.notifyDataSetChanged();
		animAdapter.notifyDataSetChanged();
	}
	
	// start request callBack
	@Override
	public void onComplete(String transitionId, JSONObject result) {
		ResponseJd<ResponseResult<ResultIITData<List<CmsActivity>>>> response = GsonUtil
				.getWarePromotionsActivittiesListResponse(result.toString());
		Logger.i(TAG, "success transitionId = " + transitionId);
		List<CmsActivity> mList = response.getResponseJd().getResultJd().getResultData();
		// 如果请求的数据不满足最大的每页的记录，没有数据返回了。
		if (mList.size() < PRE_REQUEST_SIZE || mList.size() < 1) {
			// 如果请求到的数据不满一页，设置listView显示没有更多数据。
			xListViewCmsActivityWareInfo.setPullLoadNoMoreData();
			Logger.d(TAG,
					"activity ads detaillist mList.size()=" + mList.size());
		}
		// 第一次请求数据
		if (mCurrentPager == 0) {
			mCmsActivityDetailList.addAll(mList);
		} else {
			// add 进去
			mCmsActivityDetailList.addAll(mCmsActivityDetailList.size(), mList);
			xListViewCmsActivityWareInfo.stopRefresh();
			xListViewCmsActivityWareInfo.stopLoadMore();
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
