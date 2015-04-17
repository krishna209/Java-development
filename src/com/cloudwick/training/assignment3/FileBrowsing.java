package com.cloudwick.training.assignment3;

import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class FileBrowsing extends Thread {
	String dir;
	public FileBrowsing(String dirt)
	{
		this.dir=dirt;
	}

	public void run() {
		readDirectories(dir);
	}

	public void readDirectories(String dirName) {
		File[] files = new File(dirName).listFiles();
		FileInputStream fis = null;
		BufferedInputStream bis = null;
		for (File file : files) {
			// System.out.print(Thread.currentThread()+" ");
			if (file.isDirectory()) {
				readDirectories(file.getAbsolutePath());
				// System.out.println(dirName);
			} else if (file.getName().endsWith(".txt")) {
				try {
					fis = new FileInputStream(file);
					bis = new BufferedInputStream(fis);
					int data = 0;
					while ((data = bis.read()) != -1) {
						System.out.print((char) data);
					}
					System.out.println(Thread.currentThread());
					// System.out.println();
				} catch (FileNotFoundException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}

			}
		}

	}

	public static void main(String[] args) throws IOException {
		for (int i = 0; i < 4; i++) {
			FileBrowsing fb = new FileBrowsing("directoryProgram");
			fb.start();
		}
	}

}
