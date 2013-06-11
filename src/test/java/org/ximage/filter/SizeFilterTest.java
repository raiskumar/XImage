package org.ximage.filter;

import junit.framework.Assert;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import org.ximage.common.XimageException;
import org.ximage.parser.HtmlDoc;
import org.ximage.parser.HtmlDoc.HtmlImage;

public class SizeFilterTest {
	@Test(dataProvider = "dp")
	public void f(int size, HtmlDoc doc) {
		Filter f = new SizeFilter();
		try {
			HtmlDoc processedDoc = f.execute(doc);

			Assert.assertNotNull(processedDoc);
			Assert.assertEquals(processedDoc.getImages().size(), size);

		} catch (XimageException e) {
			e.printStackTrace();
		}
	}

	@DataProvider
	public Object[][] dp() {
		HtmlDoc doc = new HtmlDoc();
		doc.setTitle("test title");
		HtmlDoc.HtmlImage image = new HtmlImage();
		image.setAlt("title");
		image.setUrl("http://www.abc.com");
		image.setHeight(101);
		image.setWidth(51);
		doc.addImage(image);

		image = new HtmlImage();
		image.setAlt("abc");
		image.setUrl("http://www.abc.com");
		image.setWidth(49);
		image.setHeight(500);
		doc.addImage(image);

		return new Object[][] { new Object[] { 2, doc }, };
	}
}
