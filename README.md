Ximage : Extracts main image / images from a web link

About :
Java library for extracting images from a web link/url.
Ximage uses Jsoup library to parse html and then extract images from it.
What is special about the library : It applies heuristic technique to find one image which is for the given article. Or in other words; it finds one image which best describes the article. 

Services Supported :
1. getArticleImage(uri);
2. getAllImages(uri);  //Returns all images from the html page
3. getImageDimension(uri); //Returns width and height of the given image

How to Use :
Step 1: Use either of below way to construct Ximage object.
Ximage ximage = new Ximage();  //default constructor
Ximage ximage = new Ximage(ip,port); //constructor with proxy details

Step 2: Ready for your service
service.setProxy("www-gdcw.sony.com", "80");  //in case you called default constructor and still want to set proxy
Image image= service.getArticleImage(uri);  
or
List<Image> images= service.getAllImages(uri);
or
Image image = service.getImageDimension(uri);

String uri = "http://www.bbc.co.uk/news/world-asia-22579098";
Ximage ximage = new Ximage();
Image img = ximage.getArticleImage(uri);
System.out.println("Image URL :"+ img.getUrl());
//http://news.bbcimg.co.uk/media/images/67681000/jpg/_67681228_64681903.jpg

Status :
Though library is quite new, but i have done extensive testing.  

Reach Me: 
rai.skumar@gmail.com
