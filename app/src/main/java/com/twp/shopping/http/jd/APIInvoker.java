/*
 * 版       权:  Royal.k.peng@gmail.com, All rights reserved
 * 作       者:  Royal
 * 座 右  铭:  Never give up, adhere to in the end.
 */
package com.twp.shopping.http.jd;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;

import com.jd.open.sdk.android.JdAndroidClient;
import com.jd.open.sdk.android.JdListener;
import com.twp.frame.util.DateUtil;

/**
 * API调用工具类
 * 
 * @author wanglingzhi
 */
public class APIInvoker {

	private static final String TAG = "APIInvoker";

	// =================New Support JOS API =============================

	// #start 【移动商城】接口导航
	/**
	 * [1]
	 * jingdong.ware.promotion.indexactivity.list 获得京东移动推荐的首页轮播促销列表
	 * 
	 * @param jdClient
	 *            JdAndroidClient
	 * @param client
	 *            客户端类型(apple、iPad、android、m、wp、wp7、Symbian、qt、androidTv、win8、
	 *            android、Pad)
	 * @param listener
	 *            回调监听器
	 */
	public static void getPromotionIndexactivityList(Context mContext,
			String transitionId,JdAndroidClient jdClient,
			String client, JdListener.RequestListener listener) {
		Bundle param = new Bundle();
		param.putString("client", client);
		jdClient.invoke(mContext, transitionId,"jingdong.ware.promotion.indexactivity.list.get",
				param, listener);
	}
	/**
	 * [2]
	 * jingdong.ware.promotion.indexactivity.get 获得京东移动推荐的首页轮播促销活动详情
	 * 
	 * @param jdClient
	 *            JdAndroidClient
	 * @param client
	 *            客户端类型(apple、iPad、android、m、wp、wp7、Symbian、qt、androidTv、win8、
	 *            android、Pad)
	 * @param activityId
	 * @param page
	 *            页码
	 * @param pageSize
	 *            每页多少条
	 * @param listener
	 *            回调监听器
	 */
	public static void getPromotionIndexactivityGet(Context mContext,
			String transitionId,JdAndroidClient jdClient,
			String client, String activityId, String page, String pageSize,
			JdListener.RequestListener listener) {
		Bundle param = new Bundle();
		param.putString("client", client);
		param.putString("activityId", activityId);
		param.putString("page", page);
		param.putString("pageSize", pageSize);
		jdClient.invoke(mContext, transitionId,"jingdong.ware.promotion.indexactivity.get", param,
				listener);
	}
	
	
	/**
	 * [3]
	 * 获得移动端的促销专场列表 jingdong.ware.promotion.promotions.list
	 * 
	 * @param jdClient
	 *            JdAndroidClient
	 * @param client
	 *            客户端类型(apple、iPad、android、m、wp、wp7、Symbian、qt、androidTv、win8、
	 *            android、Pad)
	 * @param listener
	 *            回调监听器
	 */
	public static void getPromotionPromotionsList(Context mContext,
			String transitionId,JdAndroidClient jdClient,
			String client, JdListener.RequestListener listener) {
		Bundle param = new Bundle();
		param.putString("client", client);
		jdClient.invoke(mContext, transitionId,"jingdong.ware.promotions.list.get", param, listener);

	}
	
	
	/**
	 * [4]
	 * jingdong.ware.promotions.catelogyidlist.get 根据移动端某分类获得对应的促销专场活动列表
	 * 
	 * @param jdClient
	 *            JdAndroidClient
	 * @param client
	 *            客户端类型(apple、iPad、android、m、wp、wp7、Symbian、qt、androidTv、win8、
	 *            android、Pad)
	 * @param level
	 * @param catelogyId
	 *            类目id
	 * @param listener
	 *            回调监听器
	 */
	public static void getWarePromotionsCatelogyidlist(Context mContext,
			String transitionId,
			JdAndroidClient jdClient, String client, int level, int catelogyId,
			JdListener.RequestListener listener) {
		Bundle param = new Bundle();
		param.putString("client", client);
		param.putString("level", String.valueOf(level));
		param.putString("catelogyId", String.valueOf(catelogyId));
		jdClient.invoke(mContext, transitionId,"jingdong.ware.promotions.catelogyidlist.get", param,
				listener);
	}
	
