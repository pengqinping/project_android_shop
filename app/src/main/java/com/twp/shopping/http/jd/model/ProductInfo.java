package com.twp.shopping.http.jd.model;

import java.io.Serializable;

public class ProductInfo implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 6350033019319393993L;

	/* N5图片路径 */
	private String imgUrlN5;
	private String wname;
	private String adword;
	private float marketPrice;
	private float averageScore;
	private boolean promotion;
	private float jdPrice;
	/* 好评度 */
	private String good;
	/* 是否可以咨询标志，true：是，false：否 */
	private boolean canConsultFlag;
	private String size;
	private boolean isbook;
	private String color;
	private int totalCount;
	private String description;
	private int skuId;
	private boolean secKill;
	private boolean directShow;
	private boolean showMartPrice;
	private boolean canFreeRead;
	private String imgUrlN1;
	private String imgurl;

	public String getImgUrlN5() {
		return imgUrlN5;
	}

	public void setImgUrlN5(String imgUrlN5) {
		this.imgUrlN5 = imgUrlN5;
	}

	public String getWname() {
		return wname;
	}

	public void setWname(String wname) {
		this.wname = wname;
	}

	public String getAdword() {
		return adword;
	}

	public void setAdword(String adword) {
		this.adword = adword;
	}

	public float getMarketPrice() {
		return marketPrice;
	}

	public void setMarketPrice(float marketPrice) {
		this.marketPrice = marketPrice;
	}

	public float getAverageScore() {
		return averageScore;
	}

	public void setAverageScore(float averageScore) {
		this.averageScore = averageScore;
	}

	public boolean isPromotion() {
		return promotion;
	}

	public void setPromotion(boolean promotion) {
		this.promotion = promotion;
	}

	public float getJdPrice() {
		return jdPrice;
	}

	public void setJdPrice(float jdPrice) {
		this.jdPrice = jdPrice;
	}

	public String getGood() {
		return good;
	}

	public void setGood(String good) {
		this.good = good;
	}

	public boolean isCanConsultFlag() {
		return canConsultFlag;
	}

	public void setCanConsultFlag(boolean canConsultFlag) {
		this.canConsultFlag = canConsultFlag;
	}

	public String getSize() {
		return size;
	}

	public void setSize(String size) {
		this.size = size;
	}

	public boolean isIsbook() {
		return isbook;
	}

	public void setIsbook(boolean isbook) {
		this.isbook = isbook;
	}

	public String getColor() {
		return color;
	}

	public void setColor(String color) {
		this.color = color;
	}

	public int getTotalCount() {
		return totalCount;
	}

	public void setTotalCount(int totalCount) {
		this.totalCount = totalCount;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public int getSkuId() {
		return skuId;
	}

	public void setSkuId(int skuId) {
		this.skuId = skuId;
	}

	public boolean isSecKill() {
		return secKill;
	}

	public void setSecKill(boolean secKill) {
		this.secKill = secKill;
	}

	public boolean isDirectShow() {
		return directShow;
	}

	public void setDirectShow(boolean directShow) {
		this.directShow = directShow;
	}

	public boolean isShowMartPrice() {
		return showMartPrice;
	}

	public void setShowMartPrice(boolean showMartPrice) {
		this.showMartPrice = showMartPrice;
	}

	public boolean isCanFreeRead() {
		return canFreeRead;
	}

	public void setCanFreeRead(boolean canFreeRead) {
		this.canFreeRead = canFreeRead;
	}

	public String getImgUrlN1() {
		return imgUrlN1;
	}

	public void setImgUrlN1(String imgUrlN1) {
		this.imgUrlN1 = imgUrlN1;
	}

	public String getImgurl() {
		return imgurl;
	}

	public void setImgurl(String imgurl) {
		this.imgurl = imgurl;
	}

	@Override
	public String toString() {
		return "ProductInfo [imgUrlN5=" + imgUrlN5 + ", wname=" + wname
				+ ", adword=" + adword + ", marketPrice=" + marketPrice
				+ ", averageScore=" + averageScore + ", promotion=" + promotion
				+ ", jdPrice=" + jdPrice + ", good=" + good
				+ ", canConsultFlag=" + canConsultFlag + ", size=" + size
				+ ", isbook=" + isbook + ", color=" + color + ", totalCount="
				+ totalCount + ", description=" + description + ", skuId="
				+ skuId + ", secKill=" + secKill + ", directShow=" + directShow
				+ ", showMartPrice=" + showMartPrice + ", canFreeRead="
				+ canFreeRead + ", imgUrlN1=" + imgUrlN1 + ", imgurl=" + imgurl
				+ "]";
	}

}
