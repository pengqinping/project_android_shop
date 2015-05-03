package com.twp.shopping.http.jd.model.union;

import java.io.Serializable;

//奇葩的京东 接口编码人员，你奶奶的，定义这么多不同的类型砸死啊。
//这个类的适合对象 ，一个T　一个int ,一个string,
public class ResultUnionListData<T> implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1381984236107390748L;

	private int totalCount;

	private boolean isDefault;

	private T resultListData;

	public int getTotalCount() {
		return totalCount;
	}

	public void setTotalCount(int totalCount) {
		this.totalCount = totalCount;
	}

	public boolean isDefault() {
		return isDefault;
	}

	public void setDefault(boolean isDefault) {
		this.isDefault = isDefault;
	}

	public T getResultListData() {
		return resultListData;
	}

	public void setResultListData(T resultListData) {
		this.resultListData = resultListData;
	}

	@Override
	public String toString() {
		return "ResultUnionListData [totalCount=" + totalCount + ", isDefault="
				+ isDefault + ", resultListData=" + resultListData + "]";
	}

}
