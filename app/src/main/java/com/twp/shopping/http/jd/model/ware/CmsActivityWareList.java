package com.twp.shopping.http.jd.model.ware;

import java.io.Serializable;
import java.util.List;

import com.twp.shopping.http.jd.model.recommend.CmsActivityWare;

public class CmsActivityWareList implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -3797367684456034568L;

	private int resultCode;	
//	接口返回信息码 
	private int totalCount;	
//	总记录数 
	private int couponStatus;	

	private String couponURL ;	

	private String roleIds ;	

	private String cmsActivityRebateImg ;	

	private List<CmsActivityWare> cmsActivityWareList ;

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

	public String getCmsActivityRebateImg() {
		return cmsActivityRebateImg;
	}

	public void setCmsActivityRebateImg(String cmsActivityRebateImg) {
		this.cmsActivityRebateImg = cmsActivityRebateImg;
	}

	public List<CmsActivityWare> getCmsActivityWareList() {
		return cmsActivityWareList;
	}

	public void setCmsActivityWareList(List<CmsActivityWare> cmsActivityWareList) {
		this.cmsActivityWareList = cmsActivityWareList;
	}

	@Override
	public String toString() {
		return "CmsActivityWareList [resultCode=" + resultCode
				+ ", totalCount=" + totalCount + ", couponStatus="
				+ couponStatus + ", couponURL=" + couponURL + ", roleIds="
				+ roleIds + ", cmsActivityRebateImg=" + cmsActivityRebateImg
				+ ", cmsActivityWareList=" + cmsActivityWareList + "]";
	}	

	
}
