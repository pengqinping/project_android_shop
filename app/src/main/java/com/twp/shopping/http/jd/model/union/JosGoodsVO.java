package com.twp.shopping.http.jd.model.union;

import java.io.Serializable;

public class JosGoodsVO implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -6258203132569985315L;
	private int pk;

	// 主键
	private int sku_id;

	// 商品skuid
	private int plan_id;

	// 推广商品所属计划id
	private String goods_name;

	// 商品名称
	private int unitPrice;

	// 商品单价
	private int praise_degree;

	// 商品好评度
	private String mainimgurl;

	// 商品主图url
	private int commision_ratio;

	// 商品佣金比例
	private int commision;

	// 商品佣金
	private String ware_url;

	// 商品在京东主站的url
	private String recent_sales;

	// 最近30天推广量 ;
	private int total_sales;

	// 累计推广量
	private String start_time;

	// 2013-07-03
	// 00:00:00
	// 商品推广开始时间
	private String plan_endtime;

	// 2013-07-03
	// 00:00:00
	// 商品推广结束时间
	private int insert_time;

	// 2013-07-03
	// 00:00:00
	// 插入时间
	private int update_time;

	public int getPk() {
		return pk;
	}

	public void setPk(int pk) {
		this.pk = pk;
	}

	public int getSku_id() {
		return sku_id;
	}

	public void setSku_id(int sku_id) {
		this.sku_id = sku_id;
	}

	public int getPlan_id() {
		return plan_id;
	}

	public void setPlan_id(int plan_id) {
		this.plan_id = plan_id;
	}

	public String getGoods_name() {
		return goods_name;
	}

	public void setGoods_name(String goods_name) {
		this.goods_name = goods_name;
	}

	public int getUnitPrice() {
		return unitPrice;
	}

	public void setUnitPrice(int unitPrice) {
		this.unitPrice = unitPrice;
	}

	public int getPraise_degree() {
		return praise_degree;
	}

	public void setPraise_degree(int praise_degree) {
		this.praise_degree = praise_degree;
	}

	public String getMainimgurl() {
		return mainimgurl;
	}

	public void setMainimgurl(String mainimgurl) {
		this.mainimgurl = mainimgurl;
	}

	public int getCommision_ratio() {
		return commision_ratio;
	}

	public void setCommision_ratio(int commision_ratio) {
		this.commision_ratio = commision_ratio;
	}

	public int getCommision() {
		return commision;
	}

	public void setCommision(int commision) {
		this.commision = commision;
	}

	public String getWare_url() {
		return ware_url;
	}

	public void setWare_url(String ware_url) {
		this.ware_url = ware_url;
	}

	public String getRecent_sales() {
		return recent_sales;
	}

	public void setRecent_sales(String recent_sales) {
		this.recent_sales = recent_sales;
	}

	public int getTotal_sales() {
		return total_sales;
	}

	public void setTotal_sales(int total_sales) {
		this.total_sales = total_sales;
	}

	public String getStart_time() {
		return start_time;
	}

	public void setStart_time(String start_time) {
		this.start_time = start_time;
	}

	public String getPlan_endtime() {
		return plan_endtime;
	}

	public void setPlan_endtime(String plan_endtime) {
		this.plan_endtime = plan_endtime;
	}

	public int getInsert_time() {
		return insert_time;
	}

	public void setInsert_time(int insert_time) {
		this.insert_time = insert_time;
	}

	public int getUpdate_time() {
		return update_time;
	}

	public void setUpdate_time(int update_time) {
		this.update_time = update_time;
	}

	@Override
	public String toString() {
		return "JosGoodsVO [pk=" + pk + ", sku_id=" + sku_id + ", plan_id="
				+ plan_id + ", goods_name=" + goods_name + ", unitPrice="
				+ unitPrice + ", praise_degree=" + praise_degree
				+ ", mainimgurl=" + mainimgurl + ", commision_ratio="
				+ commision_ratio + ", commision=" + commision + ", ware_url="
				+ ware_url + ", recent_sales=" + recent_sales
				+ ", total_sales=" + total_sales + ", start_time=" + start_time
				+ ", plan_endtime=" + plan_endtime + ", insert_time="
				+ insert_time + ", update_time=" + update_time + "]";
	}

	// 2013-07-03
	// 00:00:00
	// 修改时间

}
