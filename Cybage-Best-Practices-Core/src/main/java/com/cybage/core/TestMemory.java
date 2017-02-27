package com.cybage.core;
public class TestMemory
  {
     public static void main(String ar[]) throws Exception
       {
    	  System.out.println("\tRun below commands");
          System.out.println("\n\t*****************************************************************");
          System.out.println("\n\tTry to run this program like: java TestMemory");
          System.out.println("\n\tTry to run this program like: java -Xms128m -Xmx1024m TestMemory");
          System.out.println("\n\tTry to run this program like: java -Xms256m -Xmx512m TestMemory");   
          System.out.println("\n\t*****************************************************************");
          System.out.println("\tMemory Utilization:");
          System.out.println("\n\tFreeMemory  : "+Runtime.getRuntime().freeMemory()/(1024*1024)+" MB");
          System.out.println("\n\tTotalMemory : "+Runtime.getRuntime().totalMemory()/(1024*1024)+" MB");
          System.out.println("\n\tMaxMemory   : "+Runtime.getRuntime().maxMemory()/(1024*1024)+" MB");
       }
  }