package com.nt.test;

import java.lang.reflect.Constructor;
import java.util.Scanner;

public class DemoTest02 {
	

	public static void main(String[] args) {
		try {
			Scanner scn=new Scanner(System.in);
			System.out.println("Enter the calss name::");
			String cname=scn.next();
			//load the class name
			Class c=Class.forName(cname);
			//get all Constructor using 0-param constructor
			Constructor cons[]=c.getDeclaredConstructors();
			//object creation using 0-pram constructor
			Object obj1=cons[0].newInstance();
			System.out.println("data of obj1::"+obj1);
			System.out.println("=======================");
			Object obj2=cons[1].newInstance(45,48);
			System.out.println("DATA OF OBJ2::"+obj2);
			
			
			
			
		}
     catch(Exception e) {
    	 System.out.println(e);
     }
	}

}
