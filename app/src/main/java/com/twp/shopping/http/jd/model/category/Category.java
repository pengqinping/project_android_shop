package com.twp.shopping.http.jd.model.category;

import java.io.Serializable;

public class Category implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -7347141645908243463L;
	private int fid;
	private String icon;
	private int orderSort;
	private int level;
	private int cid;
	private String description;
	private String name;

	public int getFid() {
		return fid;
	}

	public void setFid(int fid) {
		this.fid = fid;
	}

	public String getIcon() {
		return icon;
	}

	public void setIcon(String icon) {
		this.icon = icon;
	}

	public int getOrderSort() {
		return orderSort;
	}

	public void setOrderSort(int orderSort) {
		this.orderSort = orderSort;
	}

	public int getLevel() {
		return level;
	}

	public void setLevel(int level) {
		this.level = level;
	}

	public int getCid() {
		return cid;
	}

	public void setCid(int cid) {
		this.cid = cid;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	@Override
	public String toString() {
		return "Categy [fid=" + fid + ", icon=" + icon + ", orderSort="
				+ orderSort + ", level=" + level + ", cid=" + cid
				+ ", description=" + description + ", name=" + name + "]";
	}

}
