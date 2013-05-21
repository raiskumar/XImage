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
	private String IP;
	private String PORT;
	/**
	 * Applies heuristic techniques to extract the main image of the article/page. 
	 * It returns a single Image object if heuristic techniques finds article image successfully; otherwise it will return null
	 * 
	 * @param uri
	 * @return Image
	 * @throws XimageException 
	 */
	public Image getArticleImage(String uri) throws XimageException {
		Controller controller = new Controller(IP,PORT);
		return controller.getArticleImage(uri);
	}
	
	/**
	 * Given the image uri; returns its width and height
	 * @param uri
	 * @return Image
	 * @throws XimageException
	 */
	public Image getImageDimension(String uri) throws XimageException {
		Controller controller =  new Controller(IP,PORT);
		return controller.getImageDimension(uri);
	}
	
	/**
	 * Fetch all images found on a web link/ uri
	 * @param uri
	 * @return List<Image>
	 * @throws XimageException
	 */
	public List<Image> getAllImages(String uri) throws XimageException {
		Controller controller =  new Controller(IP,PORT);
		return controller.fetchImages(uri);
	}
	
	/**
	 * Optional method to provide Proxy details (ip, port) to the API . 
	 * Call this method before actual api call (if you wish to provide proxy)
	 * @param ip
	 * @param port
	 * @return 
	 */
	public void setProxy(String ip, String port){
		IP = ip;
		PORT = port;
	}
	
	/**
	 * Create object with proxy details 
	 * You can also call default constructor
	 * @param ip
	 * @param port
	 * @return 
	 */

	public Ximage(String ip, String port){
		IP = ip;
		PORT = port;
	}
	
	/**
	 * Default constructor 
	 * Note : Make sure to setProxy(ip,port) if you require before actual API call
	 * @param ip
	 * @param port
	 * @return 
	 */

	public Ximage(){
		IP = null;
		PORT = null;
	}
	
}
