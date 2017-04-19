package com.cybage.core;

import java.util.Scanner;

class StarTriangle {
	public static void main(String[] args) {
		
		Thread thread = new Thread(){
			public void run(){
				int i, j, k, n;
				
				System.out.println("Please Enter number of rows to print:");
				
				Scanner scanner = new Scanner(System.in);
				n = scanner.nextInt();
				
				for (i = 1; i <= n; i++) {
					for (j = (n-1); j >= i; j--) {
						System.out.print("   ");
					}
					for (k = 1; k <= (2 * i - 1); k++) {
						try {
							Thread.sleep(200);
						} catch (InterruptedException e) {
							System.out.println("InterruptedException occured: "+e);
							e.printStackTrace();
						}
						System.out.print(" * ");
					}
					System.out.println("  ");
				}
			}
			
		};
		thread.start();
	}
}