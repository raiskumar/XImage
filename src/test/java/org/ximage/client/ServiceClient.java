package org.ximage.client;

import org.ximage.Image;
import org.ximage.Ximage;
import org.ximage.common.XimageException;


public class ServiceClient {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		String uri = "http://www.ndtv.com/article/india/chinese-premier-li-keqiang-will-handle-differences-bearing-overall-ties-in-mind-368971?pfrom=home-lateststories";
		try {
/*			System.setProperty("http.proxyHost", "www-gdcw.sony.com");
			System.setProperty("http.proxyPort", "80");
*/			System.out.println("Before call");
		    Ximage service = new Ximage();
			service.setProxy("www-gdcw.sony.com", "80");
			Image image= service.getArticleImage(uri);
			System.out.println(" image "+ image.getUrl());
			/*List<Image> imgs = Iextract.getAllImages(uri);
			for(Image i : imgs)
				System.out.println(i.toString());
			 */
			} catch (XimageException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

}