package com.cloudwick.training.designpatterns1;

public class ClonableExample extends UserClone{

	

	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub
		ClonableExample ce=new ClonableExample();
		ce.name="fremont";
		System.out.println("name :"+ce.name);
		ClonableExample ce2=new ClonableExample();
		System.out.println("second"+ce2.name);
		ClonableExample ce3=(ClonableExample) ce.clone(); 
		System.out.println("third"+ce3.name);
		

	}

}
