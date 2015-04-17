package com.cloudwick.training.IOExmaple;

import java.io.BufferedInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

public class FileStreamExample {
	private void createMyFile(String fileName) throws DuplicateFileException,
			IOException {
		File fo = new File(fileName);
		if (fo.exists()) {
			
			throw new DuplicateFileException("please provide correct file name");
		} else {
			fo.createNewFile();
		}
	}

	private void writeContent(String fileName) throws IOException {
		FileOutputStream fos = null;
		String data = "this is first line of class";
		try {
			fos = new FileOutputStream(fileName);
			fos.write(data.getBytes());
			// fos.flush();
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			if (fos != null) {
				fos.close();
			}
		}
	}

	private void readContent(String fileName) {
		FileInputStream fis = null;
		BufferedInputStream bfs = null;
		try {
			fis = new FileInputStream(fileName);
			bfs = new BufferedInputStream(fis);
			int data = 0;
			while ((data = bfs.read()) != -1) {
				System.out.println((char) data);
			}
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public static void main(String[] args) throws DuplicateFileException,
			IOException {

		FileStreamExample fse = new FileStreamExample();
		//fse.createMyFile("transfer2.txt");
		fse.writeContent("transfer2.txt");
		fse.readContent("transfer2.txt");
	}

}
