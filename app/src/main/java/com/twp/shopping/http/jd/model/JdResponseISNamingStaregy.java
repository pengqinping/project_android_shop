package com.twp.shopping.http.jd.model;

import java.lang.reflect.Field;

import com.google.gson.FieldNamingStrategy;
import com.twp.frame.util.EmptyUtil;

public class JdResponseISNamingStaregy implements FieldNamingStrategy {

	/**
	 * 这两个参数必须设置要不然获取不不到值
	 */
	private String responseJd;//接口名
	private String resultJd;//第一层list name
	private String resultCode;//第一层list 中 int 中属性名 resultCode 
	private String resultString;//第一层list 中 String 中属性名 resultString
	private String resultData;//第一层list 中 obj 中属性名 resultData,这个可能是list 也可能是对象
	

	public JdResponseISNamingStaregy() {
		super();
	}

	public JdResponseISNamingStaregy(String responseJd, String resultJd,
			String resultCode,String resultString,String resultData) {
		super();
		this.responseJd = responseJd;
		this.resultJd = resultJd;
		this.resultCode =resultCode;
		this.resultString = resultString;
		this.resultData = resultData;
		
	}

	@Override
	public String translateName(Field arg0) {
		if (EmptyUtil.isStringEmpty(responseJd)
				|| EmptyUtil.isStringEmpty(resultJd)) {
			return arg0.getName();
		}
		if (arg0.getName().equals("responseJd")) {
			return responseJd;
		}
		if (arg0.getName().equals("resultJd")) {
			return resultJd;
		}

		if (arg0.getName().equals("resultCode")) {
			return resultCode;
		}
		
		
		if (arg0.getName().equals("resultString")) {
			return resultString;
		}
		
		if (arg0.getName().equals("resultData")) {
			return resultData;
		}
		return arg0.getName();
	}
}
