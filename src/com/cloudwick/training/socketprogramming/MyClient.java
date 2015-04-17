package com.cloudwick.training.socketprogramming;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.Socket;
import java.net.UnknownHostException;

public class MyClient {
	
	

	public static void main(String[] args) throws UnknownHostException, IOException {
		Socket socket=new Socket("127.0.0.1",9000);
		OutputStream out=socket.getOutputStream();
		DataOutputStream dataout=new DataOutputStream(out);
		dataout.writeUTF("hi this is client");
		InputStream in=socket.getInputStream();
		DataInputStream datain=new DataInputStream(in);
		System.out.println("data received : "+ datain.readUTF());
		socket.close();
	}

}
