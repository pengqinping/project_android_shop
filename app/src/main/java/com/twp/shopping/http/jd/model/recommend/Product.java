package com.twp.shopping.http.jd.model.recommend;

import java.io.Serializable;

public class Product implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 8582049019217908116L;

	private int skuId;
	/* 商品编号 */
	private String skuPicUrl;
	/* 商品图片地址 */
	private String skuName;
	/* 商品名称 */
	public int getSkuId() {
		return skuId;
	}
	public void setSkuId(int skuId) {
		this.skuId = skuId;
	}
	public String getSkuPicUrl() {
		return skuPicUrl;
	}
	public void setSkuPicUrl(String skuPicUrl) {
		this.skuPicUrl = skuPicUrl;
	}
	public String getSkuName() {
		return skuName;
	}
	public void setSkuName(String skuName) {
		this.skuName = skuName;
	}
	@Override
	public String toString() {
		return "Product [skuId=" + skuId + ", skuPicUrl=" + skuPicUrl
				+ ", skuName=" + skuName + "]";
	}

	
	
}
