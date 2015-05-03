package com.twp.shopping.http.jd.model.union;

import java.io.Serializable;

public class CategoryName implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 8459082624822524546L;

	private String category_name;

	public String getCategory_name() {
		return category_name;
	}

	public void setCategory_name(String category_name) {
		this.category_name = category_name;
	}

	@Override
	public String toString() {
		return "CategoryName [category_name=" + category_name + "]";
	}
	
	
	
}
