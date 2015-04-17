package com.cloudwick.training.core;

public class EnumExample {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println(CaliforniaEnum.WINTER.getId());
		System.out.println(CaliforniaEnum.FALL.getPay());
		for(CaliforniaEnum ce:CaliforniaEnum.values())
		{
			System.out.println("California ID is:"+ce+" California pay is "+ce.getPay());
		}

	}

}
