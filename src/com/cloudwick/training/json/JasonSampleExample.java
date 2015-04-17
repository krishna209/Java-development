package com.cloudwick.training.json;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.StringWriter;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.LinkedList;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

public class JasonSampleExample {
	
	private void createJson() throws IOException
	{
		JSONObject obj=new JSONObject();
		obj.put("name", "fremont");
		obj.put("age", "24");
		JSONArray arr=new JSONArray();
		arr.add("abc");
		arr.add("def");
		arr.add("ghi");
		obj.put("aliases", arr);
		
		FileWriter writer=new FileWriter("input.json");
		writer.write(obj.toJSONString());
		writer.flush();
		writer.close();
	}

	private void parseJson() throws IOException, ParseException
	{
		JSONParser parser=new JSONParser();
		FileReader reader=new FileReader("input.json");
		Object obj=parser.parse(reader);
		JSONObject jsonobj=(JSONObject) obj;
		System.out.println("Name : "+jsonobj.get("name"));
		System.out.println("Age : "+jsonobj.get("age"));
		JSONArray jarr=(JSONArray) jsonobj.get("aliases");
		Iterator<String> itr= jarr.iterator();
		System.out.print("Aliases : [");
		while(itr.hasNext())
		{
			System.out.print(itr.next()+",");
		}
		System.out.print("]");
	}
	
	private void complexJson() throws IOException
	{
		StringWriter writer=new StringWriter();
		JSONObject obj=new JSONObject();
		LinkedHashMap map=new LinkedHashMap();
		LinkedList list=new LinkedList();
		obj.put("name", "fremont");
		list.add("1");
		list.add("2");
		obj.put("datalist",list);
		map.put("Key1", "data1");
		map.put("Key2", list);
		obj.put("datamap", map);
		
		obj.writeJSONString(writer);// we can stream the content to writer object
		System.out.println("Json"+writer.toString());
	}
	
	public static void main(String[] args) throws IOException, ParseException {
		
		JasonSampleExample jse=new JasonSampleExample();
		jse.createJson();
		jse.parseJson();
		jse.complexJson();

	}
	
	

}
