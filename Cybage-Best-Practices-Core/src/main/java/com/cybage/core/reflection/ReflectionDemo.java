package com.cybage.core.reflection;

import java.lang.reflect.Constructor;
import java.lang.reflect.Method;

public class ReflectionDemo {

	public String getName() {
		return "Reflection Demo";
	}
	
	public String getName1() {
		return "Reflection Demo1";
	}
	
	public String getName2() {
		return "Reflection Demo2";
	}
	
	
	public ReflectionDemo() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @param args
	 * @throws ClassNotFoundException 
	 */
	public static void main(String[] args) throws ClassNotFoundException {
		// TODO Auto-generated method stub

		Class classObject = Class.forName("com.cybage.core.reflection.ReflectionDemo");
		
		//Logic to get the Constructors
		/*		
		Constructor constructors[] = classObject.getConstructors();
		
		for(Constructor constructor :  constructors){
			if(!constructor.isAccessible()){
				System.out.println("it is accessible");
			}
		}
		*/
		
		
		Method[] methods = classObject.getMethods();
		
		for( Method  method : methods){
			System.out.println("Method Name:"+method.getName());
		}
		
	}

}
