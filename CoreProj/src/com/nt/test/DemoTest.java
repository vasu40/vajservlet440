package com.nt.test;

import java.util.Scanner;

public class DemoTest {

	public static void main(String[] args) {
		Scanner scn=new Scanner(System.in);
		try {
			System.out.println("Enter the class name::");
			String cname=scn.next();
			//loading the class
			Class c=Class.forName(cname);
			//create dynamic object
			Object obj=c.newInstance();
			System.out.println(obj);
		}
		catch(Exception e) {
			e.printStackTrace();
		}

	}

}
