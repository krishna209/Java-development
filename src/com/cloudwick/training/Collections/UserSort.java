package com.cloudwick.training.Collections;

public class UserSort implements Comparable<UserSort> {
	public int ssn;
	public String name;
	@Override
	public int compareTo(UserSort obj) {
		// TODO Auto-generated method stub
		return obj.ssn-this.ssn;
	}
	

}
