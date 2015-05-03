package com.twp.shopping.http.jd.model.union;

import java.io.Serializable;

public class PlanActivity implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -3976490397122154803L;

	private String activityName;

	// 活动名称
	private String activityUrl;

	// 活动链接
	private String activityStarttime;

	/*
	 * 2013-07-03 00:00:00 活动开始时间
	 */
	private String activityEndtime;

	/*
	 * 2013-07-03 00:00:00 活动结束时间
	 */
	private ImgUrl activityImgList;

	public String getActivityName() {
		return activityName;
	}

	public void setActivityName(String activityName) {
		this.activityName = activityName;
	}

	public String getActivityUrl() {
		return activityUrl;
	}

	public void setActivityUrl(String activityUrl) {
		this.activityUrl = activityUrl;
	}

	public String getActivityStarttime() {
		return activityStarttime;
	}

	public void setActivityStarttime(String activityStarttime) {
		this.activityStarttime = activityStarttime;
	}

	public String getActivityEndtime() {
		return activityEndtime;
	}

	public void setActivityEndtime(String activityEndtime) {
		this.activityEndtime = activityEndtime;
	}

	public ImgUrl getActivityImgList() {
		return activityImgList;
	}

	public void setActivityImgList(ImgUrl activityImgList) {
		this.activityImgList = activityImgList;
	}

	@Override
	public String toString() {
		return "PlanActivity [activityName=" + activityName + ", activityUrl="
				+ activityUrl + ", activityStarttime=" + activityStarttime
				+ ", activityEndtime=" + activityEndtime + ", activityImgList="
				+ activityImgList + "]";
	}

	// 活动图片列表
	
	

}
