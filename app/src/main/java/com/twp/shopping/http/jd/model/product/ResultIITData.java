package com.twp.shopping.http.jd.model.product;

import java.io.Serializable;

public class ResultIITData<T> implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1381984236107390748L;

	private int resultCode;

	private int resultCode1;

	private T resultData;

	public int getResultCode() {
		return resultCode;
	}

	public void setResultCode(int resultCode) {
		this.resultCode = resultCode;
	}

	public int getResultCode1() {
		return resultCode1;
	}

	public void setResultCode1(int resultCode1) {
		this.resultCode1 = resultCode1;
	}

	public T getResultData() {
		return resultData;
	}

	public void setResultData(T resultData) {
		this.resultData = resultData;
	}

	@Override
	public String toString() {
		return "ResultIITData [resultCode=" + resultCode + ", resultCode1="
				+ resultCode1 + ", resultData=" + resultData + "]";
	}

}
