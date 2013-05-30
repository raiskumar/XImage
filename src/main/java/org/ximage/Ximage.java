package org.ximage;

import java.util.List;

import org.ximage.common.XimageException;

/**
 * Service class for extracting images from a web page
 * @author Siddheshwar rai.skumar@gmail.com
 * @created 17th May '13
 *
 */
public class Ximage {
	Controller controller = new Controller();
	/**
	 * Applies heuristic techniques to extract the main image of the article/page. 
	 * It returns a single Image object if heuristic techniques finds article image successfully; otherwise it will return null
	 * 
	 * @param uri
	 * @return Image
	 * @throws XimageException 
	 */
	public Image getArticleImage(String uri) throws XimageException {
		return controller.getArticleImage(uri);
	}
	
	/**
	 * Given the image uri; returns its width and height
	 * @param uri
	 * @return Image
	 * @throws XimageException
	 */
	public Image getImageDimension(String uri) throws XimageException {
		return controller.getImageDimension(uri);
	}
	
	/**
	 * Fetch all images found on a web link/ uri
	 * @param uri
	 * @return List<Image>
	 * @throws XimageException
	 */
	public List<Image> getAllImages(String uri) throws XimageException {
		return controller.fetchImages(uri);
	}	
}