	/**
	 * [5]
	 * jingdong.ware.promotion.activities.list 根据促销专场id获得专场下促销活动列表
	 * 
	 * @param jdClient
	 *            JdAndroidClient
	 * @param client
	 *            客户端类型(apple、iPad、android、m、wp、wp7、Symbian、qt、androidTv、win8、
	 *            android、Pad)
	 * @param promotionsId
	 * @param page
	 *            页码
	 * @param pageSize
	 *            每页多少条
	 * @param listener
	 *            回调监听器
	 */
	public static void getPromotionActivitiesList(Context mContext,
			String transitionId,JdAndroidClient jdClient,
			String client, String promotionsId, String page, String pageSize,
			JdListener.RequestListener listener) {
		Bundle param = new Bundle();
		param.putString("client", client);
		param.putString("promotionsId", promotionsId);
		param.putString("page", page);
		param.putString("pageSize", pageSize);
		jdClient.invoke(mContext, transitionId,"jingdong.ware.promotion.activities.list.get", param,
				listener);
	}


	/**[6]
	 * jingdong.ware.promotion.activityware.list 根据促销活动id获得促销活动商品列表
	 * 
	 * @param jdClient
	 *            JdAndroidClient
	 * @param client
	 *            客户端类型(apple、iPad、android、m、wp、wp7、Symbian、qt、androidTv、win8、
	 *            android、Pad)
	 * @param activityId
	 * @param page
	 *            页码
	 * @param pageSize
	 *            每页多少条
	 * @param listener
	 *            回调监听器
	 */
	public static void getPromotionActivitywareList(Context mContext,
			String transitionId,JdAndroidClient jdClient,
			String client, String activityId, String page, String pageSize,
			JdListener.RequestListener listener) {
		Bundle param = new Bundle();
		param.putString("client", client);
		param.putString("activityId", activityId);
		param.putString("page", page);
		param.putString("pageSize", pageSize);
		jdClient.invoke(mContext, transitionId,"jingdong.ware.promotion.activityware.list.get", param,
				listener);
	}
	/**[8]
	 * 获取全部逛的促销频道
	 * 
	 * @param jdClient
	 *            JdAndroidClient
	 * @param client
	 *            客户端类型(apple、iPad、android、m、wp、wp7、Symbian、qt、androidTv、win8、
	 *            android、Pad)
	 * @param type
	 *            默认值为3
	 * @param listener
	 *            回调监听器
	 */
	public static void getStrollAllchannel(Context mContext,
			String transitionId,JdAndroidClient jdClient,
			String client, String type,

			JdListener.RequestListener listener) {
		Bundle param = new Bundle();
		param.putString("client", client);
		param.putString("type", type);
		jdClient.invoke(mContext, transitionId,"jingdong.ware.stroll.channel.list.get", param,
				listener);
	}
	

	/**
	 * [9]
	 * 获取逛的女士频道的促销商品列表
	 * 
	 * @param jdClient
	 *            JdAndroidClient
	 * @param client
	 *            客户端类型(apple、iPad、android、m、wp、wp7、Symbian、qt、androidTv、win8、
	 *            android、Pad)
	 * @param page
	 *            页码
	 * @param pageSize
	 *            每页多少条
	 * @param listener
	 *            回调监听器
	 */
	public static void getStrollLadyChannel(Context mContext,
			String transitionId,JdAndroidClient jdClient,
			String client, String page, String pageSize,
			JdListener.RequestListener listener) {
		Bundle param = new Bundle();
		param.putString("client", client);
		param.putString("page", page);
		param.putString("pagesize", pageSize);
		jdClient.invoke(mContext, transitionId,"jingdong.ware.stroll.ladychannel.list.get", param,
				listener);
	}

	/**
	 * [10]
	 * 获取逛的男士频道的促销商品列表
	 * 
	 * @param jdClient
	 *            JdAndroidClient
	 * @param client
	 *            客户端类型(apple、iPad、android、m、wp、wp7、Symbian、qt、androidTv、win8、
	 *            android、Pad)
	 * @param page
	 *            页码
	 * @param pageSize
	 *            每页多少条
	 * @param listener
	 *            回调监听器
	 */
	public static void getStrollManChannel(Context mContext,
			String transitionId,JdAndroidClient jdClient,
			String client, String page, String pageSize,
			JdListener.RequestListener listener) {
		Bundle param = new Bundle();
		param.putString("client", client);
		param.putString("page", page);
		param.putString("pagesize", pageSize);
		jdClient.invoke(mContext, transitionId,"jingdong.ware.stroll.manchannel.list.get", param,
				listener);
	}
	
