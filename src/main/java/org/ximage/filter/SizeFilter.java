package org.ximage.filter;


import java.awt.image.BufferedImage;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.Collections;

import javax.imageio.ImageIO;

import org.ximage.Image;
import org.ximage.common.XimageException;
import org.ximage.common.Util;
import org.ximage.parser.HtmlDoc;
import org.ximage.parser.HtmlDoc.HtmlImage;

/**
 * Performs below task :
 * 1. Reads dimension of the images which don't have and discard smaller images 
 * 2. Sorts images based on the dimension
 * 
 * @author Siddheshwar
 *
 */

public class SizeFilter implements Filter {
	final static private int MINIMUM_LENGTH = 50;
	
	public HtmlDoc execute(HtmlDoc doc) throws XimageException {
		if(Util.isNull(doc)){
			throw new XimageException("500", "Parsing failed");
		}
		
		HtmlDoc processed = new HtmlDoc();
		processed = fetchImageSize(doc);  //read missing sizes
		processed.setTitle(doc.getTitle());
		
		//sort images on dimension width X height
		Collections.sort(processed.getImages());
		
		return processed;
	}
	
	
	public HtmlDoc fetchImageSize(HtmlDoc doc){
		HtmlDoc processed = new HtmlDoc();
		
		for(HtmlImage image: doc.getImages()){
			int width = image.getWidth();
			int height = image.getHeight();
			BufferedImage imageObj = null;
			
			if(width == 0 || height == 0){
				try {					
					if(image.getUrl().contains("http://")){ //only if url is valid
						URL url = new URL(image.getUrl());
						imageObj = ImageIO.read(url);

						width  = imageObj.getWidth();
						height = imageObj.getHeight();								
					}
				} catch (MalformedURLException e) {
					e.printStackTrace();
					//ignore
				} catch (IOException e) {
					e.printStackTrace();
					//ignore
				}
			}
			if (width >= MINIMUM_LENGTH || height >= MINIMUM_LENGTH) {
				image.setHeight(height);
				image.setWidth(width);
				processed.addImage(image);
			}

		}
		return processed;
	}
	
}
