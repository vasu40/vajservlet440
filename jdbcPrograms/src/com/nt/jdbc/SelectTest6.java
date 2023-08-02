package com.nt.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

public class SelectTest6 {

	public static void main(String[] args) {
		Scanner sc=null;
		Statement st=null;
		ResultSet rs=null;
		Connection con=null;
		try {
			
	 //load jdbc driver class
	 Class.forName("oracle.jdbc.driver.OracleDriver");
	   //establish connection
	  con=DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:XE","system","7825");
	  //create jdbc statement
	  if(con!=null)
		  st=con.createStatement();
	  //prepare sql qury
	  String query="SELECT COUNT(*) FROM STUDENT";
	   System.out.println(query);
	   //execute query
	   if(st!=null)
		   rs=st.executeQuery(query);
	   //process the results (0 to 1 recors);
	   //process the resultset 
	    if(rs!=null) {
	    	 rs.next();
	    		int count=rs.getInt("Count(*)");
	    		System.out.println("Records count in Student DB table::"+count);
	    		
	    		
	    				
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
