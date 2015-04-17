package com.cloudwick.training.designpatterns1;

public class FactoryExample {
	
	public static void main(String[] args)
	{
		AuthenticateI ai2=UserFactory.getObject(1);
		ai2.authenticate();
		AuthenticateI ai=UserFactory.getObject(2);
		ai.authenticate();
		
		System.out.println("");
		
	}

}
