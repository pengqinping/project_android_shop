package com.twp.shopping.http.jd.model.ware;

import java.io.Serializable;

public class Guang implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 5947081527371163198L;

	private String foldFlag;
	// cms后台是否打开
	private String functionId;
	// 频道functionId
	private String icon;
	// 图片
	private String title;
	// 频道标题
	private String type;
	// 频道类型
	private String url;
	// 要跳转的url
	public String getFoldFlag() {
		return foldFlag;
	}
	public void setFoldFlag(String foldFlag) {
		this.foldFlag = foldFlag;
	}
	public String getFunctionId() {
		return functionId;
	}
	public void setFunctionId(String functionId) {
		this.functionId = functionId;
	}
	public String getIcon() {
		return icon;
	}
	public void setIcon(String icon) {
		this.icon = icon;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
	public String getUrl() {
		return url;
	}
	public void setUrl(String url) {
		this.url = url;
	}
	@Override
	public String toString() {
		return "Guang [foldFlag=" + foldFlag + ", functionId=" + functionId
				+ ", icon=" + icon + ", title=" + title + ", type=" + type
				+ ", url=" + url + "]";
	}
	
	

}
