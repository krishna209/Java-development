/**
 * 
 */
package com.cloudwick.training.designpatterns1;


public class GeneralUser implements AuthenticateI {

	@Override
	public boolean authenticate() {
		// TODO Auto-generated method stub
		System.out.println("this is general user program");
		return false;
	}

}
