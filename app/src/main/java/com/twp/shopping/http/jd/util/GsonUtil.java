package com.twp.shopping.http.jd.util;

import java.util.List;

import android.content.ClipData.Item;

import com.google.gson.FieldNamingStrategy;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.JsonSyntaxException;
import com.google.gson.reflect.TypeToken;
import com.twp.frame.util.Logger;
import com.twp.shopping.http.jd.model.BookInfo;
import com.twp.shopping.http.jd.model.JdResponseFieldNamingStaregy;
import com.twp.shopping.http.jd.model.JdResponseIITNamingStaregy;
import com.twp.shopping.http.jd.model.JdResponseISNamingStaregy;
import com.twp.shopping.http.jd.model.ProductBase;
import com.twp.shopping.http.jd.model.ResponseJd;
import com.twp.shopping.http.jd.model.ResponseResult;
import com.twp.shopping.http.jd.model.ResultBNST;
import com.twp.shopping.http.jd.model.ResultISTListData;
import com.twp.shopping.http.jd.model.ResultListData;
import com.twp.shopping.http.jd.model.VideoInfo;
import com.twp.shopping.http.jd.model.category.Category;
import com.twp.shopping.http.jd.model.product.Bookbigfield;
import com.twp.shopping.http.jd.model.product.ImagePaths;
import com.twp.shopping.http.jd.model.product.ProductStock;
import com.twp.shopping.http.jd.model.product.Productbigfield;
import com.twp.shopping.http.jd.model.product.Productsort;
import com.twp.shopping.http.jd.model.product.Provinces;
import com.twp.shopping.http.jd.model.product.ResultIITData;
import com.twp.shopping.http.jd.model.product.ResultPagerListData;
import com.twp.shopping.http.jd.model.product.ResultProductDetail;
import com.twp.shopping.http.jd.model.product.ResultSKUListData;
import com.twp.shopping.http.jd.model.product.VideoBigFieldInfo;
import com.twp.shopping.http.jd.model.product.WareInfo;
import com.twp.shopping.http.jd.model.recommend.CmsActivityWare;
import com.twp.shopping.http.jd.model.recommend.Packs;
import com.twp.shopping.http.jd.model.union.ActivitySafVo;
import com.twp.shopping.http.jd.model.union.AdZoneVo;
import com.twp.shopping.http.jd.model.union.AdvDetailVo;
import com.twp.shopping.http.jd.model.union.CategoryCommision;
import com.twp.shopping.http.jd.model.union.CmsActivity;
import com.twp.shopping.http.jd.model.union.EffectReportSafVo;
import com.twp.shopping.http.jd.model.union.GoodSafVo;
import com.twp.shopping.http.jd.model.union.GoodSafVo1;
import com.twp.shopping.http.jd.model.union.GoodsCode;
import com.twp.shopping.http.jd.model.union.MasterAccount;
import com.twp.shopping.http.jd.model.union.MasterBillVo;
import com.twp.shopping.http.jd.model.union.OverviewVo;
import com.twp.shopping.http.jd.model.union.PlanDetailVO;
import com.twp.shopping.http.jd.model.union.PlanVO;
import com.twp.shopping.http.jd.model.union.ResultOverview;
import com.twp.shopping.http.jd.model.union.ResultUnionListData;
import com.twp.shopping.http.jd.model.union.ResultUnionReportPager;
import com.twp.shopping.http.jd.model.union.WindowAdvDetail;
import com.twp.shopping.http.jd.model.union.ZoneCode;
import com.twp.shopping.http.jd.model.ware.Activity;
import com.twp.shopping.http.jd.model.ware.ActivityProductsList;
import com.twp.shopping.http.jd.model.ware.CmsActivityWareList;
import com.twp.shopping.http.jd.model.ware.CmsPromotions;
import com.twp.shopping.http.jd.model.ware.Guang;
import com.twp.shopping.http.jd.model.ware.PriceChanges;
import com.twp.shopping.http.jd.model.ware.ResultPromotionInfo;

public final class GsonUtil {

	public static <T> T getObj4String(String gsonStr, TypeToken<T> typeToken,
			FieldNamingStrategy fieldNamingStrategy) {
		GsonBuilder gsonBuilder = new GsonBuilder();
		if (null != fieldNamingStrategy) {
			gsonBuilder.setFieldNamingStrategy(fieldNamingStrategy);
		}
		Gson gson = gsonBuilder.create();
		T response = null;
		try {
			response = gson.fromJson(gsonStr, typeToken.getType());
		} catch (JsonSyntaxException exception) {
			Logger.e("has a exception during parse. msg = "
					+ exception.toString());
		}
		return response;
	}

	public static List<Category> parseCategoryResult(String jsonStr) {
		ResponseJd<ResponseResult<ResultListData<Category>>> response = getWareProductCategoryListResponse(jsonStr);
		return response.getResponseJd().getResultJd().getResultListData();

	}

	public static List<WareInfo> parseWareProductSearch(String jsonStr) {
		ResponseJd<ResponseResult<ResultPagerListData<WareInfo>>> response = getWareProductSearchResponse(jsonStr);
		return response.getResponseJd().getResultJd().getResultListData();
	}

	// ==========================================================================
	// #start 【类目服务】接口导航
	/**
	 * 1. 获取商品类目信息接口 接口名称 jingdong.ware.product.catelogy.list.get
	 * 
	 * @param jsonStr
	 * @return
	 */
	public static ResponseJd<ResponseResult<ResultListData<Category>>> getWareProductCategoryListResponse(
			String jsonStr) {
		return GsonUtil
				.getObj4String(
						jsonStr,
						new TypeToken<ResponseJd<ResponseResult<ResultListData<Category>>>>() {
						},
						new JdResponseFieldNamingStaregy(
								"jingdong_ware_product_catelogy_list_get_responce",
								"productCatelogyList", "catelogyList"));
	}

	/**
	 * 2. 获取商品类目属性信息列表 接口名称 jingdong.ware.catelogy.attribute.list.get
	 * 
	 * { "jingdong_ware_catelogy_attribute_list_get_response":{
	 * "catelogyAttributeList":{ "resultCode":"", "expandSorts":[{ "items":[{
	 * "expandSortsList":[{ "expandValueId":"", "expandSortValueName":"" }],
	 * "type":"" }], "items2":[{ "expandSortsList2":[{ "expandValueId":"",
	 * "expandSortValueName":"" }] }], "expandSortValueName":"" }] } } }
	 */
	public static ResponseJd<ResponseResult<ResultListData<Item>>> getWareCategoryAttListResponse(
			String jsonStr) {
		return GsonUtil
				.getObj4String(
						jsonStr,
						new TypeToken<ResponseJd<ResponseResult<ResultListData<Item>>>>() {
						},
						new JdResponseFieldNamingStaregy(
								"jingdong_ware_catelogy_attribute_list_get_response",
								"catelogyAttributeList", "expandSorts"));
	}

	// #end

	// ==========================================================================
	// #start 【商品服务】接口导航

