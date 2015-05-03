package com.twp.shopping.http.jd.model.product;

import java.io.Serializable;

public class WareInfo implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 6655897542903644328L;

	
	private String wareName;
	
	private float martPrice;
	
	private String startRemainTime;
	
	private String imageUrl;
	
	private String adWord;
	
	private int skuId;
	
	private float jdPrice;
	
	private String endRemainTime;
	
	private boolean canFreeRead;
	
	private boolean isBook;

	public String getWareName() {
		return wareName;
	}

	public void setWareName(String wareName) {
		this.wareName = wareName;
	}

	public float getMartPrice() {
		return martPrice;
	}

	public void setMartPrice(float martPrice) {
		this.martPrice = martPrice;
	}

	public String getStartRemainTime() {
		return startRemainTime;
	}

	public void setStartRemainTime(String startRemainTime) {
		this.startRemainTime = startRemainTime;
	}

	public String getImageUrl() {
		return imageUrl;
	}

	public void setImageUrl(String imageUrl) {
		this.imageUrl = imageUrl;
	}

	public String getAdWord() {
		return adWord;
	}

	public void setAdWord(String adWord) {
		this.adWord = adWord;
	}

	public int getSkuId() {
		return skuId;
	}

	public void setSkuId(int skuId) {
		this.skuId = skuId;
	}

	public float getJdPrice() {
		return jdPrice;
	}

	public void setJdPrice(float jdPrice) {
		this.jdPrice = jdPrice;
	}

	public String getEndRemainTime() {
		return endRemainTime;
	}

	public void setEndRemainTime(String endRemainTime) {
		this.endRemainTime = endRemainTime;
	}

	public boolean isCanFreeRead() {
		return canFreeRead;
	}

	public void setCanFreeRead(boolean canFreeRead) {
		this.canFreeRead = canFreeRead;
	}

	public boolean isBook() {
		return isBook;
	}

	public void setBook(boolean isBook) {
		this.isBook = isBook;
	}
	
	
	
}
