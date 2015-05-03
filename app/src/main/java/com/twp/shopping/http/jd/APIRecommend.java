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
public class APIRecommend {

	/**
	 * [1].
	 * 购买此商品用户最终购买的商品 替换：jingdong.userbrowsebuyrecommend.ware.get
	 * 
	 * @param jdClient
	 *            JdAndroidClient
	 * @param client
	 *            客户端类型(apple、iPad、android、m、wp、wp7、Symbian、qt、androidTv、win8、
	 *            android、Pad)
	 * @param wareId
	 *            商品ID
	 * @param listener
	 *            回调监听器
	 */
	public static void getWareBuyTobuyList(Context mContext,
			String transitionId,JdAndroidClient jdClient,
			String client, String wareId, JdListener.RequestListener listener) {
		Bundle param = new Bundle();
		param.putString("client", client);
		param.putString("wareId", wareId);
		jdClient.invoke(mContext, transitionId,"jingdong.ware.buytobuy.list.get", param, listener);
	}
	

	/**
	 * [2].浏览商品的用户还购买的商品 替换：jingdong.anotherbuyrecommend.ware.get
	 * 
	 * @param jdClient
	 *            JdAndroidClient
	 * @param wareId
	 *            商品编号
	 * @param client
	 *            客户端类型(apple、iPad、android、m、wp、wp7、Symbian、qt、androidTv、win8、
	 *            android、Pad)
	 * @param listener
	 *            回调监听器
	 */
	public static void getWareBrowseToBuyList(Context mContext,
			String transitionId,JdAndroidClient jdClient,
			String client, String wareId, JdListener.RequestListener listener) {
		Bundle param = new Bundle();
		param.putString("client", client);
		param.putString("wareId", wareId);
		jdClient.invoke(mContext, transitionId,"jingdong.ware.browsetobuy.list.get", param, listener);
	}
	
	/**
	 * [3]
	 * jingdong.ware.combine.list.get 获得商品最佳购买组合
	 * 
	 * @param jdClient
	 *            JdAndroidClient
	 * @param client
	 *            客户端类型(apple、iPad、android、m、wp、wp7、Symbian、qt、androidTv、win8、
	 *            android、Pad)
	 * @param wareId
	 *            商品编号
	 * @param listener
	 *            回调监听器
	 */
	public static void getCombineWareList(Context mContext,
			String transitionId,JdAndroidClient jdClient,
			String client, String wareId, JdListener.RequestListener listener) {
		Bundle param = new Bundle();
		param.putString("client", client);
		param.putString("wareId", wareId);
		jdClient.invoke(mContext, transitionId,"jingdong.ware.combine.list.get", param, listener);

	}
	
	/**
	 * [4]
	 * jingdong.ware.packs.get 获得商品组合套装
	 * 
	 * @param jdClient
	 *            JdAndroidClient
	 * @param client
	 *            客户端类型(apple、iPad、android、m、wp、wp7、Symbian、qt、androidTv、win8、
	 *            android、Pad)
	 * @param skuId
	 *            商品编号
	 * @param listener
	 *            回调监听器
	 */
	public static void getWarePacks(Context mContext,
			String transitionId,JdAndroidClient jdClient, String client,
			int skuId, JdListener.RequestListener listener) {
		Bundle param = new Bundle();
		param.putString("client", client);
		param.putString("skuId", String.valueOf(skuId));
		jdClient.invoke(mContext, transitionId,"jingdong.ware.packs.get", param, listener);
	}


}
