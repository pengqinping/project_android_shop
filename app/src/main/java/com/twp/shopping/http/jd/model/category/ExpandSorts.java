package com.twp.shopping.http.jd.model.category;

import java.io.Serializable;

public class ExpandSorts implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -2980977408128388707L;
	private int expandValueId ;
//	扩展属性值id 
	private String expandSortValueName;
//	扩展属性值 
	public int getExpandValueId() {
		return expandValueId;
	}
	public void setExpandValueId(int expandValueId) {
		this.expandValueId = expandValueId;
	}
	public String getExpandSortValueName() {
		return expandSortValueName;
	}
	public void setExpandSortValueName(String expandSortValueName) {
		this.expandSortValueName = expandSortValueName;
	}
	@Override
	public String toString() {
		return "ExpandSorts [expandValueId=" + expandValueId
				+ ", expandSortValueName=" + expandSortValueName + "]";
	}
	
	
}
