package org.ximage;

/**
 * Represents Image object
 * 
 * @author Siddheshwar rai.skumar@gmail.com
 * @created 14th May '13
 * 
 */
public class Image {
	private String url;
	private int width;
	private int height;

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

	@Override
	public String toString() {
		return "Image [url=" + url + ", width=" + width + ", height=" + height
				+ "]";
	}
}