	// #end
	
	
	/**
	 * jingdong.ware.promotion.seckill.list 获取促销的商品秒杀列表
	 * 
	 * @param jdClient
	 *            JdAndroidClient
	 * @param client
	 *            客户端类型(apple、iPad、android、m、wp、wp7、Symbian、qt、androidTv、win8、
	 *            android、Pad)
	 * @param listener
	 *            回调监听器
	 */
	public static void getPromotionSeckillList(Context mContext,
			String transitionId,JdAndroidClient jdClient,
			String client, JdListener.RequestListener listener) {
		Bundle param = new Bundle();
		param.putString("client", client);
		jdClient.invoke(mContext, transitionId,"jingdong.ware.promotion.seckill.list.get", param,
				listener);
	}

	
	/**
	 * jingdong.ware.promotion.categoryware.list 根据三级类目id找到该类目下的推荐商品列表
	 * 
	 * @param jdClient
	 *            JdAndroidClient
	 * @param client
	 *            客户端类型(apple、iPad、android、m、wp、wp7、Symbian、qt、androidTv、win8、
	 *            android、Pad)
	 * @param cid
	 * @param num
	 * @param listener
	 *            回调监听器
	 */
	public static void getPromotionCategorywareList(Context mContext,
			String transitionId,JdAndroidClient jdClient,
			String client, String cid, String num,
			JdListener.RequestListener listener) {
		Bundle param = new Bundle();
		param.putString("client", client);
		param.putString("cid", cid);
		param.putString("num", num);
		jdClient.invoke(mContext, transitionId,"jingdong.ware.promotion.categoryware.list.get", param,
				listener);
	}




	/**
	 * jingdong.ware.showorder.list 查询晒单列表
	 * 
	 * @param jdClient
	 *            JdAndroidClient
	 * @param client
	 *            客户端类型(apple、iPad、android、m、wp、wp7、Symbian、qt、androidTv、win8、
	 *            android、Pad)
	 * @param skuId
	 *            商品编号
	 * @param page
	 *            页码
	 * @param pageSize
	 *            每页多少条
	 * @param listener
	 *            回调监听器
	 */
	public static void getWareShoworderList(Context mContext,
			String transitionId,JdAndroidClient jdClient,
			String client, int skuId, int page, int pageSize,
			JdListener.RequestListener listener) {
		Bundle param = new Bundle();
		param.putString("client", client);
		param.putString("skuId", skuId + "");
		param.putString("page", page + "");
		param.putString("pagesize", pageSize + "");
		jdClient.invoke(mContext, transitionId,"jingdong.ware.showorder.list", param, listener);
	}

	/**
	 * jingdong.ware.stroll.special.list 获取逛的特惠精选频道的促销商品列表
	 * 
	 * @param jdClient
	 *            JdAndroidClient
	 * @param client
	 *            客户端类型(apple、iPad、android、m、wp、wp7、Symbian、qt、androidTv、win8、
	 *            android、Pad)
	 * @param listener
	 *            回调监听器
	 */
	public static void getStrollSpecialList(Context mContext,
			String transitionId,JdAndroidClient jdClient,
			String client, JdListener.RequestListener listener) {
		Bundle param = new Bundle();
		param.putString("client", client);
		jdClient.invoke(mContext, transitionId,"jingdong.ware.stroll.special.list.get", param,
				listener);
	}


	/**
	 * jingdong.ware.barcode.get 根据商品条形码,查询商品
	 * 
	 * @param jdClient
	 *            JdAndroidClient
	 * @param client
	 *            客户端类型(apple、iPad、android、m、wp、wp7、Symbian、qt、androidTv、win8、
	 *            android、Pad)
	 * @param barcode
	 * @param listener
	 *            回调监听器
	 */
	public static void getWareBarcode(Context mContext,
			String transitionId,JdAndroidClient jdClient, String client,
			String barcode, JdListener.RequestListener listener) {
		Bundle param = new Bundle();
		param.putString("client", client);
		param.putString("barcode", barcode);
		jdClient.invoke(mContext, transitionId,"jingdong.ware.barcode.get", param, listener);
	}


	/**
	 * 随机获得15个当前的搜索热词
	 * 
	 * @param jdClient
	 *            JdAndroidClient
	 * @param client
	 *            客户端类型 (apple、iPad、android、m、wp、wp7、Symbian、qt、androidTv、win8
	 *            、android、Pad)
	 * @param listener
	 *            回调监听器
	 */
	public static void getSearchHotkeywords(Context mContext,
			String transitionId,JdAndroidClient jdClient,
			String client, JdListener.RequestListener listener) {
		Bundle param = new Bundle();
		param.putString("client", client);
		jdClient.invoke(mContext, transitionId,"jingdong.ware.search.hotkeywords.list.get", param,
				listener);

	}

