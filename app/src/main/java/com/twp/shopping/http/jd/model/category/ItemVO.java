package com.twp.shopping.http.jd.model.category;

import java.io.Serializable;
import java.util.List;

public class ItemVO implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 6207031232300938292L;

	private String type;

	private List<ExpandSorts> expandSortsList;

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public List<ExpandSorts> getExpandSortsList() {
		return expandSortsList;
	}

	public void setExpandSortsList(List<ExpandSorts> expandSortsList) {
		this.expandSortsList = expandSortsList;
	}

	@Override
	public String toString() {
		return "ItemVO [type=" + type + ", expandSortsList=" + expandSortsList
				+ "]";
	}
	
	

}
