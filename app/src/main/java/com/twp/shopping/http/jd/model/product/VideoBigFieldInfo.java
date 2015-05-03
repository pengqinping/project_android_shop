package com.twp.shopping.http.jd.model.product;

import java.io.Serializable;

public class VideoBigFieldInfo implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -1408086372326068917L;

	/* 评论 */
	private String comments;
	/* 商品描述 */
	private String image;
	/* 内容简介 */
	private String contentDesc;
	/* 编辑推荐 */
	private String editerDesc;
	/* 目录 */
	private String catalogue;
	/* 包装清单 */
	private String box_Contents;
	/* 特殊说明 */
	private String material_Description;
	/* 说明书 */
	private String manual;
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
	public String getContentDesc() {
		return contentDesc;
	}
	public void setContentDesc(String contentDesc) {
		this.contentDesc = contentDesc;
	}
	public String getEditerDesc() {
		return editerDesc;
	}
	public void setEditerDesc(String editerDesc) {
		this.editerDesc = editerDesc;
	}
	public String getCatalogue() {
		return catalogue;
	}
	public void setCatalogue(String catalogue) {
		this.catalogue = catalogue;
	}
	public String getBox_Contents() {
		return box_Contents;
	}
	public void setBox_Contents(String box_Contents) {
		this.box_Contents = box_Contents;
	}
	public String getMaterial_Description() {
		return material_Description;
	}
	public void setMaterial_Description(String material_Description) {
		this.material_Description = material_Description;
	}
	public String getManual() {
		return manual;
	}
	public void setManual(String manual) {
		this.manual = manual;
	}
	@Override
	public String toString() {
		return "VideoBigFieldInfo [comments=" + comments + ", image=" + image
				+ ", contentDesc=" + contentDesc + ", editerDesc=" + editerDesc
				+ ", catalogue=" + catalogue + ", box_Contents=" + box_Contents
				+ ", material_Description=" + material_Description
				+ ", manual=" + manual + "]";
	}
	
	

}
