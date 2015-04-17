package com.cloudwick.training.XML;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.jar.Attributes;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;

public class SAXExample extends DefaultHandler {
	
	List<UserModel> userList=new ArrayList<>();
	PersonModel personObj;
	UserModel userObj;
	String data;
	
	private void parseXML() throws ParserConfigurationException, SAXException, IOException
	{
		SAXParserFactory fac=SAXParserFactory.newInstance();
		SAXParser parser=fac.newSAXParser();
		parser.parse("Person.xml",this);
	}
	
	public void startElement(String url, String localName, String qName,Attributes attributes)//last two arguments are important here
	{
		if(qName.equals("person"))
		{
			personObj=new PersonModel();;
		}
		if(qName.equals("user"))
		{
			userObj=new UserModel();
			userObj.setUserID(attributes.getValue("userID"));
		}
	}
	
	public void characters(char[] ch,int start,int length)
	{
		data=new String(ch,start,length);
	}
	
	public void endElement(String url,String localName, String qName)
	{
		if(qName.equals("username"))
		{
			userObj.setUserName(data);
		}
		else if(qName.equals("password"))
		{
			userObj.setPassword(data);
		}
		else if(qName.equals("validity"))
		{
			userObj.setValidity(data);
		}
		else if(qName.equals("user"))
		{
			userList.add(userObj);
		}
		else if(qName.equals("person"))
		{
			personObj.setUserList(userList);
		}
		
	}
	
	public void printList()
	{
		Iterator<UserModel> itr=userList.iterator();
		while(itr.hasNext())
		{
			UserModel obj=itr.next();
			String userName=obj.getUserName();
			System.out.println(userName);
		}
	}

	public static void main(String[] args) throws ParserConfigurationException, SAXException, IOException {
		
		SAXExample sax=new SAXExample();
		sax.parseXML();
		
		sax.printList();
		
	}

}
