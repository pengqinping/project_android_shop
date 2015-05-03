package com.twp.shopping.http.jd.model.union;

import java.io.Serializable;

public class PlanVO implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -4183966315574837790L;

	private int pk;

	// 计划编号
	private String planName;

	// 推广计划名称
	private String startDate ;

	// 计划开始时间
	private String endDate ;

	// 计划结束时间
	private int averageCommision;

	// 平均类目佣金比率
	private int goodsCount;

	// 主推商品件数
	private int activityCount;

	// 活动推广个数
	private int status;
	
	// 计划状态

	public int getPk() {
		return pk;
	}

	public void setPk(int pk) {
		this.pk = pk;
	}

	public String getPlanName() {
		return planName;
	}

	public void setPlanName(String planName) {
		this.planName = planName;
	}

	

	public String getStartDate() {
		return startDate;
	}

	public void setStartDate(String startDate) {
		this.startDate = startDate;
	}

	public String getEndDate() {
		return endDate;
	}

	public void setEndDate(String endDate) {
		this.endDate = endDate;
	}

	public int getAverageCommision() {
		return averageCommision;
	}

	public void setAverageCommision(int averageCommision) {
		this.averageCommision = averageCommision;
	}

	public int getGoodsCount() {
		return goodsCount;
	}

	public void setGoodsCount(int goodsCount) {
		this.goodsCount = goodsCount;
	}

	public int getActivityCount() {
		return activityCount;
	}

	public void setActivityCount(int activityCount) {
		this.activityCount = activityCount;
	}

	public int getStatus() {
		return status;
	}

	public void setStatus(int status) {
		this.status = status;
	}

	@Override
	public String toString() {
		return "PlanVO [pk=" + pk + ", planName=" + planName + ", start="
				+ startDate  + ", end=" + endDate  + ", averageCommision="
				+ averageCommision + ", goodsCount=" + goodsCount
				+ ", activityCount=" + activityCount + ", status=" + status
				+ "]";
	};

	
	
	

}
