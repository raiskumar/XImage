package org.ximage.common;

/**
 * Exception class for the service
 * @author Siddheshwar rai.skumar@gmail.com
 *
 */
public class XimageException extends Exception{
	private static final long serialVersionUID = 1L;
	private String code;
	private String message;
	
	public XimageException(String code, String message) {
		super();
		this.code = code;
		this.message = message;
	}

	public String getCode() {
		return code;
	}

	public String getMessage() {
		return message;
	}

}
