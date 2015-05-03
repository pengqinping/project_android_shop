package com.twp.shopping.http.jd.model;

import java.io.Serializable;

public class ResponseJd<T> implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 4269020977678393331L;

	private T responseJd;

	public T getResponseJd() {
		return responseJd;
	}

	public void setResponseJd(T responseJd) {
		this.responseJd = responseJd;
	}

	@Override
	public String toString() {
		return "ResponseJd [responseJd=" + responseJd + "]";
	}

}
