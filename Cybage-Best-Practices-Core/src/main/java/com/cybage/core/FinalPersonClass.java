package com.cybage.core;
public final class FinalPersonClass {

      private final String name; 
      private final int age; 
      
      public FinalPersonClass(final String name, final int age) { 
            super(); 
            this.name = name; 
            this.age = age; 
      } 
      public int getAge() { 
            return age; 
      } 
      public String getName() { 
            return name; 
      } 
      
      
      public String toString(){
		return "Name: "+name+"\nAge:"+age;
      }
      
}
