package com.twp.shopping.http.jd.model.union;

import java.io.Serializable;

public class MasterAccount implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -2059104241072820875L;
	private String union_id;
	/* 联盟id */
	private int type;
	// 1,2
	// 联盟类型:1-个人，2-公司
	private String pin;
	// 京东账号名称
	private String nick;
	// 昵称
	private String mobile;
	// 联系电话
	private String email;
	// 电子邮件地址
	private String name;

	// 姓名
	private String campany_name;

	// 公司名称（公司类型）
	private String campany_address;
	// 公司联系地址
	private String bank_name;
	// 收款银行名称
	private String bank_address;
	// 收款银行开户地址
	private String card_no;

	// 银行账号（卡号）
	private String owner_name;

	// 收款人姓名
	private String owner_id;

	public String getUnion_id() {
		return union_id;
	}

	public void setUnion_id(String union_id) {
		this.union_id = union_id;
	}

	public int getType() {
		return type;
	}

	public void setType(int type) {
		this.type = type;
	}

	public String getPin() {
		return pin;
	}

	public void setPin(String pin) {
		this.pin = pin;
	}

	public String getNick() {
		return nick;
	}

	public void setNick(String nick) {
		this.nick = nick;
	}

	public String getMobile() {
		return mobile;
	}

	public void setMobile(String mobile) {
		this.mobile = mobile;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getCampany_name() {
		return campany_name;
	}

	public void setCampany_name(String campany_name) {
		this.campany_name = campany_name;
	}

	public String getCampany_address() {
		return campany_address;
	}

	public void setCampany_address(String campany_address) {
		this.campany_address = campany_address;
	}

	public String getBank_name() {
		return bank_name;
	}

	public void setBank_name(String bank_name) {
		this.bank_name = bank_name;
	}

	public String getBank_address() {
		return bank_address;
	}

	public void setBank_address(String bank_address) {
		this.bank_address = bank_address;
	}

	public String getCard_no() {
		return card_no;
	}

	public void setCard_no(String card_no) {
		this.card_no = card_no;
	}

	public String getOwner_name() {
		return owner_name;
	}

	public void setOwner_name(String owner_name) {
		this.owner_name = owner_name;
	}

	public String getOwner_id() {
		return owner_id;
	}

	public void setOwner_id(String owner_id) {
		this.owner_id = owner_id;
	}

	@Override
	public String toString() {
		return "MasterAccount_ [union_id=" + union_id + ", type=" + type
				+ ", pin=" + pin + ", nick=" + nick + ", mobile=" + mobile
				+ ", email=" + email + ", name=" + name + ", campany_name="
				+ campany_name + ", campany_address=" + campany_address
				+ ", bank_name=" + bank_name + ", bank_address=" + bank_address
				+ ", card_no=" + card_no + ", owner_name=" + owner_name
				+ ", owner_id=" + owner_id + "]";
	}

	// 收款人身份证号

}
