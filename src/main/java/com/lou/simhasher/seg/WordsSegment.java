/**
 *  Copyright (c)  2011-2020 Panguso, Inc.
 *  All rights reserved.
 *
 *  This software is the confidential and proprietary information of Panguso, 
 *  Inc. ("Confidential Information"). You shall not
 *  disclose such Confidential Information and shall use it only in
 *  accordance with the terms of the license agreement you entered into with Panguso.
 */
package com.lou.simhasher.seg;

import java.io.IOException;
import java.io.Reader;
import java.io.StringReader;
import java.util.ArrayList;
import java.util.List;

import org.apache.lucene.analysis.Analyzer;
import org.apache.lucene.analysis.TokenStream;
import org.apache.lucene.analysis.tokenattributes.CharTermAttribute;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.wltea.analyzer.lucene.IKAnalyzer;

/**
 * 文档分词
 * 
 * @author louxuezheng@hotmail.com
 */
public final class WordsSegment {
	private static final Logger logger = LoggerFactory.getLogger(WordsSegment.class);

	private WordsSegment() {
	}

	/**
	 * 分词
	 * 
	 * @param str 字符串
	 * @return
	 */
	public static List<String> getCutWords(String str) {
		Analyzer analyzer = new IKAnalyzer();
		Reader r = new StringReader(str);
		TokenStream ts = analyzer.tokenStream("searchValue", r);
		ts.addAttribute(CharTermAttribute.class);

		List<String> list = new ArrayList<String>();
		try {
			while (ts.incrementToken()) {
				CharTermAttribute ta = ts.getAttribute(CharTermAttribute.class);
				String word = ta.toString();
				list.add(word);
			}
		} catch (IOException e) {
			logger.error("分词IO错误：" + e.getMessage());
		}
		return list;
	}
}