package com.twp.shopping.http.jd.model;

import java.io.Serializable;

public class ResultBNST<T> implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 2894599322088870889L;

	private boolean successed;
	// 查询状态
	private int code;
	// 状态码，0成功，1失败
	private String message;
	// 状态信息 ，成功时为空，失败时为失败原因
	private T resultListData;

	public boolean isSuccessed() {
		return successed;
	}

	public void setSuccessed(boolean successed) {
		this.successed = successed;
	}

	public int getCode() {
		return code;
	}

	public void setCode(int code) {
		this.code = code;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public T getResultListData() {
		return resultListData;
	}

	public void setResultListData(T resultListData) {
		this.resultListData = resultListData;
	}

	@Override
	public String toString() {
		return "ResultBNST [successed=" + successed + ", code=" + code
				+ ", message=" + message + ", resultListData=" + resultListData
				+ "]";
	}

}
