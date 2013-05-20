package org.ximage.common;

public class Util {
	public static boolean isEmpty(String text){
		if( text == null || text.length() <=1 )
			return true;
		else return false;
	}
	
	public static boolean isNull(String text){
		return isEmpty(text);
	}
	
	public static boolean isNull(Object obj){
		return obj == null ? true : false;
	}
	

}
