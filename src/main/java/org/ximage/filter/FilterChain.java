package org.ximage.filter;

import java.util.ArrayList;
import java.util.List;

import org.ximage.Image;
import org.ximage.common.XimageException;
import org.ximage.parser.HtmlDoc;


public class FilterChain {
	List<Filter> chain = new ArrayList<Filter>();
	
	{
		chain.add(new SizeFilter());
		chain.add(new AltFilter());
		chain.add(new KeywordFilter());
	}
	
	public Image filterArticleImage(HtmlDoc html) throws XimageException{
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
