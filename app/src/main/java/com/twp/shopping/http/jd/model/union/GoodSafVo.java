package com.twp.shopping.http.jd.model.union;

import java.io.Serializable;

public class GoodSafVo implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -2223079186653199125L;

	private String shop_name;
	/* 店铺名称,如果为null和设置field时没有设置该属性则在结果中不显示 */
	private String shop_promUrl;
	/* 店铺推广URL,如果为null和设置field时没有设置该属性则在结果中不显示 */
	private int shop_commRatio;
	/* 店铺佣金比例 */
	private int shop_praiseDegree;
	/* 好评度 */
	private int shop_promQuantity;
	/* 累计推广量 */
	private int shop_goodsVolume;
	/* 店铺内商品总数 */
	private String shop_materialUrl;
	/* 店铺logurl,如果为null和设置field时没有设置该属性则在结果中不显示 */
	private int shop_pk;
	/* 主键 */
	private String shop_mainCategories;
	/* 主营类目,如果为null和设置field时没有设置该属性则在结果中不显示 */
	public String getShop_name() {
		return shop_name;
	}
	public void setShop_name(String shop_name) {
		this.shop_name = shop_name;
	}
	public String getShop_promUrl() {
		return shop_promUrl;
	}
	public void setShop_promUrl(String shop_promUrl) {
		this.shop_promUrl = shop_promUrl;
	}
	public int getShop_commRatio() {
		return shop_commRatio;
	}
	public void setShop_commRatio(int shop_commRatio) {
		this.shop_commRatio = shop_commRatio;
	}
	public int getShop_praiseDegree() {
		return shop_praiseDegree;
	}
	public void setShop_praiseDegree(int shop_praiseDegree) {
		this.shop_praiseDegree = shop_praiseDegree;
	}
	public int getShop_promQuantity() {
		return shop_promQuantity;
	}
	public void setShop_promQuantity(int shop_promQuantity) {
		this.shop_promQuantity = shop_promQuantity;
	}
	public int getShop_goodsVolume() {
		return shop_goodsVolume;
	}
	public void setShop_goodsVolume(int shop_goodsVolume) {
		this.shop_goodsVolume = shop_goodsVolume;
	}
	public String getShop_materialUrl() {
		return shop_materialUrl;
	}
	public void setShop_materialUrl(String shop_materialUrl) {
		this.shop_materialUrl = shop_materialUrl;
	}
	public int getShop_pk() {
		return shop_pk;
	}
	public void setShop_pk(int shop_pk) {
		this.shop_pk = shop_pk;
	}
	public String getShop_mainCategories() {
		return shop_mainCategories;
	}
	public void setShop_mainCategories(String shop_mainCategories) {
		this.shop_mainCategories = shop_mainCategories;
	}
	@Override
	public String toString() {
		return "GoodSafVo [shop_name=" + shop_name + ", shop_promUrl="
				+ shop_promUrl + ", shop_commRatio=" + shop_commRatio
				+ ", shop_praiseDegree=" + shop_praiseDegree
				+ ", shop_promQuantity=" + shop_promQuantity
				+ ", shop_goodsVolume=" + shop_goodsVolume
				+ ", shop_materialUrl=" + shop_materialUrl + ", shop_pk="
				+ shop_pk + ", shop_mainCategories=" + shop_mainCategories
				+ "]";
	}

	
	
	
}
