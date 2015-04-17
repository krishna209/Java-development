package com.cloudwick.training.IOExmaple;

import java.io.Serializable;

public class UserSerialize implements Serializable {
	
	private int ssn;
	public int getSsn() {
		return ssn;
	}
	public void setSsn(int ssn) {
		this.ssn = ssn;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	private String name;

}
