package com.cloudwick.training.core.threads;

import java.util.concurrent.*;

public class ExecuterExample {

	public static void main(String[] args) {
		ExecutorService ee=Executors.newFixedThreadPool(500);/* This returns back executor service */
		for (int i = 0; i < 500; i++) {
			UserThread ut = new UserThread(1000000 + i);
			ee.execute(ut);
		}
		ee.shutdown();
		
		do {
			
		}while(!(ee.isTerminated()));
		System.out.println("connection is terminated");
	}

}
