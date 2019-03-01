package com.github.demon2954.utils;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.URL;
import java.net.URLConnection;
import java.util.Map;

import org.jsoup.Connection;
import org.jsoup.Jsoup;
import org.jsoup.helper.HttpConnection;
import org.jsoup.nodes.Document;

public class HttpRequester {
	
	/**
	 * 带系统带接口名调用http
	 * @param host
	 * @param systemCode
	 * @param requestName
	 * @param parameterMap
	 * @return
	 * @throws Exception
	 */
	public static String invokeHttp(String host, final String systemCode, String requestName, Map<String, ?> parameterMap) throws Exception {
		String url = "http://" + host + "/" + systemCode + "/" + requestName;
		return getReqByUrl(url, parameterMap);
	}

	/**
	 * post方式带参数调用http
	 * @param url
	 * @param parameterMap
	 * @return
	 * @throws Exception
	 */
	public static String getReqByUrl(String url, Map<String, ?> parameterMap) throws Exception {
		Connection conn = Jsoup.connect(url).ignoreContentType(true).timeout(30000);
		conn.header(HttpConnection.CONTENT_ENCODING, "UTF-8");
		if (parameterMap != null) {
			for (String key : parameterMap.keySet()) {
				conn.data(key, parameterMap.get(key)+"");
			}
		}
		Document doc = conn.post();
		String body = doc.body().toString();
		if (body.contains("<body>")) {
			body = body.substring(body.indexOf("<body>") + "<body>".length(), body.lastIndexOf("</body>")).trim();
		}
		return body;
	}
	
	/**
	 * post方式带参数调用http
	 * @param url
	 * @param parameterMap
	 * @return
	 * @throws Exception
	 */
	public static String getReqByUrl(String url, Map<String, ?> parameterMap, Map<String, ?> header) throws Exception {
		Connection conn = Jsoup.connect(url).ignoreContentType(true).timeout(30000);
		conn.header(HttpConnection.CONTENT_ENCODING, "UTF-8");
		if (header != null) {
			for (String key : header.keySet()) {
				conn.header(key, header.get(key)+"");
			}
		}
		if (parameterMap != null) {
			for (String key : parameterMap.keySet()) {
				conn.data(key, parameterMap.get(key)+"");
			}
		}
		Document doc = conn.post();
		String body = doc.body().toString();
		if (body.contains("<body>")) {
			body = body.substring(body.indexOf("<body>") + "<body>".length(), body.lastIndexOf("</body>")).trim();
		}
		return body;
	}
	
	public static String post(String url, Map<String, ?> parameterMap) throws Exception {
		Connection conn = Jsoup.connect(url).ignoreContentType(true).timeout(30000);
		conn.header(HttpConnection.CONTENT_ENCODING, "UTF-8");
		if (parameterMap != null) {
			for (String key : parameterMap.keySet()) {
//				logger.debug(key + "-----------" + parameterMap.get(key));
				conn.data(key, parameterMap.get(key) + "");
			}
		}
		Document doc = conn.post();
		String body = doc.body().toString();
//		if (body.contains("<body>")) {
//			body = body.substring(body.indexOf("<body>") + "<body>".length(), body.lastIndexOf("</body>")).trim();
//		}
		return body;
	}
	
	public static String post(String url, String data) throws Exception {
		PrintWriter out = null;
		BufferedReader in = null;
		String result = "";
		try {
			URL realUrl = new URL(url);
			// 打开和URL之间的连接
			URLConnection conn = realUrl.openConnection();
			// 设置通用的请求属性
			conn.setRequestProperty("accept", "*/*");
			conn.setRequestProperty("connection", "Keep-Alive");
			conn.setRequestProperty("user-agent", "Mozilla/4.0 (compatible; MSIE 6.0; Windows NT 5.1;SV1)");
			// 发送POST请求必须设置如下两行
			conn.setDoOutput(true);
			conn.setDoInput(true);
			// 获取URLConnection对象对应的输出流
			out = new PrintWriter(conn.getOutputStream());
			// 发送请求参数
			out.print(data);
			// flush输出流的缓冲
			out.flush();
			// 定义BufferedReader输入流来读取URL的响应
			in = new BufferedReader(new InputStreamReader(conn.getInputStream()));
			String line;
			while ((line = in.readLine()) != null) {
				result += line;
			}
		} catch (Exception e) {
			System.out.println("发送 POST 请求出现异常！" + e);
			e.printStackTrace();
		}
		// 使用finally块来关闭输出流、输入流
		finally {
			try {
				if (out != null) {
					out.close();
				}
				if (in != null) {
					in.close();
				}
			} catch (IOException ex) {
				ex.printStackTrace();
			}
		}
		return result;
	}  
	
	public static String get(String url, Map<String, ?> parameterMap) throws Exception {
		Connection conn = Jsoup.connect(url).ignoreContentType(true).timeout(30000);
		conn.header(HttpConnection.CONTENT_ENCODING, "UTF-8");
		if (parameterMap != null) {
			for (String key : parameterMap.keySet()) {
				conn.data(key, parameterMap.get(key) + "");
			}
		}
		Document doc = conn.get();
		String body = doc.body().toString();
		if (body.contains("<body>")) {
			body = body.substring(body.indexOf("<body>") + "<body>".length(), body.lastIndexOf("</body>")).trim();
		}
		return body;
	}
}
