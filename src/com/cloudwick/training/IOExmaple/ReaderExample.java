package com.cloudwick.training.IOExmaple;

import java.io.BufferedInputStream;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.IOException;

public class ReaderExample {

	public static void main(String[] args) throws FileNotFoundException {
		// TODO Auto-generated method stub
		FileReader fr = null;
		BufferedReader br = null;

		fr = new FileReader("transfer.txt");
		br = new BufferedReader(fr, 50);
		String data=null;
		try {
			while((data=br.readLine())!=null)
			{
				System.out.println(data);
			}
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

}
