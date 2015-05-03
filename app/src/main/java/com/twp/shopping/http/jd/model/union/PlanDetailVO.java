package com.twp.shopping.http.jd.model.union;

import java.io.Serializable;

public class PlanDetailVO implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -4183966315574837790L;

	// 计划编号
	private String planName;

	// 推广计划名称
	private String starttDate;

	// 计划开始时间
	private String endtDate;

	// 计划结束时间

	// 说明
	private String notes;
	private CategoryCommision categoryCommision;
	private PlanGoods planGoods;
	private PlanActivity planActivity;
	public String getPlanName() {
		return planName;
	}
	public void setPlanName(String planName) {
		this.planName = planName;
	}
	public String getStarttDate() {
		return starttDate;
	}
	public void setStarttDate(String starttDate) {
		this.starttDate = starttDate;
	}
	public String getEndtDate() {
		return endtDate;
	}
	public void setEndtDate(String endtDate) {
		this.endtDate = endtDate;
	}
	public String getNotes() {
		return notes;
	}
	public void setNotes(String notes) {
		this.notes = notes;
	}
	public CategoryCommision getCategoryCommision() {
		return categoryCommision;
	}
	public void setCategoryCommision(CategoryCommision categoryCommision) {
		this.categoryCommision = categoryCommision;
	}
	public PlanGoods getPlanGoods() {
		return planGoods;
	}
	public void setPlanGoods(PlanGoods planGoods) {
		this.planGoods = planGoods;
	}
	public PlanActivity getPlanActivity() {
		return planActivity;
	}
	public void setPlanActivity(PlanActivity planActivity) {
		this.planActivity = planActivity;
	}
	@Override
	public String toString() {
		return "PlanDetailVO [planName=" + planName + ", starttDate="
				+ starttDate + ", endtDate=" + endtDate + ", notes=" + notes
				+ ", categoryCommision=" + categoryCommision + ", planGoods="
				+ planGoods + ", planActivity=" + planActivity + "]";
	}
	
	

}
