package com.cloudwick.training.XML;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

public class DOMExample {
	private Document dom;
	public static void main(String[] args) throws ParserConfigurationException, SAXException, IOException {
		DOMExample dome=new DOMExample();
		dome.parseXMLFile();
		dome.processDocument();
	}
	private void parseXMLFile() throws ParserConfigurationException, SAXException, IOException
	{
		DocumentBuilderFactory dbf=DocumentBuilderFactory.newInstance();//these three lines are default for any DOM parsing
		DocumentBuilder db=dbf.newDocumentBuilder();
		dom=db.parse("Person.xml");
	}
	private void processDocument()
	{
		/*getting the root element in the Person.xml file */
		Element rootEl=dom.getDocumentElement();//1st went to person tag
		NodeList userList=rootEl.getElementsByTagName("user");//then to user tag 
		List<UserModel> userModelList=new ArrayList<>();
		for(int i=0;i<userList.getLength();i++)//now loop through the elements under the user tag
		{
			Element user=(Element)userList.item(i);	
			String id=user.getAttribute("userID"); 
			
			NodeList userNameList=user.getElementsByTagName("userName");
			Element uNameEl=(Element) userNameList.item(0);
			String uname= uNameEl.getFirstChild().getNodeValue();
			System.out.println(uname);
			
			NodeList passwordList=user.getElementsByTagName("password");
			Element passElement=(Element) passwordList.item(0);
			String pwd= passElement.getFirstChild().getNodeValue();
			System.out.println(pwd);
			
			NodeList validityList=user.getElementsByTagName("validity");
			Element valEl=(Element) validityList.item(0);
			String val= valEl.getFirstChild().getNodeValue();
			System.out.println(val);
			
			UserModel um=new UserModel();
			um.setUserID(id);
			um.setUserName(uname);
			um.setPassword(pwd);
			um.setValidity(val);
			userModelList.add(um);
		}
		PersonModel pm=new PersonModel();
		pm.setUserList(userModelList);
		
		
		
	}

}