	/**
	 * 1. 根据三级类目编号查询商品列表
	 * 
	 * { "jingdong_ware_promotion_search_catelogy_list_response":{
	 * "searchCatelogyList":{ "page":"", "resultCode":"", "regionIsTrue":"",
	 * "wareInfo":[{ "wareName":"", "martPrice":"", "startRemainTime":"",
	 * "imageUrl":"", "adWord":"", "skuId":"", "jdPrice":"", "endRemainTime":"",
	 * "canFreeRead":"", "isBook":"" }], "show":"", "selfIsTrue":"",
	 * "wareCount":"" } } }
	 * 
	 * @param jsonStr
	 * @return
	 */
	public static ResponseJd<ResponseResult<ResultPagerListData<WareInfo>>> getPromotionSearchCategoryResponse(
			String jsonStr) {
		return GsonUtil
				.getObj4String(
						jsonStr,
						new TypeToken<ResponseJd<ResponseResult<ResultPagerListData<WareInfo>>>>() {
						},
						new JdResponseFieldNamingStaregy(
								"jingdong_ware_promotion_search_catelogy_list_responce",
								"searchCatelogyList", "wareInfo"));
	}

	/**
	 * 2. 省会编号查询 { "jingdong_ware_selected_province_list_get_response":{
	 * "provinceList":{ "resultCode":"", "provinces":[{ "value":"", "label":""
	 * }] } } }
	 */
	public static ResponseJd<ResponseResult<ResultListData<Provinces>>> getProvincesResponse(
			String jsonstr) {
		return GsonUtil
				.getObj4String(
						jsonstr,
						new TypeToken<ResponseJd<ResponseResult<ResultListData<Provinces>>>>() {
						},
						new JdResponseFieldNamingStaregy(
								"jingdong_ware_selected_province_list_get_responce",
								"provinceList", "provinces"));
	}

	/**
	 * 3. 商品搜索列表 jingdong.ware.product.search.list.get
	 * 
	 * "jingdong_ware_product_search_list_get_response":{ "searchProductList":{
	 * "page":"", "resultCode":"", "wareInfo":[{ "wareName":"", "martPrice":"",
	 * "startRemainTime":"", "imageUrl":"", "adWord":"", "skuId":"",
	 * "jdPrice":"", "endRemainTime":"", "canFreeRead":"", "isBook":"",
	 * "markerPrice":"" }], "wareCount":"" } } }
	 * 
	 * @param jsonstr
	 * @return
	 */
	public static ResponseJd<ResponseResult<ResultPagerListData<WareInfo>>> getWareProductSearchResponse(
			String jsonStr) {
		return GsonUtil
				.getObj4String(
						jsonStr,
						new TypeToken<ResponseJd<ResponseResult<ResultPagerListData<WareInfo>>>>() {
						},
						new JdResponseFieldNamingStaregy(
								"jingdong_ware_product_search_list_get_responce",
								"searchProductList", "wareInfo"));
	}

	/**
	 * 4. 获取商品库存 jingdong.ware.product.stock.list.get
	 * 
	 * { "jingdong_ware_product_stock_list_get_response":{ "productStock":{
	 * "flag":"", "stockStatus":"", "resultCode":"" } } }
	 */

	public static ResponseJd<ResponseResult<ProductStock>> getProductStockResponse(
			String jsonstr) {
		return GsonUtil.getObj4String(jsonstr,
				new TypeToken<ResponseJd<ResponseResult<ProductStock>>>() {
				}, new JdResponseFieldNamingStaregy(
						"jingdong_ware_product_stock_list_get_responce",
						"productStock", "null"));
	}

	/**
	 * 5. 获取商品SKU信息 jingdong.ware.sku.search.list.get {
	 * "jingdong_ware_sku_search_list_get_response":{ "productSkuList":{
	 * "skuSize":[{ "description":"", "promotion":"", "skuId":"", "secKill":"",
	 * "directShow":"", "showMartPrice":"", "canFreeRead":"", "size":"" }],
	 * "skuColor":[{ "waretitle":"", "colorImg":"", "wname":"", "color":"",
	 * "description":"", "promotion":"", "skuId":"", "secKill":"",
	 * "directShow":"", "showMartPrice":"", "canFreeRead":"", "size":"" }],
	 * "resultCode":"" } } }
	 */

	public static ResponseJd<ResponseResult<ResultSKUListData>> getSKUResponse(
			String jsonStr) {
		return GsonUtil.getObj4String(jsonStr,
				new TypeToken<ResponseJd<ResponseResult<ResultSKUListData>>>() {
				}, new JdResponseFieldNamingStaregy(
						"jingdong_ware_sku_search_list_get_responce",
						"productSkuList", "null"));
	}

	/**
	 * 6. 获取商品详情列表 { "jingdong_ware_product_detail_search_list_get_responce":{
	 * "productDetailList":{ "resultCode":"", "productInfo":{ "imgUrlN5":"",
	 * "wname":"", "adword":"", "marketPrice":"", "averageScore":"",
	 * "promotion":"", "jdPrice":"", "good":"", "canConsultFlag":"", "size":"",
	 * "isbook":"", "color":"", "totalCount":"", "description":"", "skuId":"",
	 * "secKill":"", "directShow":"", "showMartPrice":"", "canFreeRead":"",
	 * "imgUrlN1":"", "imgurl":"" }, "imagePaths":[{ "skuId":"", "newpath":"",
	 * "bigpath":"" }] } } }
	 */

	public static ResponseJd<ResponseResult<ResultProductDetail>> getProductDetail(
			String gsonStr) {
		return GsonUtil
				.getObj4String(
						gsonStr,
						new TypeToken<ResponseJd<ResponseResult<ResultProductDetail>>>() {
						},
						new JdResponseFieldNamingStaregy(
								"jingdong_ware_product_detail_search_list_get_responce",
								"productDetailList", "null"));

	}

	/**
	 * 7 .获取商品基本信息 jingdong.ware.baseproduct.get {
	 * "jingdong_ware_baseproduct_get_response":{ "product_base":[{
	 * "size_sequence":"0", "model":"12支装", "weight":"单位：千克,
	 * 因JOS平台对double类型的处理上是给默认值，所以每次请求其他参数时（如name），也会返回weight：0。不是接口原因，请忽略此状况",
	 * "wserve":"无、无质保、1年质保、3年质保", "color_sequence":"0",
	 * "state":"0、下柜，1、上柜，2、可上柜（基本信息完备，采销没有正式上柜），10、POPSKU删除",
	 * "is_delete":"0无效，1有效", "brand_name":"雅诗兰黛", "value_weight":"单位：千克",
	 * "allnum":"0、未设置标签，1、新品，2、热卖", "height":"单位：毫米", "name":"雅诗兰黛紧致眼霜",
	 * "length":"单位：毫米", "sku_id":"500200",
	 * "sale_date":"如果当前商品状态是上柜，saleDate为上柜日期；反之为下柜日期",
	 * "value_pay_first":"0否，1是", "cbrand":"21赫兹", "width":"单位：毫米",
	 * "brand_id":"11516", "cid2":"0", "ebrand":"21hz", "size":"175/96A/M",
	 * "category":"652;654;833", "color":"灰色", "product_area":"北京",
	 * "image_path":
	 * "http://img13.360buyimg.com/n1/3013/3c478d95-bfae-4776-b962-f866033580b0.jpg"
	 * , }] } }
	 */

	public static ResponseJd<ResponseResult<List<ProductBase>>> getProductBaseResponse(
			String gsonStr) {
		return GsonUtil.getObj4String(gsonStr,
				new TypeToken<ResponseJd<ResponseResult<List<ProductBase>>>>() {
				}, new JdResponseFieldNamingStaregy(
						"jingdong_ware_baseproduct_get_responce",
						"product_base", "null"));
	}

	/**
	 * 8.获取商品分类信息 { "jingdong_ware_productsort_get_response":{
	 * "product_sorts":[{ "is_fit_service":"1是0否", "sort":"0", "conte":"1是0否",
	 * "product_sort_id":"652", "name":"大家电", "father_id":"0",
	 * "grade":"0：一级，1：二级，2：三级", "is_delete":"1是0否" }] } }
	 */

