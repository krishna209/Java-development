package com.cloudwick.training.core.threads;

import java.util.ArrayList;
import java.util.List;

public class ThreadExample extends Thread {

	public static void main(String[] args) throws InterruptedException {
		List<Thread> threadList = new ArrayList<>();
		for (int i = 0; i < 5000; i++) {
			UserThread ut = new UserThread(1000000 + i);
			ut.start();/*
						 * Here after running we will see the thread numbers
						 * assigned by JVM in output
						 */
			ut.setName("Krishna-" + i);/*
										 * This sets the thread name to user
										 * defined thread
										 */
			if (i > 50 && i < 100) {
				ut.setPriority(Thread.MIN_PRIORITY);/*
													 * This changes the priority
													 * of the thread to minimum
													 * which we can see in
													 * the[current_thread
													 * ,priority,parent_thread]
													 * middle value in the
													 * thread output
													 */

			}
			threadList.add(ut);
		}
		int running = 0;
		do {
			running = 0;
			for (Thread t : threadList) {
				if (t.isAlive()) {
					running++;
				}
			}
		} while (running != 0);
		Thread.currentThread().sleep(10000);
		System.out.println("system is done processing");
	}

}
