package com.cybage.core;

class StarTraingle {
	public static void main(String[] args) {
		
		Thread thread = new Thread(){
			public void run(){
				int i, j;
				for (i = 1; i < 6; i++) {
					for (j = 1; j <= i; j++) {
						System.out.print("*");
						System.out.print("\t");
						try {
							Thread.sleep(200);
						} catch (InterruptedException e) {
							System.out.println("InterruptedException occured:"+e);
							e.printStackTrace();
						}
					}
					System.out.println("\n");
					try {
						Thread.sleep(200);
					} catch (InterruptedException e) {
						System.out.println("InterruptedException occured:"+e);
						e.printStackTrace();
					}
				}
			}
		};
		
		thread.start();

	}
}