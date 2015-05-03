package com.twp.shopping.http.jd.model;

import java.io.Serializable;

public class Promotion implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = -1875752473046628411L;
	private String promitionId;
	private String promitionInfo;
	private int catelogyId;
	private String imageUrl;
	private String promotionName;

	public String getPromitionId() {
		return promitionId;
	}

	public void setPromitionId(String promitionId) {
		this.promitionId = promitionId;
	}

	public String getPromitionInfo() {
		return promitionInfo;
	}

	public void setPromitionInfo(String promitionInfo) {
		this.promitionInfo = promitionInfo;
	}

	public int getCatelogyId() {
		return catelogyId;
	}

	public void setCatelogyId(int catelogyId) {
		this.catelogyId = catelogyId;
	}

	public String getImageUrl() {
		return imageUrl;
	}

	public void setImageUrl(String imageUrl) {
		this.imageUrl = imageUrl;
	}

	public String getPromotionName() {
		return promotionName;
	}

	public void setPromotionName(String promotionName) {
		this.promotionName = promotionName;
	}

	@Override
	public String toString() {
		return "Promotion [promitionId=" + promitionId + ", promitionInfo="
				+ promitionInfo + ", catelogyId=" + catelogyId + ", imageUrl="
				+ imageUrl + ", promotionName=" + promotionName + "]";
	}

}
