package com.twp.shopping.http.jd.model.product;

import java.io.Serializable;
import java.util.List;

public class ResultPagerListData<T> implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1381984236107390748L;
	private int resultCode;
	private int page;
	private List<T> resultListData;
	private int wareCount;

	// 是否可以对地区筛选
	private boolean regionIsTrue;
	// 是否可以对配送筛选
	private boolean selfIsTrue;
	// 展示形式
	private String show;

	public int getResultCode() {
		return resultCode;
	}

	public void setResultCode(int resultCode) {
		this.resultCode = resultCode;
	}

	public int getPage() {
		return page;
	}

	public void setPage(int page) {
		this.page = page;
	}

	public List<T> getResultListData() {
		return resultListData;
	}

	public void setResultListData(List<T> resultListData) {
		this.resultListData = resultListData;
	}

	public int getWareCount() {
		return wareCount;
	}

	public void setWareCount(int wareCount) {
		this.wareCount = wareCount;
	}

	public boolean isRegionIsTrue() {
		return regionIsTrue;
	}

	public void setRegionIsTrue(boolean regionIsTrue) {
		this.regionIsTrue = regionIsTrue;
	}

	public boolean isSelfIsTrue() {
		return selfIsTrue;
	}

	public void setSelfIsTrue(boolean selfIsTrue) {
		this.selfIsTrue = selfIsTrue;
	}

	public String getShow() {
		return show;
	}

	public void setShow(String show) {
		this.show = show;
	}

	@Override
	public String toString() {
		return "ResultPagerListData [resultCode=" + resultCode + ", page="
				+ page + ", resultListData=" + resultListData + ", wareCount="
				+ wareCount + ", regionIsTrue=" + regionIsTrue
				+ ", selfIsTrue=" + selfIsTrue + ", show=" + show + "]";
	}

}
