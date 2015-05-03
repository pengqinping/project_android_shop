package com.twp.shopping.http.jd.model.recommend;

import java.io.Serializable;

public class CmsActivityWare implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 8417541889725290966L;

	private String adWord;
	// 广告词
	private boolean isBook;
	// 是否为图书
	private boolean canFreeRead;
	// 是否免费阅读
	private String endRemainTime;
	// 秒杀离结束时间
	private String imageUrl;
	// 商品图片url
	private float jdPrice;
	// 京东价
	private float martPrice;
	// 市场价
	private String startRemainTime;
	// 秒杀离开始时间
	private String skuId;
	// 商品编号
	private String wareName;

	// 商品名称
	public String getAdWord() {
		return adWord;
	}

	public void setAdWord(String adWord) {
		this.adWord = adWord;
	}

	public boolean isBook() {
		return isBook;
	}

	public void setBook(boolean isBook) {
		this.isBook = isBook;
	}

	public boolean isCanFreeRead() {
		return canFreeRead;
	}

	public void setCanFreeRead(boolean canFreeRead) {
		this.canFreeRead = canFreeRead;
	}

	public String getEndRemainTime() {
		return endRemainTime;
	}

	public void setEndRemainTime(String endRemainTime) {
		this.endRemainTime = endRemainTime;
	}

	public String getImageUrl() {
		return imageUrl;
	}

	public void setImageUrl(String imageUrl) {
		this.imageUrl = imageUrl;
	}


	public float getJdPrice() {
		return jdPrice;
	}

	public void setJdPrice(float jdPrice) {
		this.jdPrice = jdPrice;
	}

	public float getMartPrice() {
		return martPrice;
	}

	public void setMartPrice(float martPrice) {
		this.martPrice = martPrice;
	}

	public void setMartPrice(int martPrice) {
		this.martPrice = martPrice;
	}

	public String getStartRemainTime() {
		return startRemainTime;
	}

	public void setStartRemainTime(String startRemainTime) {
		this.startRemainTime = startRemainTime;
	}

	public String getSkuId() {
		return skuId;
	}

	public void setSkuId(String skuId) {
		this.skuId = skuId;
	}

	public String getWareName() {
		return wareName;
	}

	public void setWareName(String wareName) {
		this.wareName = wareName;
	}

	@Override
	public String toString() {
		return "CmsActivityWare [adWord=" + adWord + ", isBook=" + isBook
				+ ", canFreeRead=" + canFreeRead + ", endRemainTime="
				+ endRemainTime + ", imageUrl=" + imageUrl + ", jdPrice="
				+ jdPrice + ", martPrice=" + martPrice + ", startRemainTime="
				+ startRemainTime + ", skuId=" + skuId + ", wareName="
				+ wareName + "]";
	}

}
