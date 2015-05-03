package com.twp.shopping.http.jd.model.union;

import java.io.Serializable;

public class CmsActivity implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 8508528997588120563L;

	private int activityId;
	// 活动id
	private int catelogyId;
	// 分类id
	private String content;
	// 活动内容描述
	private String endDate;
	// 活动结束时间
	private String imageUrl;
	// 活动图片地址
	private String startDate;
	// 活动开始时间
	private String status;
	// 活动状态
	private String title;

	// 活动标题
	public int getActivityId() {
		return activityId;
	}

	public void setActivityId(int activityId) {
		this.activityId = activityId;
	}

	public int getCatelogyId() {
		return catelogyId;
	}

	public void setCatelogyId(int catelogyId) {
		this.catelogyId = catelogyId;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public String getEndDate() {
		return endDate;
	}

	public void setEndDate(String endDate) {
		this.endDate = endDate;
	}

	public String getImageUrl() {
		return imageUrl;
	}

	public void setImageUrl(String imageUrl) {
		this.imageUrl = imageUrl;
	}

	public String getStartDate() {
		return startDate;
	}

	public void setStartDate(String startDate) {
		this.startDate = startDate;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	@Override
	public String toString() {
		return "CmsActivity [activityId=" + activityId + ", catelogyId="
				+ catelogyId + ", content=" + content + ", endDate=" + endDate
				+ ", imageUrl=" + imageUrl + ", startDate=" + startDate
				+ ", status=" + status + ", title=" + title + "]";
	}

}
