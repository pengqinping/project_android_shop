package com.twp.shopping.http.jd.model.product;

import java.io.Serializable;

public class Provinces implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -7792641436503120934L;

	private String value;
	private String label;
	public String getValue() {
		return value;
	}
	public void setValue(String value) {
		this.value = value;
	}
	public String getLabel() {
		return label;
	}
	public void setLabel(String label) {
		this.label = label;
	}
	@Override
	public String toString() {
		return "Provinces [value=" + value + ", label=" + label + "]";
	}
	
	
	
}
