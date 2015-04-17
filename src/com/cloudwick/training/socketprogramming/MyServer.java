package com.cloudwick.training.socketprogramming;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.ServerSocket;
import java.net.Socket;

public class MyServer extends Thread {
	// MyServer class acts as thread since it is supposed to switched on all the time
	
	private ServerSocket server;
	public void run()
	{
		while(true)
		{
			try {
				Socket sock=server.accept();
				InputStream in=sock.getInputStream();
				DataInputStream data=new DataInputStream(in);
				System.out.println("data received : "+data.readUTF());
				OutputStream out=sock.getOutputStream();
				DataOutputStream dataout=new DataOutputStream(out);
				dataout.writeUTF("Thanks token is 21");
				sock.close();				
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}// this will start accepting the requests from client 
		}
	}
	
	public MyServer(int port) throws IOException
	{
		server=new ServerSocket(port);
	}
	
	
	public static void main(String[] args) throws IOException {
		MyServer server=new MyServer(9000);//9000 is the port number which is free port in your system
		server.start();
	}

}
