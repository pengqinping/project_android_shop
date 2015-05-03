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

import com.twp.frame.request.image.ImageCache;
import com.twp.frame.request.image.ImageFetcher;
import com.twp.frame.request.image.ImageWorker;
import com.twp.shopping.R;
import com.twp.shopping.http.jd.model.ware.Activity;
import com.twp.shopping.util.ConfigDataUtil;

/**
 * 
 * @author Royal
 * @Email Royal.k.peng@gmail.com
 */
public class HomeAdsFlowViewAdapter extends BasicAdapter<Activity> {
	private ImageWorker mImageWorker;

	public HomeAdsFlowViewAdapter(Context mContext) {
		super(mContext);
		init();
	}

	public HomeAdsFlowViewAdapter(List<Activity> homeAdsList,Context mContext) {
		super(homeAdsList,mContext);
		init();
	}

	private void init() {
		mImageWorker = new ImageFetcher(getContext(), 720,180);
		mImageWorker.setImageCache(ConfigDataUtil.getInstance().getmImageCache());
		mImageWorker.setLoadingImage(R.drawable.default_720_180);
	}

	@Override
	public View getItemView(int position, View convertView, ViewGroup parent) {
		ViewHolder viewHolder;
		if(convertView == null){
			viewHolder = new ViewHolder();
			convertView = LayoutInflater.from(getContext()).inflate(R.layout.ads_item_imageview, null);
			viewHolder.imgAdsView = (ImageView)convertView.findViewById(R.id.imageViewAds);
			convertView.setTag(viewHolder);
		}else{
			viewHolder = (ViewHolder)convertView.getTag();
		}
		
		Activity activityAds = getLists().get(position);
		if(null != activityAds){
			String imageUrl = activityAds.getHorizontalImag();
			mImageWorker.loadImage(imageUrl, viewHolder.imgAdsView);
		}
		
		return convertView;
	}

	static class ViewHolder{
		public ImageView imgAdsView;
	}
	
}