	/**
	 * jingdong.team.current.list 根据条件查询当期团购列表信息
	 * 
	 * @param jdClient
	 *            JdAndroidClient
	 * @param client
	 *            客户端类型(apple、iPad、android、m、wp、wp7、Symbian、qt、androidTv、win8、
	 *            android、Pad)
	 * @param cityId
	 *            城市ID,不支持全国，必须>0
	 * @param teamType
	 *            团购类型
	 * @param areaId
	 *            区域id
	 * @param sqId
	 *            商圈Id
	 * @param groupId
	 *            一级分类Id
	 * @param group2Id
	 *            二级分类Id
	 * @param sort
	 *            排序
	 * @param start
	 *            起始值
	 * @param limit
	 *            数量
	 * @param isTeamExternalUrl
	 *            过滤团购外部url字段，0不过滤，1 过滤 默认为0 不过滤
	 * @param listener
	 *            回调监听器
	 */
	public static void getTeamCurrentList(Context mContext,
			String transitionId,JdAndroidClient jdClient,
			String client, String cityId, String teamType, String areaId,
			String sqId, String groupId, String group2Id, String sort,
			String start, String limit, String isTeamExternalUrl,
			JdListener.RequestListener listener) {
		Bundle param = new Bundle();
		param.putString("client", client);
		param.putString("cityId", cityId);
		param.putString("teamType", teamType);
		param.putString("areaId", areaId);
		param.putString("sqId", sqId);
		param.putString("groupId", groupId);
		param.putString("group2Id", group2Id);
		param.putString("sort", sort);
		param.putString("start", start);
		param.putString("limit", limit);
		param.putString("isTeamExternalUrl", isTeamExternalUrl);

		jdClient.invoke(mContext, transitionId,"jingdong.team.current.list", param, listener);
	}

	/**
	 * jingdong.team.keyword.list 根据关键词查询当期团购列表信息
	 * 
	 * @param jdClient
	 *            JdAndroidClient
	 * @param keyWord
	 *            关键词
	 * @param cityName
	 *            城市名称
	 * @param start
	 *            起始值,0开始
	 * @param limit
	 *            数量,1～60。一次性最多获取60条
	 * @param isTeamExternalUrl
	 *            过滤团购外部url字段 0不过滤,1 过滤默认为0 不过滤
	 * @param client
	 *            客户端类型(apple、iPad、android、m、wp、wp7、Symbian、qt、androidTv、win8、
	 *            android、Pad)
	 * @param listener
	 *            回调监听器
	 */
	public static void getTeamKeywordList(Context mContext,
			String transitionId,JdAndroidClient jdClient,
			String client, String keyWord, String cityName, String start,
			int limit, int isTeamExternalUrl,
			JdListener.RequestListener listener) {
		Bundle param = new Bundle();
		param.putString("client", client);
		param.putString("keyWord", keyWord);
		param.putString("cityName", cityName);
		param.putString("start", start);
		param.putString("limit", limit + "");
		param.putString("isTeamExternalUrl", isTeamExternalUrl + "");
		jdClient.invoke(mContext, transitionId,"jingdong.team.keyword.list", param, listener);
	}

	/**
	 * jingdong.team.promotion.same.list 获取同类团购列表
	 * 
	 * @param jdClient
	 *            JdAndroidClient
	 * @param teamId
	 *            团购id
	 * @param cityId
	 *            城市ID,不支持全国，必须>0
	 * @param client
	 *            客户端类型(apple、iPad、android、m、wp、wp7、Symbian、qt、androidTv、win8、
	 *            android、Pad)
	 * @param listener
	 *            回调监听器
	 */
	public static void getTeamWareSameList(Context mContext,
			String transitionId,JdAndroidClient jdClient,
			String client, int teamId, int cityId,
			JdListener.RequestListener listener) {
		Bundle param = new Bundle();
		param.putString("client", client);
		param.putString("teamId", teamId + "");
		param.putString("cityId", cityId + "");
		jdClient.invoke(mContext, transitionId,"jingdong.team.promotion.same.list", param, listener);
	}

