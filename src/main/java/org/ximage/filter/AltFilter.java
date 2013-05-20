package org.ximage.filter;


import java.util.Arrays;
import java.util.List;

import org.ximage.common.XImageException;
import org.ximage.common.Util;
import org.ximage.parser.HtmlDoc;
import org.ximage.parser.HtmlDoc.HtmlImage;

/**
 * Select images which satisfy below condition
 * 1. alt = alt + imageName
 * 1. If any of the alt text matches with the page title
 * In above 2 cases images will be sent 2 next filter for processing
 *  
 * @author Siddheshwar 
 * @email rai.skumar@gmail.com
 *
 */
public class AltFilter implements Filter {
	public HtmlDoc execute(HtmlDoc doc) throws XImageException {
		if(Util.isNull(doc)){
			throw new XImageException("500", "Parsing failed");
		}
		HtmlDoc processed = new HtmlDoc();
		processed.setTitle(doc.getTitle());
		String title = doc.getTitle();
		
		for(HtmlImage image: doc.getImages()){
			String alt = image.getAlt();
			alt = alt + parseImageName(image.getUrl());
			if(altMatches(title, alt)){
				image.setAlt(alt);  //update alt 
				processed.addImage(image);
			}
		}
		if(processed.getImages().size() >=1 )
			return processed;
		else 
			return doc;
	}
	
	private boolean altMatches(String title, String alt){
		boolean matches = false;
		List<String> ts = Arrays.asList(title.split(" "));
		
		for(String t : ts ){
			if(alt.toLowerCase().contains(t.toLowerCase())){  
				return true;
			}
		}
		return matches;
	}
	
	private String parseImageName(String imgUrl){
		String name = "";
		if(imgUrl != null){
			String[] arr = imgUrl.split("/");
			name = arr[arr.length-1];
		}
		return name;
	}

}
