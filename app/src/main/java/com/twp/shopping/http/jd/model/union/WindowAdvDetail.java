package com.twp.shopping.http.jd.model.union;

import java.io.Serializable;

public class WindowAdvDetail implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -8074014556637368302L;

	private String orderTime;
	/*
	 * 2013-07-03 00:00:00 下单时间
	 */
	private String spaceName;
	// 广告位名称
	private String size;
	// 200*300
	// 广告位尺寸
	private String siteName;

	// 网站名称
	private int clickNum;
	// 点击量
	private int introductionOrders;
	// 引入订单量
	private int completeOrders;
	// 完成订单量
	private int itemNum;
	// 成交商品数量
	private int amount;
	// 成交金额
	private int commission;
	// 佣金金额
	public String getOrderTime() {
		return orderTime;
	}
	public void setOrderTime(String orderTime) {
		this.orderTime = orderTime;
	}
	public String getSpaceName() {
		return spaceName;
	}
	public void setSpaceName(String spaceName) {
		this.spaceName = spaceName;
	}
	public String getSize() {
		return size;
	}
	public void setSize(String size) {
		this.size = size;
	}
	public String getSiteName() {
		return siteName;
	}
	public void setSiteName(String siteName) {
		this.siteName = siteName;
	}
	public int getClickNum() {
		return clickNum;
	}
	public void setClickNum(int clickNum) {
		this.clickNum = clickNum;
	}
	public int getIntroductionOrders() {
		return introductionOrders;
	}
	public void setIntroductionOrders(int introductionOrders) {
		this.introductionOrders = introductionOrders;
	}
	public int getCompleteOrders() {
		return completeOrders;
	}
	public void setCompleteOrders(int completeOrders) {
		this.completeOrders = completeOrders;
	}
	public int getItemNum() {
		return itemNum;
	}
	public void setItemNum(int itemNum) {
		this.itemNum = itemNum;
	}
	public int getAmount() {
		return amount;
	}
	public void setAmount(int amount) {
		this.amount = amount;
	}
	public int getCommission() {
		return commission;
	}
	public void setCommission(int commission) {
		this.commission = commission;
	}
	@Override
	public String toString() {
		return "WindowAdvDetail [orderTime=" + orderTime + ", spaceName="
				+ spaceName + ", size=" + size + ", siteName=" + siteName
				+ ", clickNum=" + clickNum + ", introductionOrders="
				+ introductionOrders + ", completeOrders=" + completeOrders
				+ ", itemNum=" + itemNum + ", amount=" + amount
				+ ", commission=" + commission + "]";
	}
	
	
}
