package com.twp.shopping.http.jd.model.union;

import java.io.Serializable;

public class ImgUrl implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = -8220098458405926866L;
	private String imgUrl;
	public String getImgUrl() {
		return imgUrl;
	}
	public void setImgUrl(String imgUrl) {
		this.imgUrl = imgUrl;
	}
	@Override
	public String toString() {
		return "ImgUrl [imgUrl=" + imgUrl + "]";
	}
	
}
