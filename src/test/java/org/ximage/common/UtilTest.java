package org.ximage.common;

import junit.framework.Assert;

import org.testng.annotations.Test;
import org.testng.annotations.DataProvider;

public class UtilTest {
  @Test(dataProvider = "dp")
  public void f(String s, Boolean flag) {
	  boolean f = Util.validateURL(s);
	  System.out.println(s+"   "+f);
	  if(flag.equals(Boolean.TRUE)){
		  Assert.assertEquals(f, true);
	  }else{
		  Assert.assertEquals(f, false);
	  }
  }

  @DataProvider
  public Object[][] dp() {
    return new Object[][] {
      new Object[] { "http://google.com/", Boolean.TRUE },
      new Object[] { "http://www.ndtv.com/news/images/story_page/Rituparno-Ghosh-295_14.jpg", Boolean.TRUE},
      new Object[] { "", Boolean.FALSE},
      new Object[] { null, Boolean.FALSE},
      new Object[] { "http://www", Boolean.TRUE},  //Note this
    };
  }
}
