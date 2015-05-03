/*
 * 版       权:  Royal.k.peng@gmail.com, All rights reserved
 * 作       者:  Royal
 * 座 右  铭:  Never give up, adhere to in the end.
 */
package com.twp.shopping.ui;

import org.json.JSONException;
import org.json.JSONObject;

import com.google.gson.Gson;
import com.google.gson.JsonSyntaxException;
import com.google.gson.reflect.TypeToken;
import com.twp.frame.util.Logger;

/**
 * Gson 解析类
 * @author Royal
 * @Email Royal.k.peng@gmail.com
 */
public class GsonHelper {

	public static <T> Object formJson(String jsonStr, TypeToken<T> typeToken)
			throws JsonSyntaxException {
		
		if (!assetGson(jsonStr)) {
			return null;
		}
		
		Gson gson = new Gson();
		return gson.fromJson(jsonStr, typeToken.getType());
	}

	private static boolean assetGson(String jsonStr) {

		boolean isJsonStr = true;
		try {

			new JSONObject(jsonStr);

		} catch (JSONException e) {
			isJsonStr = false;
			Logger.i("error : "+e.toString());
		}
		return isJsonStr;
	}
	
}