	/**
	 * jingdong.team.ids.list 根据多个团购ID批量获取团购信息接口
	 * 
	 * @param jdClient
	 *            JdAndroidClient
	 * @param client
	 *            客户端类型(apple、iPad、android、m、wp、wp7、Symbian、qt、androidTv、win8、
	 *            android、Pad)
	 * @param teamId
	 *            团购id
	 * @param listener
	 *            回调监听器
	 */
	public static void getTeamIdsList(Context mContext,
			String transitionId,JdAndroidClient jdClient, String client,
			String teamId, String IsDetail, JdListener.RequestListener listener) {
		Bundle param = new Bundle();
		param.putString("client", client);
		param.putString("teamId", String.valueOf(teamId));
		param.putString("IsDetail", IsDetail);
		jdClient.invoke(mContext, transitionId,"jingdong.team.ids.list", param, listener);
	}

	/**
	 * jingdong.team.promotion.hot.list 人气团购推荐
	 * 
	 * @param jdClient
	 *            JdAndroidClient
	 * @param client
	 *            客户端类型(apple、iPad、android、m、wp、wp7、Symbian、qt、androidTv、win8、
	 *            android、Pad)
	 * @param teamId
	 *            团购id
	 * @param cityId
	 *            城市ID,不支持全国，必须>0
	 * @param listener
	 *            回调监听器
	 */
	public static void getTeamPromotionHotList(Context mContext,
			String transitionId,JdAndroidClient jdClient,
			String client, String teamId, String cityId,
			JdListener.RequestListener listener) {
		Bundle param = new Bundle();
		param.putString("client", client);
		param.putString("teamId", String.valueOf(teamId));
		param.putString("cityId", String.valueOf(cityId));
		jdClient.invoke(mContext, transitionId,"jingdong.team.promotion.hot.list", param, listener);
	}

	// =================New Support JOS API End=============================

	/**
	 * OAuth认证 OK
	 * 
	 * @param activity
	 *            android.app.Activity
	 * @param jdClient
	 *            JdAndroidClient
	 * @param listener
	 *            认证回调的监听器
	 */
	public static void authorize(Activity activity, JdAndroidClient jdClient,
			String[] permissions, JdListener.DialogListener listener) {
		jdClient.authorize(activity, permissions, listener);
	}

	/**
	 * 获取类目信息 OK
	 * 
	 * @param jdClient
	 *            JdAndroidClient
	 * @param cid
	 *            类目id，默认为0
	 * @param level
	 *            等级(类目分为1、2、3级，对应值为0、1、2)
	 * @param fields
	 *            需返回的字段列表。支持的字段：cid,fid,level,name,index
	 * @param listener
	 *            回调监听器
	 */
	public static void getWareCategory(Context mContext,
			String transitionId,JdAndroidClient jdClient, String cid,
			String level, String fields, JdListener.RequestListener listener) {
		Bundle param = new Bundle();
		param.putString("cid", cid);
		param.putString("level", level);
		param.putString("fields", fields);
		jdClient.invoke(mContext, transitionId,"jingdong.warecategory.get", param, listener);
	};

	/**
	 * 根据关键字搜索商品 OK
	 * 
	 * @param jdClient
	 *            JdAndroidClient
	 * @param cid
	 *            类目id
	 * @param keyword
	 *            搜索关键字
	 * @param page
	 *            分页
	 * @param pageSize
	 *            每页多少条
	 * @param fields
	 *            可选字段
	 * @param listener
	 *            回调监听器
	 */
	public static void getWareListByKeyword(Context mContext,
			String transitionId,JdAndroidClient jdClient,
			String cid, String keyword, String page, String pageSize,
			String fields, JdListener.RequestListener listener) {
		Bundle param = new Bundle();
		param.putString("cid", cid);
		param.putString("q", keyword);
		param.putString("page", page);
		param.putString("page_size", pageSize);
		param.putString("fields", fields);
		jdClient.invoke(mContext, transitionId,"jingdong.wares.search", param, listener);
	}

	/**
	 * 查询单个商品详情信息
	 * 
	 * @param jdClient
	 *            JdAndroidClient
	 * @param wareId
	 *            类目id
	 * @param regionId
	 *            地区id
	 * @param fields
	 *            返回字段信息。支持的值：ware_id, title, jd_price, ware_imgs, skus
	 * @param listener
	 *            回调监听器
	 */
	public static void getWareDetail(Context mContext,
			String transitionId,JdAndroidClient jdClient, String wareId,
			String regionId, String fields, JdListener.RequestListener listener) {
		Bundle param = new Bundle();
		param.putString("region_id", regionId);
		param.putString("fields", fields);
		param.putString("ware_id", wareId);
		jdClient.invoke(mContext, transitionId,"jingdong.ware.get", param, listener);
	}

