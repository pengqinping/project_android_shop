package com.twp.shopping.http.jd.model.product;

import java.io.Serializable;

public class ImagePaths implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -368763181979042435L;
	private String skuId;
	private String newpath;
	private String bigpath;

	public String getSkuId() {
		return skuId;
	}

	public void setSkuId(String skuId) {
		this.skuId = skuId;
	}

	public String getNewpath() {
		return newpath;
	}

	public void setNewpath(String newpath) {
		this.newpath = newpath;
	}

	public String getBigpath() {
		return bigpath;
	}

	public void setBigpath(String bigpath) {
		this.bigpath = bigpath;
	}

	@Override
	public String toString() {
		return "ImagePaths [skuId=" + skuId + ", newpath=" + newpath
				+ ", bigpath=" + bigpath + "]";
	}

}
