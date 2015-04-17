package com.cloudwick.training.json;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.codehaus.jackson.JsonGenerationException;
import org.codehaus.jackson.map.JsonMappingException;
import org.codehaus.jackson.map.ObjectMapper;

public class JacksonEample {

	public static void main(String[] args) throws JsonGenerationException, JsonMappingException, IOException {
		Employee emp=new Employee();
		emp.setAge("13");
		emp.setName("krish");
		List<String> list=new ArrayList<>();
		list.add("abd");
		list.add("def");
		list.add("ghi");
		emp.setAliases(list);
		ObjectMapper mapper=new ObjectMapper();
		File file=new File("anotherinput.json");
		mapper.writeValue(file, emp);
		
		Employee EmpObj=mapper.readValue(file, Employee.class);
		System.out.println("Age : "+EmpObj.getAge());
		System.out.println("Name : "+EmpObj.getName());
		
		
	}

}
