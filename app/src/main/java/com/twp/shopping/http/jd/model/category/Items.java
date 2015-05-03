package com.twp.shopping.http.jd.model.category;

import java.io.Serializable;
import java.util.List;

public class Items implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 3300161460058523343L;

	private List<ItemVO> items;

	private List<ItemVO2> items2;

	private String expandSortValueName;

	public List<ItemVO> getItems() {
		return items;
	}

	public void setItems(List<ItemVO> items) {
		this.items = items;
	}

	public List<ItemVO2> getItems2() {
		return items2;
	}

	public void setItems2(List<ItemVO2> items2) {
		this.items2 = items2;
	}

	public String getExpandSortValueName() {
		return expandSortValueName;
	}

	public void setExpandSortValueName(String expandSortValueName) {
		this.expandSortValueName = expandSortValueName;
	}

	@Override
	public String toString() {
		return "Items [items=" + items + ", items2=" + items2
				+ ", expandSortValueName=" + expandSortValueName + "]";
	}
	
	

}
