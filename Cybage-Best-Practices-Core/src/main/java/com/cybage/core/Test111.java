package com.cybage.core;

import java.util.Scanner;

public class Test111 {

	/**
	 * @param args
	 */
	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);
		System.out.print("Enter size : ");
		int n = sc.nextInt();
		
		for (int i = n; i >= 0; --i) {
			for (int j = i; j > 0; --j) {
				System.out.print(j+"\t");
			}
/*			for(int k= i; k >=0 ; k++){
				System.out.print(k+"\t");
			}*/
			System.out.println("\n");
		}
		for (int i = 1; i<=n; i++) {
			for (int j = i; j > 0; --j) {
				System.out.print(j+"\t");
			}			
			System.out.println("\n");
		}
		
	}

}
