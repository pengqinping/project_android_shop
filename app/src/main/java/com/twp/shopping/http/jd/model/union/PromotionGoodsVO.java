package com.twp.shopping.http.jd.model.union;

import java.io.Serializable;

public class PromotionGoodsVO implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -395214038085610614L;
//	推广商品列表 
	private JosGoodsVO goods_list; 
	private int total_count ;
	public JosGoodsVO getGoods_list() {
		return goods_list;
	}
	public void setGoods_list(JosGoodsVO goods_list) {
		this.goods_list = goods_list;
	}
	public int getTotal_count() {
		return total_count;
	}
	public void setTotal_count(int total_count) {
		this.total_count = total_count;
	}
	@Override
	public String toString() {
		return "PromotionGoodsVO [goods_list=" + goods_list + ", total_count="
				+ total_count + "]";
	}
	
	
	
}
