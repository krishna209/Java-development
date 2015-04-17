package com.cloudwick.training.designpatterns1;

public class UserFactory {
	
	public static AuthenticateI getObject(int type)
	{
		AuthenticateI ai = null;
		if(type ==1)
		{
			ai=new AdminUser();
		}
		else if(type ==2)
		{
			ai=new GeneralUser();
		}
		return ai;
		
	}

}
