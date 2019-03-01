package com.github.demon2954.utils;

import java.awt.image.BufferedImage;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.Random;

import javax.imageio.ImageIO;

/**
 *
 * @auth zone
 * @date 2018-08-15
 */
public class ImageUtils {
	public static BufferedImage getImageByUrl(String url) {
		BufferedImage image = null;
		try {
			URL u = new URL(url);
			image = ImageIO.read(u);
		} catch (MalformedURLException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		return image;
	}

	public static void saveImageByUrl(String url, String path) {
		BufferedImage image = getImageByUrl(url);
		try {
			String fileName = path + System.currentTimeMillis() + new Random().nextInt(1000) + ".jpg";
			FileOutputStream output = new FileOutputStream(new File(fileName));
			ImageIO.write(image, "jpg", output);
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
