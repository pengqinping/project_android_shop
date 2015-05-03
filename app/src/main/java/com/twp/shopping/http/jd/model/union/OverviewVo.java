package com.twp.shopping.http.jd.model.union;

import java.io.Serializable;

public class OverviewVo implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -768566903454061258L;

	private String order_time;
/*	2013-07-03
	00:00:00 
	时间,格式:yyyy-MM-dd HH:mm:ss */
	private int click_num ;
//	点击量 
	private int introduction_orders ;
//	引入订单量 
	private int complete_orders ;
//	完成订单量 
	private int item_num ;
//	成交商品件数 
	private int amount ;
//	成交金额 
	private int commission ;
//	佣金 
	public String getOrder_time() {
		return order_time;
	}
	public void setOrder_time(String order_time) {
		this.order_time = order_time;
	}
	public int getClick_num() {
		return click_num;
	}
	public void setClick_num(int click_num) {
		this.click_num = click_num;
	}
	public int getIntroduction_orders() {
		return introduction_orders;
	}
	public void setIntroduction_orders(int introduction_orders) {
		this.introduction_orders = introduction_orders;
	}
	public int getComplete_orders() {
		return complete_orders;
	}
	public void setComplete_orders(int complete_orders) {
		this.complete_orders = complete_orders;
	}
	public int getItem_num() {
		return item_num;
	}
	public void setItem_num(int item_num) {
		this.item_num = item_num;
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
		return "OverviewVo [order_time=" + order_time + ", click_num="
				+ click_num + ", introduction_orders=" + introduction_orders
				+ ", complete_orders=" + complete_orders + ", item_num="
				+ item_num + ", amount=" + amount + ", commission="
				+ commission + "]";
	}
	
	
	
}
