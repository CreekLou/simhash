package com.lou.simhasher.util;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.UnsupportedEncodingException;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.lou.simhasher.KeywordExtractor;

/**
 * 文档读入工具
 * 
 * @author louxuezheng@hotmail.com
 */
public final class DicReader {

	private static final Logger logger = LoggerFactory.getLogger(KeywordExtractor.class);

	private DicReader() {
	}

	/**
	 * 返回BufferedReader
	 * 
	 * @param name 文件名
	 * @return
	 */
	public static BufferedReader getReader(String name) {
		InputStream in = DicReader.class.getResourceAsStream("/" + name);
		try {
			return new BufferedReader(new InputStreamReader(in, "UTF-8"));
		} catch (UnsupportedEncodingException e) {
			logger.error("编码格式不支持：" + e.getMessage());
		}
		return null;
	}

	/**
	 * 返回InputStream
	 * 
	 * @param name 文件名
	 * @return
	 */
	public static InputStream getInputStream(String name) {
		InputStream in = DicReader.class.getResourceAsStream("/" + name);
		return in;
	}
}
