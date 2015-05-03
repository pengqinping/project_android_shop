package com.twp.shopping.http.jd.model.union;

import java.io.Serializable;

public class MasterBillVo implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 6180022277647121415L;

	private int bill_id;
	// 否
	//
	// 结算单号
	private int union_id;
	// 否
	//
	// 联盟id
	private String pay_month;
	// 否
	// 201307
	// 佣金所属月份(如：201307)
	private String pay_time;
	// 否
	//
	// 支付时间
	private int total;
	// 否
	//
	// 税前总佣金
	private int tax;
	// 否
	//
	// 扣税
	private int pay_amount;
	// 否
	//
	// 实际支付佣金
	private int after_tax;
	// 否
	//
	// 税后总佣金
	private int adjust;
	// 否
	//
	// 手动调整佣金
	private String bank_name;
	// 否
	//
	// 收款银行名称
	private String bank_card;
	// 否
	//
	// 收款银行卡号
	private String pay_id;
	// 否
	//
	// 支付流水号
	private int technical_fee;
	// 否
	//
	// 技术服务费
	private int status;
	/*
	 * 否 0/1/2 结算单状态（0/1/2）
	 */
	public int getBill_id() {
		return bill_id;
	}
	public void setBill_id(int bill_id) {
		this.bill_id = bill_id;
	}
	public int getUnion_id() {
		return union_id;
	}
	public void setUnion_id(int union_id) {
		this.union_id = union_id;
	}
	public String getPay_month() {
		return pay_month;
	}
	public void setPay_month(String pay_month) {
		this.pay_month = pay_month;
	}
	public String getPay_time() {
		return pay_time;
	}
	public void setPay_time(String pay_time) {
		this.pay_time = pay_time;
	}
	public int getTotal() {
		return total;
	}
	public void setTotal(int total) {
		this.total = total;
	}
	public int getTax() {
		return tax;
	}
	public void setTax(int tax) {
		this.tax = tax;
	}
	public int getPay_amount() {
		return pay_amount;
	}
	public void setPay_amount(int pay_amount) {
		this.pay_amount = pay_amount;
	}
	public int getAfter_tax() {
		return after_tax;
	}
	public void setAfter_tax(int after_tax) {
		this.after_tax = after_tax;
	}
	public int getAdjust() {
		return adjust;
	}
	public void setAdjust(int adjust) {
		this.adjust = adjust;
	}
	public String getBank_name() {
		return bank_name;
	}
	public void setBank_name(String bank_name) {
		this.bank_name = bank_name;
	}
	public String getBank_card() {
		return bank_card;
	}
	public void setBank_card(String bank_card) {
		this.bank_card = bank_card;
	}
	public String getPay_id() {
		return pay_id;
	}
	public void setPay_id(String pay_id) {
		this.pay_id = pay_id;
	}
	public int getTechnical_fee() {
		return technical_fee;
	}
	public void setTechnical_fee(int technical_fee) {
		this.technical_fee = technical_fee;
	}
	public int getStatus() {
		return status;
	}
	public void setStatus(int status) {
		this.status = status;
	}
	@Override
	public String toString() {
		return "MasterBillVo [bill_id=" + bill_id + ", union_id=" + union_id
				+ ", pay_month=" + pay_month + ", pay_time=" + pay_time
				+ ", total=" + total + ", tax=" + tax + ", pay_amount="
				+ pay_amount + ", after_tax=" + after_tax + ", adjust="
				+ adjust + ", bank_name=" + bank_name + ", bank_card="
				+ bank_card + ", pay_id=" + pay_id + ", technical_fee="
				+ technical_fee + ", status=" + status + "]";
	}

	
	
}
