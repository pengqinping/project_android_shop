/*
 * 版       权:  Royal.k.peng@gmail.com, All rights reserved
 * 作       者:  Royal
 * 座 右  铭:  Never give up, adhere to in the end.
 */
package com.twp.shopping.adapter;

import java.util.List;

import com.twp.shopping.http.jd.model.Promotion;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

/**
 * 
 * @author Royal
 * @Email Royal.k.peng@gmail.com
 */
public class PromotionListAdapter extends BasicAdapter<Promotion> {

	public PromotionListAdapter(List<Promotion> lists, Context context) {
		super(lists, context);
	}

	@Override
	public View getItemView(int position, View convertView, ViewGroup parent) {
		final Promotion pomotion = getLists().get(position);

		return new TextView(getContext());
	}

	static class ViewHodler {

	}

}
