package com.twp.shopping.http.jd.model;

import java.io.Serializable;

public class ProductImage implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 8528155995477646258L;

	/* Id编码 */
	private int id;
	/* Sku编码 */
	private int sku_id;
	/* 图片绝对路径 */
	private String path;
	/* 1 有效、0无效 */
	private int yn;
	/* 1 主图 0辅图 */
	private int is_primary;
	/* 排序 */
	private int orderSort;
	/* 备用字段，尚未启用 */
	private int position;
	/* 1 长图 0 普通主图 */
	private int type;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getSku_id() {
		return sku_id;
	}

	public void setSku_id(int sku_id) {
		this.sku_id = sku_id;
	}

	public String getPath() {
		return path;
	}

	public void setPath(String path) {
		this.path = path;
	}

	public int getYn() {
		return yn;
	}

	public void setYn(int yn) {
		this.yn = yn;
	}

	public int getIs_primary() {
		return is_primary;
	}

	public void setIs_primary(int is_primary) {
		this.is_primary = is_primary;
	}

	public int getOrderSort() {
		return orderSort;
	}

	public void setOrderSort(int orderSort) {
		this.orderSort = orderSort;
	}

	public int getPosition() {
		return position;
	}

	public void setPosition(int position) {
		this.position = position;
	}

	public int getType() {
		return type;
	}

	public void setType(int type) {
		this.type = type;
	}

	@Override
	public String toString() {
		return "ProductImageList [id=" + id + ", sku_id=" + sku_id + ", path="
				+ path + ", yn=" + yn + ", is_primary=" + is_primary
				+ ", orderSort=" + orderSort + ", position=" + position
				+ ", type=" + type + "]";
	}

}
