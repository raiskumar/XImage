package org.ximage.client;

import java.net.InetSocketAddress;
import java.net.Proxy;
import java.net.SocketAddress;

import org.ximage.Image;
import org.ximage.Ximage;
import org.ximage.common.XimageException;


public class ServiceClient {

	public static void setSystemProxy(){
		System.setProperty("http.proxyHost", "www-gdcw.sony.com");
		System.setProperty("http.proxyPort", "80");
	}
	
	
	public static void main(String[] args) {
		String uri = "http://www.ndtv.com/article/india/chinese-premier-li-keqiang-will-handle-differences-bearing-overall-ties-in-mind-368971?pfrom=home-lateststories";
		uri = "http://www.ishafoundation.org/";
		uri = "http://www.ndtv.com/article/india/ipl-spot-fixing-scandal-police-seize-rs-5-5-lakh-allegedly-paid-to-sreesanth-by-bookies-373071?pfrom=home-lateststories";
		
		//able to get image which is not visible on page as well
		uri = "http://www.ndtv.com/article/india/rituparno-ghosh-national-award-winning-filmmaker-dies-at-49-373092?pfrom=home-lateststories";
		//uri = "http://google.com/";
		uri = "http://www.firstpost.com/politics/three-polls-one-message-no-alternative-to-modi-for-bjp-804581.html";
		
		//setProxy();
		setSystemProxy();
		try {
			System.out.println("Before call");
		    Ximage service = new Ximage();
			Image image= service.getArticleImage(uri);
			System.out.println(" image : "+ image.getUrl());
			
			} catch (XimageException e) {
			e.printStackTrace();
		}
	}
}