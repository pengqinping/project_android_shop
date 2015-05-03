package com.twp.shopping.http.jd.model.union;

import java.io.Serializable;

public class AdvDetailVo implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1445702270968894370L;

	private PromotionPlanVO promotion_plan;

	// 推广计划对象
	private PromotionShopVO promotion_shop;

	// 推广店铺对象
	private PromotionGoodsVO promotion_goods;

	// 推广商品对象
	private PromotionActivityVO promotion_activity;

	public PromotionPlanVO getPromotion_plan() {
		return promotion_plan;
	}

	public void setPromotion_plan(PromotionPlanVO promotion_plan) {
		this.promotion_plan = promotion_plan;
	}

	public PromotionShopVO getPromotion_shop() {
		return promotion_shop;
	}

	public void setPromotion_shop(PromotionShopVO promotion_shop) {
		this.promotion_shop = promotion_shop;
	}

	public PromotionGoodsVO getPromotion_goods() {
		return promotion_goods;
	}

	public void setPromotion_goods(PromotionGoodsVO promotion_goods) {
		this.promotion_goods = promotion_goods;
	}

	public PromotionActivityVO getPromotion_activity() {
		return promotion_activity;
	}

	public void setPromotion_activity(PromotionActivityVO promotion_activity) {
		this.promotion_activity = promotion_activity;
	}

	@Override
	public String toString() {
		return "AdvDetailVo [promotion_plan=" + promotion_plan
				+ ", promotion_shop=" + promotion_shop + ", promotion_goods="
				+ promotion_goods + ", promotion_activity="
				+ promotion_activity + "]";
	}

	// 推广活动对象

}
