package com.cloudwick.training.json;

import java.util.List;

public class Employee {
	
	private String name;
	private String age;
	public String getName() {
		return name;
	}


	public void setName(String name) {
		this.name = name;
	}


	public String getAge() {
		return age;
	}


	public void setAge(String age) {
		this.age = age;
	}


	public List<String> getAliases() {
		return aliases;
	}


	public void setAliases(List<String> aliases) {
		this.aliases = aliases;
	}


	private List<String> aliases;
	

}
