/*
 * 文  件  名:  WareCategoryActivity.java
 * 创建日期:  2014-3-2/下午9:35:14
 * 版       权:  Royal.k.peng@gmail.com, All rights reserved
 * 作       者:  Royal
 * 座 右  铭:  Never give up, adhere to in the end.
 */
package com.twp.shopping.activity;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.json.JSONObject;

import android.app.ActionBar;
import android.content.Intent;
import android.os.Bundle;
import android.os.Message;
import android.view.KeyEvent;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.GridView;

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
import com.twp.shopping.util.Constants;

/**
 * @Ctime 2014-3-2/下午9:35:14
 * @author Royal
 * @DESC 商品一级列表点击进来后显示的第二级列表 FIXME 1.数据为空的时候，隐藏listView.
 */
public class WareCategoryActivity extends BaseActivity implements
		JdListener.RequestListener {

	private static final String TAG = "WareCategoryActivity";
	private static final String TRA_CATEGORY_LIST_GET_SECOND = "jingdong.ware.product.catelogy.list.get.second";

	private GridView gridViewSecondCategory;
	private FirstCategoryGridViewAdapter secondCategoryGridViewAdapter;
	private SwingBottomInAnimationAdapter swingBottomInAnimationAdapter; 
	private List<Category> listCategorySecond = new ArrayList<Category>();

	// 当前Category的级别，这个列表会展示，二级，三级的数据
	private int currentCategoryLevel;

	// 缓存一个二级目录或者是三级目录显示的对象。在返回的时候重新请求。
	private Map<String, Category> currentLevelCategoryMap = new HashMap<String, Category>(
			2);

	@Override
	public void handleUIMessage(Message msg) {
		switch (msg.what) {
		case HANDLER_RESULT_FNISH:
			buildView4Data((List<Category>) msg.obj);
			break;

		case HANDLER_RESULT_ERROR:
		case HANDLER_RESULT_NODATA:
			toastShort(this, "error");
			break;
		default:
			break;
		}
	}

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		Logger.d(TAG, "enter oncreate");
		parseIntent();
	}

	@Override
	public boolean onOptionsItemSelected(MenuItem item) {
		Logger.d(TAG, "item......" + item.getTitle());
		onBackNextView();
		return super.onOptionsItemSelected(item);
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		return super.onCreateOptionsMenu(menu);
	}

	/**
	 * 解析Intent
	 * 
	 * @author Royal
	 * @Email Royal.k.peng@gmail.com
	 */
	private void parseIntent() {
		Intent intent = getIntent();
		int level = intent.getIntExtra("level", -1);
		int cid = intent.getIntExtra("cid", -1);
		String titleName = intent.getStringExtra("showName");
		if (cid == -1) {
			toastShort("无法请求");
			this.finish();
		} else {
			setContentView(R.layout.fragment_all_product);
			showActionBarTitle(level, cid, titleName);
			initView();
		}
	}

	private void showActionBarTitle(int level, int cid, String titleName) {
		ActionBar actionBar = getActionBar();
		actionBar.setDisplayHomeAsUpEnabled(true);
		actionBar.setDisplayShowHomeEnabled(false);
		actionBar.setTitle(titleName);

		this.currentCategoryLevel = level;
		Category category = new Category();
		category.setCid(cid);
		category.setLevel(level);
		category.setName(titleName);
		Logger.d(TAG, "save current category level , level=" + level + ",cid="
				+ cid + ",titleName=" + titleName);
		currentLevelCategoryMap.put(String.valueOf(this.currentCategoryLevel),
				category);

		// 显示title后去请求数据
		requestData(level, cid);
	}

	private void initView() {
		// init gridView
		gridViewSecondCategory = (GridView) findViewById(R.id.gridViewFirstCategory);

		//init adapter
		secondCategoryGridViewAdapter = new FirstCategoryGridViewAdapter(this,
				listCategorySecond);
		swingBottomInAnimationAdapter = new SwingBottomInAnimationAdapter(
				secondCategoryGridViewAdapter);
		swingBottomInAnimationAdapter.setAbsListView(gridViewSecondCategory);
		swingBottomInAnimationAdapter.setInitialDelayMillis(300);
		gridViewSecondCategory.setAdapter(swingBottomInAnimationAdapter);
		
		gridViewSecondCategory
				.setOnItemClickListener(new OnItemClickListener() {

					@Override
					public void onItemClick(AdapterView<?> parent, View view,
							int position, long id) {
						Category category = listCategorySecond.get(position);
						int theLevel = category.getLevel() + 1;
						if (theLevel < 3) {
							int level = category.getLevel();
							int cid = category.getCid();
							String showTitleName = category.getName();
							showActionBarTitle(level, cid, showTitleName);
						} else {
							// proccess the result. Intent intent = new
							Intent intent = new Intent(
									WareCategoryActivity.this,
									SearchListFragmentActivity.class);
							intent.putExtra("ShowType", 2);
							intent.putExtra("showName", category.getName());
							intent.putExtra("cid", category.getCid());
							startActivity(intent);
						}
					}
				});

	}

	// 请求数据
	private void requestData(int level, int cid) {
		APICategory.getWareProductCategoryList(this,
				TRA_CATEGORY_LIST_GET_SECOND, MainTabActivity.client,
				Constants.PARAM_CLIENT_ANDROID, String.valueOf(cid),
				String.valueOf(level), true, true, this);
	}

	// 数据绑定到视图
	private void buildView4Data(List<Category> list) {
		if (EmptyUtil.isCollectionEmpty(list)) {
			Logger.d(TAG, "list is empty!");
			uiHandler.sendMessage(uiHandler
					.obtainMessage(HANDLER_RESULT_NODATA));
			return;
		}
		Logger.d(TAG, "== set Data to View ! list.size=" + list.size());
		listCategorySecond.clear();
		listCategorySecond.addAll(list);
	   secondCategoryGridViewAdapter.notifyDataSetChanged();
	   swingBottomInAnimationAdapter.notifyDataSetChanged();
	}

	@Override
	public void onComplete(String transitionId, JSONObject result) {
		if (null != result) {
			Logger.d(TAG, "request success!transitionId=" + transitionId);
			List<Category> lists = GsonUtil
					.parseCategoryResult(result.toString());
			// begin request the second category.
			Message msg = uiHandler.obtainMessage(HANDLER_RESULT_FNISH,
					lists);
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

	// 处理从3级目录和2级目录的返回，以及其他页面回来时候的返回
	private void onBackNextView() {

		// 如果当前的类别在目录3 ，那么返回二级列表
		if (this.currentCategoryLevel > 0) {
			Logger.d(TAG, "从3及目录返回到2级目录");
			Category category = currentLevelCategoryMap.get(String
					.valueOf(this.currentCategoryLevel - 1));
			showActionBarTitle(this.currentCategoryLevel - 1,
					category.getCid(), category.getName());
		} else {
			// 在二级目录，返回到1级目录，可以直接关闭这个activity处理，或者做一些资源释放的功能。
			recycle(false);
		}
	}

	// 在页面关闭的时候释放资源
	private void recycle(boolean isDestory) {
		// 如果不是onDestory中调用的，那么不要调用finish.
		if (isDestory) {

		} else {
			// 如果其他地方调用，直接finish,
			this.finish();
		}
	}

	@Override
	public void onBackPressed() {
		onBackNextView();
		super.onBackPressed();
	}

	@Override
	public boolean onKeyDown(int keyCode, KeyEvent event) {
		Logger.d(TAG, "onkeyDown");
		/*
		 * if(keyCode == KeyEvent.KEYCODE_BACK){ onBackNextView(); return true;
		 * }
		 */
		switch (keyCode) {
		case KeyEvent.KEYCODE_BACK:
			return true;
		default:
			break;
		}
		return super.onKeyDown(keyCode, event);
	}

}