	public static ResponseJd<ResponseResult<List<Productsort>>> getProductSortsResponse(
			String gsonStr) {
		return GsonUtil.getObj4String(gsonStr,
				new TypeToken<ResponseJd<ResponseResult<List<Productsort>>>>() {
				}, new JdResponseFieldNamingStaregy(
						"jingdong_ware_productsort_get_responce",
						"product_sorts", "null"));
	}

	/**
	 * 9.获取商品大字段信息 { "jingdong_ware_productbigfield_get_response":{
	 * "prop_code":"", "wdis":"", "ware_qd":"", "shou_hou":"" } }
	 */

	public static ResponseJd<Productbigfield> getProductBigFieldResponse(
			String gsonStr) {
		return GsonUtil.getObj4String(gsonStr,
				new TypeToken<ResponseJd<Productbigfield>>() {
				}, new JdResponseFieldNamingStaregy(
						"jingdong_ware_productbigfield_get_responce", "null",
						"null"));
	}

	/**
	 * 10.获取图书大字段信息 ResponseResult 泛型代表的 list中 只有一个对象，至与对象中的结构怎么样我们就不用管了。 // 为了
	 * 避免我们 ResponseReult所对象的是list ，但是 list中还有list //
	 * 或者还是两层对象的结构,我们都需要去为这些list来提供一个ResultXXX来解析我们的对象太过于麻烦。所以我们提供一个公共的 //
	 * ResultproductSkuListData来处理这个 //
	 * ResponseResult对应的list中不是一个单纯的mode。还有其他的list获取是两层对象的情况。 //
	 * 但是字段不宜过多，我们这里只设置了3个。first_class_id ，sku_id，T. 提供一个泛型，来传入list或者是对象。 {
	 * "jingdong_ware_bookbigfield_get_response":{ "BookBigFieldEntity":[{
	 * "book_big_field_info":{ "book_abstract":"", "relatedProducts":"",
	 * "catalogue":"", "authorDesc":"", "content_desc":"", "image":"",
	 * "editer_desc":"", "introduction":"", "comments":"" },
	 * "first_class_id":"", "sku_id":"" }] } }
	 */
	public static ResponseJd<ResponseResult<List<ResultIITData<Bookbigfield>>>> getBookBigFieldResponse(
			String gsonStr) {
		return GsonUtil
				.getObj4String(
						gsonStr,
						new TypeToken<ResponseJd<ResponseResult<List<ResultIITData<Bookbigfield>>>>>() {
						}, new JdResponseIITNamingStaregy(
								"jingdong_ware_bookbigfield_get_responsce",
								"BookBigFieldEntity", "sku_id",
								"first_class_id", "book_big_field_info"));
	}

	/**
	 * 11.获取商品图片信息（多图）ResponseResult 泛型所代表的对象 {
	 * "jingdong_ware_productimage_get_response":{ "image_path_list":[{
	 * "image_list":[{ "position":"", "id":"", "orderSort":"", "path":"",
	 * "yn":"", "is_primary":"", "sku_id":"", "type":"" }], "sku_id":"" }] } }
	 */
	public static ResponseJd<ResponseResult<List<ResultListData<ImagePaths>>>> getProductImageResponse(
			String gsonStr) {
		return GsonUtil
				.getObj4String(
						gsonStr,
						new TypeToken<ResponseJd<ResponseResult<List<ResultListData<ImagePaths>>>>>() {
						}, new JdResponseFieldNamingStaregy(
								"jingdong_ware_productimage_get_responce",
								"image_path_list", "sku_id", "image_list"));
	}

	/**
	 * 12.获取音像大字段信息 { "jingdong_ware_videobigfield_get_response":{
	 * "VideoBigFieldEntity":[{ "videoBigFieldInfo":{ "manual":"",
	 * "catalogue":"", "image":"", "editerDesc":"", "material_Description":"",
	 * "box_Contents":"", "contentDesc":"", "comments":"" }, "firstClassId":"",
	 * "skuId":"" }] } }
	 */
	public static ResponseJd<ResponseResult<List<ResultIITData<VideoBigFieldInfo>>>> getVideoBigFieldResponse(
			String gsonStr) {
		return GsonUtil
				.getObj4String(
						gsonStr,
						new TypeToken<ResponseJd<ResponseResult<List<ResultIITData<VideoBigFieldInfo>>>>>() {
						}, new JdResponseIITNamingStaregy(
								"jingdong_ware_videobigfield_get_responce",
								"VideoBigFieldEntity", "sku_id",
								"firstClassId", "videoBigFieldInfo"));
	}

	/**
	 * #start 13.获取音像基本信息 { "jingdong_ware_basevideo_get_response":{
	 * "videoEntitys":[{ "skuId":"", "videoInfo":{ "type_keywords":"",
	 * "mvd_gqyz":"", "language_pronunciation":"", "aka":"", "isrc":"",
	 * "voiceover":"", "actor":"", "finishing":"", "type":"",
	 * "audio_encoding_chinese":"", "authors":"", "mfg_minimum":"",
	 * "compose":"", "screenwriter":"", "quality_description":"",
	 * "record_number":"", "platform":"", "screen_ratio":"", "keywords":"",
	 * "foreignname":"", "barcode":"", "copyright":"", "format":"",
	 * "director":"", "soundtrack":"", "menu_language":"", "awards":"",
	 * "number_of_discs":"", "included_additional_item":"",
	 * "recommended_system_description":"", "performer":"", "mfg_maximum":"",
	 * "language":"", "dub":"", "media":"", "region":"", "press":"",
	 * "episode":"", "singer":"", "orchestra":"", "photography":"",
	 * "version":"", "mvd_wxjz":"", "set_the_number_of":"", "compile":"",
	 * "isbn":"", "write":"", "command":"", "length":"", "read":"",
	 * "production_company":"", "dictation":"", "mvd_wyjz":"", "dregion":"",
	 * "language_dubbed":"", "sid":"", "publishing_company":"", "mvd_xcyg":"",
	 * "online_play_description":"",
	 * "minimum_system_requirement_description":"", "readers":"",
	 * "language_subtitled":"", "first_category":"1713为图书、4051、4052、4053是音像",
	 * "number_of_players":"", "accessories":"", "color":"",
	 * "version_language":"", "producer":"", "release_date":"", "brand":"",
	 * "mvd_dcz":"", "publication_date":"" } }] } }
	 */
	public static ResponseJd<ResponseResult<List<ResultIITData<VideoInfo>>>> getVideoInfoResponse(
			String gsonStr) {
		return GsonUtil
				.getObj4String(
						gsonStr,
						new TypeToken<ResponseJd<ResponseResult<List<ResultIITData<VideoInfo>>>>>() {
						}, new JdResponseIITNamingStaregy(
								"jingdong_ware_basevideo_get_responce",
								"videoEntitys", "sku_id", "firstClassId",
								"videoBigFieldInfo"));
	}

