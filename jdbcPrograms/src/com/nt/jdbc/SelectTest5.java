package com.nt.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

public class SelectTest5 {

	public static void main(String[] args) {
		Scanner sc=null;
		Statement st=null;
		ResultSet rs=null;
		Connection con=null;
		try {
			//read inputs
			sc=new Scanner(System.in);
			int dno=0;
			if(sc!=null)
			{
				System.out.println("Enter the dno::");
			  dno=sc.nextInt();
		   }//if
	 //load jdbc driver class
	 Class.forName("oracle.jdbc.driver.OracleDriver");
	   //establish connection
	  con=DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:XE","system","7825");
	  //create jdbc statement
	  if(con!=null)
		  st=con.createStatement();
	  //prepare sql qury
	  String query="SELECT DEPTNO,DNAME,LOC FROM DEPT WHERE DEPTNO="+dno;
	   System.out.println(query);
	   //execute query
	   if(st!=null)
		   rs=st.executeQuery(query);
	   //process the results (0 to 1 recors);
	   //process the resultset 
	    if(rs!=null) {
	    	 if(rs.next())
	    		  System.out.println(rs.getInt(1)+" "+rs.getString(2)+" "+rs.getString(3));
	    	 else
	    		 System.out.println("No record Found");
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
