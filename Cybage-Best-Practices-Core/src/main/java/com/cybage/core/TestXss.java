package com.cybage.core;

import java.util.Scanner;

public class TestXss {
	public static void main(final String[] args) throws Exception {
		
		Scanner scanner = new Scanner(System.in);
		
		System.out.println("Please enter number:");
		
		int n = scanner.nextInt();
		
		// start the given number of threads
		for (int i = 1; i <= n; i++) {
			System.out.println("Starting Thread " + i);
			final Thread t = new Thread("T[" + i + "]") {
				public void run() {
					try {
						while (true) {
							Thread.sleep(1000);
						}
					} catch (Exception e) {
						e.printStackTrace();
					}
				}
			};
			t.setDaemon(true);
			t.start();
			Thread.sleep(50);
//			System.out.println("Daemon is running");
		}
		// wait
		Thread.sleep(1000000);
	}
}