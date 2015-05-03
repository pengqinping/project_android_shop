/*
 * 版       权:  Royal.k.peng@gmail.com, All rights reserved
 * 作       者:  Royal
 * 座 右  铭:  Never give up, adhere to in the end.
 */
package com.twp.shopping.adapter;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;

import com.haarman.listviewanimations.itemmanipulation.ExpandableListItemAdapter;
import com.twp.frame.request.image.ImageFetcher;
import com.twp.frame.request.image.ImageWorker;
import com.twp.frame.util.Logger;
import com.twp.shopping.R;
import com.twp.shopping.http.jd.model.category.Category;
import com.twp.shopping.util.ConfigDataUtil;

/**
 * 
 * @author Royal
 * @Email Royal.k.peng@gmail.com
 */
public class CategoryListViewAdapter extends
		ExpandableListItemAdapter<Category> {
	private Context mContext;
	private List<Category> listsCategory;
	private ImageWorker mImageWorker;
	private Map<String, List<Category>> mapsSecondCategory = new HashMap<String, List<Category>>();

	protected CategoryListViewAdapter(Context context) {
		super(context);
		init(context);
	}

	public CategoryListViewAdapter(Context context, List<Category> items) {
		super(context, R.layout.activity_expandablelistitem_card,
				R.id.categy_expandablelistitem_card_title,
				R.id.categy_expandablelistitem_card_content, items);
		Logger.i(context + " == " + items.size());
		this.listsCategory = items;
		init(context);
	}

	public void setData(List<Category> listsCategory) {
		this.listsCategory = listsCategory;
		notifyDataSetChanged();
	}

	private void init(Context context) {
		mContext = context;
		mImageWorker = new ImageFetcher(mContext, 96);
		mImageWorker.setImageCache(ConfigDataUtil.getInstance().getmImageCache());
		mImageWorker.setLoadingImage(R.drawable.default_96_96);
	}

	@Override
	public View getTitleView(int position, View convertView, ViewGroup parent) {
		Logger.i("getTitleView");
		final int index = position;
		TitleViewHodler titleViewHodler;
		if (null == convertView) {
			titleViewHodler = new TitleViewHodler();
			convertView = LayoutInflater.from(mContext).inflate(
					R.layout.category_list_title, null);
			titleViewHodler.imgCateGoryIcon = (ImageView) convertView
					.findViewById(R.id.imgCategoryIcon);
			titleViewHodler.tvCategoryName = (TextView) convertView
					.findViewById(R.id.tvCategoryListTitle);
			titleViewHodler.tvCategoryTitleDesc = (TextView) convertView
					.findViewById(R.id.tvCategoryTitleDesc);
			convertView.setTag(titleViewHodler);
		} else {
			titleViewHodler = (TitleViewHodler) convertView.getTag();
		}

		final Category category = listsCategory.get(index);
		if (null != category) {

			titleViewHodler.tvCategoryName.setText(category.getName());
			titleViewHodler.tvCategoryTitleDesc.setText(category
					.getDescription());
			String loadImageUrl = category.getIcon();
			mImageWorker.loadImage(loadImageUrl,
					titleViewHodler.imgCateGoryIcon);
		}

		return convertView;
	}

	@Override
	public View getContentView(int position, View convertView, ViewGroup parent) {
		// request a next data
		final int index = position;
		Logger.i("getContentView");
		ContentViewHodler contentViewHolder;
		if (null == convertView) {
			contentViewHolder = new ContentViewHodler();
			convertView = LayoutInflater.from(mContext).inflate(
					R.layout.category_list_content, null);
			contentViewHolder.listview = (ListView) convertView
					.findViewById(R.id.secondCategoryListView);
			convertView.setTag(contentViewHolder);
		} else {
			contentViewHolder = (ContentViewHodler) convertView.getTag();
		}

		final Category cateGory = listsCategory.get(index);
		if (null != cateGory) {
			final String cid = String.valueOf(cateGory.getCid());
			if (mapsSecondCategory.containsKey("cid")) {
				Logger.i(" Second list has request we are don't to reqeust!");
				buildContentListView(mapsSecondCategory.get(cid),
						contentViewHolder);
			} else {
				Logger.i("Second list request...");
				// requestSecondCategory(cid, contentViewHolder);
			}
		}

		// end

		return convertView;
	}

	private void buildContentListView(List<Category> lists,
			ContentViewHodler contentViewHolder) {

		SecondAdapter secondAdapter = new SecondAdapter(lists, mContext);
		// get viewHolder
		contentViewHolder.listview.setAdapter(secondAdapter);

		// domian calc height of listview

		int totalHeight = 0;

		for (int i = 0; i < secondAdapter.getCount(); i++) {
			View listItem = secondAdapter.getView(i, null,
					contentViewHolder.listview);
			if (null != listItem) {
				listItem.measure(0, 0);
				totalHeight += listItem.getMeasuredHeight();
			} else {
				Logger.i("get view error!");
			}
		}

		ViewGroup.LayoutParams params = contentViewHolder.listview
				.getLayoutParams();

		params.height = totalHeight
				+ (contentViewHolder.listview.getDividerHeight() * (secondAdapter
						.getCount() - 1));

		// ((MarginLayoutParams) params).setMargins(10, 10, 10, 10); // 可删除

		contentViewHolder.listview.setLayoutParams(params);

	}

	/*
	 * private void requestSecondCategory(final String cid, final
	 * ContentViewHodler contentViewHolder) {
	 * APICategory.getWareProductCategoryList(MainTabActivity.client,
	 * Constants.PARAM_CLIENT_ANDROID, cid, "1", true, true, new
	 * RequestListener() {
	 * 
	 * @Override public void onJdError(JdException e) {
	 * Logger.i("getSecend list has error!"); }
	 * 
	 * @Override public void onError(InvokeError e) {
	 * Logger.i("getSecend list has error!"); }
	 * 
	 * @Override public void onComplete(JSONObject result) { if (null != result)
	 * { Logger.i(" == request success! cid = " + cid); List<Category>
	 * listOfSecend = GsonUtil .parseCategoryResult(result.toString());
	 * mapsSecondCategory.put(cid, listOfSecend);
	 * buildContentListView(listOfSecend, contentViewHolder);
	 * 
	 * } else { Logger.i("getSecond is no data!"); } } }); }
	 */

	static class TitleViewHodler {

		ImageView imgCateGoryIcon;// 商品图片
		TextView tvCategoryName;// 类别名称
		TextView tvCategoryTitleDesc;// 类别子目录
	}

	static class ContentViewHodler {
		ListView listview;
	}

	private class SecondAdapter extends BasicAdapter<Category> {

		public SecondAdapter(Context context) {
			super(context);
		}

		public SecondAdapter(List<Category> lists, Context context) {
			super(lists, context);
		}

		@Override
		public View getItemView(int position, View convertView, ViewGroup parent) {
			final int index = position;
			SecondCategoryName secondCategoryViewHodler;
			if (null == convertView) {
				secondCategoryViewHodler = new SecondCategoryName();
				convertView = LayoutInflater.from(mContext).inflate(
						R.layout.item_second_category, null);
				secondCategoryViewHodler.imgSecondCategoryIcon = (ImageView) convertView
						.findViewById(R.id.imgSecondCategoryIcon);

				secondCategoryViewHodler.tvSecondCategoryName = (TextView) convertView
						.findViewById(R.id.tvSecondCategoryName);

				secondCategoryViewHodler.tvSecondCategoryDesc = (TextView) convertView
						.findViewById(R.id.tvSecondCategoryDesc);

				convertView.setTag(secondCategoryViewHodler);
			} else {
				secondCategoryViewHodler = (SecondCategoryName) convertView
						.getTag();
			}

			final Category secondCategory = getLists().get(index);
			if (null != secondCategory) {
				secondCategoryViewHodler.tvSecondCategoryName
						.setText(secondCategory.getName());
				secondCategoryViewHodler.tvSecondCategoryDesc
						.setText(secondCategory.getDescription());
				mImageWorker.loadImage(secondCategory.getIcon(),
						secondCategoryViewHodler.imgSecondCategoryIcon);
			}
			return convertView;
		}
	}

	static class SecondCategoryName {
		ImageView imgSecondCategoryIcon;
		TextView tvSecondCategoryName;
		TextView tvSecondCategoryDesc;

	}

}
