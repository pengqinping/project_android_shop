package com.twp.shopping.http.jd.model.union;

import java.io.Serializable;

public class ActivitySafVo implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -7614321859993542729L;
	private String activity_name;
	/* 活动名称,如果为null和设置field时没有设置该属性则在结果中不显示 */
	private String activity_url;
	/* 活动推广URL,如果为null和设置field时没有设置该属性则在结果中不显示 */
	private int activity_width;
	/* 图片宽度 */
	private int activity_height;
	/* 图片长度 */
	private String activity_start;
	/* 推广开始时间 */
	private String activity_end;
	/* 推广开始时间 */
	private String activity_shopName;
	/* 店铺名称,如果为null和设置field时没有设置该属性则在结果中不显示 */
	private String activity_mainCategory;
	/* 主营类目,如果为null和设置field时没有设置该属性则在结果中不显示 */
	private int activity_commRatio;
	/* 佣金比例 */
	private String activity_pk;
	/* 主键 */
	public String getActivity_name() {
		return activity_name;
	}
	public void setActivity_name(String activity_name) {
		this.activity_name = activity_name;
	}
	public String getActivity_url() {
		return activity_url;
	}
	public void setActivity_url(String activity_url) {
		this.activity_url = activity_url;
	}
	public int getActivity_width() {
		return activity_width;
	}
	public void setActivity_width(int activity_width) {
		this.activity_width = activity_width;
	}
	public int getActivity_height() {
		return activity_height;
	}
	public void setActivity_height(int activity_height) {
		this.activity_height = activity_height;
	}
	public String getActivity_start() {
		return activity_start;
	}
	public void setActivity_start(String activity_start) {
		this.activity_start = activity_start;
	}
	public String getActivity_end() {
		return activity_end;
	}
	public void setActivity_end(String activity_end) {
		this.activity_end = activity_end;
	}
	public String getActivity_shopName() {
		return activity_shopName;
	}
	public void setActivity_shopName(String activity_shopName) {
		this.activity_shopName = activity_shopName;
	}
	public String getActivity_mainCategory() {
		return activity_mainCategory;
	}
	public void setActivity_mainCategory(String activity_mainCategory) {
		this.activity_mainCategory = activity_mainCategory;
	}
	public int getActivity_commRatio() {
		return activity_commRatio;
	}
	public void setActivity_commRatio(int activity_commRatio) {
		this.activity_commRatio = activity_commRatio;
	}
	public String getActivity_pk() {
		return activity_pk;
	}
	public void setActivity_pk(String activity_pk) {
		this.activity_pk = activity_pk;
	}
	@Override
	public String toString() {
		return "ActivitySafVo [activity_name=" + activity_name
				+ ", activity_url=" + activity_url + ", activity_width="
				+ activity_width + ", activity_height=" + activity_height
				+ ", activity_start=" + activity_start + ", activity_end="
				+ activity_end + ", activity_shopName=" + activity_shopName
				+ ", activity_mainCategory=" + activity_mainCategory
				+ ", activity_commRatio=" + activity_commRatio
				+ ", activity_pk=" + activity_pk + "]";
	}
	
	
}
