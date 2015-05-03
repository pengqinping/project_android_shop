package com.twp.shopping.http.jd.model.product;

import java.io.Serializable;

public class Productsort implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 7876422371322994693L;

	/* 652 分类ID */
	private int product_sort_id;
	/* 0 父类ID */
	private int father_id;
	/* 大家电 分类名称 */
	private String name;
	/* 1是0否 是否有效 */
	private int is_delete;
	/* 0：一级，1：二级，2：三级 分类级别 */
	private int grade;
	/* 1是0否 是否上柜 */
	private String conte;
	/* 0 排序，内部ERP使用，对外无实际用途 */
	private int sort;
	/* 1是0否 是否提供安装服务 */
	private int is_fit_service;

	public int getProduct_sort_id() {
		return product_sort_id;
	}

	public void setProduct_sort_id(int product_sort_id) {
		this.product_sort_id = product_sort_id;
	}

	public int getFather_id() {
		return father_id;
	}

	public void setFather_id(int father_id) {
		this.father_id = father_id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getIs_delete() {
		return is_delete;
	}

	public void setIs_delete(int is_delete) {
		this.is_delete = is_delete;
	}

	public int getGrade() {
		return grade;
	}

	public void setGrade(int grade) {
		this.grade = grade;
	}

	public String getConte() {
		return conte;
	}

	public void setConte(String conte) {
		this.conte = conte;
	}

	public int getSort() {
		return sort;
	}

	public void setSort(int sort) {
		this.sort = sort;
	}

	public int getIs_fit_service() {
		return is_fit_service;
	}

	public void setIs_fit_service(int is_fit_service) {
		this.is_fit_service = is_fit_service;
	}

	@Override
	public String toString() {
		return "Productsort [product_sort_id=" + product_sort_id
				+ ", father_id=" + father_id + ", name=" + name
				+ ", is_delete=" + is_delete + ", grade=" + grade + ", conte="
				+ conte + ", sort=" + sort + ", is_fit_service="
				+ is_fit_service + "]";
	}

}
