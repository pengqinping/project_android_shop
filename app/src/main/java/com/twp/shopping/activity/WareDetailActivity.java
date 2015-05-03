/*
 * 文  件  名:  WareDetailActivity.java
 * 创建日期:  2014-3-9/下午4:41:55
 * 版       权:  Royal.k.peng@gmail.com, All rights reserved
 * 作       者:  Royal
 * 座 右  铭:  Never give up, adhere to in the end.
 */
package com.twp.shopping.activity;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

import org.json.JSONObject;

import android.app.ActionBar;
import android.content.ContentValues;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.os.Message;
import android.text.Html;
import android.text.TextUtils;
import android.view.MenuItem;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.jd.open.sdk.android.JdException;
import com.jd.open.sdk.android.JdListener;
import com.jd.open.sdk.android.api.InvokeError;
import com.twp.frame.request.image.ImageFetcher;
import com.twp.frame.request.image.ImageResizer;
import com.twp.frame.util.EmptyUtil;
import com.twp.frame.util.Logger;
import com.twp.shopping.R;
import com.twp.shopping.http.jd.APIProduct;
import com.twp.shopping.http.jd.model.ProductBase;
import com.twp.shopping.http.jd.model.ProductInfo;
import com.twp.shopping.http.jd.model.ResponseJd;
import com.twp.shopping.http.jd.model.ResponseResult;
import com.twp.shopping.http.jd.model.ResultListData;
import com.twp.shopping.http.jd.model.product.Productbigfield;
import com.twp.shopping.http.jd.model.product.Provinces;
import com.twp.shopping.http.jd.model.product.ResultProductDetail;
import com.twp.shopping.http.jd.model.product.ResultSKUListData;
import com.twp.shopping.http.jd.util.GsonUtil;
import com.twp.shopping.provider.CollectOpenHelper;
import com.twp.shopping.provider.ProviderCollect;
import com.twp.shopping.util.ConfigDataUtil;
import com.twp.shopping.util.Constants;
import com.twp.shopping.util.XMLParse;

/**
 * @Ctime 2014-3-9/下午4:41:55
 * @author Royal
 * @DESC 商品详情页面大致布局和请求过程。<br>
 *       请求： 1. 省会查询。保存一份到本地，下次先去展示，然后在去下载，下载完成后在熟刷新缓存。 1.2.查询省会的库存 2. 获取商品详情列表
 *       3. 获取sku商品信息。
 * 
 */
