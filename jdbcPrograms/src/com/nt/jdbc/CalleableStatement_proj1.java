package com.nt.jdbc;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Types;
import java.util.Scanner;

public class CalleableStatement_proj1 {
	private static final String CALL_PROCEDURE="{CALL FIRST_PRO(?,?,?)}";
	public static void main(String[] args) {
		//READ INTPUTS
		int first=0,second=0;
		try(Scanner scn=new Scanner(System.in)){
			 if(scn!=null) {
				  System.out.println("enter first vlaue");
				  first=scn.nextInt();
				  System.out.println("Enter the seceond vlaue");
					   second=scn.nextInt();
			 }
			 //establish the connection
			 try(Connection con=DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:XE","system","7825");
				 //create CallableStatement object havaing precompiled 
				 CallableStatement cs=con.prepareCall(CALL_PROCEDURE);){
					//register out params with jdbc datatypes
				 if(cs!=null) 
					 cs.registerOutParameter(3,Types.INTEGER);
					 //SET values to i params
					    if(cs!=null) {
					   cs.setInt(1, first);
					   cs.setInt(2, second);
				 }
				 //execute/calal the pl/sql function
				 if(cs!=null)
					 cs.execute();
				 //gather results from out param
				 int result=0;
				 if(cs!=null)
					 result=cs.getInt(3);
				 System.out.println("sum is::"+result);
				 
				  }//try2
				  
			 }//try1
			catch(SQLException se) {
				se.printStackTrace();
		}
		catch(Exception e) {
			e.printStackTrace();
		}
	}//main

}//class
