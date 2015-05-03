package com.twp.shopping.http.jd.model.recommend;

import java.io.Serializable;

public class Packs implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 4946499342870602009L;

	private String packListPrice;
	/* 组合原价 */
	private String packPrice;
	/* 套装价 */
	private String mainSkuPicUrl;
	/* 商品图片url */
	private String packId;

	private String mainSkuId;
	/* 主商品编号 */
	private String discount;
	/* 折扣 */
	private String mainSkuName;
	/* 主商品名称 */
	private Product packs;
	/* 组合商品信息 */
	public String getPackListPrice() {
		return packListPrice;
	}
	public void setPackListPrice(String packListPrice) {
		this.packListPrice = packListPrice;
	}
	public String getPackPrice() {
		return packPrice;
	}
	public void setPackPrice(String packPrice) {
		this.packPrice = packPrice;
	}
	public String getMainSkuPicUrl() {
		return mainSkuPicUrl;
	}
	public void setMainSkuPicUrl(String mainSkuPicUrl) {
		this.mainSkuPicUrl = mainSkuPicUrl;
	}
	public String getPackId() {
		return packId;
	}
	public void setPackId(String packId) {
		this.packId = packId;
	}
	public String getMainSkuId() {
		return mainSkuId;
	}
	public void setMainSkuId(String mainSkuId) {
		this.mainSkuId = mainSkuId;
	}
	public String getDiscount() {
		return discount;
	}
	public void setDiscount(String discount) {
		this.discount = discount;
	}
	public String getMainSkuName() {
		return mainSkuName;
	}
	public void setMainSkuName(String mainSkuName) {
		this.mainSkuName = mainSkuName;
	}
	public Product getPacks() {
		return packs;
	}
	public void setPacks(Product packs) {
		this.packs = packs;
	}
	@Override
	public String toString() {
		return "Packs [packListPrice=" + packListPrice + ", packPrice="
				+ packPrice + ", mainSkuPicUrl=" + mainSkuPicUrl + ", packId="
				+ packId + ", mainSkuId=" + mainSkuId + ", discount="
				+ discount + ", mainSkuName=" + mainSkuName + ", packs="
				+ packs + "]";
	}
	
	

}
