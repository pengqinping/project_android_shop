/*
 * 版       权:  Royal.k.peng@gmail.com, All rights reserved
 * 作       者:  Royal
 * 座 右  铭:  Never give up, adhere to in the end.
 */
package com.twp.shopping.adapter;

import java.util.Collection;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

import android.content.Context;
import android.database.Cursor;
import android.graphics.drawable.Drawable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CursorAdapter;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.twp.frame.request.image.ImageFetcher;
import com.twp.frame.request.image.ImageWorker;
import com.twp.frame.util.Logger;
import com.twp.shopping.R;
import com.twp.shopping.provider.CollectOpenHelper;
import com.twp.shopping.util.ConfigDataUtil;

/**
 * @author Royal
 * @Email Royal.k.peng@gmail.com
 */
public class CollectListViewAdapter extends CursorAdapter {
	private static final String TAG = "CollectListViewAdapter";
	private ImageWorker mImageWorker;
	private LayoutInflater mInflater;
	private boolean actionModeStarted;
	private Map<Integer, Integer> itemStatusMap = new HashMap<Integer, Integer>();
	private Context mContext;

	public boolean isActionModeStarted() {
		return actionModeStarted;
	}

	public void setActionModeStarted(boolean actionModeStarted) {
		this.actionModeStarted = actionModeStarted;
	}

	public void setItemStatu(int position, int status) {
		itemStatusMap.put(position, status);
		notifyDataSetChanged();
	}

	public int getItemStatu(int position) {
		if (itemStatusMap.containsKey(position)) {
			return itemStatusMap.get(position);
		}
		return 0;
	}

	public Set<Integer> getSelectedItem() {
		Set<Integer> selectKeySet = new HashSet<Integer>();
		Set<Integer> keySet = itemStatusMap.keySet();
		Iterator<Integer> itKey = keySet.iterator();
		while (itKey.hasNext()) {
			Integer key = (Integer) itKey.next();
			int status = itemStatusMap.get(key);
			if (status == 1) {
				selectKeySet.add(key);
			}
		}

		return selectKeySet;
	}

	public int getSeletedCount() {
		Collection<Integer> values = itemStatusMap.values();
		if (values == null || values.isEmpty()) {
			return 0;
		}
		int count = 0;
		Iterator<Integer> valueIt = values.iterator();
		while (valueIt.hasNext()) {
			if (valueIt.next() == 1) {
				count++;
			}
		}
		return count;
	}

	public CollectListViewAdapter(Context context) {
		super(context, null);
		init(context);
		mInflater = LayoutInflater.from(context);
	}

	private void init(Context context) {
		this.mContext = context;
		mImageWorker = new ImageFetcher(context, 96);
		mImageWorker.setImageCache(ConfigDataUtil.getInstance()
				.getmImageCache());
		mImageWorker.setLoadingImage(R.drawable.default_96_96);
	}

	@Override
	public void bindView(View convertView, Context context, Cursor cursor) {
		ImageView imgSearchListViewIcon = (ImageView) convertView
				.findViewById(R.id.imgSearchListViewIcon);
		TextView tvWareInfoName = (TextView) convertView
				.findViewById(R.id.tvWareInfoName);
		TextView tvWareInfoprice = (TextView) convertView
				.findViewById(R.id.tvWareInfoprice);
		String wareName = cursor
				.getString(CollectOpenHelper.COLUMNINDEX_WARMNAME);
		String warePrice = cursor
				.getString(CollectOpenHelper.COLUMNINDEX_WAREPRICE);
		String url = cursor
				.getString(CollectOpenHelper.COLUMNINDEX_WARE_IMAGEURL);
		tvWareInfoName.setText(wareName);
		tvWareInfoprice.setText(warePrice);
		mImageWorker.loadImage(url, imgSearchListViewIcon);
		if (null != cursor) {
			updateBackground(convertView, cursor.getPosition());
		}
	}

	private void updateBackground(View view, int positionId) {
		int resID = R.drawable.list_nomarl_bg;
		if (!itemStatusMap.containsKey(positionId)) {
			resID = R.drawable.list_nomarl_bg;
		} else {
			if (itemStatusMap.get(positionId) == 0) {
				//未选中状态
				resID = R.drawable.list_nomarl_bg;
			} else {
				//选中状态
				resID =R.drawable.list_press_bg;
			}
		}

		Drawable drawable = mContext.getResources().getDrawable(resID);
		if (view instanceof RelativeLayout) {

			((RelativeLayout) view).setBackgroundDrawable(drawable);
		}
	}

	@Override
	public View newView(Context arg0, Cursor arg1, ViewGroup arg2) {
		return mInflater.inflate(R.layout.item_collect_listview, null);
	}

}
