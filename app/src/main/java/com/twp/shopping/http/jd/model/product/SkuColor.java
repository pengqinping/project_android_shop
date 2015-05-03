package com.twp.shopping.http.jd.model.product;

import java.io.Serializable;

public class SkuColor implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 981428161832377657L;

	/** 广告词  */
	private String waretitle;
	
	/** 颜色URL  */
	private String colorImg;
	/** 商品名称  */
	private String wname;
	private String color;
	private String description;
	private boolean promotion;
	private int skuId;
	private boolean secKill;
	private boolean directShow;
	private boolean showMartPrice;
	private boolean canFreeRead;
	private String size;
	public String getWaretitle() {
		return waretitle;
	}
	public void setWaretitle(String waretitle) {
		this.waretitle = waretitle;
	}
	public String getColorImg() {
		return colorImg;
	}
	public void setColorImg(String colorImg) {
		this.colorImg = colorImg;
	}
	public String getWname() {
		return wname;
	}
	public void setWname(String wname) {
		this.wname = wname;
	}
	public String getColor() {
		return color;
	}
	public void setColor(String color) {
		this.color = color;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	
	public String getSize() {
		return size;
	}
	public void setSize(String size) {
		this.size = size;
	}
	public boolean isPromotion() {
		return promotion;
	}
	public void setPromotion(boolean promotion) {
		this.promotion = promotion;
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
	@Override
	public String toString() {
		return "SkuColor [waretitle=" + waretitle + ", colorImg=" + colorImg
				+ ", wname=" + wname + ", color=" + color + ", description="
				+ description + ", promotion=" + promotion + ", skuId=" + skuId
				+ ", secKill=" + secKill + ", directShow=" + directShow
				+ ", showMartPrice=" + showMartPrice + ", canFreeRead="
				+ canFreeRead + ", size=" + size + "]";
	}
	
	
}
