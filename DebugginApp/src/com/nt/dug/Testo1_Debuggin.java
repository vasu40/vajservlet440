package com.nt.dug;

import java.util.Scanner;

public class Testo1_Debuggin {
	
	
	public  void sayHello(String uname) {
		System.out.println("Testo1_Debuggin.sayHello()");
		for(int i=1;i<=10;++i) {
		      System.out.println(uname+" "+i);
	       }
		System.out.println("End if the sayHello(-)");
	Scanner scn=new Scanner(System.in);
	String msg=scn.next();
	scn.close();
	displayMsg(msg);
	}
	public void displayMsg(String msg) {
		System.out.println("Testo1_Debuggin.displayMsg()"+msg);
		System.out.println("Testo1_Debuggin.displayMsg()"+msg);	
		printNumbers(10);
	}
	private void printNumbers(int n) {
		System.out.println("Testo1_Debuggin.printNumbers()");
		for(int i=1;i<=10;i++)
		System.out.println(i);
		System.out.println("end");
		
	}
	public int add(int a,int b) {
		System.out.println("Testo1_Debuggin.add()");
		return a+b;
		
	}
	public int sub(int a,int b) {
		System.out.println("Testo1_Debuggin.sub()");
		return a-b;
		
	}
	
	public static void main(String[] args) {
		Testo1_Debuggin app1=new Testo1_Debuggin(); 
		app1.sayHello("raja");
		app1.add(10,20);
		app1.sub(30,20);
	}

}
