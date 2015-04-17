package com.cloudwick.training.assignment2;

import java.io.*;
import java.util.*;
public class StateCount {
	Map<String,Integer> dataMap1;
	public void searchState(String fileName)
	{
		File file=new File(fileName);
		FileInputStream fis=null;
		InputStreamReader isr=null;
		BufferedReader br=null;
		dataMap1=new HashMap<>();
		try {
			fis=new FileInputStream(file);
			isr=new InputStreamReader(fis);
			br=new BufferedReader(isr);
			String str=null;
			String state="";
			int age;
			int commonCount=0,caCount=0,mdCount=0,njCount=0,ncCount=0,inCount=0;
			while((str=br.readLine())!=null)
			{
				String[] sr=str.split(",");
				String firstName=sr[0];
				String lastName=sr[1];
				age=Integer.parseInt(sr[2]);
				state=sr[3];
				//System.out.println(state+" "+age);
				if(sr[3].equals("CA") && age>20)
				{
					caCount++;
					dataMap1.put(state,caCount);
				}
				else if(state.equals("MD") && age>20)
				{
					mdCount++;
					dataMap1.put(state,mdCount);
				}
				else if(state.equals("NJ") && age>20)
				{
					njCount++;
					dataMap1.put(state,njCount);
				}
				else if(state.equals("NC") && age>20)
				{
					ncCount++;
					dataMap1.put(state,ncCount);
				}
				else if(state.equals("IN") && age>20)
				{
					inCount++;
					dataMap1.put(state,inCount);
				}
				else
				{
					//no count
				}
				
			}
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			try {
				br.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		
	}
	public void fetchData(String outputFile) throws IOException 
	{
		FileWriter fw=null;
		BufferedWriter bw=null;
		String app;
		Set<String> key=dataMap1.keySet();
		Iterator<String> itr=key.iterator();
		while(itr.hasNext())
		{
			String state=itr.next();
			int countState=dataMap1.get(state);
			//System.out.println(state+","+countState);
			try {
				
				fw=new FileWriter(outputFile,true);
				app=state+","+countState;
				//System.out.println(app+"\r\n");
				fw.write(app+"\r\n");
				fw.flush();
			} catch (IOException e) {
				e.printStackTrace();
			} 
		}
		//fw.flush();
		fw.close();
		
		
	}
	public static void main(String[] args) throws IOException
	{
		
		StateCount sc=new StateCount();
		sc.searchState("CollectionInput.txt");
		sc.fetchData("CollectionOutput.txt");
	}

}
