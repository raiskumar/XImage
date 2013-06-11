package org.ximage.client;

import org.ximage.Image;
import org.ximage.Ximage;
import org.ximage.common.XimageException;

public class ServiceClient {

	public static void setSystemProxy() {
		System.setProperty("http.proxyHost", "www-gdcw.sony.com");
		System.setProperty("http.proxyPort", "80");
	}

	public static void main(String[] args) {
		String uri = "http://www.ndtv.com/article/india/chinese-premier-li-keqiang-will-handle-differences-bearing-overall-ties-in-mind-368971?pfrom=home-lateststories";

		// setSystemProxy();
		try {
			Ximage service = new Ximage();
			Image image = service.getArticleImage(uri);
			System.out.println(image);
		} catch (XimageException e) {
			e.printStackTrace();
		}
	}
}