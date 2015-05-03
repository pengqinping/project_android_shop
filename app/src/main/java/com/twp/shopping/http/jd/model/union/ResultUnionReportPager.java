package com.twp.shopping.http.jd.model.union;

import java.io.Serializable;

//奇葩的京东 接口编码人员，你奶奶的，定义这么多不同的类型砸死啊。
//这个类的适合对象 ，一个T　一个int ,一个string,
public class ResultUnionReportPager<T> implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1381984236107390748L;

	private int page_index;
	private int page_size;
	// 每页数据条数
	private boolean success;
	/*
	 * true,false 是否成功
	 */
	private String message;
	// 操作成功!
	// 操作结果描述

	private T resultListData;

	public T getResultListData() {
		return resultListData;
	}

	public void setResultListData(T resultListData) {
		this.resultListData = resultListData;
	}

	public int getPage_index() {
		return page_index;
	}

	public void setPage_index(int page_index) {
		this.page_index = page_index;
	}

	public int getPage_size() {
		return page_size;
	}

	public void setPage_size(int page_size) {
		this.page_size = page_size;
	}

	public boolean isSuccess() {
		return success;
	}

	public void setSuccess(boolean success) {
		this.success = success;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	@Override
	public String toString() {
		return "ResultUnionReportPager [page_index=" + page_index
				+ ", page_size=" + page_size + ", success=" + success
				+ ", message=" + message + ", resultListData=" + resultListData
				+ "]";
	}



}