	/**
	 * 14. 获取图书基本信息 { "jingdong_ware_basebook_get_response":{ "BookEntity":[{
	 * "sku_id":"", "book_info":{ "series":"", "publish_no":"", "pack_num":"",
	 * "publishers":"", "issn":"", "finishing":"", "drawer":"",
	 * "photography":"", "china_catalog":"", "id":"", "author":"",
	 * "size_and_height":"", "book_name":"", "compile":"", "proofreader":"",
	 * "isbn":"", "write":"", "print_time":"", "read":"", "dictation":"",
	 * "batch_no":"", "sheet":"", "print_no":"", "transfer":"", "keywords":"",
	 * "packages":"", "bar_code":"", "pages":"", "foreign_book_name":"",
	 * "papers":"", "attachment":"",
	 * "first_category":"1713为图书、4051、4052、4053是音像", "format":"",
	 * "publish_time":"", "remarker":"", "pick_state":"", "brand":"",
	 * "attachment_num":"", "language":"", "letters":"", "editer":"" } }] } }
	 */
	public static ResponseJd<ResponseResult<List<ResultIITData<BookInfo>>>> getBookInfoResponse(
			String gsonStr) {
		return GsonUtil
				.getObj4String(
						gsonStr,
						new TypeToken<ResponseJd<ResponseResult<List<ResultIITData<BookInfo>>>>>() {
						}, new JdResponseIITNamingStaregy(
								"jingdong_ware_basebook_get_responce",
								"BookEntity", "sku_id", "firstClassId",
								"book_info"));
	}

	// #end 【商品服务】接口导航

	// ==========================================================================
	// #start 【推荐服务】接口导航
	/**
	 * 1. 购买该商品的人最终购买了 { "jingdong_ware_buytobuy_list_get_response":{
	 * "buyToBuyWidsList":{ "resultCode":"", "buyToBuyWids":[{ "wareName":"",
	 * "martPrice":"", "startRemainTime":"", "imageUrl":"", "adWord":"",
	 * "skuId":"", "jdPrice":"", "endRemainTime":"", "canFreeRead":"",
	 * "isBook":"" }] } } }
	 */
	public static ResponseJd<ResponseResult<ResultListData<CmsActivityWare>>> getBuyToBuyResponse(
			String gsonStr) {

		return GsonUtil
				.getObj4String(
						gsonStr,
						new TypeToken<ResponseJd<ResponseResult<ResultListData<CmsActivityWare>>>>() {
						}, new JdResponseFieldNamingStaregy(
								"jingdong_ware_buytobuy_list_get_responce",
								"buyToBuyWidsList", "buyToBuyWids"));

	}

	/**
	 * 2.浏览过该商品的人最终购买了 { "jingdong_ware_browsetobuy_list_get_response":{
	 * "browseBuyWidsList":{ "browseBuyWids":[{ "wareName":"", "martPrice":"",
	 * "startRemainTime":"", "imageUrl":"", "adWord":"", "skuId":"",
	 * "jdPrice":"", "endRemainTime":"", "canFreeRead":"", "isBook":"" }],
	 * "resultCode":"" } } }
	 */
	public static ResponseJd<ResponseResult<ResultListData<CmsActivityWare>>> getBrowseToBuyResponse(
			String gsonStr) {

		return GsonUtil
				.getObj4String(
						gsonStr,
						new TypeToken<ResponseJd<ResponseResult<ResultListData<CmsActivityWare>>>>() {
						}, new JdResponseFieldNamingStaregy(
								"jingdong_ware_browsetobuy_list_get_responce",
								"browseBuyWidsList", "browseBuyWids"));

	}

	/**
	 * 3.获得商品最佳购买组合
	 * 
	 * { "jingdong_ware_combine_list_get_response":{ "combineBuyingWidsList":{
	 * "showClick":"", "resultCode":"", "combineWareId":"",
	 * "combineBuyingWids":[{ "wareName":"", "martPrice":"",
	 * "startRemainTime":"", "imageUrl":"", "adWord":"", "skuId":"",
	 * "jdPrice":"", "endRemainTime":"", "canFreeRead":"", "isBook":"" }] } } }
	 */
	public static ResponseJd<ResponseResult<ResultListData<CmsActivityWare>>> getCombineResponse(
			String gsonStr) {

		return GsonUtil
				.getObj4String(
						gsonStr,
						new TypeToken<ResponseJd<ResponseResult<ResultListData<CmsActivityWare>>>>() {
						}, new JdResponseFieldNamingStaregy(
								"jingdong_ware_combine_list_get_responce",
								"combineBuyingWidsList", "combineBuyingWids"));

	}

	/**
	 * 4. 获得商品组合套装 { "jingdong_ware_packs_get_response":{ "packsList":{
	 * "imageDomain":"", "data":[{ "mainSkuPicUrl":"", "mainSkuId":"",
	 * "packId":"", "packListPrice":"", "packPrice":"", "mainSkuName":"",
	 * "packs":[{ "skuPicUrl":"", "skuId":"", "skuName":"" }], "discount":"" }],
	 * "resultCode":"" } }
	 */
	public static ResponseJd<ResponseResult<ResultISTListData<List<Packs>>>> getWarePacksResponse(
			String gsonStr) {

		return GsonUtil
				.getObj4String(
						gsonStr,
						new TypeToken<ResponseJd<ResponseResult<ResultISTListData<List<Packs>>>>>() {
						}, new JdResponseISNamingStaregy(
								"jingdong_ware_packs_get_responce",
								"packsList", "resultCode", "imageDomain",
								"data"));

	}

	// #end

	// ==========================================================================
	// #start 【CPS服务】接口导航
	/**
	 * 1. 联盟店铺转换 { "jingdong_union_promotionshop_update_response": { "msg": {
	 * "shopList": { "shop_promUrl": "", "shop_commRatio": "",
	 * "shop_materialUrl": "", "shop_goodsVolume": "", "shop_praiseDegree": "",
	 * "shop_promQuantity": "", "shop_mainCategories": "", "shop_pk": "",
	 * "shop_name": "" }, "isDefault": "", "totalCount": "" } } }
	 */
	public static ResponseJd<ResponseResult<ResultUnionListData<GoodSafVo>>> getPromotionShopResponse(
			String gsonStr) {

		return GsonUtil
				.getObj4String(
						gsonStr,
						new TypeToken<ResponseJd<ResponseResult<ResultUnionListData<GoodSafVo>>>>() {
						}, new JdResponseFieldNamingStaregy(
								"jingdong_union_promotionshop_update_responce",
								"msg", "shopList"));

	}

	/**
	 * 2. 联盟推广活动查询 接口名称： jingdong.union.promotionactivity.query {
	 * "jingdong_union_promotionactivity_query_response": { "msg": {
	 * "isDefault": "", "totalCount": "", "activity_list": { "activity_pk": "",
	 * "activity_start": "", "activity_height": "", "activity_url": "",
	 * "activity_width": "", "activity_shopName": "", "activity_name": "",
	 * "activity_mainCategory": "", "activity_end": "", "activity_commRatio": ""
	 * } } } }
	 */
	public static ResponseJd<ResponseResult<ResultUnionListData<ActivitySafVo>>> getPromotionActivityResponse(
			String gsonStr) {

		return GsonUtil
				.getObj4String(
						gsonStr,
						new TypeToken<ResponseJd<ResponseResult<ResultUnionListData<ActivitySafVo>>>>() {
						},
						new JdResponseFieldNamingStaregy(
								"jingdong_union_promotionactivity_query_responce",
								"msg", "activity_list"));

	}

