package com.cybage.core;
class Test {
   public static void main(String args[]) { 
	   
     System.out.println(fun());
     
   }
 
   static int fun()
   {
      int x= 10;  //Error: Static local variables are not allowed   static   int x= 10; 
     return x--;
   }
} 