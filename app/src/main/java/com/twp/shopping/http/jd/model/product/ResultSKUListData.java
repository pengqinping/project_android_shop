package com.twp.shopping.http.jd.model.product;

import java.io.Serializable;
import java.util.List;


public class ResultSKUListData implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -1978114835417784628L;

	private List<SkuColor> skuColor;

	private List<SkuSize> skuSize;

	private int resultCode;

	public List<SkuColor> getSkuColor() {
		return skuColor;
	}

	public void setSkuColor(List<SkuColor> skuColor) {
		this.skuColor = skuColor;
	}

	public List<SkuSize> getSkuSize() {
		return skuSize;
	}

	public void setSkuSize(List<SkuSize> skuSize) {
		this.skuSize = skuSize;
	}

	public int getResultCode() {
		return resultCode;
	}

	public void setResultCode(int resultCode) {
		this.resultCode = resultCode;
	}

	@Override
	public String toString() {
		return "ResultSKUListData [skuColor=" + skuColor + ", skuSize="
				+ skuSize + ", resultCode=" + resultCode + "]";
	}

}
