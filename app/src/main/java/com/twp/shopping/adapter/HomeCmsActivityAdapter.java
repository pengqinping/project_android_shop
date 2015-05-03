/*
 * 版       权:  Royal.k.peng@gmail.com, All rights reserved
 * 作       者:  Royal
 * 座 右  铭:  Never give up, adhere to in the end.
 */
package com.twp.shopping.adapter;

import java.util.ArrayList;

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
import com.twp.shopping.http.jd.model.recommend.CmsActivityWare;
import com.twp.shopping.util.ConfigDataUtil;

/**
 * 
 * @author Royal
 * @Email Royal.k.peng@gmail.com
 */
public class HomeCmsActivityAdapter extends BasicAdapter<CmsActivityWare> {
	private ImageWorker mImageWorker;

	public HomeCmsActivityAdapter(Context mContext) {
		super(mContext);
		init();
	}

	public HomeCmsActivityAdapter(ArrayList<CmsActivityWare> cmsActivityWare,Context mContext) {
		super(cmsActivityWare,mContext);
		init();
	}

	private void init() {
		mImageWorker = new ImageFetcher(getContext(), 96, 96);
		mImageWorker.setImageCache(ConfigDataUtil.getInstance().getmImageCache());
		mImageWorker.setLoadingImage(R.drawable.default_96_96);
	}

	@Override
	public View getItemView(int position, View convertView, ViewGroup parent) {
		ViewHolder viewHolder;
		if(convertView == null){
			viewHolder = new ViewHolder();
			convertView = LayoutInflater.from(getContext()).inflate(R.layout.item_cms_activity_listview, null);
			viewHolder.imgCmsActivityIcon = (ImageView)convertView.findViewById(R.id.imgCmsActivityIcon);
			viewHolder.tvWareName = (TextView)convertView.findViewById(R.id.tvWareName);
			viewHolder.tvJdPrice = (TextView)convertView.findViewById(R.id.tvjdPrice);
			viewHolder.tvMarkPrice = (TextView)convertView.findViewById(R.id.tvMarkPrice);
			convertView.setTag(viewHolder);
		}else{
			viewHolder = (ViewHolder)convertView.getTag();
		}
		
		final CmsActivityWare cmsActivityWare = getLists().get(position);
		if(null != cmsActivityWare){
			viewHolder.tvWareName.setText(cmsActivityWare.getWareName());
			viewHolder.tvJdPrice.setText(String.valueOf(cmsActivityWare.getJdPrice()));
			viewHolder.tvMarkPrice.setText(cmsActivityWare.getAdWord());
			String imageUrl = cmsActivityWare.getImageUrl();
			mImageWorker.loadImage(imageUrl,viewHolder.imgCmsActivityIcon);
		}
		
		return convertView;
	}

	static class ViewHolder{
		public ImageView imgCmsActivityIcon;
		public TextView tvWareName;
		public TextView tvJdPrice;
		public TextView tvMarkPrice;
	}
	
}
