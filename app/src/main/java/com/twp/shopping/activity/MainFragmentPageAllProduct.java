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
import android.os.Message;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.GridView;
import android.widget.SearchView;
import android.widget.TextView;
import android.widget.SearchView.OnQueryTextListener;

import com.haarman.listviewanimations.swinginadapters.prepared.SwingBottomInAnimationAdapter;
import com.jd.open.sdk.android.JdException;
import com.jd.open.sdk.android.JdListener;
import com.jd.open.sdk.android.api.InvokeError;
import com.twp.frame.util.EmptyUtil;
import com.twp.frame.util.Logger;
import com.twp.shopping.R;
import com.twp.shopping.adapter.FirstCategoryGridViewAdapter;
import com.twp.shopping.http.jd.APICategory;
import com.twp.shopping.http.jd.model.category.Category;
import com.twp.shopping.http.jd.util.GsonUtil;
import com.twp.shopping.ui.WaitDialog;
import com.twp.shopping.ui.inter.MenuCreate;
import com.twp.shopping.util.Constants;

/**
 * Oncreate 的执行在 OncreateView的前面执行。
 * 
 * @author Royal
 * 
 */
public class MainFragmentPageAllProduct extends BaseFragment implements
		JdListener.RequestListener {

	private static final String TAG = "MainFragmentPageAllProduct";

	private final String TRA_PRODUCT_CATEGORY_LIST = "jingdong.ware.product.catelogy.list.get.1";

	private GridView gridViewFirstCategory;

	private List<Category> listsCategy = new ArrayList<Category>();

	private FirstCategoryGridViewAdapter firstCategoryGridViewAdapter;

	private SwingBottomInAnimationAdapter swingBottomInAnimationAdapter;

	// 表示请求过了
	private boolean hasRequested;

	// extends super class
	protected void handleUIMessage(android.os.Message msg) {
		switch (msg.what) {
		case HANDLER_RESULT_REQ: {
			// 收到消息去请求数据。
			initData();
			break;
		}
		case HANDLER_RESULT_ERROR: {
			// 隐藏等待框
			Object toast = msg.obj;
			// 服务返回结果中的错误信息，直接在界面上行显示
			toastShort(mActivity, toast.toString());
			break;
		}
		case HANDLER_RESULT_FNISH: {
			buildView4Data((List<Category>) (msg.obj));
			break;
		}
		case HANDLER_RESULT_NODATA: {
			break;
		}
		case HANDLER_RESULT_NOCONNCTION: {
			break;
		}
		default:
			break;
		}
	};
	
	public static MainFragmentPageAllProduct newInstance() {
		MainFragmentPageAllProduct home = new MainFragmentPageAllProduct();
		Bundle arg = new Bundle();
		home.setArguments(arg);
		return home;
	}

	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
	}

	@Override
	public View onChileCreateView(LayoutInflater inflater, ViewGroup container,
			Bundle savedInstanceState) {
		Logger.d(TAG, "enter onChildCreateView");
		View allProductContentView = LayoutInflater.from(mActivity).inflate(
				R.layout.fragment_all_product, null);
		initView(allProductContentView);
		uiHandler.sendEmptyMessage(HANDLER_RESULT_REQ);
		return allProductContentView;
	}

	public void onPause() {
		super.onPause();
	}

	@Override
	public void onDestroy() {
		super.onDestroy();
		hasRequested = false;
		Logger.d(TAG, "ondestroy hasRequested = " + hasRequested);
	}

	private void initView(View view) {

		// init gridView
		gridViewFirstCategory = (GridView) view
				.findViewById(R.id.gridViewFirstCategory);

		gridViewFirstCategory.setOnItemClickListener(new OnItemClickListener() {

			@Override
			public void onItemClick(AdapterView<?> parent, View view,
					int position, long id) {
				Category category = listsCategy.get(position);
				Logger.i(TAG, "onItemClick = " + category.getName());
				// 跳转到二级列表页面
				Intent intent = new Intent(mActivity,
						WareCategoryActivity.class);
				intent.putExtra("cid", category.getCid());
				intent.putExtra("level", category.getLevel());
				intent.putExtra("showName", category.getName());
				startActivity(intent);
			}
		});

		// init adapter.
		firstCategoryGridViewAdapter = new FirstCategoryGridViewAdapter(
				mActivity, listsCategy);
		swingBottomInAnimationAdapter = new SwingBottomInAnimationAdapter(
				firstCategoryGridViewAdapter);
		swingBottomInAnimationAdapter.setAbsListView(gridViewFirstCategory);
		swingBottomInAnimationAdapter.setInitialDelayMillis(300);
		gridViewFirstCategory.setAdapter(swingBottomInAnimationAdapter);

	}

	/**
	 * 初始化数据，只在页面显示的时候才去加载。
	 */
	private void initData() {

		APICategory.getWareProductCategoryList(mActivity,
				TRA_PRODUCT_CATEGORY_LIST, MainTabActivity.client,
				Constants.PARAM_CLIENT_ANDROID, "0", "0", true, true, this);
	}

	// 请求成功后，使用数据填充到视图。
	private void buildView4Data(List<Category> list) {
		if (EmptyUtil.isCollectionEmpty(list)) {
			Logger.d(TAG, "list is empty!");
			uiHandler.sendMessage(uiHandler
					.obtainMessage(HANDLER_RESULT_NODATA));
			return;
		}
		Logger.d(TAG,
				mActivity + "== set Data to View ! list.size=" + list.size());
		listsCategy.clear();
		listsCategy.addAll(list);
		firstCategoryGridViewAdapter.notifyDataSetChanged();
		swingBottomInAnimationAdapter.notifyDataSetChanged();

	}

	// #start 【请求回调】
	@Override
	public void onComplete(String transitionId, JSONObject result) {
		if (null != result) {
			Logger.d(TAG, "request success!transitionId=" + transitionId);
			List<Category> resultList = GsonUtil.parseCategoryResult(result
					.toString());
			// begin request the second category.
			Message msg = uiHandler.obtainMessage(HANDLER_RESULT_FNISH,
					resultList);
			uiHandler.sendMessage(msg);
		} else {
			// 返回结果为空，
			uiHandler.sendEmptyMessage(HANDLER_RESULT_NODATA);
		}
	}

	@Override
	public void onError(String transitionId, InvokeError e) {
		// 返回结果中的错误
		Logger.d(TAG, "request Error! error Msg = " + e.getErrorZHMessage());
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

	// #end 【请求回调】

	@Override
	public void onCreateOptionsMenu(Menu menu, MenuInflater inflater) {
		super.onCreateOptionsMenu(menu, inflater);
		inflater.inflate(R.menu.product_list_search, menu);
		final SearchView searchView = (SearchView) menu.findItem(
				R.id.menuAllProductSearch).getActionView();
		searchView.setOnQueryTextListener(new OnQueryTextListener() {

			@Override
			public boolean onQueryTextSubmit(String query) {
				Logger.v(TAG, "query = " + query);
				if (EmptyUtil.isStringEmpty(query)) {
					toastLong(mActivity,
							getString(R.string.search_key_not_null));
					return false;
				}
				// proccess the result. Intent intent = new
				Intent intent = new Intent(mActivity,
						SearchListFragmentActivity.class);
				intent.putExtra("ShowType", 1);
				intent.putExtra("keyWord", query);
				startActivity(intent);
				return false;
			}

			@Override
			public boolean onQueryTextChange(String newText) {
				Logger.v(TAG, "newText = " + newText);
				return false;
			}
		});

	}

	@Override
	public void onNetWorkSettingActivityResult(int requestCode, int resultCode,
			Intent data) {
		if (requestCode == ACTIVITYR_ESULTCODE_NONETWORK) {
			Logger.d(TAG, data + "");
			// 重新发起一遍请求
			uiHandler.sendEmptyMessage(HANDLER_RESULT_REQ);
		}
	}

	@Override
	public int getActionTitle() {
		return R.string.tab_search;
	}
}