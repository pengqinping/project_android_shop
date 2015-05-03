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
public class APICPS {

	/**
	 * [1]. 联盟店铺转换 接口名称： jingdong.union.promotionshop.update
	 * 
	 * 功能说明： 查询相关的店铺名称的店铺推广数据（查询若无结果或者没输入查询条件则返回默认店铺推广数据） . shopName String 否
	 * 店铺名称串,如果shopName不填或者没有相匹配的店铺信息则返回默认的推广数据 fields String 否
	 * shop_name,shop_promUrl,shop_materialUrl,
	 * shop_goodsVolume,shop_praiseDegree,
	 * shop_promQuantity,shop_mainCategories, shop_pk,shop_name,totalCount
	 * 需返回的字段列表
	 */
	public static void getUnionPromotionShopUpdate(Context mContext,
			String transitionId, JdAndroidClient jdClient, String shopName,
			String fields, JdListener.RequestListener listener) {
		Bundle param = new Bundle();
		param.putString("shopName", shopName);
		param.putString("fields", fields);
		jdClient.invoke(mContext, transitionId,
				"jingdong.union.promotionshop.update", param, listener);
	}

	/**
	 * [2] 联盟推广活动查询 jingdong.union.promotionactivity.query
	 * 
	 * @param keywords
	 *            String 否活动名称关键字,
	 *            如果activity_keywords和activity_categoryId为空或者是没有找到相匹配的结果
	 *            ，则返回默认的广数据
	 * @param categoryId
	 *            Number 否\活动所属类目ID,
	 *            如果activity_keywords和activity_categoryId为空或者是没有找到相匹配的结果，
	 *            则返回默认的推广数据.
	 * @param property
	 *            String 否 commisionRatio 排序列的属性名，默认值commisionRatio
	 * @param sort
	 *            String 否 DESC/ASC 升序或降序排列,默认值DESC
	 * @param pageIndex
	 *            Number 是页码，当输入页码小于1时候默认pageIndex为1
	 * @param pageSize
	 *            Number 是 每页条数，当输入条数小于1时候默认pageSize为10
	 * @param fields
	 *            Number 否 activity_pk,activity_name,activity_url,
	 *            activity_width,activity_height, activity_start,activity_end,
	 *            activity_shopName,activity_mainCategory,
	 *            activity_commRatio,totalCount 需要返回的
	 */

	public static void getUnionPromotionActivityQuery(Context mContext,
			String transitionId, JdAndroidClient jdClient, String keywords,
			int categoryId, String sort, String property, int pageIndex,
			int pageSize, int fields, JdListener.RequestListener listener) {
		Bundle param = new Bundle();
		param.putString("keywords ", keywords);
		param.putInt("categoryId", categoryId);
		param.putString("property", property);
		param.putString("sort", sort);
		param.putInt("pageIndex", pageIndex);
		param.putInt("pageSize", pageSize);
		param.putInt("int", fields);
		jdClient.invoke(mContext, transitionId,
				"jingdong.union.promotionshop.update", param, listener);
	}

}
