package com.twp.shopping.http.jd.model.union;

import java.io.Serializable;

public class JosActivityImgVO implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -2412854857176273430L;

	private int activity_pk;

	// 活动主键
	private int plan_id;

	// 计划主键
	private String activity_name;

	// 活动名称
	private String activity_url;

	// 活动URL
	private String activity_starttime;

	// 活动开始时间
	private String activity_endtime;

	// 活动结束时间
	private int average_commision;

	// 类目平均佣金
	private int img_pk;

	// 图片主键
	private String img_url;

	/*
	 * /g15/M09/02/0C/rBEh WFHHtFsIAAAAAA CVuAWYPKsAAAe AQPOChEAAJXQ 933.jpg
	 * 图片相对url（完整url需加前缀字段img_urlprefix的值，如完整url为
	 * http://img30.360buyimg.com/ads// g15/M09/02/0C/rBEhWFHHtFsI
	 * AAAAAACVuAWYPKsAAAeA QPOChEAAJXQ933.jpg ）
	 */
	private int img_width;

	// 图片宽度
	private int img_height;

	// 图片高度
	private String img_urlprefix;

	public int getActivity_pk() {
		return activity_pk;
	}

	public void setActivity_pk(int activity_pk) {
		this.activity_pk = activity_pk;
	}

	public int getPlan_id() {
		return plan_id;
	}

	public void setPlan_id(int plan_id) {
		this.plan_id = plan_id;
	}

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

	public String getActivity_starttime() {
		return activity_starttime;
	}

	public void setActivity_starttime(String activity_starttime) {
		this.activity_starttime = activity_starttime;
	}

	public String getActivity_endtime() {
		return activity_endtime;
	}

	public void setActivity_endtime(String activity_endtime) {
		this.activity_endtime = activity_endtime;
	}

	public int getAverage_commision() {
		return average_commision;
	}

	public void setAverage_commision(int average_commision) {
		this.average_commision = average_commision;
	}

	public int getImg_pk() {
		return img_pk;
	}

	public void setImg_pk(int img_pk) {
		this.img_pk = img_pk;
	}

	public String getImg_url() {
		return img_url;
	}

	public void setImg_url(String img_url) {
		this.img_url = img_url;
	}

	public int getImg_width() {
		return img_width;
	}

	public void setImg_width(int img_width) {
		this.img_width = img_width;
	}

	public int getImg_height() {
		return img_height;
	}

	public void setImg_height(int img_height) {
		this.img_height = img_height;
	}

	public String getImg_urlprefix() {
		return img_urlprefix;
	}

	public void setImg_urlprefix(String img_urlprefix) {
		this.img_urlprefix = img_urlprefix;
	}

	@Override
	public String toString() {
		return "JosActivityImgVO [activity_pk=" + activity_pk + ", plan_id="
				+ plan_id + ", activity_name=" + activity_name
				+ ", activity_url=" + activity_url + ", activity_starttime="
				+ activity_starttime + ", activity_endtime=" + activity_endtime
				+ ", average_commision=" + average_commision + ", img_pk="
				+ img_pk + ", img_url=" + img_url + ", img_width=" + img_width
				+ ", img_height=" + img_height + ", img_urlprefix="
				+ img_urlprefix + "]";
	}

	/*
	 * http://img30.360buy img.com/ads/ 图片url前缀
	 */
	
	

}
