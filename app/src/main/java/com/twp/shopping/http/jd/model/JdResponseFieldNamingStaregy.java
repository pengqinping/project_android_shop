package com.twp.shopping.http.jd.model;

import java.lang.reflect.Field;

import com.google.gson.FieldNamingStrategy;
import com.twp.frame.util.EmptyUtil;

public class JdResponseFieldNamingStaregy implements FieldNamingStrategy {

	/**
	 * 这两个参数必须设置要不然获取不不到值
	 */
	private String responseJd;
	private String resultJd;
	private String resultListData;
	private String resultCode;

	public JdResponseFieldNamingStaregy() {
		super();
	}

	public JdResponseFieldNamingStaregy(String responseJd, String resultJd,
			String resultListData) {
		super();
		this.responseJd = responseJd;
		this.resultJd = resultJd;
		this.resultListData = resultListData;
	}

	public JdResponseFieldNamingStaregy(String responseJd, String resultJd,
			String resultCode, String resultListData) {
		super();
		this.responseJd = responseJd;
		this.resultJd = resultJd;
		this.resultCode = resultCode;
		this.resultListData = resultListData;
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
		if(arg0.getName().equals("resultCode")){
			return resultCode;
		}
		if (arg0.getName().equals("resultListData")) {
			return resultListData;
		}
		return arg0.getName();
	}
}
