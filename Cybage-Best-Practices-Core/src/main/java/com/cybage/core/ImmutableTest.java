package com.cybage.core;

public class ImmutableTest {

	/**
	 * @param args
	 */
	public static void main(String[] args) {

		FinalPersonClass finalPersonClass = new FinalPersonClass("Ramesh", 25);
		FinalPersonClass finalPersonClass1 = new FinalPersonClass("Ramesh2", 256);
		System.out.println(finalPersonClass.toString());
		
		if(finalPersonClass == finalPersonClass1){
			System.out.println(finalPersonClass.toString());
		}
	}

}
