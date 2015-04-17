package com.cloudwick.training.Collections;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class SortExample {

	public static void main(String[] args) {
		List ls=new ArrayList();
		ls.add(12);
		ls.add(36);
		ls.add(15);
		ls.add(25);
		ls.add(11);
		for(Object i:ls)
		{
			System.out.println(i);
		}
		Collections.sort(ls);//collection is a class where as collections is an interface
		for(Object i:ls)
		{
			System.out.println(i);
		}
		
		List userList=new ArrayList();
		UserSort us=new UserSort();
		us.ssn=2343;
		us.name="krishna";
		userList.add(us);
		
		UserSort us1=new UserSort();
		us1.ssn=1843;
		us1.name="chaitanya";
		userList.add(us1);
		
		Collections.sort(userList);
		for(Object j:userList)
		{
			UserSort u=(UserSort) j;//we are type casting the j with the UserSort object
			System.out.println(u.ssn);
		}
		

	}

}
