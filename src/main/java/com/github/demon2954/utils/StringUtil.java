package com.github.demon2954.utils;

import org.apache.commons.lang3.StringUtils;

/**
 * 字符创工具类
 * 
 * @author ZoneChan
 * @since 2019-03-18
 */
public class StringUtil {
	/**
	 * 字符串是否为空
	 * 
	 * <pre>
	 * StringUtils.isBlank(null)      = true
	 * StringUtils.isBlank("null")    = true
	 * StringUtils.isBlank("NULL")    = true
	 * StringUtils.isBlank("")        = true
	 * StringUtils.isBlank(" ")       = true
	 * StringUtils.isBlank("bob")     = false
	 * StringUtils.isBlank("  bob  ") = false
	 * </pre>
	 * 
	 * @param str
	 * @return
	 */
	public static boolean isBlank(String str) {
		return StringUtils.isBlank(str) || "null".equalsIgnoreCase(str);
	}

	/**
	 * 字符串是否为空
	 * 
	 * <pre>
	 * StringUtils.isBlank(null)      = false
	 * StringUtils.isBlank("null")    = false
	 * StringUtils.isBlank("NULL")    = false
	 * StringUtils.isBlank("")        = false
	 * StringUtils.isBlank(" ")       = false
	 * StringUtils.isBlank("bob")     = true
	 * StringUtils.isBlank("  bob  ") = true
	 * </pre>
	 * 
	 * @param str
	 * @return
	 */
	public static boolean isNotBlank(String str) {
		return !isBlank(str);
	}
	
	/**
	 * 驼峰式转为下划线
	 * @return
	 */
	public static String camelToUnderline(String camelCaseName) {
		StringBuilder result = new StringBuilder();
		if (camelCaseName != null && camelCaseName.length() > 0) {
			result.append(camelCaseName.substring(0, 1).toLowerCase());
			for (int i = 1; i < camelCaseName.length(); i++) {
				char ch = camelCaseName.charAt(i);
				if (Character.isUpperCase(ch)) {
					result.append("_");
					result.append(Character.toLowerCase(ch));
				} else {
					result.append(ch);
				}
			}
		}
		return result.toString();
	}
}
