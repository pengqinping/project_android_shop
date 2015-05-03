/*
 * 版       权:  Royal.k.peng@gmail.com, All rights reserved
 * 作       者:  Royal
 * 座 右  铭:  Never give up, adhere to in the end.
 */
package com.twp.shopping.adapter;

import java.util.ArrayList;
import java.util.List;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;

/**
 * 
 * @author Royal
 * @Email Royal.k.peng@gmail.com
 * @param <T>
 */
public abstract class BasicAdapter<T> extends BaseAdapter {

	private List<T> lists ;

	private Context context;

	public List<T> getLists() {
		return lists;
	}

	public Context getContext() {
		return context;
	}

	public BasicAdapter(Context context) {
		this.context = context;
	}

	/**
	 * @param lists
	 * @param context
	 */
	public BasicAdapter(List<T> lists, Context context) {
		super();
		this.lists = lists;
		this.context = context;
	}

	@Override
	public int getCount() {

		return null != lists ? lists.size() : 0;
	}

	@Override
	public Object getItem(int position) {
		return null != lists ? lists.get(position) : null;
	}

	@Override
	public long getItemId(int position) {
		return position;
	}

	@Override
	public View getView(int position, View convertView, ViewGroup parent) {
		View itemView = getItemView(position, convertView, parent);
		return itemView;
	}

	public abstract View getItemView(int position, View convertView,
			ViewGroup parent);

}
