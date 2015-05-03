/*
 * 版       权:  Royal.k.peng@gmail.com, All rights reserved
 * 作       者:  Royal
 * 座 右  铭:  Never give up, adhere to in the end.
 */
package com.twp.shopping.adapter;

import java.util.List;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.twp.frame.request.image.ImageFetcher;
import com.twp.frame.request.image.ImageWorker;
import com.twp.frame.util.Logger;
import com.twp.shopping.R;
import com.twp.shopping.http.jd.model.category.Category;
import com.twp.shopping.util.ConfigDataUtil;
/**
 * @author Royal
 * @Email Royal.k.peng@gmail.com
 */
public class FirstCategoryGridViewAdapter extends BasicAdapter<Category> {
	private static final String TAG = "FirstCategoryGridViewAdapter";
	private Context mContext;
	private List<Category> listsCategory;
	private ImageWorker mImageWorker;

	protected FirstCategoryGridViewAdapter(Context context) {
		super(context);
		init(context);
	}

	public FirstCategoryGridViewAdapter(Context context, List<Category> items) {
		super(items, context);
		Logger.v(TAG, "Enter into construction ");
		this.listsCategory = items;
		init(context);
		Logger.v(TAG, "leave construction ");
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

	static class TitleViewHodler {

		ImageView imgCateGoryIcon;// 商品图片
		TextView tvCategoryName;// 类别名称
		TextView tvCategoryTitleDesc;// 类别子目录
	}

	@Override
	public View getItemView(int position, View convertView, ViewGroup parent) {

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

}