public class WareDetailActivity extends BaseActivity implements
		JdListener.RequestListener {

	private static final String TAG = "WareDetailActivity";
	private static final String TRA_WARESELECTEDPROVINCELIST = "jingdong.ware.selected.province.list.get";
	private static final String TRA_WARESKUSEARCHLIST = "jingdong.ware.sku.search.list.get";
	private static final String TRA_WAREBASEINTO = "jingdong.ware.baseproduct.get";
	private static final String TRA_WAREDETAIL = "jingdong.ware.product.detail.search.list.get";
	private static final String TRA_BIGFIELD = "jingdong.ware.bookbigfield.get";
	private static final int REQ_PROVINCE_FNISH = 1;
	private static final int REQ_SKU_FNISH = 2;
	private static final int REQ_BASE_FNISH = 3;
	private static final int REQ_DETAIL_FNISH = 4;
	private static final int REQ_BIGFIELD_FNISH = 5;

	private String flashFilePath = "provinces.xml";

	private volatile String skuID = "";

	private List<Provinces> mProvices = new ArrayList<Provinces>();

	private ImageView imgWareBigShow;
	private TextView tvKeyWorld;
	private TextView tvProvince;

	private TextView tvWareInfoSku;
	private TextView tvWareInfoDetail;
	private TextView tvWareInfoBase;
	private TextView tvWareInfoBig;

	//
	private ImageResizer mImageWorker;

	//
	ProductInfo productInfo;

	ProductBase mProductBase;

	@Override
	public void handleUIMessage(Message msg) {
		switch (msg.what) {
		case REQ_PROVINCE_FNISH:
			// 先缓存
			XMLParse.createProvicesXML((List<Provinces>) msg.obj, getFilesDir()
					+ File.separator + flashFilePath);

			break;
		case REQ_SKU_FNISH:
			tvWareInfoSku.setText("---"
					+ ((ResultSKUListData) msg.obj).toString());
			break;
		case REQ_BASE_FNISH:
			List<ProductBase> baseLists = (List<ProductBase>) msg.obj;
			if (baseLists != null && baseLists.size() >= 1) {
				mProductBase = baseLists.get(0);
			}
			StringBuffer sb = new StringBuffer("[");
			for (ProductBase productBase : baseLists) {
				sb.append(productBase.toString());
			}
			sb.append("]");
			tvWareInfoBase.setText(sb.toString());
			break;
		case REQ_DETAIL_FNISH:
			// tvWareInfoDetail
			// .setText(((ResultProductDetail) msg.obj).toString());
			ResultProductDetail result = ((ResultProductDetail) msg.obj);
			productInfo = result.getProductInfo();
			if (EmptyUtil.isStringNotEmpty(productInfo.getImgUrlN1())) {
				mImageWorker.loadImage(productInfo.getImgUrlN1(),
						imgWareBigShow);
			}
			tvKeyWorld.setText(productInfo.getAdword());
			StringBuffer stringbuffer = new StringBuffer();
			stringbuffer.append("市场价:");
			stringbuffer.append(productInfo.getMarketPrice() + "\n");
			stringbuffer.append("京东价:");
			stringbuffer.append(productInfo.getJdPrice() + " \n");
			stringbuffer.append("库存:");
			stringbuffer.append(productInfo.getTotalCount());
			tvWareInfoDetail
					.setText(TextUtils.isEmpty(stringbuffer.toString()) ? "没有详细信息"
							: stringbuffer.toString());
			break;
		case REQ_BIGFIELD_FNISH:
			Productbigfield productBigField = (Productbigfield) msg.obj;
			tvWareInfoBig.setText(Html.fromHtml(EmptyUtil
					.isStringEmpty(productBigField.getShou_hou()) ? ""
					: productBigField.getShou_hou()));
			break;
		default:
			break;
		}
	}

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		Intent intent = getIntent();
		int skuId = intent.getIntExtra("skuId", 0);
		skuID = String.valueOf(skuId);

		ActionBar actionBar = getActionBar();
		if (null != actionBar) {
			actionBar.setDisplayHomeAsUpEnabled(true);
			actionBar.setDisplayShowHomeEnabled(false);
			String title = intent.getStringExtra("Title");
			actionBar.setTitle(title);
		}

		setContentView(R.layout.activity_ware_detail);
		initView();
		// requestProvinceCode();
		requestWareDetail(skuId, true);
		//requestWareInfoSku(skuID);
		//requesetWareInfoBaseMessage(skuID, "name");
		requestWareBigInfo(skuID, "prop_code");
	}

	/**
	 * 保存到数据库
	 * 
	 * @param v
	 */
	public void onWatch(View v) {
		if (null != productInfo) {
			ContentValues cValues = new ContentValues();
			cValues.put(CollectOpenHelper.PARAM_SKUID, skuID);
			cValues.put(CollectOpenHelper.PARAM_WARMNAME,
					productInfo.getWname());
			cValues.put(CollectOpenHelper.PARAM_WAREPRICE,
					String.valueOf(productInfo.getJdPrice()));
			cValues.put(CollectOpenHelper.PARAM_WARE_IMAGEURL,
					productInfo.getImgUrlN1());
			cValues.put(CollectOpenHelper.PARAM_WARE_CONTENT,
					productInfo.getAdword());
			Uri uri = Uri.parse(ProviderCollect.CONTENT_URI + "/1");
			getContentResolver().insert(uri, cValues);
			Toast.makeText(this, "收藏成功", Toast.LENGTH_SHORT).show();
		}
	}

	public void onShared(View v) {

		if (null != productInfo) {
			Intent intent = new Intent(Intent.ACTION_SEND);
			intent.setType("image/*");
			intent.putExtra(Intent.EXTRA_SUBJECT, "商品分享");

			intent.putExtra(Intent.EXTRA_TEXT,
					"我在 Shopping 应用中发现一个 不错的商品，大家快去看看。网址:"
							+ "http://m.360buy.com/product/" + skuID
							+ ".html?v=1");
			intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
			startActivity(Intent.createChooser(intent, "选择应用分享"));
		}

	}

	public void gotoBuy(View view) {
		Intent intent = new Intent(WareDetailActivity.this,
				WareBuyWebViewActivity.class);
		intent.putExtra("url", "http://m.360buy.com/product/" + skuID
				+ ".html?v=1");
		startActivity(intent);
	}

	@Override
	public boolean onOptionsItemSelected(MenuItem item) {

		switch (item.getItemId()) {
		case android.R.id.home: {
			super.onBackPressed();
			break;
		}
		default:
			break;
		}
		return super.onOptionsItemSelected(item);
	}

	private void initView() {
		imgWareBigShow = (ImageView) findViewById(R.id.imgWareBigShow);
		tvKeyWorld = (TextView) findViewById(R.id.tvKeyWorld);
		tvProvince = (TextView) findViewById(R.id.tvProvince);
		tvWareInfoSku = (TextView) findViewById(R.id.tvWareInfoSku);
		tvWareInfoBase = (TextView) findViewById(R.id.tvWareInfoBase);
		tvWareInfoDetail = (TextView) findViewById(R.id.tvWareInfoDetail);
		tvWareInfoBig = (TextView) findViewById(R.id.tvWareInfoBig);

		mImageWorker = new ImageFetcher(this, 250);
		mImageWorker.setImageCache(ConfigDataUtil.getInstance()
				.getmImageCache());
		mImageWorker.setLoadingImage(R.drawable.default_720_225);
	}

	// 省会编号
	private void requestProvinceCode() {
		// 先去判断一下是否存在本地文件。
		// getFilesDir = /data/data/com.twp.shopping/files
		final File file = new File(getFilesDir(), flashFilePath);
		Logger.d(TAG, "getFilesDir() = " + getFilesDir());
		if (file.isFile() && file.exists()) {
			// 省份存在缓存文件。直接读取xml文件
			Logger.d(
					TAG,
					"exists a file of provinces.xml file.path = "
							+ file.getPath());
			new Thread() {
				public void run() {
					mProvices = XMLParse.parseProvicesXML(file);

				};
			}.start();
		} else {
			APIProduct.getWareSelectedProvinceList(WareDetailActivity.this,
					TRA_WARESELECTEDPROVINCELIST, client,
					Constants.PARAM_CLIENT_ANDROID, this);
		}
	}

	// detail
	private void requestWareDetail(int skuId, boolean isLoadWareScore) {
		APIProduct.getWareProductWareDetail(WareDetailActivity.this,
				TRA_WAREDETAIL, client, Constants.PARAM_CLIENT_ANDROID, skuId,
				isLoadWareScore, this);
	}

	// sku
	private void requestWareInfoSku(String skuID) {
		APIProduct.getWareSkuSearchList(WareDetailActivity.this,
				TRA_WARESKUSEARCHLIST, client, Constants.PARAM_CLIENT_ANDROID,
				skuID, this);
	}

	// baseInfo
	private void requesetWareInfoBaseMessage(String ids, String bases) {
		APIProduct.getWareBaseProdct(WareDetailActivity.this, TRA_WAREBASEINTO,
				client, ids, bases, this);
	}

	private void requestWareBigInfo(String sku_id, String field) {
		APIProduct.getWareProductBigField(WareDetailActivity.this,
				TRA_BIGFIELD, client, sku_id, field, this);
	}

	@Override
	public void onComplete(String transitionId, JSONObject result) {
		if (transitionId.equals(TRA_WARESELECTEDPROVINCELIST)) {
			// 省会编号,缓存到xml文件
			ResponseJd<ResponseResult<ResultListData<Provinces>>> response = GsonUtil
					.getProvincesResponse(result.toString());
			List<Provinces> resultList = response.getResponseJd().getResultJd()
					.getResultListData();
			Message message = uiHandler.obtainMessage();
			message.obj = resultList;
			message.what = REQ_PROVINCE_FNISH;
			uiHandler.sendMessage(message);
		} else if (transitionId.equals(TRA_WARESKUSEARCHLIST)) {
			ResponseJd<ResponseResult<ResultSKUListData>> response = GsonUtil
					.getSKUResponse(result.toString());
			ResultSKUListData resultSku = response.getResponseJd()
					.getResultJd();
			Message message = uiHandler.obtainMessage();
			message.obj = resultSku;
			message.what = REQ_SKU_FNISH;
			uiHandler.sendMessage(message);
		} else if (transitionId.equals(TRA_WAREDETAIL)) {
			ResponseJd<ResponseResult<ResultProductDetail>> response = GsonUtil
					.getProductDetail(result.toString());
			Message message = uiHandler.obtainMessage();
			message.obj = response.getResponseJd().getResultJd();
			message.what = REQ_DETAIL_FNISH;
			uiHandler.sendMessage(message);

		} else if (transitionId.equals(TRA_WAREBASEINTO)) {
			ResponseJd<ResponseResult<List<ProductBase>>> response = GsonUtil
					.getProductBaseResponse(result.toString());
			Message message = uiHandler.obtainMessage();
			message.obj = response.getResponseJd().getResultJd();
			message.what = REQ_BASE_FNISH;
			uiHandler.sendMessage(message);

		} else if (transitionId.equals(TRA_BIGFIELD)) {
			ResponseJd<Productbigfield> response = GsonUtil
					.getProductBigFieldResponse(result.toString());
			Message message = uiHandler.obtainMessage();
			message.obj = response.getResponseJd();
			message.what = REQ_BIGFIELD_FNISH;
			uiHandler.sendMessage(message);
		}
	}

	@Override
	public void onError(String transitionId, InvokeError e) {

	}

	@Override
	public void onJdError(String transitionId, JdException e) {

	}

}
