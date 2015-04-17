package com.cloudwick.training.annotations;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

public class AnnotationProcessor {

	public static void main(String[] args) throws IllegalAccessException, IllegalArgumentException, InvocationTargetException {
		AnnotationUser au=new AnnotationUser();
		Method[] methods=au.getClass().getMethods();//this gives array of classes and then array of methods in class
		for(Method method:methods)
		{
			MyAnnotation ma=method.getAnnotation(MyAnnotation.class);
			if(ma!=null)
			{
				method.invoke(au);
			}
		}
	}
}
