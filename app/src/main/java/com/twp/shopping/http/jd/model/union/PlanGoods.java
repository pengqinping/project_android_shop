package com.twp.shopping.http.jd.model.union;

import java.io.Serializable;

public class PlanGoods implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 4637823016713150579L;

	private int skuId;

	// SKUID（商品编号）
	private String goodsName;

	// 商品名称
	private int saleVolume;

	// 销量
	private int praiseDegree;

	// 好评度
	private int commisionRatio;

	public int getSkuId() {
		return skuId;
	}

	public void setSkuId(int skuId) {
		this.skuId = skuId;
	}

	public String getGoodsName() {
		return goodsName;
	}

	public void setGoodsName(String goodsName) {
		this.goodsName = goodsName;
	}

	public int getSaleVolume() {
		return saleVolume;
	}

	public void setSaleVolume(int saleVolume) {
		this.saleVolume = saleVolume;
	}

	public int getPraiseDegree() {
		return praiseDegree;
	}

	public void setPraiseDegree(int praiseDegree) {
		this.praiseDegree = praiseDegree;
	}

	public int getCommisionRatio() {
		return commisionRatio;
	}

	public void setCommisionRatio(int commisionRatio) {
		this.commisionRatio = commisionRatio;
	}

	@Override
	public String toString() {
		return "PlanGoods [skuId=" + skuId + ", goodsName=" + goodsName
				+ ", saleVolume=" + saleVolume + ", praiseDegree="
				+ praiseDegree + ", commisionRatio=" + commisionRatio + "]";
	}

	// 佣金

}
