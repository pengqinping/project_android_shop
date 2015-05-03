package com.twp.shopping.http.jd.model.ware;

import java.io.Serializable;
import java.util.List;

import com.twp.shopping.http.jd.model.product.WareInfo;

public class ActivityProductsList implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -3924696919029419424L;

	private int resultCode;
	// 接口返回信息码
	private int totalCount;
	// 总记录数
	private int couponStatus;

	private int page;

	private String couponURL;

	private String roleIds;

	private String title;

	private String promotionDetail;

	private String horizontalImag;

	private List<WareInfo> activityProducts;

	public int getResultCode() {
		return resultCode;
	}

	public void setResultCode(int resultCode) {
		this.resultCode = resultCode;
	}

	public int getTotalCount() {
		return totalCount;
	}

	public void setTotalCount(int totalCount) {
		this.totalCount = totalCount;
	}

	public int getCouponStatus() {
		return couponStatus;
	}

	public void setCouponStatus(int couponStatus) {
		this.couponStatus = couponStatus;
	}

	public int getPage() {
		return page;
	}

	public void setPage(int page) {
		this.page = page;
	}

	public String getCouponURL() {
		return couponURL;
	}

	public void setCouponURL(String couponURL) {
		this.couponURL = couponURL;
	}

	public String getRoleIds() {
		return roleIds;
	}

	public void setRoleIds(String roleIds) {
		this.roleIds = roleIds;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getPromotionDetail() {
		return promotionDetail;
	}

	public void setPromotionDetail(String promotionDetail) {
		this.promotionDetail = promotionDetail;
	}

	public String getHorizontalImag() {
		return horizontalImag;
	}

	public void setHorizontalImag(String horizontalImag) {
		this.horizontalImag = horizontalImag;
	}

	public List<WareInfo> getActivityProducts() {
		return activityProducts;
	}

	public void setActivityProducts(List<WareInfo> activityProducts) {
		this.activityProducts = activityProducts;
	}

	@Override
	public String toString() {
		return "ActivityProductsList [resultCode=" + resultCode
				+ ", totalCount=" + totalCount + ", couponStatus="
				+ couponStatus + ", page=" + page + ", couponURL=" + couponURL
				+ ", roleIds=" + roleIds + ", title=" + title
				+ ", promotionDetail=" + promotionDetail + ", horizontalImag="
				+ horizontalImag + ", activityProducts=" + activityProducts
				+ "]";
	}

}
