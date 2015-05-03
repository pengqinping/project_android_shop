package com.twp.shopping.http.jd.model.product;

import java.io.Serializable;

public class ProductStock implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 894437836776010859L;

	/* 是否有货 */
	private boolean flag;

	/* 库存状态 */
	private String stockStatus;

	private int resultCode;

	public String getStockStatus() {
		return stockStatus;
	}

	public void setStockStatus(String stockStatus) {
		this.stockStatus = stockStatus;
	}

	public boolean isFlag() {
		return flag;
	}

	public void setFlag(boolean flag) {
		this.flag = flag;
	}

	public int getResultCode() {
		return resultCode;
	}

	public void setResultCode(int resultCode) {
		this.resultCode = resultCode;
	}

	@Override
	public String toString() {
		return "ProductStock [flag=" + flag + ", stockStatus=" + stockStatus
				+ ", resultCode=" + resultCode + "]";
	}

}