	/**
	 * 3. 联盟推广商品查询 接口名称： jingdong.union.promotiongood.query
	 * 
	 * { "jingdong_union_promotiongood_query_response": { "msg": { "isDefault":
	 * "", "totalCount": "", "good_list": { "good_endDate": "", "good_shopName":
	 * "", "good_targetUrl": "", "good_materialUrl": "", "good_promQuantity":
	 * "", "good_praiseDegree": "", "good_startDate": "", "good_name": "",
	 * "good_commRatio": "", "good_price": "", "good_pk": "", "good_shopUrl":
	 * "", "good_commision": "", "good_skuId": "" } } } }
	 */
	public static ResponseJd<ResponseResult<ResultUnionListData<GoodSafVo1>>> getPromotionGoodResponse(
			String gsonStr) {

		return GsonUtil
				.getObj4String(
						gsonStr,
						new TypeToken<ResponseJd<ResponseResult<ResultUnionListData<GoodSafVo1>>>>() {
						}, new JdResponseFieldNamingStaregy(
								"jingdong_union_promotiongood_query_responce",
								"msg", "good_list"));

	}

	/**
	 * 4. 联盟店铺搜索 接口名称： jingdong.union.promotionshop.query {
	 * "jingdong_union_promotionshop_query_response": { "msg": { "shop_list": {
	 * "shop_commRatio": "", "shop_materialUrl": "", "shop_goodsVolume": "",
	 * "shop_praiseDegree": "", "shop_promQuantity": "", "shop_mainCategories":
	 * "", "shop_pk": "", "shop_promotionUrl": "", "shop_name": "" },
	 * "isDefault": "", "totalCount": "" } } }
	 */
	public static ResponseJd<ResponseResult<ResultUnionListData<GoodSafVo>>> getPromotionShopQueryResponse(
			String gsonStr) {

		return GsonUtil
				.getObj4String(
						gsonStr,
						new TypeToken<ResponseJd<ResponseResult<ResultUnionListData<GoodSafVo>>>>() {
						}, new JdResponseFieldNamingStaregy(
								"jingdong_union_promotionshop_query_responce",
								"msg", "shop_list"));

	}

	/**
	 * 5. 查询效果报表数据 接口名称： jingdong.union.promotionreport.query
	 * 
	 * { "jingdong_union_promotionreport_query_response": { "msg": {
	 * "totalCount": "", "report_list": { "report_skuId": "", "report_itemNum":
	 * "", "report_shopName": "", "report_itemPrice": "", "report_commRatio":
	 * "", "report_sourceType": "", "report_orderNo": "", "report_unionId": "",
	 * "report_commision": "", "report_itemName": "", "report_orderStatus": "" }
	 * } } }
	 */
	public static ResponseJd<ResponseResult<ResultUnionListData<EffectReportSafVo>>> getPromotionReportQueryResponse(
			String gsonStr) {

		return GsonUtil
				.getObj4String(
						gsonStr,
						new TypeToken<ResponseJd<ResponseResult<ResultUnionListData<EffectReportSafVo>>>>() {
						},
						new JdResponseFieldNamingStaregy(
								"jingdong_union_promotionreport_query_responce",
								"msg", "report_list"));

	}

	/**
	 * 
	 * 6. 获取联盟用户详细信息 接口名称： jingdong.union.master.account.get
	 * 
	 * { "jingdong_union_master_account_get_responce":{ "campany_name":"",
	 * "bank_name":"", "owner_name":"", "card_no":"", "type":"1, 2",
	 * "union_id":"", "nick":"", "pin":"", "email":"", "name":"", "owner_id":"",
	 * "campany_address":"", "bank_address":"", "mobile":"" }
	 */
	public static ResponseJd<MasterAccount> getMasterAccountResponse(
			String gsonStr) {

		return GsonUtil.getObj4String(gsonStr,
				new TypeToken<ResponseJd<MasterAccount>>() {
				}, new JdResponseFieldNamingStaregy(
						"jingdong_union_master_account_get_responce", "null",
						"null"));

	}

	/**
	 * 7. 获取专柜推广报表 接口名称： jingdong.union.report.window.search {
	 * "jingdong_union_report_window_search_response":{ "result":{
	 * "message":"操作成功!", "datas":{ "amount":"", "itemNum":"",
	 * "completeOrders":"", "spaceName":"", "clickNum":"",
	 * "orderTime":"2013-07-03 00:00:00", "commission":"",
	 * "introductionOrders":"", "siteName":"", "size":"200*300" },
	 * "page_size":"", "page_index":"", "success":"true, false" } } }
	 */
	public static ResponseJd<ResponseResult<ResultUnionReportPager<WindowAdvDetail>>> getReportWindowResponse(
			String gsonStr) {

		return GsonUtil
				.getObj4String(
						gsonStr,
						new TypeToken<ResponseJd<ResponseResult<ResultUnionReportPager<WindowAdvDetail>>>>() {
						}, new JdResponseFieldNamingStaregy(
								"jingdong_union_report_window_search_responce",
								"result", "datas"));

	}

	/**
	 * 8. 商品转换接口(获取商品推广代码) 接口名称： jingdong.union.goods.code.get
	 * 
	 * { "jingdong_union_goods_code_response":{ "result":{ "link_code":"",
	 * "message":"操作成功!", "success":"true, false", "url_code":"", "img_code":""
	 * } } }
	 */
	public static ResponseJd<ResponseResult<GoodsCode>> getGoodCodeResponse(
			String gsonStr) {

		return GsonUtil
				.getObj4String(gsonStr,
						new TypeToken<ResponseJd<ResponseResult<GoodsCode>>>() {
						}, new JdResponseFieldNamingStaregy(
								"jingdong_union_goods_code_responce", "result",
								"null"));

	}

	/**
	 * 9. 店铺转换接口(获取店铺推广代码) 接口名称： jingdong.union.shop.code.get
	 * 
	 * { "jingdong_union_shop_code_response":{ "result":{ "link_code":"",
	 * "success":"true, false", "message":"操作成功!", "url_code":"", "img_code":""
	 * } } }
	 */
	public static ResponseJd<ResponseResult<GoodsCode>> getShopCodeResponse(
			String gsonStr) {

		return GsonUtil.getObj4String(gsonStr,
				new TypeToken<ResponseJd<ResponseResult<GoodsCode>>>() {
				}, new JdResponseFieldNamingStaregy(
						"jingdong_union_shop_code_responce", "result", "null"));

	}

	/**
	 * 这里总算做点好事 10. 活动转换接口(获取活动推广代码)
	 * 
	 * { "jingdong_union_activity_code_response":{ "result":{ "link_code":"",
	 * "message":"操作成功!", "success":"true, false", "url_code":"", "img_code":""
	 * } } }
	 * 
	 */
	public static ResponseJd<ResponseResult<GoodsCode>> getActivityCodeResponse(
			String gsonStr) {

		return GsonUtil.getObj4String(gsonStr,
				new TypeToken<ResponseJd<ResponseResult<GoodsCode>>>() {
				}, new JdResponseFieldNamingStaregy(
						"jingdong_union_activity_code_responce", "result",
						"null"));

	}

	/**
	 * 
	 * 11. 获取专柜信息 接口名称： jingdong.union.zone.info.get
	 * 
	 * { "jingdong_union_zone_info_response":{ "ad_zone":{ "zone_id":"",
	 * "status":"1,2", "web_url":"http://www.jd.com", "width":"", "size_id":"",
	 * "size_name":"", "promotion_type":"1,2", "web_name":"京东商城", "union_id":"",
	 * "category":[{ "category_name":"" }], "height":"", "zone_name":"",
	 * "web_id":"" } } }
	 * 
	 * 
	 */
	public static ResponseJd<ResponseResult<AdZoneVo>> getZoneInfoResponse(
			String gsonStr) {

		return GsonUtil
				.getObj4String(gsonStr,
						new TypeToken<ResponseJd<ResponseResult<AdZoneVo>>>() {
						}, new JdResponseFieldNamingStaregy(
								"jingdong_union_zone_info_responce", "ad_zone",
								"null"));

	}

