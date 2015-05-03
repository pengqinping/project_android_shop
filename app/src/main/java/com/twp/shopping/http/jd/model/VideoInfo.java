package com.twp.shopping.http.jd.model;

import java.io.Serializable;

public class VideoInfo implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -7316548718059091494L;

	private String sid;
	/* 音像编号 */
	private String aka;
	/* 又名 */
	private int first_category;
	/* 1713为图书、4051、4052、4053是音像 一级分类 */
	private String brand;
	/* 品牌 */
	private String foreignname;
	/* 外文名 */
	private String isbn;
	/* isbn */
	private String barcode;
	/* 条形码 */
	private String mvd_wxjz;
	/* 文像进字 */
	private String mvd_gqyz;
	/* 国权音字 */
	private String mvd_wyjz;
	/* 文音进字 */
	private String isrc;
	/* isrc */
	private String mvd_dcz;
	/* 电出字 */
	private String mvd_xcyg;
	/* 新出音管 */
	private String press;
	/* 出版社 */
	private String publishing_company;
	/* 发行公司 */
	private String production_company;
	/* 出品公司 */
	private String copyright;
	/* 版权提供 */
	private String actor;
	/* 演员 */
	private String director;
	/* 导演 */
	private String dub;
	/* 配音 */
	private String voiceover;
	/* 解说者 */
	private String screenwriter;
	/* 编剧 */
	private String producer;
	/* 监制 */
	private String singer;
	/* 演唱者 */
	private String performer;
	/* 演奏者 */
	private String authors;
	/* 作词 */
	private String compose;
	/* 作曲 */
	private String command;
	/* 指挥 */
	private String orchestra;
	/* 知名乐团 */
	private String media;
	/* 介质 */
	private int soundtrack;
	/* 碟数 */
	private int number_of_discs;
	/* 碟片数 */
	private int episode;
	/* 集数 */
	private int record_number;
	/* 唱片数量 */
	private String publication_date;
	/* 出版日期 */
	private String release_date;
	/* 上映日期 */
	private String accessories;
	/* 附件 */
	private int included_additional_item;
	/* 附件数量 */
	private int set_the_number_of;
	/* 套装数量 */
	private String format;
	/* 格式 */
	private String color;
	/* 色差 */
	private String region;
	/* 区码 */
	private String length;
	/* 片长 */
	private String screen_ratio;
	/* 屏幕比例 */
	private String audio_encoding_chinese;
	/* 音频格式 */
	private String quality_description;
	/* 品质说明 */
	private String dregion;
	/* 地区 */
	private String language;
	/* 图书语言 */
	private String language_dubbed;
	/* 配音语言 */
	private String language_subtitled;
	/* 字幕语言 */
	private String version_language;
	/* 版本语言 */
	private String language_pronunciation;
	/* 发音语言 */
	private String menu_language;
	/* 菜单语言 */
	private String version;
	/* 版本 */
	private String type;
	/* 类型 */
	private String platform;
	/* 操作系统 */
	private String minimum_system_requirement_description;
	/* 最低配置要求 */
	private String recommended_system_description;
	/* 推荐配置要求 */
	private String online_play_description;
	/* 在线游戏 */
	private String awards;
	/* 获奖情况 */
	private String type_keywords;
	/* 商品类型关键词 */
	private String keywords;
	/* 主题词 */
	private String readers;
	/* 读者对象 */
	private String number_of_players;
	/* 游戏人员数量 */
	private int mfg_minimum;
	/* 最小年龄 */
	private int mfg_maximum;
	/* 最大年龄 */
	private String compile;
	/* 编纂 */
	private String photography;
	/* 摄影 */
	private String dictation;
	/* 口述 */
	private String read;
	/* 朗读 */
	private String finishing;
	/* 整理 */
	private String write;
	/* 书写 */
	public String getSid() {
		return sid;
	}
	public void setSid(String sid) {
		this.sid = sid;
	}
	public String getAka() {
		return aka;
	}
	public void setAka(String aka) {
		this.aka = aka;
	}
	public int getFirst_category() {
		return first_category;
	}
	public void setFirst_category(int first_category) {
		this.first_category = first_category;
	}
	public String getBrand() {
		return brand;
	}
	public void setBrand(String brand) {
		this.brand = brand;
	}
	public String getForeignname() {
		return foreignname;
	}
	public void setForeignname(String foreignname) {
		this.foreignname = foreignname;
	}
	public String getIsbn() {
		return isbn;
	}
	public void setIsbn(String isbn) {
		this.isbn = isbn;
	}
	public String getBarcode() {
		return barcode;
	}
	public void setBarcode(String barcode) {
		this.barcode = barcode;
	}
	public String getMvd_wxjz() {
		return mvd_wxjz;
	}
	public void setMvd_wxjz(String mvd_wxjz) {
		this.mvd_wxjz = mvd_wxjz;
	}
	public String getMvd_gqyz() {
		return mvd_gqyz;
	}
	public void setMvd_gqyz(String mvd_gqyz) {
		this.mvd_gqyz = mvd_gqyz;
	}
	public String getMvd_wyjz() {
		return mvd_wyjz;
	}
	public void setMvd_wyjz(String mvd_wyjz) {
		this.mvd_wyjz = mvd_wyjz;
	}
	public String getIsrc() {
		return isrc;
	}
	public void setIsrc(String isrc) {
		this.isrc = isrc;
	}
	public String getMvd_dcz() {
		return mvd_dcz;
	}
	public void setMvd_dcz(String mvd_dcz) {
		this.mvd_dcz = mvd_dcz;
	}
	public String getMvd_xcyg() {
		return mvd_xcyg;
	}
	public void setMvd_xcyg(String mvd_xcyg) {
		this.mvd_xcyg = mvd_xcyg;
	}
	public String getPress() {
		return press;
	}
	public void setPress(String press) {
		this.press = press;
	}
	public String getPublishing_company() {
		return publishing_company;
	}
	public void setPublishing_company(String publishing_company) {
		this.publishing_company = publishing_company;
	}
	public String getProduction_company() {
		return production_company;
	}
	public void setProduction_company(String production_company) {
		this.production_company = production_company;
	}
	public String getCopyright() {
		return copyright;
	}
	public void setCopyright(String copyright) {
		this.copyright = copyright;
	}
	public String getActor() {
		return actor;
	}
	public void setActor(String actor) {
		this.actor = actor;
	}
	public String getDirector() {
		return director;
	}
	public void setDirector(String director) {
		this.director = director;
	}
	public String getDub() {
		return dub;
	}
	public void setDub(String dub) {
		this.dub = dub;
	}
	public String getVoiceover() {
		return voiceover;
	}
	public void setVoiceover(String voiceover) {
		this.voiceover = voiceover;
	}
	public String getScreenwriter() {
		return screenwriter;
	}
	public void setScreenwriter(String screenwriter) {
		this.screenwriter = screenwriter;
	}
	public String getProducer() {
		return producer;
	}
	public void setProducer(String producer) {
		this.producer = producer;
	}
	public String getSinger() {
		return singer;
	}
	public void setSinger(String singer) {
		this.singer = singer;
	}
	public String getPerformer() {
		return performer;
	}
	public void setPerformer(String performer) {
		this.performer = performer;
	}
	public String getAuthors() {
		return authors;
	}
	public void setAuthors(String authors) {
		this.authors = authors;
	}
	public String getCompose() {
		return compose;
	}
	public void setCompose(String compose) {
		this.compose = compose;
	}
	public String getCommand() {
		return command;
	}
	public void setCommand(String command) {
		this.command = command;
	}
	public String getOrchestra() {
		return orchestra;
	}
	public void setOrchestra(String orchestra) {
		this.orchestra = orchestra;
	}
	public String getMedia() {
		return media;
	}
	public void setMedia(String media) {
		this.media = media;
	}
	public int getSoundtrack() {
		return soundtrack;
	}
	public void setSoundtrack(int soundtrack) {
		this.soundtrack = soundtrack;
	}
	public int getNumber_of_discs() {
		return number_of_discs;
	}
	public void setNumber_of_discs(int number_of_discs) {
		this.number_of_discs = number_of_discs;
	}
	public int getEpisode() {
		return episode;
	}
	public void setEpisode(int episode) {
		this.episode = episode;
	}
	public int getRecord_number() {
		return record_number;
	}
	public void setRecord_number(int record_number) {
		this.record_number = record_number;
	}
	public String getPublication_date() {
		return publication_date;
	}
	public void setPublication_date(String publication_date) {
		this.publication_date = publication_date;
	}
	public String getRelease_date() {
		return release_date;
	}
	public void setRelease_date(String release_date) {
		this.release_date = release_date;
	}
	public String getAccessories() {
		return accessories;
	}
	public void setAccessories(String accessories) {
		this.accessories = accessories;
	}
	public int getIncluded_additional_item() {
		return included_additional_item;
	}
	public void setIncluded_additional_item(int included_additional_item) {
		this.included_additional_item = included_additional_item;
	}
	public int getSet_the_number_of() {
		return set_the_number_of;
	}
	public void setSet_the_number_of(int set_the_number_of) {
		this.set_the_number_of = set_the_number_of;
	}
	public String getFormat() {
		return format;
	}
	public void setFormat(String format) {
		this.format = format;
	}
	public String getColor() {
		return color;
	}
	public void setColor(String color) {
		this.color = color;
	}
	public String getRegion() {
		return region;
	}
	public void setRegion(String region) {
		this.region = region;
	}
	public String getLength() {
		return length;
	}
	public void setLength(String length) {
		this.length = length;
	}
	public String getScreen_ratio() {
		return screen_ratio;
	}
	public void setScreen_ratio(String screen_ratio) {
		this.screen_ratio = screen_ratio;
	}
	public String getAudio_encoding_chinese() {
		return audio_encoding_chinese;
	}
	public void setAudio_encoding_chinese(String audio_encoding_chinese) {
		this.audio_encoding_chinese = audio_encoding_chinese;
	}
	public String getQuality_description() {
		return quality_description;
	}
	public void setQuality_description(String quality_description) {
		this.quality_description = quality_description;
	}
	public String getDregion() {
		return dregion;
	}
	public void setDregion(String dregion) {
		this.dregion = dregion;
	}
	public String getLanguage() {
		return language;
	}
	public void setLanguage(String language) {
		this.language = language;
	}
	public String getLanguage_dubbed() {
		return language_dubbed;
	}
	public void setLanguage_dubbed(String language_dubbed) {
		this.language_dubbed = language_dubbed;
	}
	public String getLanguage_subtitled() {
		return language_subtitled;
	}
	public void setLanguage_subtitled(String language_subtitled) {
		this.language_subtitled = language_subtitled;
	}
	public String getVersion_language() {
		return version_language;
	}
	public void setVersion_language(String version_language) {
		this.version_language = version_language;
	}
	public String getLanguage_pronunciation() {
		return language_pronunciation;
	}
	public void setLanguage_pronunciation(String language_pronunciation) {
		this.language_pronunciation = language_pronunciation;
	}
	public String getMenu_language() {
		return menu_language;
	}
	public void setMenu_language(String menu_language) {
		this.menu_language = menu_language;
	}
	public String getVersion() {
		return version;
	}
	public void setVersion(String version) {
		this.version = version;
	}
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
	public String getPlatform() {
		return platform;
	}
	public void setPlatform(String platform) {
		this.platform = platform;
	}
	public String getMinimum_system_requirement_description() {
		return minimum_system_requirement_description;
	}
	public void setMinimum_system_requirement_description(
			String minimum_system_requirement_description) {
		this.minimum_system_requirement_description = minimum_system_requirement_description;
	}
	public String getRecommended_system_description() {
		return recommended_system_description;
	}
	public void setRecommended_system_description(
			String recommended_system_description) {
		this.recommended_system_description = recommended_system_description;
	}
	public String getOnline_play_description() {
		return online_play_description;
	}
	public void setOnline_play_description(String online_play_description) {
		this.online_play_description = online_play_description;
	}
	public String getAwards() {
		return awards;
	}
	public void setAwards(String awards) {
		this.awards = awards;
	}
	public String getType_keywords() {
		return type_keywords;
	}
	public void setType_keywords(String type_keywords) {
		this.type_keywords = type_keywords;
	}
	public String getKeywords() {
		return keywords;
	}
	public void setKeywords(String keywords) {
		this.keywords = keywords;
	}
	public String getReaders() {
		return readers;
	}
	public void setReaders(String readers) {
		this.readers = readers;
	}
	public String getNumber_of_players() {
		return number_of_players;
	}
	public void setNumber_of_players(String number_of_players) {
		this.number_of_players = number_of_players;
	}
	public int getMfg_minimum() {
		return mfg_minimum;
	}
	public void setMfg_minimum(int mfg_minimum) {
		this.mfg_minimum = mfg_minimum;
	}
	public int getMfg_maximum() {
		return mfg_maximum;
	}
	public void setMfg_maximum(int mfg_maximum) {
		this.mfg_maximum = mfg_maximum;
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
		return "VideoInfo [sid=" + sid + ", aka=" + aka + ", first_category="
				+ first_category + ", brand=" + brand + ", foreignname="
				+ foreignname + ", isbn=" + isbn + ", barcode=" + barcode
				+ ", mvd_wxjz=" + mvd_wxjz + ", mvd_gqyz=" + mvd_gqyz
				+ ", mvd_wyjz=" + mvd_wyjz + ", isrc=" + isrc + ", mvd_dcz="
				+ mvd_dcz + ", mvd_xcyg=" + mvd_xcyg + ", press=" + press
				+ ", publishing_company=" + publishing_company
				+ ", production_company=" + production_company + ", copyright="
				+ copyright + ", actor=" + actor + ", director=" + director
				+ ", dub=" + dub + ", voiceover=" + voiceover
				+ ", screenwriter=" + screenwriter + ", producer=" + producer
				+ ", singer=" + singer + ", performer=" + performer
				+ ", authors=" + authors + ", compose=" + compose
				+ ", command=" + command + ", orchestra=" + orchestra
				+ ", media=" + media + ", soundtrack=" + soundtrack
				+ ", number_of_discs=" + number_of_discs + ", episode="
				+ episode + ", record_number=" + record_number
				+ ", publication_date=" + publication_date + ", release_date="
				+ release_date + ", accessories=" + accessories
				+ ", included_additional_item=" + included_additional_item
				+ ", set_the_number_of=" + set_the_number_of + ", format="
				+ format + ", color=" + color + ", region=" + region
				+ ", length=" + length + ", screen_ratio=" + screen_ratio
				+ ", audio_encoding_chinese=" + audio_encoding_chinese
				+ ", quality_description=" + quality_description + ", dregion="
				+ dregion + ", language=" + language + ", language_dubbed="
				+ language_dubbed + ", language_subtitled="
				+ language_subtitled + ", version_language=" + version_language
				+ ", language_pronunciation=" + language_pronunciation
				+ ", menu_language=" + menu_language + ", version=" + version
				+ ", type=" + type + ", platform=" + platform
				+ ", minimum_system_requirement_description="
				+ minimum_system_requirement_description
				+ ", recommended_system_description="
				+ recommended_system_description + ", online_play_description="
				+ online_play_description + ", awards=" + awards
				+ ", type_keywords=" + type_keywords + ", keywords=" + keywords
				+ ", readers=" + readers + ", number_of_players="
				+ number_of_players + ", mfg_minimum=" + mfg_minimum
				+ ", mfg_maximum=" + mfg_maximum + ", compile=" + compile
				+ ", photography=" + photography + ", dictation=" + dictation
				+ ", read=" + read + ", finishing=" + finishing + ", write="
				+ write + "]";
	}
	
	

}
