package com.cybage.core;
public class ReverseStringExample {
 
    public static void main(String args[]) {
     
       //Reverse String in Java with Using StringBuffer
        String str = "Ramesh on Java";
        String reverse = new StringBuffer(str).reverse().toString();
        System.out.printf(" original String : %s , reversed String: %s  %n", str, reverse);
     
        //Reverse String in Java with Using StringBuilder
        str = "Ramesh on Java";
        reverse = new StringBuilder(str).reverse().toString();
        System.out.printf(" original String : %s , reversed String: %s %n", str, reverse);
     
        //Reverse String in Java without Using StringBuffer or StringBuilder
        str = "Ramesh on Java";
        reverse = reverse(str);
        System.out.printf(" original String : %s , reversed String: %s %n", str, reverse);
    }
    
    public static String reverse(String source){
        if(source == null || source.isEmpty()){
            return source;
        }      
        String reverse = "";
        for(int i = source.length() -1; i>=0; i--){
            reverse = reverse + source.charAt(i);
        }
     
        return reverse;
    }
   
}
