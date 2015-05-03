package com.twp.shopping.http.jd.model.union;

import java.io.Serializable;

public class ZoneCode implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -6862507933959300970L;

	private String zone_code;

	public String getZone_code() {
		return zone_code;
	}

	public void setZone_code(String zone_code) {
		this.zone_code = zone_code;
	}

	@Override
	public String toString() {
		return "ZoneCode [zone_code=" + zone_code + "]";
	}
	
	
	
}
