/*
 * 版       权:  Royal.k.peng@gmail.com, All rights reserved
 * 作       者:  Royal
 * 座 右  铭:  Never give up, adhere to in the end.
 */
package com.twp.shopping.http.jd;

import android.content.Context;
import android.os.Bundle;

import com.jd.open.sdk.android.JdAndroidClient;
import com.jd.open.sdk.android.JdListener;

/**
 * 
 * @author Royal
 * @Email Royal.k.peng@gmail.com
 */
public class APICategory {

	// #start 【类目服务】
	/**
	 * jingdong.ware.promotion.catelogy.attribute.list 获取类目属性信息列表
	 * 
	 * @param jdClient
	 *            JdAndroidClient
	 * @param newVersion
	 * @param catelogyId
	 *            类目id
	 * @param client
	 *            客户端类型(apple、iPad、android、m、wp、wp7、Symbian、qt、androidTv、win8、
	 *            android、Pad)
	 * @param listener
	 *            回调监听器
	 */
	public static void getWareCategoryAttrList(Context mContext,
			String transitionId, JdAndroidClient jdClient, String client,
			String newVersion, String catelogyId,
			JdListener.RequestListener listener) {
		Bundle param = new Bundle();
		param.putString("client", client);
		param.putString("newVersion", newVersion);
		param.putString("catelogyId", catelogyId);
		jdClient.invoke(mContext, transitionId,
				"jingdong.ware.catelogy.attribute.list.get", param, listener);
	}

	/**
	 * 获取类目信息　替换： jingdong.warecategory.get
	 * 
	 * @param jdClient
	 *            JdAndroidClient
	 * @param catelogyId
	 *            类目id，默认为0
	 * @param level
	 *            等级(类目分为1、2、3级，对应值为0、1、2)
	 * @param isIcon
	 *            是否加载下级图标 (true or false)
	 * @param isDescription
	 *            是否加载下级描述 (true or false)
	 * @param listener
	 *            回调监听器
	 */
	public static void getWareProductCategoryList(Context mContext,
			String transitionId, JdAndroidClient jdClient, String client,
			String catelogyId, String level, boolean isIcon,
			boolean isDescription, JdListener.RequestListener listener) {
		Bundle param = new Bundle();
		param.putString("client", client);
		param.putString("catelogyId", catelogyId);
		param.putString("level", level);
		param.putString("isIcon", String.valueOf(isIcon));
		param.putString("isDescription", String.valueOf(isDescription));
		param.putString("client", client);
		jdClient.invoke(mContext, transitionId,
				"jingdong.ware.product.catelogy.list.get", param, listener);
	}
	// #end

}
