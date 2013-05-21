package org.ximage.filter;


import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.ximage.common.XimageException;
import org.ximage.common.Util;
import org.ximage.parser.HtmlDoc;
import org.ximage.parser.HtmlDoc.HtmlImage;

public class KeywordFilter implements Filter {
	List<String> hashed = new ArrayList<String>();
	
	public KeywordFilter() {
		String keywords = "btn,save,thumb,logo,gif";
		hashed.addAll(Arrays.asList(keywords.split(",")));
	}
	
	public HtmlDoc execute(HtmlDoc doc) throws XimageException {
		if(Util.isNull(doc)){
			throw new XimageException("500", "Parsing failed");
		}
		
		HtmlDoc processed = new HtmlDoc();
		processed.setTitle(doc.getTitle());
		
		for(HtmlImage image: doc.getImages()){
			if(!hasKeyword(image.getAlt())){
				processed.addImage(image);
			}
		}
		return processed;
	}
	
	private boolean hasKeyword(String alt){
		boolean has = false;
		for(String keyword : hashed){
			if(alt.contains(keyword)){
				return true;
			}
		}
		return has;
	}
}