	/**
	 * 12. 专柜转换接口(获取专柜推广代码)
	 * 
	 * { "jingdong_union_zone_code_response":{ "zone_code":"" } }
	 */
	public static ResponseJd<ZoneCode> getZoneCodeResponse(String gsonStr) {

		return GsonUtil.getObj4String(gsonStr,
				new TypeToken<ResponseJd<ZoneCode>>() {
				}, new JdResponseFieldNamingStaregy(
						"jingdong_union_zone_code_responce", "null", "null"));

	}

	/**
	 * 13. 获取效果概况 接口名称： jingdong.union.report.overview.search
	 * 
	 * { "jingdong_union_report_overview_response":{ "result":{ "page_size":"",
	 * "end_date":"2013-07-03 00:00:00", "page_total":"", "page_index":"",
	 * "data":{ "amount":"", "item_num":"", "order_time":"2013-07-03 00:00:00",
	 * "click_num":"", "introduction_orders":"", "commission":"",
	 * "complete_orders":"" }, "start_date":"2013-07-03 00:00:00" } } }
	 */

	public static ResponseJd<ResponseResult<ResultOverview<OverviewVo>>> getReportOverViewResponse(
			String gsonStr) {

		return GsonUtil
				.getObj4String(
						gsonStr,
						new TypeToken<ResponseJd<ResponseResult<ResultOverview<OverviewVo>>>>() {
						}, new JdResponseFieldNamingStaregy(
								"jingdong_union_report_overview_responce",
								"result", "null"));

	}

	/**
	 * 14. 获取结算单信息 接口名称： jingdong.union.master.bill.search
	 * 
	 * { "jingdong_union_bill_list_response":{ "data":{ "page_size":"",
	 * "page_index":"", "page_total":"", "bill_list":{ "total":"",
	 * "pay_amount":"", "bank_name":"", "status":"0/1/2", "pay_month":"201307",
	 * "pay_time":"2013-07-03 00:00:00", "technical_fee":"", "union_id":"",
	 * "bank_card":"", "tax":"", "adjust":"", "after_tax":"", "pay_id":"",
	 * "bill_id":"" } } } }
	 */
	public static ResponseJd<ResponseResult<ResultOverview<MasterBillVo>>> getMasterBillResponse(
			String gsonStr) {

		return GsonUtil
				.getObj4String(
						gsonStr,
						new TypeToken<ResponseJd<ResponseResult<ResultOverview<MasterBillVo>>>>() {
						}, new JdResponseFieldNamingStaregy(
								"jingdong_union_report_overview_responce",
								"result", "null"));

	}

	/**
	 * 15. 获取计划列表 接口名称： jingdong.union.planlist.search 这个接口很奇葩。我们可以看到，
	 * totalPage, 和totalCount参数，还好我们有个 ResultProductSkuListData 这个结果
	 * 类可以来顶替一下，int,int,T 刚好也满足这个规范，记住需要使用JdResponseSkuFieldNamingSt...这个类
	 * 
	 * { "jingdong_union_plan_list_response":{ "planListVO":{ "totalCount":"",
	 * "planList":{ "activityCount":"", "startDate":"", "planName":"",
	 * "status":"", "goodsCount":"", "endDate":"", "averageCommision":"",
	 * "pk":"" }, "totalPage":"" } } }
	 */
	public static ResponseJd<ResponseResult<ResultIITData<PlanVO>>> getPlanListResponse(
			String gsonStr) {

		return GsonUtil
				.getObj4String(
						gsonStr,
						new TypeToken<ResponseJd<ResponseResult<ResultIITData<PlanVO>>>>() {
						}, new JdResponseIITNamingStaregy(
								"jingdong_union_plan_list_responce",
								"planListVO", "totalCount", "totalPage",
								"planList"));

	}

	/**
	 * 16. 获取计划详情 接口名称： jingdong.union.plandetail.get 功能说明： 根据商家账号和计划编号查询商家计划详情
	 * 
	 * { "jingdong_union_plan_detail_response":{ "planVO":{
	 * "startDate":"2013-07-03 00:00:00", "planName":"", "categoryCommision":{
	 * "categoryLevel2Id":"", "categoryLevel2Name":"", "commisionRatio":"",
	 * "categoryLevel3Id":"", "categoryLevel1Id":"", "commisionRatioLevel2":"",
	 * "categoryLevel1Name":"", "categoryLevel3Name":"" },
	 * "endDate":"2013-07-03 00:00:00", "notes":"", "planActivity":{
	 * "activityImgList":{ "imgUrl":"" }, "activityUrl":"",
	 * "activityEndtime":"2013-07-03 00:00:00",
	 * "activityStarttime":"2013-07-03 00:00:00", "activityName":"" },
	 * "planGoods":{ "saleVolume":"", "skuId":"", "commisionRatio":"",
	 * "praiseDegree":"", "goodsName":"" } } } }
	 */
	public static ResponseJd<ResponseResult<PlanDetailVO>> getPlanDetailResponse(
			String gsonStr) {

		return GsonUtil
				.getObj4String(
						gsonStr,
						new TypeToken<ResponseJd<ResponseResult<PlanDetailVO>>>() {
						}, new JdResponseFieldNamingStaregy(
								"jingdong_union_plan_detail_responce",
								"planVO", "null"));

	}

	/**
	 * 17. 查询店铺推广详情 接口名称： jingdong.union.advdetail.get {
	 * "jingdong_union_adv_detail_response":{ "adv_detail":{ "promotion_goods":{
	 * "goods_list":{ "insert_time":"2013-07-03 00:00:00", "goods_name":"",
	 * "unitPrice":"", "plan_endtime":"2013-07-03 00:00:00", "praise_degree":"",
	 * "total_sales":"", "commision_ratio":"", "plan_id":"", "commision":"",
	 * "ware_url":"", "update_time":"2013-07-03 00:00:00", "mainimgurl":"",
	 * "recent_sales":"", "start_time":"2013-07-03 00:00:00", "sku_id":"",
	 * "pk":"" }, "total_count":"" }, "promotion_shop":{ "average_commision":"",
	 * "goods_volume":"", "shop_id":"", "insert_time":"2013-07-03 00:00:00",
	 * "pop_id":"", "praise_degree":"", "shop_mainurl":"", "plan_id":"",
	 * "shop_name":"", "accumulative_total":"",
	 * "update_time":"2013-07-03 00:00:00", "shop_url":"", "main_categories":"",
	 * "pk":"" }, "promotion_activity":{ "activity_list":{ "img_url":
	 * "/g15/M09/02/0C/rBEhWFHHtFsIAAAAAACVuAWYPKsAAAeAQPOChEAAJXQ933.jpg",
	 * "activity_pk":"", "average_commision":"",
	 * "activity_starttime":"2013-07-03 00:00:00", "activity_url":"",
	 * "img_urlprefix":"http://img30.360buyimg.com/ads/",
	 * "activity_endtime":"2013-07-03 00:00:00", "img_height":"",
	 * "activity_name":"", "img_pk":"", "img_width":"", "plan_id":"" },
	 * "total_count":"" }, "promotion_plan":{ "average_commision":"",
	 * "end_date":"2013-07-03 00:00:00", "update_time":"2013-07-03 00:00:00",
	 * "status":"1/11/9/6/10/-1", "activity_count":"",
	 * "insert_time":"2013-07-03 00:00:00", "pop_id":"",
	 * "start_date":"2013-07-03 00:00:00", "goods_count":"", "plan_name":"",
	 * "pk":"" } } } }
	 */
	public static ResponseJd<ResponseResult<AdvDetailVo>> getAdvDetailResponse(
			String gsonStr) {

		return GsonUtil.getObj4String(gsonStr,
				new TypeToken<ResponseJd<ResponseResult<AdvDetailVo>>>() {
				}, new JdResponseFieldNamingStaregy(
						"jingdong_union_adv_detail_responce", "adv_detail",
						"null"));

	}

