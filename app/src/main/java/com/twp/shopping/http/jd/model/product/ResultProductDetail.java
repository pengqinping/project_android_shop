package com.twp.shopping.http.jd.model.product;

import java.io.Serializable;
import java.util.List;

import com.twp.shopping.http.jd.model.ProductInfo;

public class ResultProductDetail implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -7820915401905157935L;

	private String resultCode;

	private ProductInfo productInfo;

	private List<ImagePaths> imagePaths;

	public String getResultCode() {
		return resultCode;
	}

	public void setResultCode(String resultCode) {
		this.resultCode = resultCode;
	}

	public ProductInfo getProductInfo() {
		return productInfo;
	}

	public void setProductInfo(ProductInfo productInfo) {
		this.productInfo = productInfo;
	}

	public List<ImagePaths> getImagePaths() {
		return imagePaths;
	}

	public void setImagePaths(List<ImagePaths> imagePaths) {
		this.imagePaths = imagePaths;
	}

	@Override
	public String toString() {
		return "ResultProductDetail [resultCode=" + resultCode
				+ ", productInfo=" + productInfo + ", imagePaths=" + imagePaths
				+ "]";
	}

}
