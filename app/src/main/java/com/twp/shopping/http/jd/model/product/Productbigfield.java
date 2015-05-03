package com.twp.shopping.http.jd.model.product;

import java.io.Serializable;

public class Productbigfield implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 7125509661086944107L;

	/* 售后 */
	private String shou_hou;
	/* 商品介绍 */
	private String wdis;
	/* 规格参数 */
	private String prop_code;
	/* 包装清单 */
	private String ware_qd;

	public static final String attrName = "shou_hou,wdis,prop_code,ware_qd";

	public String getShou_hou() {
		return shou_hou;
	}

	public void setShou_hou(String shou_hou) {
		this.shou_hou = shou_hou;
	}

	public String getWdis() {
		return wdis;
	}

	public void setWdis(String wdis) {
		this.wdis = wdis;
	}

	public String getProp_code() {
		return prop_code;
	}

	public void setProp_code(String prop_code) {
		this.prop_code = prop_code;
	}

	public String getWare_qd() {
		return ware_qd;
	}

	public void setWare_qd(String ware_qd) {
		this.ware_qd = ware_qd;
	}

	@Override
	public String toString() {
		return "Productbigfield [shou_hou=" + shou_hou + ", wdis=" + wdis
				+ ", prop_code=" + prop_code + ", ware_qd=" + ware_qd + "]";
	}

}
