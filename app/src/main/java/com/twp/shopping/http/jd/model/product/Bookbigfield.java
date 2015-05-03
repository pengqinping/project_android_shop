package com.twp.shopping.http.jd.model.product;

import java.io.Serializable;

public class Bookbigfield implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 5410209501953084756L;
	private String comments;
	// 媒体评论
	private String image;
	// 精彩文摘与插图（插图）
	private String content_desc;
	// 内容摘要（内容简介）
	private String relatedProducts;
	// 产品描述（相关商品）
	private String editer_desc;
	// 编辑推荐
	private String catalogue;
	// 目录
	private String book_abstract;
	// 精彩摘要（精彩书摘）
	private String authorDesc;
	// 作者简介
	private String introduction;

	// 前言（前言/序言）
	public String getComments() {
		return comments;
	}

	public void setComments(String comments) {
		this.comments = comments;
	}

	public String getImage() {
		return image;
	}

	public void setImage(String image) {
		this.image = image;
	}

	public String getContent_desc() {
		return content_desc;
	}

	public void setContent_desc(String content_desc) {
		this.content_desc = content_desc;
	}

	public String getRelatedProducts() {
		return relatedProducts;
	}

	public void setRelatedProducts(String relatedProducts) {
		this.relatedProducts = relatedProducts;
	}

	public String getEditer_desc() {
		return editer_desc;
	}

	public void setEditer_desc(String editer_desc) {
		this.editer_desc = editer_desc;
	}

	public String getCatalogue() {
		return catalogue;
	}

	public void setCatalogue(String catalogue) {
		this.catalogue = catalogue;
	}

	public String getBook_abstract() {
		return book_abstract;
	}

	public void setBook_abstract(String book_abstract) {
		this.book_abstract = book_abstract;
	}

	public String getAuthorDesc() {
		return authorDesc;
	}

	public void setAuthorDesc(String authorDesc) {
		this.authorDesc = authorDesc;
	}

	public String getIntroduction() {
		return introduction;
	}

	public void setIntroduction(String introduction) {
		this.introduction = introduction;
	}

	@Override
	public String toString() {
		return "Bookbigfield [comments=" + comments + ", image=" + image
				+ ", content_desc=" + content_desc + ", relatedProducts="
				+ relatedProducts + ", editer_desc=" + editer_desc
				+ ", catalogue=" + catalogue + ", book_abstract="
				+ book_abstract + ", authorDesc=" + authorDesc
				+ ", introduction=" + introduction + "]";
	}

}
