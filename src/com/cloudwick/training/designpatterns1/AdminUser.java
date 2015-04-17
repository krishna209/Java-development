package com.cloudwick.training.designpatterns1;

public class AdminUser implements AuthenticateI {

	@Override
	public boolean authenticate() {
		System.out.println("this coming from authenticate and in aadmin user");
		return false;
	}

}
