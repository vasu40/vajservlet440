package com.nt.jdbc;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.Scanner;
import java.sql.DriverManager;
import java.sql.SQLException;

public class SelectTest4 {

	public static void main(String[] args) {
		 Scanner sc=null;
		 Connection con=null;
		 Statement st=null;
		 ResultSet rs=null;
		 
		try {
			 //read inputs
			sc=new Scanner(System.in);
					String initChars=null;
					if(sc!=null) {
						System.out.println("Enter initial charactersof employee name::");
						initChars=sc.next();
				}//if
		//convert input value as required for the sql query
					initChars="'"+initChars+"%'";//gives 's%'
					//register jdbc driver by oading
					//establish connection
					con=DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:XE","system","7825");
					//create statement
					if(con!=null)
						st=con.createStatement();
					//prepare sql qury
					String query="SELECT EMPNO,ENAME,JOB,SAL FROM EMP WHERE ENAME LIKE"+initChars;
					System.out.println(query);
					//send and execute query
				 if(st!=null)
					 rs=st.executeQuery(query);
				 //process the result set obj
				 if(rs!=null) {
					 boolean flag=false;
					 while(rs.next()) {
						 flag=true;
						 System.out.println(rs.getInt(1)+" "+rs.getString(2)+" "+rs.getString(3)+" "+rs.getFloat(4));
						 
					 }//while
					 if(flag==false)
						 System.out.println("No records found");
					  }//if
					 			
		   }//try
		catch(SQLException se) {
			se.printStackTrace();
		}
		catch(Exception e) {
			e.printStackTrace();
		}
		finally {
			//close jdbc objs
			try {
				 if(rs!=null)
					 rs.close();
				 
			 }//try
			catch(SQLException se) {
				  se.printStackTrace();
			}
			try {
				 if(st!=null)
					 st.close();
				 
			 }//try
			catch(SQLException se) {
				  se.printStackTrace();
			}
			try {
				 if(con!=null)
					 con.close();
				 
			 }//try
			catch(SQLException se) {
				  se.printStackTrace();
			}
			try {
				 if(sc!=null)
					 sc.close();
				 
			 }//try
			catch(Exception se) {
				  se.printStackTrace();
			}
		}
		

	}

}
