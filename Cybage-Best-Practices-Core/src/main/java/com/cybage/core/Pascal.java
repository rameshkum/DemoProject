package com.cybage.core;

import java.util.Scanner;

public class Pascal {
	public static void main(String[] args) {
		
		Thread thread = new Thread( new Runnable(){
            public void run(){
            	int bin, p, q, r, x;
        		Scanner s = new Scanner(System.in);
        		System.out.println("Please Enter number of rows: ");
        		r = s.nextInt();
        		bin = 1;
        		q = 0;

        		System.out.print("Pascal's Triangle: \n");

        		while (q < r) {
        			for (p = 40 - 3 * q; p > 0; --p)
        				System.out.print(" ");
        			for (x = 0; x <= q; ++x) {
        				if ((x == 0) || (q == 0))
        					bin = 1;
        				else
        					bin = (bin * (q - x + 1)) / x;
        				System.out.print("     ");
        				System.out.print(bin);
        			}

        			System.out.println("");
        			try {
						Thread.sleep(200);
					} catch (InterruptedException e) {
						
						e.printStackTrace();
					}
        			++q;
        		}
            }
        });
		
		
		thread.start();
	}
}