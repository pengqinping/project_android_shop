package com.twp.shopping.http.jd.model.ware;

import java.io.Serializable;
import java.util.List;

public class ResultPromotionInfo implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -2834287259173201792L;
	private String skuId;
	// 商品编号
	private List<PromotionInfo> promotionInfoList;
	// 促销信息集合
	public String getSkuId() {
		return skuId;
	}
	public void setSkuId(String skuId) {
		this.skuId = skuId;
	}
	public List<PromotionInfo> getPromotionInfoList() {
		return promotionInfoList;
	}
	public void setPromotionInfoList(List<PromotionInfo> promotionInfoList) {
		this.promotionInfoList = promotionInfoList;
	}
	@Override
	public String toString() {
		return "ResultPromotionInfo [skuId=" + skuId + ", promotionInfoList="
				+ promotionInfoList + "]";
	}
	
	
}
