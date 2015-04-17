package com.cloudwick.training.IOExmaple;

import java.io.BufferedInputStream;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.zip.ZipEntry;
import java.util.zip.ZipOutputStream;

public class CompressionExample {

	public static void main(String[] args) throws IOException {
		FileOutputStream fos=new FileOutputStream("user.zip");
		ZipOutputStream zos=new ZipOutputStream(fos);
		ZipEntry ze=new ZipEntry("inputCE.txt");
		zos.putNextEntry(ze);
		FileInputStream fis=new FileInputStream("inputCE.txt");
		BufferedInputStream bis=new BufferedInputStream(fis);
		int read =0;
		while((read=bis.read())!=-1)
		{
			zos.write((char)read);
		}
		fis.close();
		zos.closeEntry();
		zos.close();

	}

}
