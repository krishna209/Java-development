package com.cloudwick.training.Collections;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

public class MapExample {
	Map<Integer,String> dataMap;
	private void populateMap()
	{
		dataMap=new HashMap<>();
		dataMap.put(11, "F");
		dataMap.put(12, "B");
		dataMap.put(13, "C");
		dataMap.put(11, "A");
		//dataMap.put(null, null); this method while inserting will insert values(null) but while reading out(fetchData) there is null value which will throw null pointer exception.
	}
	private void fetchDataByKey()
	{
		Set<Integer> keySet=dataMap.keySet();//it creates snapshot 
		Iterator<Integer> itr=keySet.iterator();//it loops through snapshot created above
		while(itr.hasNext())
		{
			int i=itr.next();
			System.out.println("Key is :"+i);
			String var=dataMap.get(i);
			System.out.println("Value is:"+var);
			//dataMap.remove(13);/*this will throw concurrent modification exception we can avoid this by concurrent hash map i.e., we can do modification while looping through 
		}
	}
	private void fetchByEntry()
	{
		Set<Entry<Integer,String>> entries=dataMap.entrySet();
		for(Entry<Integer,String> entry:entries)
		{
			System.out.println("Entry key is:"+entry.getKey());
			System.out.println("Entry value is:"+entry.getValue());
		}
	}
	public static void main(String[] args) {
		
		MapExample me=new MapExample();
		me.populateMap();
		me.fetchDataByKey();
		me.fetchByEntry();
		
	}

}
