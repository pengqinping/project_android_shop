package com.twp.shopping.http.jd.model.union;

import java.io.Serializable;

public class EffectReportSafVo implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 8610458270226313575L;

	private int report_unionId;
	/* 联盟ID */
	private int report_orderNo;
	/* 订单号 */
	private int report_commRatio;
	/* 佣金比例 */
	private int report_commision;
	/* 佣金 */
	private String report_sourceType;
	/*
	 * 推广来源（stdl：静态链接；adsp：动态链接） 静态链接：专柜推广链接 动态链接：店铺、商品、活动推广链接
	 */
	private int report_orderStatus;
	/* 订单状态 （1:待完成 2:完成 3:无效） */
	private int report_itemPrice;
	/* 商品价格 */
	private int report_skuId;
	/* skuid,如果为null和设置field时没有设置该属性则在结果中不显示 */
	private String report_itemName;
	/* 商品名称,如果为null和设置field时没有设置该属性则在结果中不显示 */
	private int report_itemNum;
	/* 商品数量,如果为null和设置field时没有设置该属性则在结果中不显示 */
	private String report_shopName;
	/* 店铺名称,如果为null和设置field时没有设置该属性则在结果中不显示 */
	public int getReport_unionId() {
		return report_unionId;
	}
	public void setReport_unionId(int report_unionId) {
		this.report_unionId = report_unionId;
	}
	public int getReport_orderNo() {
		return report_orderNo;
	}
	public void setReport_orderNo(int report_orderNo) {
		this.report_orderNo = report_orderNo;
	}
	public int getReport_commRatio() {
		return report_commRatio;
	}
	public void setReport_commRatio(int report_commRatio) {
		this.report_commRatio = report_commRatio;
	}
	public int getReport_commision() {
		return report_commision;
	}
	public void setReport_commision(int report_commision) {
		this.report_commision = report_commision;
	}
	public String getReport_sourceType() {
		return report_sourceType;
	}
	public void setReport_sourceType(String report_sourceType) {
		this.report_sourceType = report_sourceType;
	}
	public int getReport_orderStatus() {
		return report_orderStatus;
	}
	public void setReport_orderStatus(int report_orderStatus) {
		this.report_orderStatus = report_orderStatus;
	}
	public int getReport_itemPrice() {
		return report_itemPrice;
	}
	public void setReport_itemPrice(int report_itemPrice) {
		this.report_itemPrice = report_itemPrice;
	}
	public int getReport_skuId() {
		return report_skuId;
	}
	public void setReport_skuId(int report_skuId) {
		this.report_skuId = report_skuId;
	}
	public String getReport_itemName() {
		return report_itemName;
	}
	public void setReport_itemName(String report_itemName) {
		this.report_itemName = report_itemName;
	}
	public int getReport_itemNum() {
		return report_itemNum;
	}
	public void setReport_itemNum(int report_itemNum) {
		this.report_itemNum = report_itemNum;
	}
	public String getReport_shopName() {
		return report_shopName;
	}
	public void setReport_shopName(String report_shopName) {
		this.report_shopName = report_shopName;
	}
	@Override
	public String toString() {
		return "EffectReportSafVo [report_unionId=" + report_unionId
				+ ", report_orderNo=" + report_orderNo + ", report_commRatio="
				+ report_commRatio + ", report_commision=" + report_commision
				+ ", report_sourceType=" + report_sourceType
				+ ", report_orderStatus=" + report_orderStatus
				+ ", report_itemPrice=" + report_itemPrice + ", report_skuId="
				+ report_skuId + ", report_itemName=" + report_itemName
				+ ", report_itemNum=" + report_itemNum + ", report_shopName="
				+ report_shopName + "]";
	}

	
}
