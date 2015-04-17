package com.cloudwick.training.IOExmaple;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

public class SerializableExample {
	
	public static void main(String[] args)
	{
		SerializableExample se=new SerializableExample();
		se.serializeData();
		se.deSerializeData();
		
	}
	public void serializeData()
	{
		UserSerialize us=new UserSerialize();
		us.setSsn(3456);
		us.setName("krishna");
		try {
			FileOutputStream fos=new FileOutputStream("serialize.txt");
			ObjectOutputStream oos=new ObjectOutputStream(fos);
			oos.writeObject(us);
			fos.flush();
			fos.close();
			oos.close();
			
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	private void deSerializeData()
	{
		try {
			FileInputStream fis=new FileInputStream("serialize.txt");
			ObjectInputStream ois=new ObjectInputStream(fis);
			UserSerialize usnew=(UserSerialize)ois.readObject();//we are taking object reference coz the object we are creating doesnt know what data it is 
			/*if (usnew instanceof UserSerialize){
			 * 	UserSerializable obj=(UserSerialize) usnew;
			 * }
				
				*/
			System.out.println(usnew.getSsn());
			System.out.println(usnew.getName());
			fis.close();
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
	}

}
