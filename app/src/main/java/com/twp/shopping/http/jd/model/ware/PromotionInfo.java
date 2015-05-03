package com.twp.shopping.http.jd.model.ware;

import java.io.Serializable;
import java.util.List;

public class PromotionInfo implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -128160684579194529L;

	private String promoId;
	// 促销编号
	private int promoType;
	// 促销类型
	private int extType;
	// 单品扩展类型
	private int fullRefundType;

	// 满返满赠扩展类型
	private int userLevel;

	// 用户级别
	private int minNum;
	// 最小购买数
	private int maxNum;
	// 最大购买数
	private int limitUserType;
	// 是否为限购，4是限购
	private String price;
	// 京东价
	// (只有会员级别促销时，才有price返回值，如：铁牌及以上会员专享)
	private String discount;
	// 直降直降
	private String reward;
	// 返现
	private String addMoney;
	// 加价购所加的钱
	private String needMondey;
	// 参加满返满赠所需的金额
	private int needNum;
	// 参加满返满赠所需的商品数量
	private int deliverNum;
	// 参加满返满赠减N件最低价的阶梯数
	private String topMoney;
	// 每满返的封顶价
	private int percent;
	// 参加满返促销的返现百分比
	private int rebate;
	// 折扣
	private boolean haveFullRefundGifts;

	// 是满赠还是满减促销
	private int score;
	// 积分
	private int promoEndTime;
	// 促销结束时间
	private List<AdwordCoupon> adwordCouponList;
	// 券集合
	private List<AdwordGiftSku> adwordGiftSkuList;
	// 赠品集合
	public String getPromoId() {
		return promoId;
	}
	public void setPromoId(String promoId) {
		this.promoId = promoId;
	}
	public int getPromoType() {
		return promoType;
	}
	public void setPromoType(int promoType) {
		this.promoType = promoType;
	}
	public int getExtType() {
		return extType;
	}
	public void setExtType(int extType) {
		this.extType = extType;
	}
	public int getFullRefundType() {
		return fullRefundType;
	}
	public void setFullRefundType(int fullRefundType) {
		this.fullRefundType = fullRefundType;
	}
	public int getUserLevel() {
		return userLevel;
	}
	public void setUserLevel(int userLevel) {
		this.userLevel = userLevel;
	}
	public int getMinNum() {
		return minNum;
	}
	public void setMinNum(int minNum) {
		this.minNum = minNum;
	}
	public int getMaxNum() {
		return maxNum;
	}
	public void setMaxNum(int maxNum) {
		this.maxNum = maxNum;
	}
	public int getLimitUserType() {
		return limitUserType;
	}
	public void setLimitUserType(int limitUserType) {
		this.limitUserType = limitUserType;
	}
	public String getPrice() {
		return price;
	}
	public void setPrice(String price) {
		this.price = price;
	}
	public String getDiscount() {
		return discount;
	}
	public void setDiscount(String discount) {
		this.discount = discount;
	}
	public String getReward() {
		return reward;
	}
	public void setReward(String reward) {
		this.reward = reward;
	}
	public String getAddMoney() {
		return addMoney;
	}
	public void setAddMoney(String addMoney) {
		this.addMoney = addMoney;
	}
	public String getNeedMondey() {
		return needMondey;
	}
	public void setNeedMondey(String needMondey) {
		this.needMondey = needMondey;
	}
	public int getNeedNum() {
		return needNum;
	}
	public void setNeedNum(int needNum) {
		this.needNum = needNum;
	}
	public int getDeliverNum() {
		return deliverNum;
	}
	public void setDeliverNum(int deliverNum) {
		this.deliverNum = deliverNum;
	}
	public String getTopMoney() {
		return topMoney;
	}
	public void setTopMoney(String topMoney) {
		this.topMoney = topMoney;
	}
	public int getPercent() {
		return percent;
	}
	public void setPercent(int percent) {
		this.percent = percent;
	}
	public int getRebate() {
		return rebate;
	}
	public void setRebate(int rebate) {
		this.rebate = rebate;
	}
	public boolean isHaveFullRefundGifts() {
		return haveFullRefundGifts;
	}
	public void setHaveFullRefundGifts(boolean haveFullRefundGifts) {
		this.haveFullRefundGifts = haveFullRefundGifts;
	}
	public int getScore() {
		return score;
	}
	public void setScore(int score) {
		this.score = score;
	}
	public int getPromoEndTime() {
		return promoEndTime;
	}
	public void setPromoEndTime(int promoEndTime) {
		this.promoEndTime = promoEndTime;
	}
	public List<AdwordCoupon> getAdwordCouponList() {
		return adwordCouponList;
	}
	public void setAdwordCouponList(List<AdwordCoupon> adwordCouponList) {
		this.adwordCouponList = adwordCouponList;
	}
	public List<AdwordGiftSku> getAdwordGiftSkuList() {
		return adwordGiftSkuList;
	}
	public void setAdwordGiftSkuList(List<AdwordGiftSku> adwordGiftSkuList) {
		this.adwordGiftSkuList = adwordGiftSkuList;
	}
	@Override
	public String toString() {
		return "PromotionInfo [promoId=" + promoId + ", promoType=" + promoType
				+ ", extType=" + extType + ", fullRefundType=" + fullRefundType
				+ ", userLevel=" + userLevel + ", minNum=" + minNum
				+ ", maxNum=" + maxNum + ", limitUserType=" + limitUserType
				+ ", price=" + price + ", discount=" + discount + ", reward="
				+ reward + ", addMoney=" + addMoney + ", needMondey="
				+ needMondey + ", needNum=" + needNum + ", deliverNum="
				+ deliverNum + ", topMoney=" + topMoney + ", percent="
				+ percent + ", rebate=" + rebate + ", haveFullRefundGifts="
				+ haveFullRefundGifts + ", score=" + score + ", promoEndTime="
				+ promoEndTime + ", adwordCouponList=" + adwordCouponList
				+ ", adwordGiftSkuList=" + adwordGiftSkuList + "]";
	}
	
	

}
