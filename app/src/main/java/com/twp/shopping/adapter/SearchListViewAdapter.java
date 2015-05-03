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

import com.twp.frame.request.image.ImageCache;
import com.twp.frame.request.image.ImageFetcher;
import com.twp.frame.request.image.ImageWorker;
import com.twp.shopping.R;
import com.twp.shopping.http.jd.model.product.WareInfo;
import com.twp.shopping.util.ConfigDataUtil;
import com.twp.shopping.util.StaticConstant;

/**
 * @author Royal
 * @Email Royal.k.peng@gmail.com
 */
public class SearchListViewAdapter extends BasicAdapter<WareInfo> {
	private static final String TAG = "SearchListViewAdapter";
	private ImageWorker mImageWorker;

	protected SearchListViewAdapter(Context context) {
		super(context);
		init();
	}

	public SearchListViewAdapter(Context context, List<WareInfo> items) {
		super(items, context);
		init();
	}

	private void init() {
		mImageWorker = new ImageFetcher(getContext(), 96);
		mImageWorker.setImageCache(ConfigDataUtil.getInstance().getmImageCache());
		mImageWorker.setLoadingImage(R.drawable.default_96_96);
	}

	static class TitleViewHodler {

		ImageView imgSearchListViewIcon;// 商品图片
		TextView tvWareInfoName;// 类别名称
		TextView tvWareInfoprice;// 类别子目录
	}

	@Override
	public View getItemView(int position, View convertView, ViewGroup parent) {

		final int index = position;
		TitleViewHodler titleViewHodler;
		if (null == convertView) {
			titleViewHodler = new TitleViewHodler();
			convertView = LayoutInflater.from(getContext()).inflate(
					R.layout.item_search_listview, null);
			titleViewHodler.imgSearchListViewIcon = (ImageView) convertView
					.findViewById(R.id.imgSearchListViewIcon);
			titleViewHodler.tvWareInfoName = (TextView) convertView
					.findViewById(R.id.tvWareInfoName);
			titleViewHodler.tvWareInfoprice = (TextView) convertView
					.findViewById(R.id.tvWareInfoprice);
			convertView.setTag(titleViewHodler);
		} else {
			titleViewHodler = (TitleViewHodler) convertView.getTag();
		}

		if (null != getLists()) {
			final WareInfo mWareInfo = getLists().get(index);
			if (null != mWareInfo) {

				titleViewHodler.tvWareInfoName.setText(mWareInfo.getWareName());
				titleViewHodler.tvWareInfoprice.setText(String
						.valueOf(mWareInfo.getJdPrice()));
				String loadImageUrl = mWareInfo.getImageUrl();
				mImageWorker.loadImage(loadImageUrl,
						titleViewHodler.imgSearchListViewIcon);
			}

		}
		return convertView;
	}

}
