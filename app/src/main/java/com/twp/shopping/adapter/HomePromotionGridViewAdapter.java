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
import android.widget.TextView;

import com.twp.shopping.R;
import com.twp.shopping.http.jd.model.ware.CmsPromotions;

/**
 * 
 * @author Royal
 * @Email Royal.k.peng@gmail.com
 */
public class HomePromotionGridViewAdapter extends BasicAdapter<CmsPromotions> {
	private int[] bgcolorResId = { R.drawable.text_view_border_color1,
			R.drawable.text_view_border_color3,
			R.drawable.text_view_border_color5,
			R.drawable.text_view_border_color7,
			R.drawable.text_view_border_color9,
			R.drawable.text_view_border_color8,
			R.drawable.text_view_border_color4,
			R.drawable.text_view_border_color10,
			R.drawable.text_view_border_color2,
			R.drawable.text_view_border_color6 };

	protected HomePromotionGridViewAdapter(Context context) {
		super(context);
	}

	public HomePromotionGridViewAdapter(Context context,
			List<CmsPromotions> items) {
		super(items, context);
	}

	static class TitleViewHodler {

		// ImageView imgPromotionIcon;// 商品图片
		TextView tvName;
	}

	@Override
	public View getItemView(int position, View convertView, ViewGroup parent) {

		final int index = position;
		TitleViewHodler titleViewHodler;
		if (null == convertView) {
			titleViewHodler = new TitleViewHodler();
			convertView = LayoutInflater.from(getContext()).inflate(
					R.layout.item_home_promotion_grid_view, null);

			titleViewHodler.tvName = (TextView) convertView
					.findViewById(R.id.tvPromotionName);
			convertView.setTag(titleViewHodler);
		} else {
			titleViewHodler = (TitleViewHodler) convertView.getTag();
		}

		if (null != getLists()) {
			final CmsPromotions promotions = getLists().get(index);
			if (null != promotions) {

				String name = promotions.getPromotionName();
				titleViewHodler.tvName.setText(name.replace("促销专场", ""));
//				titleViewHodler.tvName
//						.setBackgroundResource(bgcolorResId[position % 10]);
			}
		}
		return convertView;
	}

}
