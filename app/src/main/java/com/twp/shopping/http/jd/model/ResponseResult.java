package com.twp.shopping.http.jd.model;

import java.io.Serializable;

public class ResponseResult<T> implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -1118790342463537025L;

	private T resultJd;

	public T getResultJd() {
		return resultJd;
	}

	public void setResultJd(T resultJd) {
		this.resultJd = resultJd;
	}

	@Override
	public String toString() {
		return "ResponseResult [resultJd=" + resultJd + "]";
	}

	
}
