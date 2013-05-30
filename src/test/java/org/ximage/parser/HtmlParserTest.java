package org.ximage.parser;

import junit.framework.Assert;

import org.testng.annotations.Test;
import org.testng.annotations.DataProvider;
import org.ximage.client.ServiceClient;
import org.ximage.common.XimageException;

public class HtmlParserTest {
  @Test(dataProvider = "dp")
  public void f(String url, boolean f) {
	  HtmlParser parser = new HtmlParser();
	  HtmlDoc html = null;
	  try {
		html = parser.extractImages(url);
		if(f == true){
			Assert.assertNotNull(html);	
		}
			
	} catch (XimageException e) {
		Assert.assertNull(html);
	}
  }

  @DataProvider
  public Object[][] dp() {
    return new Object[][] {
      new Object[] { "http://www.firstpost.com/politics/three-polls-one-message-no-alternative-to-modi-for-bjp-804581.html", true },
      new Object[] { " ", false },
    };
  }
}
