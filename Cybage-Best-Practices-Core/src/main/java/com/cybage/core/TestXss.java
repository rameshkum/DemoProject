package com.cybage.core;

public class TestXss {
	public static void main(final String[] args) throws Exception {
		// start the given number of threads
		for (int i = 1; i <= Integer.parseInt(args[0]); i++) {
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
			Thread.sleep(5);
		}
		// wait
		Thread.sleep(1000000);
	}
}