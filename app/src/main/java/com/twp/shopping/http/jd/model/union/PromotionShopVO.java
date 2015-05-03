package com.twp.shopping.http.jd.model.union;

import java.io.Serializable;

public class PromotionShopVO implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -2922970029640794988L;

	private int pk;
	// 主键
	private int pop_id;
	// 商家id
	private int shop_id;
	// 店铺id
	private int plan_id;
	// 店铺推广所属计划id
	private String shop_name;
	// 店铺名称 ;
	private String shop_mainurl;
	// 店铺主图url
	private String main_categories;
	// 店铺主营类目
	private String shop_url;
	// 店铺链接
	private int average_commision;
	// 平均类目佣金
	private int goods_volume;
	// 店铺商品数量
	private int accumulative_total;
	// 店铺累计推广商品数量
	private int praise_degree;
	// 店铺好评度
	private String update_time;
	// 2013-07-03
	// 00:00:00
	// 更新时间
	private String insert_time;
	// 2013-07-03
	// 00:00:00
	// 插入时间
	public int getPk() {
		return pk;
	}
	public void setPk(int pk) {
		this.pk = pk;
	}
	public int getPop_id() {
		return pop_id;
	}
	public void setPop_id(int pop_id) {
		this.pop_id = pop_id;
	}
	public int getShop_id() {
		return shop_id;
	}
	public void setShop_id(int shop_id) {
		this.shop_id = shop_id;
	}
	public int getPlan_id() {
		return plan_id;
	}
	public void setPlan_id(int plan_id) {
		this.plan_id = plan_id;
	}
	public String getShop_name() {
		return shop_name;
	}
	public void setShop_name(String shop_name) {
		this.shop_name = shop_name;
	}
	public String getShop_mainurl() {
		return shop_mainurl;
	}
	public void setShop_mainurl(String shop_mainurl) {
		this.shop_mainurl = shop_mainurl;
	}
	public String getMain_categories() {
		return main_categories;
	}
	public void setMain_categories(String main_categories) {
		this.main_categories = main_categories;
	}
	public String getShop_url() {
		return shop_url;
	}
	public void setShop_url(String shop_url) {
		this.shop_url = shop_url;
	}
	public int getAverage_commision() {
		return average_commision;
	}
	public void setAverage_commision(int average_commision) {
		this.average_commision = average_commision;
	}
	public int getGoods_volume() {
		return goods_volume;
	}
	public void setGoods_volume(int goods_volume) {
		this.goods_volume = goods_volume;
	}
	public int getAccumulative_total() {
		return accumulative_total;
	}
	public void setAccumulative_total(int accumulative_total) {
		this.accumulative_total = accumulative_total;
	}
	public int getPraise_degree() {
		return praise_degree;
	}
	public void setPraise_degree(int praise_degree) {
		this.praise_degree = praise_degree;
	}
	public String getUpdate_time() {
		return update_time;
	}
	public void setUpdate_time(String update_time) {
		this.update_time = update_time;
	}
	public String getInsert_time() {
		return insert_time;
	}
	public void setInsert_time(String insert_time) {
		this.insert_time = insert_time;
	}
	@Override
	public String toString() {
		return "PromotionShopVO [pk=" + pk + ", pop_id=" + pop_id
				+ ", shop_id=" + shop_id + ", plan_id=" + plan_id
				+ ", shop_name=" + shop_name + ", shop_mainurl=" + shop_mainurl
				+ ", main_categories=" + main_categories + ", shop_url="
				+ shop_url + ", average_commision=" + average_commision
				+ ", goods_volume=" + goods_volume + ", accumulative_total="
				+ accumulative_total + ", praise_degree=" + praise_degree
				+ ", update_time=" + update_time + ", insert_time="
				+ insert_time + "]";
	}
	
	

}
