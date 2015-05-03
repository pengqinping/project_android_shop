package com.twp.shopping.http.jd.model.category;

import java.io.Serializable;
import java.util.List;

public class ItemVO2 implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -8172968445242974457L;

	private List<ExpandSorts> expandSortsList2;

	public List<ExpandSorts> getExpandSortsList2() {
		return expandSortsList2;
	}

	public void setExpandSortsList2(List<ExpandSorts> expandSortsList2) {
		this.expandSortsList2 = expandSortsList2;
	}

	@Override
	public String toString() {
		return "ItemVO2 [expandSortsList2=" + expandSortsList2 + "]";
	}
	
	
	
}
