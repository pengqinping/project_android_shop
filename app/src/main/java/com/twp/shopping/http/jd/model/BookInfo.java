package com.twp.shopping.http.jd.model;

import java.io.Serializable;

public class BookInfo implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1827317983665397999L;

	private String id;
	/* 图书编号 */
	private int first_category;
	// 1713为图书、4051、4052、4053是音像 一级分类
	private String isbn;
	// isbn
	private String issn;
	// issn
	private String book_name;
	// 营销书名
	private String foreign_book_name;
	// 外文书名
	private String language;
	// 图书语言
	private String author;
	// 作者
	private String editer;
	// 编者
	private String proofreader;
	// 校对
	private String remarker;
	// 注释
	private String transfer;
	// 译者
	private String drawer;
	// 绘者
	private String publishers;
	// 出版社
	private String publish_no;
	// 出版社号
	private String series;
	// 丛书名
	private String brand;
	// 品牌
	private String format;
	// 格式
	private String packages;
	// 包装
	private String pages;
	// 页数
	private String batch_no;
	// 版次
	private String publish_time;
	// 出版时间
	private int print_no;
	// 印次
	private String print_time;
	// 印刷时间
	private String size_and_height;
	// 尺寸及重量
	private String china_catalog;
	// 中国法分类号
	private String sheet;
	// 印张
	private String papers;
	// 用纸
	private String attachment;
	// 附件
	private int attachment_num;
	// 附件数量
	private int pack_num;
	// 套装数量
	private int letters;
	// 字数
	private String bar_code;
	// 条形码
	private String keywords;
	// 主题词
	private String pick_state;
	// 捡货标记
	private String compile;
	// 编纂
	private String photography;
	// 摄影
	private String dictation;
	// 口述
	private String read;
	// 朗读
	private String finishing;
	// 整理
	private String write;

	// 书写
	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public int getFirst_category() {
		return first_category;
	}

	public void setFirst_category(int first_category) {
		this.first_category = first_category;
	}

	public String getIsbn() {
		return isbn;
	}

	public void setIsbn(String isbn) {
		this.isbn = isbn;
	}

	public String getIssn() {
		return issn;
	}

	public void setIssn(String issn) {
		this.issn = issn;
	}

	public String getBook_name() {
		return book_name;
	}

	public void setBook_name(String book_name) {
		this.book_name = book_name;
	}

	public String getForeign_book_name() {
		return foreign_book_name;
	}

	public void setForeign_book_name(String foreign_book_name) {
		this.foreign_book_name = foreign_book_name;
	}

	public String getLanguage() {
		return language;
	}

	public void setLanguage(String language) {
		this.language = language;
	}

	public String getAuthor() {
		return author;
	}

	public void setAuthor(String author) {
		this.author = author;
	}

	public String getEditer() {
		return editer;
	}

	public void setEditer(String editer) {
		this.editer = editer;
	}

	public String getProofreader() {
		return proofreader;
	}

	public void setProofreader(String proofreader) {
		this.proofreader = proofreader;
	}

	public String getRemarker() {
		return remarker;
	}

	public void setRemarker(String remarker) {
		this.remarker = remarker;
	}

	public String getTransfer() {
		return transfer;
	}

	public void setTransfer(String transfer) {
		this.transfer = transfer;
	}

	public String getDrawer() {
		return drawer;
	}

	public void setDrawer(String drawer) {
		this.drawer = drawer;
	}

	public String getPublishers() {
		return publishers;
	}

	public void setPublishers(String publishers) {
		this.publishers = publishers;
	}

	public String getPublish_no() {
		return publish_no;
	}

	public void setPublish_no(String publish_no) {
		this.publish_no = publish_no;
	}

	public String getSeries() {
		return series;
	}

	public void setSeries(String series) {
		this.series = series;
	}

	public String getBrand() {
		return brand;
	}

	public void setBrand(String brand) {
		this.brand = brand;
	}

	public String getFormat() {
		return format;
	}

	public void setFormat(String format) {
		this.format = format;
	}

	public String getPackages() {
		return packages;
	}

	public void setPackages(String packages) {
		this.packages = packages;
	}

	public String getPages() {
		return pages;
	}

	public void setPages(String pages) {
		this.pages = pages;
	}

	public String getBatch_no() {
		return batch_no;
	}

	public void setBatch_no(String batch_no) {
		this.batch_no = batch_no;
	}

	public String getPublish_time() {
		return publish_time;
	}

	public void setPublish_time(String publish_time) {
		this.publish_time = publish_time;
	}

	public int getPrint_no() {
		return print_no;
	}

	public void setPrint_no(int print_no) {
		this.print_no = print_no;
	}

	public String getPrint_time() {
		return print_time;
	}

	public void setPrint_time(String print_time) {
		this.print_time = print_time;
	}

	public String getSize_and_height() {
		return size_and_height;
	}

	public void setSize_and_height(String size_and_height) {
		this.size_and_height = size_and_height;
	}

	public String getChina_catalog() {
		return china_catalog;
	}

	public void setChina_catalog(String china_catalog) {
		this.china_catalog = china_catalog;
	}

	public String getSheet() {
		return sheet;
	}

	public void setSheet(String sheet) {
		this.sheet = sheet;
	}

	public String getPapers() {
		return papers;
	}

	public void setPapers(String papers) {
		this.papers = papers;
	}

	public String getAttachment() {
		return attachment;
	}

	public void setAttachment(String attachment) {
		this.attachment = attachment;
	}

	public int getAttachment_num() {
		return attachment_num;
	}

	public void setAttachment_num(int attachment_num) {
		this.attachment_num = attachment_num;
	}

	public int getPack_num() {
		return pack_num;
	}

	public void setPack_num(int pack_num) {
		this.pack_num = pack_num;
	}

	public int getLetters() {
		return letters;
	}

	public void setLetters(int letters) {
		this.letters = letters;
	}

	public String getBar_code() {
		return bar_code;
	}

	public void setBar_code(String bar_code) {
		this.bar_code = bar_code;
	}

	public String getKeywords() {
		return keywords;
	}

	public void setKeywords(String keywords) {
		this.keywords = keywords;
	}

	public String getPick_state() {
		return pick_state;
	}

	public void setPick_state(String pick_state) {
		this.pick_state = pick_state;
	}

	public String getCompile() {
		return compile;
	}

	public void setCompile(String compile) {
		this.compile = compile;
	}

	public String getPhotography() {
		return photography;
	}

	public void setPhotography(String photography) {
		this.photography = photography;
	}

	public String getDictation() {
		return dictation;
	}

	public void setDictation(String dictation) {
		this.dictation = dictation;
	}

	public String getRead() {
		return read;
	}

	public void setRead(String read) {
		this.read = read;
	}

	public String getFinishing() {
		return finishing;
	}

	public void setFinishing(String finishing) {
		this.finishing = finishing;
	}

	public String getWrite() {
		return write;
	}

	public void setWrite(String write) {
		this.write = write;
	}

	@Override
	public String toString() {
		return "BookInfo [id=" + id + ", first_category=" + first_category
				+ ", isbn=" + isbn + ", issn=" + issn + ", book_name="
				+ book_name + ", foreign_book_name=" + foreign_book_name
				+ ", language=" + language + ", author=" + author + ", editer="
				+ editer + ", proofreader=" + proofreader + ", remarker="
				+ remarker + ", transfer=" + transfer + ", drawer=" + drawer
				+ ", publishers=" + publishers + ", publish_no=" + publish_no
				+ ", series=" + series + ", brand=" + brand + ", format="
				+ format + ", packages=" + packages + ", pages=" + pages
				+ ", batch_no=" + batch_no + ", publish_time=" + publish_time
				+ ", print_no=" + print_no + ", print_time=" + print_time
				+ ", size_and_height=" + size_and_height + ", china_catalog="
				+ china_catalog + ", sheet=" + sheet + ", papers=" + papers
				+ ", attachment=" + attachment + ", attachment_num="
				+ attachment_num + ", pack_num=" + pack_num + ", letters="
				+ letters + ", bar_code=" + bar_code + ", keywords=" + keywords
				+ ", pick_state=" + pick_state + ", compile=" + compile
				+ ", photography=" + photography + ", dictation=" + dictation
				+ ", read=" + read + ", finishing=" + finishing + ", write="
				+ write + "]";
	}

}
