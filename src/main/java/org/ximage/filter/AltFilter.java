package org.ximage.filter;


import java.util.Arrays;
import java.util.List;

import org.ximage.common.XimageException;
import org.ximage.common.Util;
import org.ximage.parser.HtmlDoc;
import org.ximage.parser.HtmlDoc.HtmlImage;

/**
 * Concatanate imageName to alt value i.e. alt += imageName 
 * Then Select images which satisfy below condition
 * 
 * If any of the alt text matches with the page title then it should be added to output
 * In case non of the image satisfied above criteria then return the original object
 *  
 * @author Siddheshwar 
 * @email rai.skumar@gmail.com
 *
 */
public class AltFilter implements Filter {
	public HtmlDoc execute(HtmlDoc doc) throws XimageException {
		if(Util.isNull(doc)){
			throw new XimageException("500", "Parsing failed");
		}
		HtmlDoc processed = new HtmlDoc();
		String title = doc.getTitle();
		processed.setTitle(title);
		
		for(HtmlImage image: doc.getImages()){
			String alt = image.getAlt();
			alt = alt + parseImageName(image.getUrl());
			if(altMatches(title, alt)){
				image.setAlt(alt);  //update alt 
				processed.addImage(image);
			}
		}
		if(processed.getImages().size() > 0 )
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
		if(!Util.isEmpty(imgUrl)){
			String[] arr = imgUrl.split("/");
			name = arr[arr.length-1];
		}
		return name;
	}

}
