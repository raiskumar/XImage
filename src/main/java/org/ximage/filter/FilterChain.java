package org.ximage.filter;

import java.util.ArrayList;
import java.util.List;

import org.ximage.common.XImageException;
import org.ximage.parser.HtmlDoc;
import org.ximage.service.Image;


public class FilterChain {
	List<Filter> chain = new ArrayList<Filter>();
	
	{
		chain.add(new SizeFilter());
		chain.add(new AltFilter());
		chain.add(new KeywordFilter());
	}
	
	public Image filterArticleImage(HtmlDoc html) throws XImageException{
		Image image = new Image();
		HtmlDoc processed = html;
		
		for(Filter f : chain){
			processed = f.execute(processed);
		}
		
		if(!processed.getImages().isEmpty()){
			image.setUrl(processed.getImages().get(0).getUrl());
			image.setHeight(processed.getImages().get(0).getHeight());
			image.setWidth(processed.getImages().get(0).getWidth());			
		}
		return image;
	}

}