	/**
	 * 获取地区信息
	 * 
	 * @param jdClient
	 *            JdAndroidClient
	 * @param listener
	 *            回调监听器
	 */
	public static void getRegionInfo(Context mContext,
			String transitionId,JdAndroidClient jdClient,
			JdListener.RequestListener listener) {
		Bundle param = new Bundle();
		jdClient.invoke(mContext, transitionId,"jingdong.regioninfo.get", param, listener);
	}

	/**
	 * 获取买此商品的用户还购买的商品
	 * 
	 * @param jdClient
	 *            JdAndroidClient
	 * @param wareId
	 *            商品ID
	 * @param fields
	 *            返回字段信息。支持的值：ware_id, title, jd_price, ware_imgs, skus
	 * @param listener
	 *            回调监听器
	 */
	public static void getAnotherbuyrecommendWare(Context mContext,
			String transitionId,JdAndroidClient jdClient,
			String wareId, String fields, JdListener.RequestListener listener) {
		Bundle param = new Bundle();
		param.putString("ware_id", wareId);
		param.putString("fields", fields);
		jdClient.invoke(mContext, transitionId,"jingdong.anotherbuyrecommend.ware.get", param,
				listener);
	}

	/**
	 * 商品推荐组合
	 * 
	 * @param jdClient
	 *            JdAndroidClient
	 * @param wareId
	 *            商品ID
	 * @param fields
	 *            返回字段信息。支持的值：ware_id, title, jd_price, ware_imgs, skus
	 * @param listener
	 *            回调监听器
	 */
	public static void getCombinerecommendWare(Context mContext,
			String transitionId,JdAndroidClient jdClient,
			String wareId, String fields, JdListener.RequestListener listener) {
		Bundle param = new Bundle();
		param.putString("ware_id", wareId);
		param.putString("fields", fields);
		jdClient.invoke(mContext, transitionId,"jingdong.combinerecommend.ware.get", param, listener);
	}

	/**
	 * 浏览此商品用户最终购买的商品 jingdong.promotion.buytobuy.list
	 * 
	 * @param jdClient
	 *            JdAndroidClient
	 * @param wareId
	 *            商品ID
	 * @param fields
	 *            返回字段信息。支持的值：ware_id, title, jd_price, ware_imgs, skus
	 * @param listener
	 *            回调监听器
	 */
	public static void getUserbrowsebuyrecommendWare(Context mContext,
			String transitionId,JdAndroidClient jdClient,
			String wareId, String fields, JdListener.RequestListener listener) {
		Bundle param = new Bundle();
		param.putString("ware_id", wareId);
		param.putString("fields", fields);
		jdClient.invoke(mContext, transitionId,"jingdong.userbrowsebuyrecommend.ware.get", param,
				listener);
	}

	/**
	 * 获取商家类目信息
	 * 
	 * @param jdClient
	 *            JdAndroidClient
	 * @param fields
	 *            需返回的字段列表:id,fid,status,lev,name,index_id
	 * @param listener
	 *            回调监听器
	 */
	public static void getWareCats(Context mContext,
			String transitionId,JdAndroidClient jdClient, String fields,
			JdListener.RequestListener listener) {
		Bundle param = new Bundle();
		param.putString("fields", fields);
		jdClient.invoke(mContext, transitionId,"360buy.warecats.get", param, listener);
	}

	public static void getPromotionInfo(Context mContext,
			String transitionId,JdAndroidClient jdClient, String skuId,
			JdListener.RequestListener listener) {
		Bundle param = new Bundle();
		param.putString("skuId", skuId);
		param.putInt("webSite", 1);
		param.putInt("origin", 2);
		jdClient.invoke(mContext, transitionId,"jingdong.ware.promotionInfo.get", param, listener);
	}

	/**
	 * 获取专柜推广报表 jingdong.union.report.window.search
	 */
	public static void getUnionSearch(Context mContext,
			String transitionId,JdAndroidClient jdClient, int pageSize,
			int pageIndex, JdListener.RequestListener listener) {

		Bundle param = new Bundle();
		param.putInt("page_index", pageIndex);
		param.putInt("page_size", pageSize);
		String nowData = DateUtil.getNowBeforeOneDate();
		param.putString("start_date", nowData);
		param.putString("end_date", nowData);

		jdClient.invoke(mContext, transitionId,"jingdong.union.report.window.search", param, listener);
	}

}
