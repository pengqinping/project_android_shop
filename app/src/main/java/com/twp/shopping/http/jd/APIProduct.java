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
public class APIProduct {
	/**
	 * [1] 根据类目搜索商品　替换接口：jingdong.wares.searchbycid
	 * jingdong.ware.promotion.search.catelogy.list
	 * 
	 * @param jdClient
	 *            JdAndroidClient
	 * @param client
	 *            客户端类型(apple、iPad、android、m、wp、wp7、Symbian、qt、androidTv、win8、
	 *            android、Pad)
	 * @param catelogyId
	 *            类目id
	 * @param page
	 *            页码
	 * @param pageSize
	 *            每页多少条
	 * @param listener
	 *            回调监听器
	 */
	public static void getWareListByCategoryId(Context mContext,
			String transitionId,JdAndroidClient jdClient,
			String client, String catelogyId, String page, String pageSize,
			JdListener.RequestListener listener) {
		Bundle param = new Bundle();
		param.putString("catelogyId", catelogyId);
		param.putString("page", page);
		param.putString("pageSize", pageSize);
		param.putString("client", client);
		jdClient.invoke(mContext, transitionId,"jingdong.ware.promotion.search.catelogy.list", param,
				listener);
	}

	/**
	 * [2] jingdong.ware.selected.province.list.get 商品所属省会编号查询
	 * 
	 * @param jdClient
	 *            JdAndroidClient
	 * @param client
	 *            客户端类型(apple、iPad、android、m、wp、wp7、Symbian、qt、androidTv、win8、
	 *            android、Pad)
	 * @param listener
	 *            回调监听器
	 */
	public static void getWareSelectedProvinceList(Context mContext,
			String transitionId,JdAndroidClient jdClient,
			String client, JdListener.RequestListener listener) {
		Bundle param = new Bundle();
		param.putString("client", client);
		jdClient.invoke(mContext, transitionId,"jingdong.ware.selected.province.list.get", param,
				listener);
	}

	/**
	 * [3] 根据关键字搜索商品
	 * 
	 * @param jdClient
	 *            JdAndroidClient
	 * @param isLoadAverageScore
	 *            是否加载评星，true为加载，false为不加载
	 * @param isLoadPromotion
	 *            是否加载促销，true为加载，false为不加载
	 * @param sort
	 *            排序 1:销量排序 2:价格降序 3:价格升序 4:好评度 6:评论数
	 * @param page
	 *            页码 第一页加载传入1。传入0请求不到数据
	 * @param pageSize
	 *            每页多少条
	 * @param keyword
	 *            关键词
	 * @param client
	 *            客户端类型
	 * @param listener
	 *            回调监听器
	 */
	public static void getWareListByKeyword(Context mContext,
			String transitionId,JdAndroidClient jdClient,
			String client, boolean isLoadAverageScore, boolean isLoadPromotion,
			int sort, int page, int pageSize, String keyword,
			JdListener.RequestListener listener) {
		Bundle param = new Bundle();
		param.putString("isLoadAverageScore",
				String.valueOf(isLoadAverageScore));
		param.putString("isLoadPromotion", String.valueOf(isLoadPromotion));

		param.putString("sort", String.valueOf(sort));
		param.putString("page", String.valueOf(page));
		param.putString("pageSize", String.valueOf(pageSize));
		param.putString("keyword", keyword);

		param.putString("client", client);
		jdClient.invoke(mContext, transitionId,"jingdong.ware.product.search.list.get", param,
				listener);
	}

	/**
	 * [4]
	 * 
	 * 获取库存信息列表
	 * 
	 * @param jdClient
	 *            JdAndroidClient
	 * @param skuId
	 *            商品编号
	 * @param provinceId
	 *            省份编号
	 * @param client
	 *            客户端类型
	 * @param listener
	 *            回调监听器
	 */
	public static void getWareProductStockList(Context mContext,
			String transitionId,JdAndroidClient jdClient,
			int skuId, int provinceId, String client,
			JdListener.RequestListener listener) {
		Bundle param = new Bundle();

		param.putString("skuId", String.valueOf(skuId));
		param.putString("provinceId", String.valueOf(provinceId));
		param.putString("client", client);
		jdClient.invoke(mContext, transitionId,"jingdong.ware.product.stock.list.get", param, listener);
	}

	/**
	 * [5] jingdong.ware.promotion.sku.search.list 获取商品SKU信息列表
	 * 
	 * @param jdClient
	 *            JdAndroidClient
	 * @param skuId
	 *            商品编号
	 * @param client
	 *            客户端类型(apple、iPad、android、m、wp、wp7、Symbian、qt、androidTv、win8、
	 *            android、Pad)
	 * @param listener
	 *            回调监听器
	 */
	public static void getWareSkuSearchList(Context mContext,
			String transitionId,JdAndroidClient jdClient,
			String client, String skuId, JdListener.RequestListener listener) {
		Bundle param = new Bundle();
		param.putString("client", client);
		param.putString("skuId", skuId);
		jdClient.invoke(mContext, transitionId,"jingdong.ware.sku.search.list.get", param, listener);
	}

