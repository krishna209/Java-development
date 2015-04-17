package com.cloudwick.training.designpatterns1;

public class UserClone implements Cloneable {
	public String name;
	public Object clone() throws CloneNotSupportedException
	{
		return super.clone();
	}

}
