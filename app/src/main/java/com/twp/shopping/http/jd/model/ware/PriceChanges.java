package com.twp.shopping.http.jd.model.ware;

import java.io.Serializable;

public class PriceChanges implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -4648273893435728498L;
	private String sku_id;
	// J_100012
	// 商品编号
	private String price;
	// 66.00
	// 商品价格
	private String market_price;
	public String getSku_id() {
		return sku_id;
	}
	public void setSku_id(String sku_id) {
		this.sku_id = sku_id;
	}
	public String getPrice() {
		return price;
	}
	public void setPrice(String price) {
		this.price = price;
	}
	public String getMarket_price() {
		return market_price;
	}
	public void setMarket_price(String market_price) {
		this.market_price = market_price;
	}
	@Override
	public String toString() {
		return "PriceChanges [sku_id=" + sku_id + ", price=" + price
				+ ", market_price=" + market_price + "]";
	}

	// 市场价
	
	
}
