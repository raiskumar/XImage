###Ximage : Extracts image from a URL/URI

##About :

Java library for extracting images from a web link/url.
Ximage uses Jsoup library to parse html and then extract images from it.
It applies heuristic technique to find one image which is for the given article. Or in other words; it finds one image which best describes the article. 

### Available Methods:

1. getArticleImage(uri);  //Returns main image of the page
2. getAllImages(uri);  //Returns all images from the html page
3. getImageDimension(uri); //Returns width and height of the given image

###How to Use :
**Ximage ximage = new Ximage();**

**Image image= service.getArticleImage(uri);**

**System.out.println("Image :"+ image.getUrl());**

###Jar Dependency :
jsoup : http://jsoup.org


--------------------
Reach Me: 

rai.skumar@gmail.com
