package org.ximage;

import java.util.ArrayList;
import java.util.List;

import org.ximage.common.XimageException;
import org.ximage.common.Util;
import org.ximage.filter.Filter;
import org.ximage.filter.FilterChain;
import org.ximage.filter.SizeFilter;
import org.ximage.parser.HtmlDoc;
import org.ximage.parser.HtmlParser;

/**
 * Image Extractor service interface 
 * @author Siddheshwar rai.skumar@gmail.com
 *
 */
public class Controller {
	
	public Controller(String ip, String port) {
		if(!Util.isEmpty(ip) && !Util.isEmpty(port)){
			System.setProperty("http.proxyHost", ip);
			System.setProperty("http.proxyPort", port);
		}
	}
	
	public List<Image> fetchImages(String uri) throws XimageException{
		List<Image> images = new ArrayList<Image>();
		
		HtmlParser parser = new HtmlParser();
		
		//fetch all images
		HtmlDoc html =  parser.extractImages(uri);  
		
		//some of the image might not have valid dimension
		//use size filter to get size as well
		Filter f = new SizeFilter();
		HtmlDoc htmlRevised = f.execute(html);
		
		Image img = null;
		for(HtmlDoc.HtmlImage i : htmlRevised.getImages()){
			img = new Image();
			img.setUrl(i.getUrl());
			img.setHeight(i.getHeight());
			img.setWidth(i.getWidth());
			images.add(img);
		}
		
		return images;
	}
	
	public Image getImageDimension(String uri) throws XimageException{
		HtmlParser parser = new HtmlParser();
		Image img = parser.getImageDimension(uri);
		return img;
	}
	
	public Image getArticleImage(String uri) throws XimageException{
		HtmlParser parser = new HtmlParser();
		HtmlDoc html = parser.extractImages(uri);
		FilterChain fc = new FilterChain();
		Image img = fc.filterArticleImage(html);
		return img;
	}	
}
