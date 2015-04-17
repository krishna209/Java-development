package com.cloudwick.training.XML;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;

import org.apache.xml.serialize.OutputFormat;
import org.apache.xml.serialize.XMLSerializer;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Text;

public class DomXMLExample {
	public Document dom;
	public List<UserModel> userList=new ArrayList<>();
	
	public void createDocument() throws ParserConfigurationException
	{
		DocumentBuilderFactory fac=DocumentBuilderFactory.newInstance();
		DocumentBuilder doc=fac.newDocumentBuilder();
		dom=doc.newDocument();
		
	}
	
	public void populateUsers()
	{
		UserModel obj=new UserModel();
		obj.setUserID("11");
		obj.setUserName("racha");
		obj.setPassword("rambola");
		obj.setValidity("20");
		userList.add(obj);
		
		obj.setUserID("12");
		obj.setUserName("kirak");
		obj.setPassword("basha");
		obj.setValidity("23");
		userList.add(obj);
		
		obj.setUserID("13");
		obj.setUserName("manikyam");
		obj.setPassword("muthu");
		obj.setValidity("23");
		userList.add(obj);		
		
	}
	
	public void createXML()
	{
		//creating root element
		Element rootEl=dom.createElement("person");// here we have not created root element yet 
		dom.appendChild(rootEl);// this creates the root element <person>
		Iterator<UserModel> itr=userList.iterator();
		while(itr.hasNext())
		{
			UserModel obj=itr.next();
			//creating user element 
			Element userEl=dom.createElement("user");
			userEl.setAttribute("UserID", obj.getUserID());
			
			//appending child nodes to user element
			Element unEl=dom.createElement("username");
			Text unText=dom.createTextNode(obj.getUserName());
			unEl.appendChild(unText);
			userEl.appendChild(unEl);
			
			Element pwdEl=dom.createElement("password");
			Text unPwd=dom.createTextNode(obj.getPassword());
			pwdEl.appendChild(unPwd);
			userEl.appendChild(pwdEl);
			
			Element valEl=dom.createElement("validity");
			Text unVal=dom.createTextNode(obj.getValidity());
			valEl.appendChild(unVal);
			userEl.appendChild(valEl);
			
			rootEl.appendChild(userEl);
		}
		
		
	}
	public void printXMLComtent() throws IOException
	{
		OutputFormat format=new OutputFormat(dom);
		format.setIndenting(true);
		XMLSerializer serializer=new XMLSerializer(new FileOutputStream("userOutput.xml"),format);
		serializer.serialize(dom);
		
	}

	public static void main(String[] args) throws ParserConfigurationException, IOException {
		
		DomXMLExample dxe=new DomXMLExample();
		dxe.createDocument();
		dxe.populateUsers();
		dxe.createXML();
		dxe.printXMLComtent();
		
		
		

	}

}
