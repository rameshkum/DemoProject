package com.cybage.core;

import java.util.HashMap;
import java.util.Scanner;

class MapTest
{
    public static void main(String args[]){
        HashMap<Integer,Integer> h = new HashMap<Integer,Integer>();
        int arr[] = new int[]{2,2,2,2,3,3,3,5,6,7,9,8,9,0,10,15,10,10,10,10,10,10};
        for(int i=0; i<arr.length; i++){
            if(h.containsKey(arr[i])){
                h.put(arr[i], h.get(arr[i]) + 1);
            } else {
                h.put(arr[i], 1);
            }
        }
        System.out.println("Map of key value pairs: "+ h);
        
        System.out.println("\nPlease Enter number to find frequency in Array:");
		Scanner sc = new Scanner(System.in);
		int number = sc.nextInt();
        
		System.out.println("Frequency of "+number+" is: "+h.get(number));
		
    }
}