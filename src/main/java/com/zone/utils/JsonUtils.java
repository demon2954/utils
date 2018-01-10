package com.zone.utils;

import com.google.gson.Gson;

/**
 * json工具类
 * @author zone
 * @date 2018-01-10
 */
public class JsonUtils {
	private static Gson gson = new Gson();

	/**
	 * 对象转json
	 * @param bean
	 * @return
	 */
	public String toJsonString(Object bean) {
		return gson.toJson(bean);
	}

	/**
	 * json转对象
	 * @param json
	 * @param clazz
	 * @return
	 */
	public <T> T parseJson(String json, Class<T> clazz) {
		return gson.fromJson(json, clazz);
	}
}
