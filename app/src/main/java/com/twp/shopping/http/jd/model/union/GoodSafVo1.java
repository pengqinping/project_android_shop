package com.twp.shopping.http.jd.model.union;

import java.io.Serializable;

public class GoodSafVo1 implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 5068223105850450445L;
	private int ood_pk;
	/* 主键（京东联盟中的商品编号） */
	private int good_skuId;
	/* sku id */
	private String good_shopName;
	/* 商家名称,如果为null和设置field时没有设置该属性则在结果中不显示 */
	private String good_name;
	/* 商品标题名称,如果为null和设置field时没有设置该属性则在结果中不显示 */
	private int good_price;
	/* 商品价格，返回结果负数不做处理 */
	private int good_praiseDegree;
	/* 好评度 */
	private String good_targetUrl;
	/* 页URL,如果为null和设置field时没有设置该属性则在结果中不显示 */
	private String good_shopUrl;
	/* 店铺URL,如果为null和设置field时没有设置该属性则在结果中不显示 */
	private String good_materialUrl;
	/* 商品主图素材URL，如果为null和设置field时没有设置该属性则在结果中不显示，字段为空不做特殊处理 */

	private int good_commRatio;
	/* 佣金比例 */
	private int good_commision;/*
								 * 佣金
								 */
	private int good_promQuantity;/*
								 * 30天内的交易量
								 */
	private String good_startDate;
	/* 推广开始时间 */
	private String good_endDate;
	public int getOod_pk() {
		return ood_pk;
	}
	public void setOod_pk(int ood_pk) {
		this.ood_pk = ood_pk;
	}
	public int getGood_skuId() {
		return good_skuId;
	}
	public void setGood_skuId(int good_skuId) {
		this.good_skuId = good_skuId;
	}
	public String getGood_shopName() {
		return good_shopName;
	}
	public void setGood_shopName(String good_shopName) {
		this.good_shopName = good_shopName;
	}
	public String getGood_name() {
		return good_name;
	}
	public void setGood_name(String good_name) {
		this.good_name = good_name;
	}
	public int getGood_price() {
		return good_price;
	}
	public void setGood_price(int good_price) {
		this.good_price = good_price;
	}
	public int getGood_praiseDegree() {
		return good_praiseDegree;
	}
	public void setGood_praiseDegree(int good_praiseDegree) {
		this.good_praiseDegree = good_praiseDegree;
	}
	public String getGood_targetUrl() {
		return good_targetUrl;
	}
	public void setGood_targetUrl(String good_targetUrl) {
		this.good_targetUrl = good_targetUrl;
	}
	public String getGood_shopUrl() {
		return good_shopUrl;
	}
	public void setGood_shopUrl(String good_shopUrl) {
		this.good_shopUrl = good_shopUrl;
	}
	public String getGood_materialUrl() {
		return good_materialUrl;
	}
	public void setGood_materialUrl(String good_materialUrl) {
		this.good_materialUrl = good_materialUrl;
	}
	public int getGood_commRatio() {
		return good_commRatio;
	}
	public void setGood_commRatio(int good_commRatio) {
		this.good_commRatio = good_commRatio;
	}
	public int getGood_commision() {
		return good_commision;
	}
	public void setGood_commision(int good_commision) {
		this.good_commision = good_commision;
	}
	public int getGood_promQuantity() {
		return good_promQuantity;
	}
	public void setGood_promQuantity(int good_promQuantity) {
		this.good_promQuantity = good_promQuantity;
	}
	public String getGood_startDate() {
		return good_startDate;
	}
	public void setGood_startDate(String good_startDate) {
		this.good_startDate = good_startDate;
	}
	public String getGood_endDate() {
		return good_endDate;
	}
	public void setGood_endDate(String good_endDate) {
		this.good_endDate = good_endDate;
	}
	@Override
	public String toString() {
		return "GoodSafVo1 [ood_pk=" + ood_pk + ", good_skuId=" + good_skuId
				+ ", good_shopName=" + good_shopName + ", good_name="
				+ good_name + ", good_price=" + good_price
				+ ", good_praiseDegree=" + good_praiseDegree
				+ ", good_targetUrl=" + good_targetUrl + ", good_shopUrl="
				+ good_shopUrl + ", good_materialUrl=" + good_materialUrl
				+ ", good_commRatio=" + good_commRatio + ", good_commision="
				+ good_commision + ", good_promQuantity=" + good_promQuantity
				+ ", good_startDate=" + good_startDate + ", good_endDate="
				+ good_endDate + "]";
	}

	/* 推广开始时间 */
	
	
	
	
}
