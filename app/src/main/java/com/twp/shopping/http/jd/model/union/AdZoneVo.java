package com.twp.shopping.http.jd.model.union;

import java.io.Serializable;
import java.util.List;

public class AdZoneVo implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -7849792258242739535L;

	private int zone_id;

	// 专柜id
	private int union_id;

	// 联盟id
	private int web_id;

	// 网站id

	private String web_name;/* 京东商城 网站名称 */
	private String web_url;/* http://www.jd.com 网站域名 */
	private int zone_name;

	// 专柜名称
	private int width;

	// 专柜宽度
	private int height;

	// 专柜高度
	private List<CategoryName> category; /* List 否 */

	// 专柜推广类目
	private int size_id;

	// 专柜尺寸id s
	private String size_name;

	/* 专柜尺寸名称 */
	private int promotion_type;
	/* 专柜推广类型 */
	private int status;
	/* 1,2 专柜状态 */
	public int getZone_id() {
		return zone_id;
	}
	public void setZone_id(int zone_id) {
		this.zone_id = zone_id;
	}
	public int getUnion_id() {
		return union_id;
	}
	public void setUnion_id(int union_id) {
		this.union_id = union_id;
	}
	public int getWeb_id() {
		return web_id;
	}
	public void setWeb_id(int web_id) {
		this.web_id = web_id;
	}
	public String getWeb_name() {
		return web_name;
	}
	public void setWeb_name(String web_name) {
		this.web_name = web_name;
	}
	public String getWeb_url() {
		return web_url;
	}
	public void setWeb_url(String web_url) {
		this.web_url = web_url;
	}
	public int getZone_name() {
		return zone_name;
	}
	public void setZone_name(int zone_name) {
		this.zone_name = zone_name;
	}
	public int getWidth() {
		return width;
	}
	public void setWidth(int width) {
		this.width = width;
	}
	public int getHeight() {
		return height;
	}
	public void setHeight(int height) {
		this.height = height;
	}
	public List<CategoryName> getCategory() {
		return category;
	}
	public void setCategory(List<CategoryName> category) {
		this.category = category;
	}
	public int getSize_id() {
		return size_id;
	}
	public void setSize_id(int size_id) {
		this.size_id = size_id;
	}
	public String getSize_name() {
		return size_name;
	}
	public void setSize_name(String size_name) {
		this.size_name = size_name;
	}
	public int getPromotion_type() {
		return promotion_type;
	}
	public void setPromotion_type(int promotion_type) {
		this.promotion_type = promotion_type;
	}
	public int getStatus() {
		return status;
	}
	public void setStatus(int status) {
		this.status = status;
	}
	@Override
	public String toString() {
		return "AdZoneVo [zone_id=" + zone_id + ", union_id=" + union_id
				+ ", web_id=" + web_id + ", web_name=" + web_name
				+ ", web_url=" + web_url + ", zone_name=" + zone_name
				+ ", width=" + width + ", height=" + height + ", category="
				+ category + ", size_id=" + size_id + ", size_name="
				+ size_name + ", promotion_type=" + promotion_type
				+ ", status=" + status + "]";
	}
	
	

}
