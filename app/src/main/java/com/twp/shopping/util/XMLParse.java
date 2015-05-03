/*
 * 文  件  名:  XMLParse.java
 * 创建日期:  2014-5-4/下午8:40:03
 * 版       权:  Royal.k.peng@gmail.com, All rights reserved
 * 作       者:  Royal
 * 座 右  铭:  Never give up, adhere to in the end.
 */
package com.twp.shopping.util;

import java.io.File;
import java.io.FileWriter;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.dom4j.Attribute;
import org.dom4j.Document;
import org.dom4j.DocumentException;
import org.dom4j.DocumentHelper;
import org.dom4j.Element;
import org.dom4j.io.OutputFormat;
import org.dom4j.io.SAXReader;
import org.dom4j.io.XMLWriter;

import com.twp.shopping.http.jd.model.product.Provinces;

/**
 * @Ctime 2014-5-4/下午8:40:03
 * @author Royal
 * @DESC
 */
public class XMLParse {

	public static int createProvicesXML(List<Provinces> provinces,
			String fileName) {
		/** 返回操作结果, 0表失败, 1表成功 */
		int returnValue = 0;
		if (provinces == null || provinces.size() < 1) {
			return returnValue;
		}
		/** 建立document对象 */
		Document document = DocumentHelper.createDocument();
		/** 建立XML文档的根provinces */
		Element provincesElement = document.addElement("provinces");
		/** 加入一行注释 */
		provincesElement
				.addComment("This is flash provinces ,not always to get from intent.");

		// 添加节点使用for循环
		for (int i = 0; i < provinces.size(); i++) {
			Element provinceElement = provincesElement.addElement("province");
			Provinces province = provinces.get(i);
			// 加入 label属性
			provinceElement.addAttribute("label", province.getLabel());
			// 加入 value 属性
			provinceElement.addAttribute("value", province.getValue());

		}
		try {
			OutputFormat outputFormat = new OutputFormat();
			outputFormat.setEncoding("utf-8");
			outputFormat.setIndent(false);
			outputFormat.setNewlines(true);
			outputFormat.setTrimText(true);
			/** 将document中的内容写入文件中 */
			File mFile = new File(fileName);
			mFile.setExecutable(true);
			mFile.setWritable(true);
			mFile.setReadable(true);
			XMLWriter writer = new XMLWriter(new FileWriter(mFile), outputFormat);
			writer.write(document);
			writer.close();
			/** 执行成功,需返回1 */
			returnValue = 1;
		} catch (Exception ex) {
			ex.printStackTrace();
		}

		return returnValue;

	}

	public static List<Provinces> parseProvicesXML(File file) {
		List<Provinces> resultProvinces = new ArrayList<Provinces>();
		SAXReader saxReader = new SAXReader();
		try {
			Document document = saxReader.read(file);

			// <provinces>跟节点标签
			Element provinces = document.getRootElement();

			// iterators of province
			Iterator<Element> itProvince = provinces
					.elementIterator("province");

			while (itProvince.hasNext()) {
				Element province = itProvince.next();
				Iterator itAttrOfProvince = province.attributeIterator();
				Provinces provice = new Provinces();
				while (itAttrOfProvince.hasNext()) {
					Attribute at = (Attribute) itAttrOfProvince.next();
					if (at.getName().equalsIgnoreCase("label")) {
						provice.setLabel(at.getText());
					}
					if (at.getName().equalsIgnoreCase("value")) {
						provice.setValue(at.getText());
					}
				}
				resultProvinces.add(provice);
			}
		} catch (DocumentException e) {
			e.printStackTrace();
		}
		return resultProvinces;
	}

}
