package com.cloudwick.training.core.threads;

public class UserThread extends Thread {
	int number;

	public UserThread(int num) {
		this.number = num;
	}

	public void run() {
		int sum = 0;
		for (int i = 0; i <= number; i++) {
			sum = sum + i;
		}
		System.out.println("sum is :" + sum + ": Thread :"
				+ Thread.currentThread());
	}
}
