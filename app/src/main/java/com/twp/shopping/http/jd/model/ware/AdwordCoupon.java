package com.twp.shopping.http.jd.model.ware;

import java.io.Serializable;

public class AdwordCoupon implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -7395211291643088802L;

	private int type;

	// 券类型
	private String key;
	// 限品类不为空，非限品类为空
	private int couponQouta;

	// 券值大小
	public int getType() {
		return type;
	}

	public void setType(int type) {
		this.type = type;
	}

	public String getKey() {
		return key;
	}

	public void setKey(String key) {
		this.key = key;
	}

	public int getCouponQouta() {
		return couponQouta;
	}

	public void setCouponQouta(int couponQouta) {
		this.couponQouta = couponQouta;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	@Override
	public String toString() {
		return "AdwordCoupon [type=" + type + ", key=" + key + ", couponQouta="
				+ couponQouta + "]";
	}

}
