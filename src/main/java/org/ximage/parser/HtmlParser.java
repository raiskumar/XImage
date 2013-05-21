package org.ximage.parser;

import java.io.IOException;

import org.ximage.Image;
import org.ximage.common.XimageException;
import org.ximage.common.Util;
import org.ximage.filter.SizeFilter;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

/**
 * Makes http calls to fetch content of a link and then parses it to retrieve images
 * @author Siddheshwar rai.skumar@gmail.com
 * @created 14th May '13
 *
 */
public class HtmlParser {
	
	public HtmlDoc extractImages(String url) throws XimageException {
		HtmlDoc html = new HtmlDoc();
		try {
			Document doc = Jsoup.connect(url).userAgent("Mozilla").get();  //It’s recommended to specify a “userAgent” in Jsoup, to avoid HTTP 403 error messages
			String title = "";
			
			if(!Util.isNull(doc.getElementById("title"))){
				title = doc.getElementById("title").text();
				html.setTitle(title);  //page title
			}else{
				title = doc.getElementsByTag("title").text();
				html.setTitle(title);  //page title
			}

			Elements images = doc.select("img[src~=(?i)\\.(gif|png|jpe?g)]");
		
			for (Element image : images) {
				HtmlDoc.HtmlImage img = new HtmlDoc.HtmlImage();
				img.setUrl(image.attr("src"));
				img.setAlt(image.attr("alt"));
				
				if(!Util.isNull(image.attr("width"))){
					img.setWidth(Integer.parseInt(image.attr("width")));
				}
				if(!Util.isNull(image.attr("height"))){
					img.setHeight(Integer.parseInt(image.attr("height")));
				}
				
				html.addImage(img);
			}

		} catch (IOException e) {
			throw new XimageException("500", "Unable to read given uri :"+ e.getCause());
		}
		return html;
	}
	
	/**
	 * Get width and height of the given image
	 * @param uri
	 * @return Image
	 * @throws XimageException 
	 */
	public Image getImageDimension(String uri) throws XimageException{
		HtmlDoc doc = new HtmlDoc();
		HtmlDoc.HtmlImage img = new HtmlDoc.HtmlImage();
		img.setUrl(uri);
		doc.addImage(img);
		
		SizeFilter sz = new SizeFilter();
		HtmlDoc html = sz.fetchImageSize(doc);
		
		if(Util.isNull(uri) || html.getImages().isEmpty()){
			throw new XimageException("400", "Invalid Image URL");
		}
		Image image = new Image();
		image.setUrl(uri);
		image.setHeight(html.getImages().get(0).getHeight());
		image.setWidth(html.getImages().get(0).getWidth());
		return image;
	}


}
