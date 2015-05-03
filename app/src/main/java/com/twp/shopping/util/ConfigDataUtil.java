/*
 * 文  件  名:  Constants.java
 * 创建日期:  2014-3-2/上午9:48:12
 * 版       权:  Royal.k.peng@gmail.com, All rights reserved
 * 作       者:  Royal
 * 座 右  铭:  Never give up, adhere to in the end.
 */
package com.twp.shopping.util;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

import android.content.Context;
import android.os.Bundle;
import android.util.DisplayMetrics;
import android.util.Log;

import com.twp.frame.request.image.DiskLruCache;
import com.twp.frame.request.image.ImageCache;
import com.twp.frame.request.image.ImageFetcher;
import com.twp.frame.request.image.ImageCache.ImageCacheParams;
import com.twp.frame.request.image.Utils;
import com.twp.frame.util.Logger;
import com.twp.shopping.R;

/**
 * 
 * @author Royal
 * @Email Royal.k.peng@gmail.com
 */
public final class ConfigDataUtil {

	private static final String TAG = "ConfigDataUtil";
	private static final String IMAGE_CACHE_DIR = "thumbs";
	// 饿汉模式，默认初始化，
	private static ConfigDataUtil instance = new ConfigDataUtil();

	private Properties properties;

	public ProPertiesSetting proPertiesSetting;

	//bitmapfun 
	private ImageCacheParams cacheParams;
	private ImageCache mImageCache;

	private DisplayMetrics metrics;

	public DisplayMetrics getMetrics() {
		return metrics;
	}

	public void setMetrics(DisplayMetrics metrics) {
		this.metrics = metrics;
	}

	/** 使用私有构造器，不让外部对象初始化对象 */
	private ConfigDataUtil() {
		this.properties = new Properties();
	}

	public static ConfigDataUtil getInstance() {
		if (instance == null) {
			instance = new ConfigDataUtil();
		}
		return instance;
	}

	public void init(Context context) {
		initProperties(context);
		initImageCache(context);
	}

	/** 初始化属性配置对象,读取setting中的配置 */
	private void initProperties(Context context) {
		InputStream in = null;
		try {

			in = context.getResources().openRawResource(R.raw.setting);
			properties.load(in);
			Bundle bundle = new Bundle();
			String tag = properties.getProperty(Logger.KEY_TAG);
			bundle.putString(Logger.KEY_TAG, tag);
			boolean isLog = getPropertieBoolean(Logger.KEY_ISLOG);
			bundle.putBoolean(Logger.KEY_ISLOG, isLog);
			boolean write2Sdcard = getPropertieBoolean(Logger.KEY_WRITE_SDCARD);
			bundle.putBoolean(Logger.KEY_WRITE_SDCARD, write2Sdcard);
			int logLevel = getPropertieInt(Logger.KEY_LOG_LEVEL);
			bundle.putInt(Logger.KEY_LOG_LEVEL, logLevel);
			String fileName = properties.getProperty(Logger.KEY_LOG_FILENAME);
			bundle.putString(Logger.KEY_LOG_FILENAME, fileName);
			String logPath = context.getFilesDir().toString();
			bundle.putString(Logger.KEY_LOG_PATH, logPath);
			Log.i(TAG, "logconfig=[tag=" + tag + ",islog=" + isLog
					+ ",writeTosdCard=" + write2Sdcard + ",logLevel="
					+ logLevel + ",fileName=" + fileName + ",logPath="
					+ logPath);
			// init the logger.
			Logger.initLogger(bundle);

			boolean isTestData = getPropertieBoolean(StaticConstant.KEY_IS_TESTDATA);
			String appId = properties.getProperty(StaticConstant.KEY_APP_ID,
					StaticConstant.KEY_APP_ID);

		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			if (null != in) {
				try {
					in.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		}
	}

	private boolean getPropertieBoolean(String key) {
		return Boolean.parseBoolean(properties.getProperty(key));
	}

	private int getPropertieInt(String key) {
		int i = Log.INFO;
		try {
			String str = properties.getProperty(key);
			i = Integer.parseInt(str);
		} catch (NumberFormatException e) {
			Log.v(TAG, "pasre propertieInt error! messge = " + e.toString());
			return i;
		}
		return i;
	}

	/**
	 * 初始化 bitmapfun 框架中的配置参数
	 * @param context
	 */
	private void initImageCache(Context context) {

		cacheParams = new ImageCacheParams(IMAGE_CACHE_DIR);
		cacheParams.memCacheSize = 1024 * 1024 * Utils.getMemoryClass(context) / 3;
		mImageCache = new ImageCache(context, cacheParams);
	}

	public ImageCache getmImageCache() {
		if (null == mImageCache) {
			throw new NullPointerException(
					"you need call initImageCache function before you call this methods.");
		}
		return mImageCache;
	}

	public void clearCache(Context context) {
		getmImageCache().clearCaches();
		DiskLruCache.clearCache(context, ImageFetcher.HTTP_CACHE_DIR);
	}

	/**
	 * <pre>
	 * setting.properties 中的配置文件,
	 * setting.properties 中有几个属性就需要有几个成员变量,类型需要一直
	 * @author Administrator / Never give up, adhere to in the end.
	 * @addrs  pengqinping@gmail.com
	 */
	public class ProPertiesSetting {

		public boolean isLog;

		public boolean isTestData;

		public String appId;

		private ProPertiesSetting(boolean isLog, boolean isTestData,
				String appId) {
			this.isLog = isLog;
			this.appId = appId;
			this.isTestData = isTestData;
		}

		public boolean isLog() {
			return isLog;
		}

		public void setLog(boolean isLog) {
			this.isLog = isLog;
		}

		public boolean isTestData() {
			return isTestData;
		}

		public void setTestData(boolean isTestData) {
			this.isTestData = isTestData;
		}

		public String getAppId() {
			return appId;
		}

		public void setAppId(String appId) {
			this.appId = appId;
		}

	}

}
