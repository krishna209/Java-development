package com.cloudwick.training.jsoup;

import java.io.IOException;

import org.apache.log4j.BasicConfigurator;
import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;


public class JsoupExample {
	/*Parsing HTML links*/
	
	public final static Logger log=Logger.getLogger(JsoupExample.class);//this can be used to log the messages
	
	public static void main(String[] args) throws IOException {
		PropertyConfigurator.configure("Cloudwick.properties");
		log.debug("received message for parsing");
		
		Document docObj=(Document) Jsoup.connect("https://www.google.com").get();//there are two types of http operations get and post	
		String title=docObj.title();
		System.out.println("Title : "+title);
		System.out.println("HTML : "+docObj.html());
		//fetch hyper links from xml tag from the html file <a href=" ">
		Elements links=docObj.select("a[href]");
		for(Element e:links)
		{
			System.out.println("link : "+e.attr("href"));
			System.out.println("link text value is : "+e.text());
		}
		
		Elements images=docObj.select("img[src~=(?i)\\.(png|jpg|jpeg|gif)]");//? is just a replacer to a character like /
		//~= is to find a regular expression and | is or symbol
		for(Element e:images)
		{
			log.info(e.attr("src"));
			log.info(e.attr("height"));
			log.info(e.attr("width"));
			
			//System.out.println("source : "+e.attr("src"));
			//System.out.println("height : "+e.attr("height"));
			//System.out.println("width : "+e.attr("width"));
		}
	}
	

}
