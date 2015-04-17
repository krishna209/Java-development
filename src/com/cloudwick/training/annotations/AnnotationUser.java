package com.cloudwick.training.annotations;

public class AnnotationUser {
	public void getInfo()
	{
		System.out.println("GetInfo invoked");
	}
	//since it is in same package we dont need to import if it is in diff one we do.
	@MyAnnotation 
	public void getDetails()
	{
		System.out.println("GetDetails Invoked");
	}

}
