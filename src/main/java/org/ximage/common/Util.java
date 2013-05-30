package org.ximage.common;

import java.net.MalformedURLException;
import java.net.URI;
import java.net.URISyntaxException;
import java.net.URL;

public class Util {
	public static boolean isEmpty(String text){
		return text == null || text.length() <= 1;
	}
	
	public static boolean isNull(String text){
		return isEmpty(text);
	}
	
	public static boolean isNull(Object obj){
		return obj == null;
	}
	
	public static boolean validateURL(String URL){
		URI uri = null;
		try {
			URL u = new URL(URL); // this would check for the protocol
			uri = u.toURI();  // does the extra checking required for validation of URI 
		} catch (MalformedURLException e) {
			e.printStackTrace();
		} catch (URISyntaxException e) {
			e.printStackTrace();
		} 
		return uri != null;
	}
	
	/*public static void main(String[] args){
		System.out.println(" "+ validateURL("http://www"));
	}*/

}
