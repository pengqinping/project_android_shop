package com.twp.shopping.http.jd.model.ware;

import java.io.Serializable;

public class AdwordGiftSku implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 8294364004862130286L;

	private String skuId;
	// 赠品编号
	private String imagePath;
	// 赠品图片路径
	private String name;

	// 赠品名称
	private int number;
	// 赠品数量
	private int giftType;

	// 赠品类型，1-附件、2-普通赠品
	public String getSkuId() {
		return skuId;
	}

	public void setSkuId(String skuId) {
		this.skuId = skuId;
	}

	public String getImagePath() {
		return imagePath;
	}

	public void setImagePath(String imagePath) {
		this.imagePath = imagePath;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getNumber() {
		return number;
	}

	public void setNumber(int number) {
		this.number = number;
	}

	public int getGiftType() {
		return giftType;
	}

	public void setGiftType(int giftType) {
		this.giftType = giftType;
	}

	@Override
	public String toString() {
		return "AdwordGiftSku [skuId=" + skuId + ", imagePath=" + imagePath
				+ ", name=" + name + ", number=" + number + ", giftType="
				+ giftType + "]";
	}

}
