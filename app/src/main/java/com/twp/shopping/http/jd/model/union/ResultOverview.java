package com.twp.shopping.http.jd.model.union;

import java.io.Serializable;

public class ResultOverview<T> implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 8286740000268504398L;

	private T resultListData;

	/* 效果概况数据 */
	private int page_index;
	/*
	 * Number
	 * 
	 * 页码
	 */
	private int page_size;
	/*
	 * Number
	 * 
	 * 每页记录数
	 */
	private int page_total;
	/*
	 * Number
	 * 
	 * 总页数
	 */
	private String start_date;
	/*
	 * Date 2013-07-03 00:00:00 查询开始时间 （仅支持按日查询，时分秒数据只可为00:00:00）
	 */
	private String end_date;
	/*
	 * Date 2013-07-03 00:00:00 查询结束时间 （仅支持按日查询，时分秒数据只可为00:00:00）
	 */

	public int getPage_index() {
		return page_index;
	}
	public T getResultListData() {
		return resultListData;
	}
	public void setResultListData(T resultListData) {
		this.resultListData = resultListData;
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
	public int getPage_total() {
		return page_total;
	}
	public void setPage_total(int page_total) {
		this.page_total = page_total;
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
	@Override
	public String toString() {
		return "ResultOverview [page_index=" + page_index + ", page_size="
				+ page_size + ", page_total=" + page_total + ", start_date="
				+ start_date + ", end_date=" + end_date + "]";
	}
	
	
	
	
}
