package com.twp.shopping.http.jd.model.ware;

import java.io.Serializable;

public class CmsPromotions implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -2903041300772699467L;
	private int catelogyId;	
//	分类编号 
	private String imageUrl;
//	促销专场图片地址 
	private String promitionInfo;
//	促销分类名 
	private String promotionId;
//	促销分类编号 
	private String promotionName;
//	促销专场名称 
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
	public String getPromitionInfo() {
		return promitionInfo;
	}
	public void setPromitionInfo(String promitionInfo) {
		this.promitionInfo = promitionInfo;
	}
	public String getPromotionId() {
		return promotionId;
	}
	public void setPromotionId(String promotionId) {
		this.promotionId = promotionId;
	}
	public String getPromotionName() {
		return promotionName;
	}
	public void setPromotionName(String promotionName) {
		this.promotionName = promotionName;
	}
	@Override
	public String toString() {
		return "CmsPromotions [catelogyId=" + catelogyId + ", imageUrl="
				+ imageUrl + ", promitionInfo=" + promitionInfo
				+ ", promotionId=" + promotionId + ", promotionName="
				+ promotionName + "]";
	}
	
	
}
