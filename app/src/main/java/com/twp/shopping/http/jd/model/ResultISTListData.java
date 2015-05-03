package com.twp.shopping.http.jd.model;

import java.io.Serializable;

//奇葩的京东 接口编码人员，你奶奶的，定义这么多不同的类型砸死啊。
//这个类的适合对象 ，一个T　一个int ,一个string,
public class ResultISTListData<T> implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1381984236107390748L;

	private int resultCode;

	private String resultString;

	private T resultData;

	public int getResultCode() {
		return resultCode;
	}

	public void setResultCode(int resultCode) {
		this.resultCode = resultCode;
	}

	
	public T getResultData() {
		return resultData;
	}

	public void setResultData(T resultData) {
		this.resultData = resultData;
	}

	public String getResultString() {
		return resultString;
	}

	public void setResultString(String resultString) {
		this.resultString = resultString;
	}

	@Override
	public String toString() {
		return "ResultISTListData [resultCode=" + resultCode
				+ ", resultString=" + resultString + ", resultData="
				+ resultData + "]";
	}


}
