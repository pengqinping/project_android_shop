package com.twp.shopping.http.jd.model.union;

import java.io.Serializable;

public class PromotionActivityVO implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -939959554803590169L;
	private JosActivityImgVO activity_list;

	// 活动列表
	private int total_count;

	public JosActivityImgVO getActivity_list() {
		return activity_list;
	}

	public void setActivity_list(JosActivityImgVO activity_list) {
		this.activity_list = activity_list;
	}

	public int getTotal_count() {
		return total_count;
	}

	public void setTotal_count(int total_count) {
		this.total_count = total_count;
	}

	@Override
	public String toString() {
		return "PromotionActivityVO [activity_list=" + activity_list
				+ ", total_count=" + total_count + "]";
	}
	
	

}
