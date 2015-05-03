/*
 * 版       权:  Royal.k.peng@gmail.com, All rights reserved
 * 作       者:  Royal
 * 座 右  铭:  Never give up, adhere to in the end.
 */
package com.twp.shopping.adapter;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.app.FragmentStatePagerAdapter;
import android.util.SparseArray;
import android.view.ViewGroup;

import com.twp.frame.util.Logger;
import com.twp.shopping.activity.MainFragmentCollect;
import com.twp.shopping.activity.MainFragmentHome;
import com.twp.shopping.activity.MainFragmentPageAllProduct;
import com.twp.shopping.activity.MainFragmentSetting;
import com.twp.shopping.ui.JazzyViewPager;

/**
 * 
 * @author Royal
 * @Email Royal.k.peng@gmail.com
 */
public class ViewPagerAdapter extends FragmentStatePagerAdapter{

	private static final String TAG = "ViewPagerAdapter";

	// 可以把fragment 缓存起来，不能每次ViewPager get Item 都去 new一下Fragment()
	private SparseArray<Fragment> sparseArray = new SparseArray<Fragment>();

	public ViewPagerAdapter(FragmentManager fm, JazzyViewPager mJazzy) {
		super(fm);
		this.mJazzy = mJazzy;
	}

	private JazzyViewPager mJazzy;

	@Override
	public Fragment getItem(int arg0) {

		if (arg0 == 0) {
			return MainFragmentHome.newInstance();
		} else if (arg0 == 1) {
			return MainFragmentPageAllProduct.newInstance();
		} else if (arg0 == 2) {
			return MainFragmentCollect.newInstance();
		} else if (arg0 == 3) {
			return MainFragmentSetting.newInstance();
		}else{
			throw new IllegalArgumentException("IllegalArgument params");
		}

	}

	/* ... */
	@Override
	public Object instantiateItem(ViewGroup container, final int position) {
		Object obj = super.instantiateItem(container, position);
		mJazzy.setObjectForPosition(obj, position);
		return obj;
	}

	@Override
	public int getCount() {
		return 4;
	}

}
