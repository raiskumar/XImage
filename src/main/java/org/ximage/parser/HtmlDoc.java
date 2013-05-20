package org.ximage.parser;

import java.util.ArrayList;
import java.util.List;

/**
 * 
 * Used to represent html after parsing
 * @author Siddheshwar rai.skumar@gmail.com
 * @created 14th May '13
 *
 */
public class HtmlDoc {
	private String title;
	List<HtmlImage> images = new ArrayList<HtmlImage>();
	
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	
	public void addImage(HtmlImage image){
		images.add(image);
	}
	public List<HtmlImage> getImages(){
		return images;
	}
	
	public void setImages(List<HtmlImage> images) {
		this.images = images;
	}
	
	public static class HtmlImage implements Comparable<HtmlImage>{
		private String url;
		private int width;
		private int height;
		private String alt;

		public String getUrl() {
			return url;
		}

		public void setUrl(String url) {
			this.url = url;
		}

		public int getWidth() {
			return width;
		}

		public void setWidth(int width) {
			this.width = width;
		}

		public int getHeight() {
			return height;
		}

		public void setHeight(int height) {
			this.height = height;
		}

		public String getAlt() {
			return alt;
		}

		public void setAlt(String alt) {
			this.alt = alt;
		}

		public String toString(){
			return "widthXheight: "+width+"X"+height+" ;url: "+ url + " ;alt:"+alt;
		}

		public int compareTo(HtmlImage obj) {
			if( obj == null )
				return 0;
			else{
				double thisProduct = this.width * this.height;
				double objProduct = obj.height * obj.height;
				
				if(thisProduct < objProduct) return 1;
				else if(thisProduct > objProduct) return -1;
				else return 0;
			}
		}

	}
}
