package org.ximage.service;

import java.util.List;

import org.ximage.common.XImageException;

/**
 * Service class for extracting images from a web page
 * @author Siddheshwar rai.skumar@gmail.com
 * @created 17th May '13
 *
 */
public class XImage {
	private static String IP;
	private static String PORT;
	/**
	 * Applies heuristic techniques to extract the main image of the article/page
	 * So from a news article this will only return the image of that article
	 * @param uri
	 * @return Image
	 * @throws XImageException 
	 */
	public static Image getArticleImage(String uri) throws XImageException {
		Controller c = new Controller(IP,PORT);
		return c.getArticleImage(uri);
	}
	
	/**
	 * Given the image uri; returns its width and height
	 * @param uri
	 * @return Image
	 * @throws XImageException
	 */
	public static Image getImageDimension(String uri) throws XImageException {
		Controller c =  new Controller(IP,PORT);
		return c.getImageDimension(uri);
	}
	
	/**
	 * Fetch all images of the article
	 * @param uri
	 * @return List<Image>
	 * @throws XImageException
	 */
	public static List<Image> getAllImages(String uri) throws XImageException {
		Controller c =  new Controller(IP,PORT);
		return c.fetchImages(uri);
	}
	
	/**
	 * Provide port and ip address if you want to set proxy. This is optional
	 * @param ip
	 * @param port
	 * @return Iextract
	 */
	public static XImage proxy(String ip, String port){
		IP = ip;
		PORT = port;
		return new XImage();
	}
	
}
