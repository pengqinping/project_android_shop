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

import com.twp.frame.request.image.ImageFetcher;
import com.twp.frame.request.image.ImageWorker;
import com.twp.shopping.R;
import com.twp.shopping.http.jd.model.union.CmsActivity;
import com.twp.shopping.util.ConfigDataUtil;

/**
 * 
 * @author Royal
 * @Email Royal.k.peng@gmail.com
 */
public class HomeCmsActivityListAdapter extends BasicAdapter<CmsActivity> {
	private ImageWorker mImageWorker;

	public HomeCmsActivityListAdapter(Context mContext) {
		super(mContext);
		init();
	}

	public HomeCmsActivityListAdapter(ArrayList<CmsActivity> cmsActivitys,Context mContext) {
		super(cmsActivitys,mContext);
		init();
	}

	private void init() {
		mImageWorker = new ImageFetcher(getContext(), 720, 225);
		mImageWorker.setImageCache(ConfigDataUtil.getInstance().getmImageCache());
		mImageWorker.setLoadingImage(R.drawable.default_720_225);
	}

	@Override
	public View getItemView(int position, View convertView, ViewGroup parent) {
		ViewHolder viewHolder;
		if(convertView == null){
			viewHolder = new ViewHolder();
			convertView = LayoutInflater.from(getContext()).inflate(R.layout.item_promotion_detail_list, null);
			viewHolder.imgViewPromotion = (ImageView)convertView.findViewById(R.id.imgPromotionListDetail);
			viewHolder.tvPromotionTitle = (TextView)convertView.findViewById(R.id.tvPromotionTitle);
			viewHolder.tvPromotionContent = (TextView)convertView.findViewById(R.id.tvPromotionContent);
			convertView.setTag(viewHolder);
		}else{
			viewHolder = (ViewHolder)convertView.getTag();
		}
		
		final CmsActivity cmsActivity = getLists().get(position);
		if(null != cmsActivity){
			viewHolder.tvPromotionTitle.setText(cmsActivity.getTitle());
			String startTime = cmsActivity.getStartDate();
			String endTime = cmsActivity.getEndDate();
			viewHolder.tvPromotionContent.setText("活动时间:\n"+startTime+"\t -- \t"+endTime);
			String imageUrl = cmsActivity.getImageUrl();
			mImageWorker.loadImage(imageUrl,viewHolder.imgViewPromotion);
		}
		
		return convertView;
	}

	static class ViewHolder{
		public ImageView imgViewPromotion;
		public TextView tvPromotionTitle;
		public TextView tvPromotionContent;
	}
	
}
