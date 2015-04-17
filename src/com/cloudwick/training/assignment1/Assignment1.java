package com.cloudwick.training.assignment1;

import java.io.*;

public class Assignment1 implements AssignmentInterface {
	
	public void searchZipCode(String fileName,int zip) 
	{
		File file=new File(fileName);
		FileInputStream fis=null;
		InputStreamReader isr=null;
		BufferedReader br=null;		
		try {
			fis=new FileInputStream(file);
			isr=new InputStreamReader(fis);
			br=new BufferedReader(isr);
			String str=null;
			String writeString=null;
			while((str=br.readLine())!=null)
			{
				String[] sr=str.split(",");
				int ID=Integer.parseInt(sr[0]);
				String firstName=sr[1];
				String lastName=sr[2];
				int zipCode=Integer.parseInt(sr[3]);
				if(zipCode==zip)
				{
					writeString=firstName+","+lastName;
					writeContent("output.txt",writeString);
					
				}
				
			}
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (NumberFormatException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally{
			try {
				br.close();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
	}
	public void writeContent(String opFile,String wrStr)
	{
		FileWriter fw=null;
		try {
			fw=new FileWriter(opFile,true);
			fw.append(wrStr+"\r\n");
						
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			
		} finally{
			if(fw!=null)
			{
				try {
					fw.flush();
					fw.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
				
			}
		}
		
	}

	public static void main(String[] args) throws IOException {
		Assignment1 as1=new Assignment1();
		as1.searchZipCode("input.txt",95438);

	}

}
