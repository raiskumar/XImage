Image Extractor from a web link

Iextract is a Java library for extracting images from a web link.

Iextract uses jsoup to parse html page. Provides below operations :

Using heuristic find image which is for the given article. Finds article image from a list of 20-50 image based on some heuristic.
Find all images on a web link
Given an image url find the width/height of the image


**How to Use **

String uri = "http://www.bbc.co.uk/news/world-asia-22579098";

Image img = XImage.getArticleImage(uri);

System.out.println("Image URL :"+ img.getUrl());

//http://news.bbcimg.co.uk/media/images/67681000/jpg/_67681228_64681903.jpg

You can reach me at rai.skumar@gmail.com