	/**
	 * [6] 获取商品详情列表 替换接口：jingdong.wares.search
	 * 
	 * @param jdClient
	 *            JdAndroidClient
	 * @param skuId
	 *            商品编号
	 * @param isLoadWareScore
	 *            是否加载商品积分，true加载，false不加载
	 * @param client
	 *            客户端类型 (apple、iPad、android、m、wp、wp7、Symbian、qt、androidTv、win8
	 *            、android、Pad)
	 * @param listener
	 *            回调监听器
	 */
	public static void getWareProductWareDetail(Context mContext,
			String transitionId,JdAndroidClient jdClient,
			String client, int skuId, boolean isLoadWareScore,
			JdListener.RequestListener listener) {
		Bundle param = new Bundle();
		param.putString("client", client);
		param.putString("skuId", String.valueOf(skuId));
		param.putString("isLoadWareScore", String.valueOf(isLoadWareScore));
		jdClient.invoke(mContext, transitionId,"jingdong.ware.product.detail.search.list.get", param,
				listener);
	}

	/**
	 * [7] 获取商品基本信息
	 * 
	 * @param bases
	 *            需要查询的字段，与返回值ProductBase中的字段对应 jingdong.ware.baseproduct.get
	 */
	public static void getWareBaseProdct(Context mContext,
			String transitionId,JdAndroidClient jdClient, String ids,
			String bases, JdListener.RequestListener listener) {
		Bundle param = new Bundle();
		param.putString("ids", ids);
		param.putString("base", bases);
		jdClient.invoke(mContext, transitionId,"jingdong.ware.baseproduct.get", param, listener);
	}

	/**
	 * [8].获取商品分类信息 jingdong.ware.productsort.get
	 * 
	 * @param jdClient
	 * @param product_sort_ids
	 *            可批量查询分类ID，中间用逗号分隔
	 * @param listener
	 */
	public static void getWareProductSort(Context mContext,
			String transitionId,JdAndroidClient jdClient,
			int[] product_sort_ids, JdListener.RequestListener listener) {
		Bundle param = new Bundle();
		param.putIntArray("product_sort_ids", product_sort_ids);
		jdClient.invoke(mContext, transitionId,"jingdong.ware.baseproduct.get", param, listener);
	}

	/**
	 * [9].获取商品大字段信息 sku_id String 是 500200 skuId field String[] 是 wareQD
	 * 传入要查询的字段，如：wareQD（包装清单
	 * ）、propCode（规格参数）、wdis（商品介绍）、shouhou（售后）。可单独查询一个字段，也可查询多个
	 * ，查多个时用逗号分隔。如：prop_code,wdis
	 */
	public static void getWareProductBigField(Context mContext,
			String transitionId,JdAndroidClient jdClient,
			String sku_id, String field, JdListener.RequestListener listener) {
		Bundle param = new Bundle();
		param.putString("sku_id", sku_id);
		param.putString("field", field);
		jdClient.invoke(mContext, transitionId,"jingdong.ware.productbigfield.get", param, listener);

	}

	/**
	 * [10].获取图书大字段信息 sku_id Number[] 是 skuid
	 */
	public static void getWareProductBigField(Context mContext,
			String transitionId,JdAndroidClient jdClient,
			String[] sku_id, JdListener.RequestListener listener) {
		Bundle param = new Bundle();
		param.putStringArray("sku_id", sku_id);
		jdClient.invoke(mContext, transitionId,"jingdong.ware.bookbigfield.get", param, listener);

	}

	/**
	 * [11].获取商品图片信息（多图） jingdong.ware.productimage.get
	 */
	public static void getProductImageField(Context mContext,
			String transitionId,JdAndroidClient jdClient,
			String[] sku_id, JdListener.RequestListener listener) {
		Bundle param = new Bundle();
		param.putStringArray("sku_id", sku_id);
		jdClient.invoke(mContext, transitionId,"jingdong.ware.productimage.get", param, listener);

	}

	/**
	 * [12].获取音像大字段信息 jingdong.ware.videobigfield.get
	 */
	public static void getWareVideoBigField(Context mContext,
			String transitionId,JdAndroidClient jdClient,
			String[] sku_id, JdListener.RequestListener listener) {
		Bundle param = new Bundle();
		param.putStringArray("sku_id", sku_id);
		jdClient.invoke(mContext, transitionId,"jingdong.ware.videobigfield.get", param, listener);

	}

	/**
	 * [13].获取音像基本信息 jingdong.ware.basevideo.get
	 */
	public static void getWareBaseVideo(Context mContext,
			String transitionId,JdAndroidClient jdClient,
			String[] sku_id, JdListener.RequestListener listener) {
		Bundle param = new Bundle();
		param.putStringArray("sku_id", sku_id);
		jdClient.invoke(mContext, transitionId,"jingdong.ware.basevideo.get", param, listener);

	}

	/**
	 * [14].获取图书基本信息 接口名称 jingdong.ware.basebook.get
	 */
	public static void getWareBaseBook(Context mContext,
			String transitionId,JdAndroidClient jdClient,
			String[] sku_id, JdListener.RequestListener listener) {
		Bundle param = new Bundle();
		param.putStringArray("sku_id", sku_id);
		jdClient.invoke(mContext, transitionId,"jingdong.ware.basebook.get", param, listener);

	}
}
