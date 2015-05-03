package com.twp.shopping.http.jd.model.union;

import java.io.Serializable;

public class CategoryCommision implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -1804986942683232665L;

	private int categoryLevel1Id;

	// 一级类目编号
	private int categoryLevel2Id;

	// 二级类目编号
	private int categoryLevel3Id;

	// 三级类目编号
	private String categoryLevel1Name;

	// 一级类目名称
	private String categoryLevel2Name;

	// 二级类目名称
	private String categoryLevel3Name;

	// 三级类目名称
	private int commisionRatioLevel2;

	// 二级类目佣金
	// 三级类目佣金
	private int commisionRatio;
	
	private int priceStart ;/*起始佣金比例范围*/
	public int getPriceStart() {
		return priceStart;
	}

	public void setPriceStart(int priceStart) {
		this.priceStart = priceStart;
	}

	public int getPriceEnd() {
		return priceEnd;
	}

	public void setPriceEnd(int priceEnd) {
		this.priceEnd = priceEnd;
	}

	private int priceEnd ;/*终止佣金比例范围*/

	public int getCategoryLevel1Id() {
		return categoryLevel1Id;
	}

	public void setCategoryLevel1Id(int categoryLevel1Id) {
		this.categoryLevel1Id = categoryLevel1Id;
	}

	public int getCategoryLevel2Id() {
		return categoryLevel2Id;
	}

	public void setCategoryLevel2Id(int categoryLevel2Id) {
		this.categoryLevel2Id = categoryLevel2Id;
	}

	public int getCategoryLevel3Id() {
		return categoryLevel3Id;
	}

	public void setCategoryLevel3Id(int categoryLevel3Id) {
		this.categoryLevel3Id = categoryLevel3Id;
	}

	public String getCategoryLevel1Name() {
		return categoryLevel1Name;
	}

	public void setCategoryLevel1Name(String categoryLevel1Name) {
		this.categoryLevel1Name = categoryLevel1Name;
	}

	public String getCategoryLevel2Name() {
		return categoryLevel2Name;
	}

	public void setCategoryLevel2Name(String categoryLevel2Name) {
		this.categoryLevel2Name = categoryLevel2Name;
	}

	public String getCategoryLevel3Name() {
		return categoryLevel3Name;
	}

	public void setCategoryLevel3Name(String categoryLevel3Name) {
		this.categoryLevel3Name = categoryLevel3Name;
	}

	public int getCommisionRatioLevel2() {
		return commisionRatioLevel2;
	}

	public void setCommisionRatioLevel2(int commisionRatioLevel2) {
		this.commisionRatioLevel2 = commisionRatioLevel2;
	}

	public int getCommisionRatio() {
		return commisionRatio;
	}

	public void setCommisionRatio(int commisionRatio) {
		this.commisionRatio = commisionRatio;
	}

	@Override
	public String toString() {
		return "CategoryCommision [categoryLevel1Id=" + categoryLevel1Id
				+ ", categoryLevel2Id=" + categoryLevel2Id
				+ ", categoryLevel3Id=" + categoryLevel3Id
				+ ", categoryLevel1Name=" + categoryLevel1Name
				+ ", categoryLevel2Name=" + categoryLevel2Name
				+ ", categoryLevel3Name=" + categoryLevel3Name
				+ ", commisionRatioLevel2=" + commisionRatioLevel2
				+ ", commisionRatio=" + commisionRatio + ", priceStart="
				+ priceStart + ", priceEnd=" + priceEnd + "]";
	}
	
	
	

}
