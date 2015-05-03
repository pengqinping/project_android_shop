package com.twp.shopping.http.jd.model;

import java.io.Serializable;

public class ProductBase implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 9026754693625208544L;

	/* 500200 skus编码 */
	private int sku_id;
	/* 否 雅诗兰黛紧致眼霜 sku名称 */
	private String name;
	/*
	 * 否
	 * http://img13.360buyimg.com/n1/3013/3c478d95-bfae-4776-b962-f866033580b0.
	 * jpg sku主图地址
	 */
	private String image_path;
	/* 否 0、下柜，1、上柜，2、可上柜（基本信息完备，采销没有正式上柜），10、POPSKU删除 上下柜状态 */
	private int state;
	/* 否 0无效，1有效 是否有效 */
	private int is_delete;
	/* 否 雅诗兰黛 品牌名称 */
	private String brand_name;
	/* 否 单位：千克 高精度重量,double类型 */
	private String value_weight;
	/* 否 单位：毫米 长 */
	private int length;
	/* 否 单位：毫米 宽 */
	private int width;
	/* 否 单位：毫米 高 */
	private int height;
	/* 否 0否，1是 是否在线支付商品 */
	private int value_pay_first;
	/*
	 * 否
	 * 单位：千克,因JOS平台对double类型的处理上是给默认值，所以每次请求其他参数时（如name），也会返回weight：0。不是接口原因，请忽略此状况
	 * 重量
	 */
	private double weigh;
	/* 否 0 商品的第二分类(3级) */
	private int cid2;
	/* 否 北京 商品产地 */
	private String product_area;
	/* 否 如果当前商品状态是上柜，saleDate为上柜日期；反之为下柜日期 上下柜日期 */
	private String sale_date;
	/* 无、无质保、1年质保、3年质保 质保 */
	private String wserve;
	/* 0、未设置标签，1、新品，2、热卖 图片标签 默认0 没有标签 */
	private int allnum;
	/* 11516 新品牌id */
	private int brand_id;
	/* 灰色 颜色 */
	private String colo;
	/* 0 颜色顺序 */
	private int color_sequence;
	/* 175/96A/M 尺码 */
	private String size;
	/* 0 尺码顺序 */
	private int size_sequence;
	/* 21hz 品牌英文名称 */
	private String ebrand;
	/* 21赫兹 品牌中文名称 */
	private String cbrand;
	/* 12支装 型号 */
	private String model;
	/* 652;654;833 分类信息，格式为：一级分类；二级分类；三级分类 */
	private String category;

	public static final String attrNames = "sku_id,name,image_path,state,is_delete,brand_name,value_weight,length,width,value_pay_first,weigh,cid2,product_area,sale_date,wserve,allnum,brand_id,colo,color_sequence,size,size_sequence,ebrand,cbrand,model,category";

	public int getSku_id() {
		return sku_id;
	}

	public void setSku_id(int sku_id) {
		this.sku_id = sku_id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getImage_path() {
		return image_path;
	}

	public void setImage_path(String image_path) {
		this.image_path = image_path;
	}

	public int getState() {
		return state;
	}

	public void setState(int state) {
		this.state = state;
	}

	public int getIs_delete() {
		return is_delete;
	}

	public void setIs_delete(int is_delete) {
		this.is_delete = is_delete;
	}

	public String getBrand_name() {
		return brand_name;
	}

	public void setBrand_name(String brand_name) {
		this.brand_name = brand_name;
	}

	public String getValue_weight() {
		return value_weight;
	}

	public void setValue_weight(String value_weight) {
		this.value_weight = value_weight;
	}

	public int getLength() {
		return length;
	}

	public void setLength(int length) {
		this.length = length;
	}

	public int getWidth() {
		return width;
	}

	public void setWidth(int width) {
		this.width = width;
	}

	public int getHeight() {
		return height;
	}

	public void setHeight(int height) {
		this.height = height;
	}

	public int getValue_pay_first() {
		return value_pay_first;
	}

	public void setValue_pay_first(int value_pay_first) {
		this.value_pay_first = value_pay_first;
	}

	public double getWeigh() {
		return weigh;
	}

	public void setWeigh(double weigh) {
		this.weigh = weigh;
	}

	public int getCid2() {
		return cid2;
	}

	public void setCid2(int cid2) {
		this.cid2 = cid2;
	}

	public String getProduct_area() {
		return product_area;
	}

	public void setProduct_area(String product_area) {
		this.product_area = product_area;
	}

	public String getSale_date() {
		return sale_date;
	}

	public void setSale_date(String sale_date) {
		this.sale_date = sale_date;
	}

	public String getWserve() {
		return wserve;
	}

	public void setWserve(String wserve) {
		this.wserve = wserve;
	}

	public int getAllnum() {
		return allnum;
	}

	public void setAllnum(int allnum) {
		this.allnum = allnum;
	}

	public int getBrand_id() {
		return brand_id;
	}

	public void setBrand_id(int brand_id) {
		this.brand_id = brand_id;
	}

	public String getColo() {
		return colo;
	}

	public void setColo(String colo) {
		this.colo = colo;
	}

	public int getColor_sequence() {
		return color_sequence;
	}

	public void setColor_sequence(int color_sequence) {
		this.color_sequence = color_sequence;
	}

	public String getSize() {
		return size;
	}

	public void setSize(String size) {
		this.size = size;
	}

	public int getSize_sequence() {
		return size_sequence;
	}

	public void setSize_sequence(int size_sequence) {
		this.size_sequence = size_sequence;
	}

	public String getEbrand() {
		return ebrand;
	}

	public void setEbrand(String ebrand) {
		this.ebrand = ebrand;
	}

	public String getCbrand() {
		return cbrand;
	}

	public void setCbrand(String cbrand) {
		this.cbrand = cbrand;
	}

	public String getModel() {
		return model;
	}

	public void setModel(String model) {
		this.model = model;
	}

	public String getCategory() {
		return category;
	}

	public void setCategory(String category) {
		this.category = category;
	}

	@Override
	public String toString() {
		return "ProductBase [sku_id=" + sku_id + ", name=" + name
				+ ", image_path=" + image_path + ", state=" + state
				+ ", is_delete=" + is_delete + ", brand_name=" + brand_name
				+ ", value_weight=" + value_weight + ", length=" + length
				+ ", width=" + width + ", height=" + height
				+ ", value_pay_first=" + value_pay_first + ", weigh=" + weigh
				+ ", cid2=" + cid2 + ", product_area=" + product_area
				+ ", sale_date=" + sale_date + ", wserve=" + wserve
				+ ", allnum=" + allnum + ", brand_id=" + brand_id + ", colo="
				+ colo + ", color_sequence=" + color_sequence + ", size="
				+ size + ", size_sequence=" + size_sequence + ", ebrand="
				+ ebrand + ", cbrand=" + cbrand + ", model=" + model
				+ ", category=" + category + "]";
	}

}
