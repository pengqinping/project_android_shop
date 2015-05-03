/*
 * 版       权:  Royal.k.peng@gmail.com, All rights reserved
 * 作       者:  Royal
 * 座 右  铭:  Never give up, adhere to in the end.
 */
package com.twp.shopping.activity;

import java.util.ArrayList;
import java.util.List;

import org.json.JSONObject;

import android.app.ActionBar;
import android.content.Intent;
import android.os.Bundle;
import android.os.Message;
import android.view.Menu;
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
import com.twp.shopping.http.jd.APIProduct;
import com.twp.shopping.http.jd.model.ResponseJd;
import com.twp.shopping.http.jd.model.ResponseResult;
import com.twp.shopping.http.jd.model.product.ResultPagerListData;
import com.twp.shopping.http.jd.model.product.WareInfo;
import com.twp.shopping.http.jd.util.GsonUtil;
import com.twp.shopping.ui.listview.XListView;
import com.twp.shopping.util.Constants;

/**
 * FIXME ,设置列表展示筛选条件
 * 
 * @author Royal
 * @Email Royal.k.peng@gmail.com
 */
public class SearchListFragmentActivity extends BaseActivity implements
		JdListener.RequestListener, XListView.IXListViewListener {

	// 排序 1:销量排序 2:价格降序 3:价格升序 4:好评度 6:评论数

	private static final String TAG = "SearchListFragmentActivity";
	private static final int PRE_REQUEST_SIZE = 20;
	// 按关键字搜索，
	private static final String TRA_WARELISTBYKEYWORD = "jingdong.ware.product.search.list.get";
	private static final String TRA_WARELISTBYCID = "jingdong.ware.product.search.list.cid";
	private static final int SHOW_TYPE_SEARCH = 1;
	private static final int SHOW_TYPE_CID = 2;
	private static final int SORT_TYPE_SELL = 1;
	private static final int SORT_TYPE_Price_DOWN = 2;
	private static final int SORT_TYPE_PRICE_UP = 3;
	private static final int SORT_TYPE_FEED_BACK = 4;
	private static final int SORT_TYPE_POSITIVE_FEED_BACK = 6;
	private int sortType = 0;
	private int showType = 0;
	private int currentPager = 0;
	private String showTitle;
	// 初始化视图
	private XListView mSearchListView;

	private List<WareInfo> mListWareInfo = new ArrayList<WareInfo>();
	private SearchListViewAdapter mSearchListViewAdapter;
	private AnimationAdapter animAdapter ;

	@Override
	public void handleUIMessage(Message msg) {
		switch (msg.what) {
		case HANDLER_RESULT_FNISH:
			buildData2View((List<WareInfo>) msg.obj);
			break;
		default:
			break;
		}
	}

	@Override
	protected void onCreate(Bundle arg0) {
		super.onCreate(arg0);
		Logger.i(TAG, "enter into onCreate.");
		Intent comingIntent = getIntent();
		int showType = comingIntent.getIntExtra("ShowType", 0);
		Logger.i(TAG, "showType = " + showType);
		if (showType == 1) {
			String keyWord = comingIntent.getStringExtra("keyWord");
			this.showTitle = keyWord;
			requestByKeyWorkSearch(keyWord);
			updateActionBar(keyWord, true);
		} else if (showType == 2) {
			int cid = comingIntent.getIntExtra("cid", 0);
			this.showTitle = String.valueOf(cid);
			String showName = comingIntent.getStringExtra("showName");
			updateActionBar(showName, false);
			requestByCategoryId(String.valueOf(cid));
		}
		initView();

	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		if (showType == SHOW_TYPE_SEARCH) {
			getMenuInflater().inflate(R.menu.ware_list_filter, menu);
		}
		return super.onCreateOptionsMenu(menu);
	}

	private void initView() {
		setContentView(R.layout.activity_search);
		mSearchListView = (XListView) findViewById(R.id.xSearchListView);
		mSearchListView.setPullRefreshEnable(false);
		mSearchListView.setPullLoadEnable(true);
		mSearchListView.setXListViewListener(this);// 设置上啦下拉回调方法。

		// set onclickListener
		mSearchListView.setOnItemClickListener(new OnItemClickListener() {

			@Override
			public void onItemClick(AdapterView<?> parent, View view,
					int position, long id) {
				//因为listView 添加了headerView 所以这里的postion 包括了 headerview.
				int listPosition =(int) parent.getAdapter().getItemId(position);
				Logger.i(" position = "+listPosition);
				WareInfo wareInfo = mListWareInfo.get(listPosition);
				// 调整商品详情页面
				Intent intent = new Intent(SearchListFragmentActivity.this,WareDetailActivity.class);
				intent.putExtra("skuId",wareInfo.getSkuId());
				intent.putExtra("Title", wareInfo.getWareName());
				startActivity(intent);

			}
		});

		
		//new Adapter 数据从新加载后，notification就可以了。
		mSearchListViewAdapter = new SearchListViewAdapter(this, mListWareInfo);
		animAdapter = new ScaleInAnimationAdapter(mSearchListViewAdapter);
		animAdapter.setAbsListView(mSearchListView);
		mSearchListView.setAdapter(animAdapter);
	}

	private void updateActionBar(String titleName, boolean isKeySearcher) {
		ActionBar actionBar = getActionBar();
		actionBar.setDisplayHomeAsUpEnabled(true);
		actionBar.setDisplayShowHomeEnabled(false);
		actionBar.setTitle(titleName);
	}

	@Override
	public boolean onOptionsItemSelected(MenuItem item) {
		switch (item.getItemId()) {
		case android.R.id.home: {
			super.onBackPressed();
			break;
		}

		// 安装销量排行
		case R.id.menuWareSortSell: {
			onItemMeunSelectedResetPager();
			sortType = SORT_TYPE_SELL;
			break;
		}
		case R.id.menuWareSortPrice: {
			onItemMeunSelectedResetPager();

			// 默认的是降序。点击后为升序
			if (item.getTitle()
					.equals(getString(R.string.ware_sort_price_down))) {
				sortType = SORT_TYPE_PRICE_UP;
				item.setTitle(getString(R.string.ware_sort_price_up));
			} else {
				sortType = SORT_TYPE_Price_DOWN;
				item.setTitle(getString(R.string.ware_sort_price_down));
			}
			break;
		}
		case R.id.menuWareSortFeedBack: {
			onItemMeunSelectedResetPager();
			sortType = SORT_TYPE_FEED_BACK;
			break;
		}
		case R.id.menuWareSortPositiveFeedBack: {
			onItemMeunSelectedResetPager();
			sortType = SORT_TYPE_POSITIVE_FEED_BACK;
			break;
		}
		default:
			break;
		}
		if (showType == SHOW_TYPE_SEARCH) {
			Logger.d(TAG,"sort by type = "+sortType);
			requestByKeyWordSearch(showTitle, sortType, currentPager);
		}
		return super.onOptionsItemSelected(item);
	}

	private void onItemMeunSelectedResetPager() {
		currentPager = 0;
	}

	private void buildData2View(List<WareInfo> mWareInfoLists) {
		mListWareInfo = mWareInfoLists;
		mSearchListViewAdapter.notifyDataSetChanged();
		animAdapter.notifyDataSetChanged();
	}


	private void requestByKeyWorkSearch(String keyWord) {
		showType = SHOW_TYPE_SEARCH;
		// FIXME client 可能为没有授权
		requestByKeyWordSearch(keyWord, currentPager);

	}

	private void requestByKeyWordSearch(String keyWord, int pager) {
		requestByKeyWordSearch(keyWord, SORT_TYPE_SELL, pager);
	}

	private void requestByKeyWordSearch(String keyWord, int sortType, int pager) {
		APIProduct.getWareListByKeyword(this, TRA_WARELISTBYKEYWORD, client,
				Constants.PARAM_CLIENT_ANDROID, true, true, sortType, pager+1,
				PRE_REQUEST_SIZE, keyWord, this);
	}

	private void requestByCategoryId(String keyWord) {
		showType = SHOW_TYPE_CID;
		// FIXME client 可能为没有授权
		requestByCategoryId(keyWord, currentPager);

	}

	private void requestByCategoryId(String categoryId, int pager) {
		APIProduct.getWareListByCategoryId(getApplicationContext(),
				TRA_WARELISTBYCID, client, Constants.PARAM_CLIENT_ANDROID,
				categoryId, String.valueOf(pager+1),
				String.valueOf(PRE_REQUEST_SIZE), this);
	}

	@Override
	public void onComplete(String transitionId, JSONObject result) {
		if (TRA_WARELISTBYKEYWORD.equals(transitionId)) {
			ResponseJd<ResponseResult<ResultPagerListData<WareInfo>>> response = GsonUtil
					.getWareProductSearchResponse(result.toString());
			Logger.i(TAG, "transitionId success." + transitionId);
			List<WareInfo> mList = response.getResponseJd().getResultJd()
					.getResultListData();
			// 如果请求的数据不满足最大的每页的记录，没有数据返回了。
			if (mList.size() < PRE_REQUEST_SIZE || mList.size() < 1) {
				// 如果请求到的数据不满一页，设置listView显示没有更多数据。
				mSearchListView.setPullLoadNoMoreData();
				Logger.d(
						TAG,
						"keyword mode no more data.mList.size()="
								+ mList.size());
			}
			// 第一次请求数据
			if (currentPager == 0) {
				mListWareInfo.clear();
				mListWareInfo.addAll(mList);
			} else {
				// add 进去
				mListWareInfo.addAll(mListWareInfo.size(), mList);
				mSearchListView.stopRefresh();
				mSearchListView.stopLoadMore();
			}

		} else if (transitionId.equalsIgnoreCase(TRA_WARELISTBYCID)) {
			Logger.i(TAG, "transitionId success." + transitionId);
			ResponseJd<ResponseResult<ResultPagerListData<WareInfo>>> response = GsonUtil
					.getPromotionSearchCategoryResponse(result.toString());
			List<WareInfo> mList = response.getResponseJd().getResultJd()
					.getResultListData();
			// 如果请求的数据不满足最大的每页的记录，没有数据返回了。
			if (mList.size() < PRE_REQUEST_SIZE || mList.size() < 1) {
				mSearchListView.setPullLoadNoMoreData();
				Logger.d(TAG, "no more data.mList.size()=" + mList.size());
			}
			// 第一次请求数据
			if (currentPager == 0) {
				mListWareInfo.addAll(mList);
			} else {
				// add 进去
				mListWareInfo.addAll(mListWareInfo.size(), mList);
				mSearchListView.stopRefresh();
				mSearchListView.stopLoadMore();
			}
		}

		currentPager++;

		uiHandler.sendMessage(uiHandler.obtainMessage(HANDLER_RESULT_FNISH, 0,
				0, mListWareInfo));

	}

	@Override
	public void onError(String transitionId, InvokeError e) {

	}

	@Override
	public void onJdError(String transitionId, JdException e) {

	}

	// #start 【XlistView
	// 上啦加载更多回调】============================================================
	@Override
	public void onRefresh() {
		// 下拉刷新可以先不用实现
	}

	@Override
	public void onLoadMore() {
		// 发起一个请求，页码
		if (showType == SHOW_TYPE_SEARCH) {
			requestByKeyWordSearch(showTitle, currentPager);
		} else {
			requestByCategoryId(showTitle, currentPager);
		}
	}

	@Override
	public void onNoMoreData() {
		// 没有数据的,listView footer click called this method.
		toastShort("亲！就这么多数据了。");
	}

	// #end

}
