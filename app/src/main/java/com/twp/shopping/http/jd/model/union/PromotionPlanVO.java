package com.twp.shopping.http.jd.model.union;

import java.io.Serializable;

public class PromotionPlanVO implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -4183966315574837790L;

	private int pk;

	private int pop_id;/* 商家id */

	// 计划编号
	private String plan_name;

	// 推广计划名称
	private String start_date;

	// 计划开始时间
	private String end_date;

	// 计划结束时间
	
	private String update_time ;
	
	private String insert_time ;
	
	private int average_commision;

	// 平均类目佣金比率
	private int goods_count;

	// 主推商品件数
	private int activity_count;

	// 活动推广个数
	private int status;

	// 计划状态

	public int getPk() {
		return pk;
	}

	public void setPk(int pk) {
		this.pk = pk;
	}

	public int getPop_id() {
		return pop_id;
	}

	public void setPop_id(int pop_id) {
		this.pop_id = pop_id;
	}

	public String getPlan_name() {
		return plan_name;
	}

	public void setPlan_name(String plan_name) {
		this.plan_name = plan_name;
	}

	public String getStart_date() {
		return start_date;
	}

	public void setStart_date(String start_date) {
		this.start_date = start_date;
	}

	public String getEnd_date() {
		return end_date;
	}

	public void setEnd_date(String end_date) {
		this.end_date = end_date;
	}

	public String getUpdate_time() {
		return update_time;
	}

	public void setUpdate_time(String update_time) {
		this.update_time = update_time;
	}

	public String getInsert_time() {
		return insert_time;
	}

	public void setInsert_time(String insert_time) {
		this.insert_time = insert_time;
	}

	public int getAverage_commision() {
		return average_commision;
	}

	public void setAverage_commision(int average_commision) {
		this.average_commision = average_commision;
	}

	public int getGoods_count() {
		return goods_count;
	}

	public void setGoods_count(int goods_count) {
		this.goods_count = goods_count;
	}

	public int getActivity_count() {
		return activity_count;
	}

	public void setActivity_count(int activity_count) {
		this.activity_count = activity_count;
	}

	public int getStatus() {
		return status;
	}

	public void setStatus(int status) {
		this.status = status;
	}

	@Override
	public String toString() {
		return "PromotionPlanVO [pk=" + pk + ", pop_id=" + pop_id
				+ ", plan_name=" + plan_name + ", start_date=" + start_date
				+ ", end_date=" + end_date + ", update_time=" + update_time
				+ ", insert_time=" + insert_time + ", average_commision="
				+ average_commision + ", goods_count=" + goods_count
				+ ", activity_count=" + activity_count + ", status=" + status
				+ "]";
	}


	
	
}
