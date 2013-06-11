package org.ximage.filter;

import junit.framework.Assert;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import org.ximage.common.XimageException;
import org.ximage.parser.HtmlDoc;
import org.ximage.parser.HtmlDoc.HtmlImage;

public class KeywordFilterTest {
	@Test(dataProvider = "dp")
	public void f(int size, HtmlDoc doc) {
		Filter f = new KeywordFilter();
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
		image.setAlt("btn");
		image.setUrl("http://www.abc.com");
		doc.addImage(image);

		image = new HtmlImage();
		image.setAlt("save");
		image.setUrl("http://www.abc.com");
		doc.addImage(image);
		
		HtmlDoc doc1 = new HtmlDoc();
		doc1.setTitle("test title");
		HtmlDoc.HtmlImage image1 = new HtmlImage();
		image1.setAlt("ramji");
		image1.setUrl("http://www.abc.com");
		doc1.addImage(image1);


		return new Object[][] { new Object[] { 0, doc },
								new Object[] { 1, doc1 },
		};
	}
}
