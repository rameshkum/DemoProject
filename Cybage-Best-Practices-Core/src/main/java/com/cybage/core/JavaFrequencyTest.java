package com.cybage.core;

import java.util.Arrays;
import java.util.Collections;
import java.util.Scanner;

public class JavaFrequencyTest {

	/**
	 * @param args
	 */
	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);
		System.out.print("Enter size : ");
		int n = sc.nextInt();
		
		int a[] = new int[n];
		for(int i=0;i<n;i++)
		{
			System.out.print("Enter value for array : ");
			a[i] = sc.nextInt();
		}
		System.out.print("Enter number to count frequency : ");
		int k = sc.nextInt();
		
		int frequency = Collections.frequency(Arrays.asList(a), k);
		
		System.out.println("Frequency of "+k+"is : " + frequency);
		
	}

}
