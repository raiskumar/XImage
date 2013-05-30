package org.ximage;

import java.util.List;

import junit.framework.Assert;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import org.ximage.client.ServiceClient;
import org.ximage.common.XimageException;

public class ControllerTest {
  
  @Test(dataProvider = "dp")
  public void getArticleImageTest(String n, boolean s) {
	  //ServiceClient.setSystemProxy();
	  Ximage service = new Ximage();
	  Image image = null;
	  try {
		image= service.getArticleImage(n);
		//System.out.println(s.equals(Boolean.TRUE) + " image url :"+ image.getUrl());
		if(s == true){
			Assert.assertNotNull(image);
			Assert.assertNotNull(image.getUrl());			
		}
	} catch (XimageException e) {
		e.printStackTrace();
		Assert.assertNull(image);
	}
  }

  @Test(dataProvider = "dp")
  public void getAllImageTest(String n, Boolean s) {
	  ServiceClient.setSystemProxy();
	  Ximage service = new Ximage();
	  Image image = null;
	  try {
		List<Image> iList= service.getAllImages(n);
		if(s == true){
			Assert.assertTrue(!iList.isEmpty());			
		}
	} catch (XimageException e) {
		e.printStackTrace();
		Assert.assertNull(image);
	}
  }

  @Test(dataProvider = "dp1")
  public void getImageDimensionTest(String n, boolean s) {
	  ServiceClient.setSystemProxy();
	  Ximage service = new Ximage();
	  Image image = null;
	  try {
		image= service.getImageDimension(n);
		if(s == false){
			Assert.assertNotNull(image);
			Assert.assertNotNull(image.getHeight());
			Assert.assertNotNull(image.getWidth());			
		}
	} catch (XimageException e) {
		e.printStackTrace();
		Assert.assertNull(image);
	}
  }

  
  @DataProvider
  public Object[][] dp() {
    return new Object[][] {
      new Object[] { "http://www.firstpost.com/politics/three-polls-one-message-no-alternative-to-modi-for-bjp-804581.html", true },
      new Object[] { "", false },
      new Object[] { "http://google.com/", false },
      new Object[] { null, false},
    };
  }
  
  @DataProvider
  public Object[][] dp1() {
    return new Object[][] {
      new Object[] { "http://www.ndtv.com/news/images/story_page/Rituparno-Ghosh-295_14.jpg", true },
      new Object[] { "", false },
      new Object[] { null, false },
    };
  }

}