	/**
	 * 18. 获取类目信息 接口名称： jingdong.union.categoryinfo.search
	 * 
	 * 
	 * { "jingdong_union_categoryinfo_search_response":{ "resultVO":{
	 * "message":"", "result":[{ "priceStart":"", "categoryLevel2Id":"",
	 * "categoryLevel2Name":"", "commisionRatio":"", "categoryLevel3Id":"",
	 * "categoryLevel1Id":"", "priceEnd":"", "commisionRatioLevel2":"",
	 * "categoryLevel1Name":"", "categoryLevel3Name":"" }], "successed":"",
	 * "code":"" } } }
	 */
	public static ResponseJd<ResponseResult<ResultBNST<List<CategoryCommision>>>> getCategoryInfoResponse(
			String gsonStr) {

		return GsonUtil
				.getObj4String(
						gsonStr,
						new TypeToken<ResponseJd<ResponseResult<ResultBNST<List<CategoryCommision>>>>>() {
						}, new JdResponseFieldNamingStaregy(
								"jingdong_union_categoryinfo_search_responce",
								"resultVO", "result"));

	}

	/**
	 * 19. 保存计划信息 接口名称： jingdong.union.plan.save 功能说明： 根据商家输入的计划信息新建或修改商家计划
	 * 
	 * 
	 * { "jingdong_union_plan_save_response":{ "resultVO":{ "message":"",
	 * "result":"", "successed":"", "code":"" } } }
	 * 
	 */
	public static ResponseJd<ResponseResult<ResultBNST<Integer>>> getPlanSaveResponse(
			String gsonStr) {

		return GsonUtil
				.getObj4String(
						gsonStr,
						new TypeToken<ResponseJd<ResponseResult<ResultBNST<Integer>>>>() {
						}, new JdResponseFieldNamingStaregy(
								"jingdong_union_plan_save_responce",
								"resultVO", "result"));

	}

	/**
	 * 20. 获取计划基本信息 接口名称： jingdong.union.planbaseinfo.get 功能说明：
	 * 根据商家计划编号查询商家计划基本信息 API用户授权类型：
	 * 
	 * { "jingdong_union_planbaseinfo_get_response":{ "resultVO":{ "message":"",
	 * "result":{ "startDate":"", "planName":"", "status":"", "endDate":"",
	 * "notes":"" }, "successed":"", "code":"" } } }
	 */
	public static ResponseJd<ResponseResult<ResultBNST<PlanVO>>> getPlanBaseInfoResponse(
			String gsonStr) {

		return GsonUtil
				.getObj4String(
						gsonStr,
						new TypeToken<ResponseJd<ResponseResult<ResultBNST<PlanVO>>>>() {
						}, new JdResponseFieldNamingStaregy(
								"jingdong_union_planbaseinfo_get_responce",
								"resultVO", "result"));

	}

	// #end

	// ==========================================================================
	// #start 【价格及促销】接口导航
	/**
	 * 1. 根据SKUID获取商品价格 接口名称： jingdong.ware.price.get
	 * 
	 * 
	 * 
	 * { "jingdong_ware_price_get_response": { "price_changes": [ { "price":
	 * "66.00", "market_price": "", "sku_id": "J_100012" } ] } }
	 */
	public static ResponseJd<ResponseResult<List<PriceChanges>>> getWarePriceResponse(
			String gsonStr) {

		return GsonUtil
				.getObj4String(
						gsonStr,
						new TypeToken<ResponseJd<ResponseResult<List<PriceChanges>>>>() {
						}, new JdResponseFieldNamingStaregy(
								"jingdong_ware_price_get_responce",
								"price_changes", "null"));

	}

	/**
	 * 2. 获取商品促销信息的接口 接口名称： jingdong.ware.promotionInfo.get
	 * 
	 * 
	 * { "jingdong_ware_promotionInfo_get_response": { "promoInfoResponse": {
	 * "promotionInfoList": [ { "promoId": "", "percent": "", "extType": "",
	 * "adwordGiftSkuList": [ { "giftType": "", "imagePath": "", "name": "",
	 * "skuId": "", "number": "", "giftState": "" } ], "reward": "",
	 * "fullRefundType": "", "haveFullRefundGifts": "", "adwordCouponList": [ {
	 * "couponQouta": "", "type": "", "key": "" } ], "topMoney": "",
	 * "promoEndTime": "", "score": "", "minNum": "", "needNum": "",
	 * "needMondey": "", "discount": "", "price": "", "userLevel": "", "rebate":
	 * "", "addMoney": "", "maxNum": "", "promoType": "", "limitUserType": "",
	 * "deliverNum": "" } ], "skuId": "" } } }
	 */
	public static ResponseJd<ResponseResult<ResultPromotionInfo>> getPromotionInfoResponse(
			String gsonStr) {

		return GsonUtil
				.getObj4String(
						gsonStr,
						new TypeToken<ResponseJd<ResponseResult<ResultPromotionInfo>>>() {
						}, new JdResponseFieldNamingStaregy(
								"jingdong_ware_promotionInfo_get_responce",
								"promoInfoResponse", "null"));

	}

	// #end

	// ==========================================================================
	// #start 【移动商城】接口导航
	/**
	 * 1.获得京东移动推荐的首页轮播图促销列表 jingdong.ware.promotion.indexactivity.list.get
	 * 
	 * { "jingdong_ware_promotion_indexactivity_list_get_response": {
	 * "activityInfoList": { "resultCode": "", "activityList": [ { "activity": {
	 * "activityId": "", "title": "", "horizontalImag": "", "sortNo": "",
	 * "type": "" } } ] } } }
	 */
	public static ResponseJd<ResponseResult<ResultListData<Activity>>> getWarePromotionIndexActivityListResponse(
			String gsonStr) {
		return GsonUtil
				.getObj4String(
						gsonStr,
						new TypeToken<ResponseJd<ResponseResult<ResultListData<Activity>>>>() {
						},
						new JdResponseFieldNamingStaregy(
								"jingdong_ware_promotion_indexactivity_list_get_responce",
								"activityInfoList", "activityList"));
	}

	/**
	 * 2.获得京东移动推荐首页轮播促销活动详情 jingdong.ware.promotion.indexactivity.get {
	 * "jingdong_ware_promotion_indexactivity_get_response": {
	 * "activityProductsList": { "activityProducts": [ { "wareName": "",
	 * "martPrice": "", "startRemainTime": "", "imageUrl": "", "adWord": "",
	 * "skuId": "", "jdPrice": "", "endRemainTime": "", "canFreeRead": "",
	 * "isBook": "" } ], "title": "", "page": "", "couponStatus": "",
	 * "totalCount": "", "couponURL": "", "horizontalImag": "",
	 * "promotionDetail": "", "resultCode": "", "roleIds": "" } } }
	 */
	public static ResponseJd<ResponseResult<ActivityProductsList>> getWarePromotionIndexActivityResponse(
			String gsonStr) {
		return GsonUtil
				.getObj4String(
						gsonStr,
						new TypeToken<ResponseJd<ResponseResult<ActivityProductsList>>>() {
						},
						new JdResponseFieldNamingStaregy(
								"jingdong_ware_promotion_indexactivity_get_responce",
								"activityProductsList", "activityProducts"));
	}

