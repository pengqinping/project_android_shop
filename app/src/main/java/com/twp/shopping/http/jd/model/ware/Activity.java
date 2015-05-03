package com.twp.shopping.http.jd.model.ware;

import java.io.Serializable;

public class Activity implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 8315781347186758758L;
	private int activityId;
	// 活动id
	private String horizontalImag;
	// 横板图
	private String sortNo;
	// 排序的号码
	private String title;
	// 标题
	private String type;
	// 0：普通活动图，1：专题列表的活动图
	public int getActivityId() {
		return activityId;
	}
	public void setActivityId(int activityId) {
		this.activityId = activityId;
	}
	public String getHorizontalImag() {
		return horizontalImag;
	}
	public void setHorizontalImag(String horizontalImag) {
		this.horizontalImag = horizontalImag;
	}
	public String getSortNo() {
		return sortNo;
	}
	public void setSortNo(String sortNo) {
		this.sortNo = sortNo;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
	@Override
	public String toString() {
		return "Activity [activityId=" + activityId + ", horizontalImag="
				+ horizontalImag + ", sortNo=" + sortNo + ", title=" + title
				+ ", type=" + type + "]";
	}
	
	
}
