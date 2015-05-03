package com.twp.shopping.http.jd.model.product;

import java.io.Serializable;

public class SkuSize implements Serializable {

	/**
	 * 
	 */

	private static final long serialVersionUID = 2332974409241708679L;

	private String description;
	/** 是否促销 */
	private boolean promotion;
	private int skuId;
	/** 是否是秒杀商品 */
	private boolean secKill;

	/** 是否直接展示 */
	private boolean directShow;
	private boolean showMartPrice;

	/** 是否能免费阅读 */
	private boolean canFreeRead;
	private String size;

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
		return "SkuSize [description=" + description + ", promotion="
				+ promotion + ", skuId=" + skuId + ", secKill=" + secKill
				+ ", directShow=" + directShow + ", showMartPrice="
				+ showMartPrice + ", canFreeRead=" + canFreeRead + ", size="
				+ size + "]";
	}

}