	/**
	 * 3.获得移动端的促销专场列表 接口名称 jingdong.ware.promotions.list.get
	 * 
	 * { "jingdong_ware_promotions_list_get_response": { "cmsPromotionsList": {
	 * "cmsPromotionsAll": [ { "promotionId": "", "promitionInfo": "",
	 * "imageUrl": "", "promotionName": "", "catelogyId": "" } ], "resultCode":
	 * "" } } }
	 * 
	 */
	public static ResponseJd<ResponseResult<ResultListData<CmsPromotions>>> getWarePromotionsListResponse(
			String gsonStr) {

		return GsonUtil
				.getObj4String(
						gsonStr,
						new TypeToken<ResponseJd<ResponseResult<ResultListData<CmsPromotions>>>>() {
						}, new JdResponseFieldNamingStaregy(
								"jingdong_ware_promotions_list_get_responce",
								"cmsPromotionsList", "cmsPromotionsAll"));

	}

	/**
	 * 4.根据移动端某分类获得对应的促销专场活动列表 接口名称 jingdong.ware.promotions.catelogyidlist.get
	 * { "jingdong_ware_promotions_catelogyidlist_get_response": {
	 * "cmsPromotionsByCatelogyIdList": { "cmsPromotionsList": [ {
	 * "promotionId": "", "promitionInfo": "", "imageUrl": "", "promotionName":
	 * "", "catelogyId": "" } ], "resultCode": "" } } }
	 */
	public static ResponseJd<ResponseResult<ResultListData<CmsPromotions>>> getWarePromotionsCategoryListResponse(
			String gsonStr) {

		return GsonUtil
				.getObj4String(
						gsonStr,
						new TypeToken<ResponseJd<ResponseResult<ResultListData<CmsPromotions>>>>() {
						},
						new JdResponseFieldNamingStaregy(
								"jingdong_ware_promotions_catelogyidlist_get_responce",
								"cmsPromotionsByCatelogyIdList",
								"cmsPromotionsList"));

	}

	/**
	 * 5.根据促销专场id获得专场促销活动列表 接口名称 jingdong.ware.promotion.activities.list.get
	 * 
	 * { "jingdong_ware_promotion_activities_list_get_response": {
	 * "cmsActivityList": { "cmsActivityLists": [ { "cmsActivity": { "content":
	 * "", "activityId": "", "startDate": "", "title": "", "status": "",
	 * "imageUrl": "", "endDate": "", "catelogyId": "" } } ], "totalCount": "",
	 * "resultCode": "" } } }
	 */
	public static ResponseJd<ResponseResult<ResultIITData<List<CmsActivity>>>> getWarePromotionsActivittiesListResponse(
			String gsonStr) {

		return GsonUtil
				.getObj4String(
						gsonStr,
						new TypeToken<ResponseJd<ResponseResult<ResultIITData<List<CmsActivity>>>>>() {
						},
						new JdResponseIITNamingStaregy(
								"jingdong_ware_promotion_activities_list_get_responce",
								"cmsActivityList", "totalCount", "resultCode",
								"cmsActivityLists"));

	}

	/**
	 * 6.根据促销活动id获得促销活动商品列表 接口名称 jingdong.ware.promotion.activityware.list.get
	 * "jingdong_ware_promotion_activityware_list_get_response": {
	 * "cmsActivityWareList": { "couponStatus": "", "totalCount": "",
	 * "couponURL": "", "resultCode": "", "cmsActivityWareLists": [ {
	 * "cmsActivityWare": { "wareName": "", "martPrice": "", "startRemainTime":
	 * "", "imageUrl": "", "adWord": "", "skuId": "", "jdPrice": "",
	 * "endRemainTime": "", "canFreeRead": "", "isBook": "" } } ],
	 * "cmsActivityRebateImg": "", "roleIds": "" } } }
	 */
	public static ResponseJd<ResponseResult<CmsActivityWareList>> getWarePromotionsActiviWareListResponse(
			String gsonStr) {

		return GsonUtil
				.getObj4String(
						gsonStr,
						new TypeToken<ResponseJd<ResponseResult<CmsActivityWareList>>>() {
						},
						new JdResponseFieldNamingStaregy(
								"jingdong_ware_promotion_activityware_list_get_responce",
								"cmsActivityWareList", "null"));

	}

	/**
	 * 8.获取全部逛的促销频道 接口名称 jingdong.ware.stroll.channel.list.get
	 * 
	 * 
	 * { "jingdong_ware_stroll_channel_list_get_response": { "guangList": {
	 * "resultCode": "", "guang_index_list": [ { "icon": "", "title": "",
	 * "foldFlag": "", "type": "", "functionId": "", "url": "" } ] } } }
	 */
	public static ResponseJd<ResponseResult<ResultListData<Guang>>> getWareStrollChannelResponse(
			String gsonStr) {

		return GsonUtil
				.getObj4String(
						gsonStr,
						new TypeToken<ResponseJd<ResponseResult<ResultListData<Guang>>>>() {
						},
						new JdResponseFieldNamingStaregy(
								"jingdong_ware_stroll_channel_list_get_responce",
								"guangList", "guang_index_list"));

	}

	/**
	 * 9.获取逛的女士频道的促销商品列表 接口名称 jingdong.ware.stroll.ladychannel.list.get {
	 * "jingdong_ware_stroll_ladychannel_list_get_response": { "channelList": {
	 * "showClick": "", "resultCode": "", "wareInfoList": [ { "wareName": "",
	 * "martPrice": "", "startRemainTime": "", "imageUrl": "", "adWord": "",
	 * "skuId": "", "jdPrice": "", "endRemainTime": "", "canFreeRead": "",
	 * "isBook": "" } ] } } }
	 */
	public static ResponseJd<ResponseResult<ResultISTListData<WareInfo>>> getWareStrollLadyChannelResponse(
			String gsonStr) {

		return GsonUtil
				.getObj4String(
						gsonStr,
						new TypeToken<ResponseJd<ResponseResult<ResultISTListData<WareInfo>>>>() {
						},
						new JdResponseISNamingStaregy(
								"jingdong_ware_stroll_ladychannel_list_get_responce",
								"channelList", "resultCode", "showClick",
								"wareInfoList"));

	}

	/**
	 * 10.获取逛的男士频道的促销商品列表 接口名称 jingdong.ware.stroll.manchannel.list.get
	 * 
	 * { "jingdong_ware_stroll_manchannel_list_get_response": { "channelList": {
	 * "showClick": "", "resultCode": "", "wareInfoList": [ { "wareName": "",
	 * "martPrice": "", "startRemainTime": "", "imageUrl": "", "adWord": "",
	 * "skuId": "", "jdPrice": "", "endRemainTime": "", "canFreeRead": "",
	 * "isBook": "" } ] } } }
	 */
	public static ResponseJd<ResponseResult<ResultISTListData<WareInfo>>> getWareStrollManChannelResponse(
			String gsonStr) {

		return GsonUtil
				.getObj4String(
						gsonStr,
						new TypeToken<ResponseJd<ResponseResult<ResultISTListData<WareInfo>>>>() {
						},
						new JdResponseISNamingStaregy(
								"jingdong_ware_stroll_manchannel_list_get_responce",
								"channelList", "resultCode", "showClick",
								"wareInfoList"));

	}
	// #end
	
}
