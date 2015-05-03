package com.twp.shopping.http.jd.model.union;

import java.io.Serializable;

public class GoodsCode implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -6526944890202376612L;

	private String url_code;
	// url推广代码
	private String img_code;
	// 图片推广代码
	private String link_code;
	// 文字链推广代码
	private boolean success;
	// true,false
	// 是否成功
	private String message;

	// 获取推广代码成功
	// 操作结果描述
	public String getUrl_code() {
		return url_code;
	}

	public void setUrl_code(String url_code) {
		this.url_code = url_code;
	}

	public String getImg_code() {
		return img_code;
	}

	public void setImg_code(String img_code) {
		this.img_code = img_code;
	}

	public String getLink_code() {
		return link_code;
	}

	public void setLink_code(String link_code) {
		this.link_code = link_code;
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
		return "GoodsCode [url_code=" + url_code + ", img_code=" + img_code
				+ ", link_code=" + link_code + ", success=" + success
				+ ", message=" + message + "]";
	}

}
