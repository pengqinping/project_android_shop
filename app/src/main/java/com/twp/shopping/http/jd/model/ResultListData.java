package com.twp.shopping.http.jd.model;

import java.io.Serializable;
import java.util.List;

public class ResultListData<T> implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1381984236107390748L;
	private int resultCode;
	private List<T> resultListData;

	public int getResultCode() {
		return resultCode;
	}

	public void setResultCode(int resultCode) {
		this.resultCode = resultCode;
	}

	public List<T> getResultListData() {
		return resultListData;
	}

	public void setResultListData(List<T> resultListData) {
		this.resultListData = resultListData;
	}

	@Override
	public String toString() {
		return "ResultListData [resultCode=" + resultCode + ", resultListData="
				+ resultListData + "]";
	}

	
}
