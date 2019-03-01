package com.github.demon2954.utils;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStreamWriter;

/**
 * @author zone
 * @date 2018-01-10
 */
public class FileWriter {
	public static void write(String path, String content) {
		File file = new File(path);
		BufferedWriter out = null;
		try {
			out = new BufferedWriter(new OutputStreamWriter(new FileOutputStream(file), "utf-8"));
			out.write(content);
		} catch (FileNotFoundException e) {
			System.out.println("file is not fond");
		} catch (IOException e) {
			System.out.println("Read or write Exceptioned");
		} finally {
			if (null != out) {
				try {
					out.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		}
	}
	
	public static void main(String[] args) {
		write("D:\\test.txt", "我\n写\n字");
	}
}
