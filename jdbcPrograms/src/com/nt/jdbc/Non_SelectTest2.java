package com.nt.jdbc;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.Scanner;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Non_SelectTest2 {

	public static void main(String[] args) {
		Scanner sc=null;
		Statement st=null;
		Connection con=null;
		ResultSet rs=null;
		
		try {
		sc=new Scanner(System.in);
		String user=null,pwd=null;
		if(sc!=null) {
			 System.out.println("ENter the username::");
			 user=sc.nextLine();
			 System.out.println("Enter the password::");
			 pwd=sc.nextLine();
		    } //if
		//covert inptut values into requried query
		user="'"+user+"'";
		pwd="'"+pwd+"'";
		//load jdbs calls
		Class.forName("oracle.jdbc.driver.OracleDriver");
		//create connection
		con=DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:XE","system","7825");
			//cretae Statement obj
		if(con!=null)
			st=con.createStatement();
		//prepare sql query
		String query="select count(*) from  IRTC_TAB where uname="+user+"and pwd="+pwd;
		   System.out.println(query);
		   //execute query
		   if(st!=null)
		         rs=st.executeQuery(query);
		   //process the rs obj
		   if(rs!=null) {
			    rs.next();
			    int count=rs.getInt(1);
			    //process the result
			       if(count==0)
			    	   System.out.println("INVALID CREDENTIALS");
			       else
			    	   System.out.println("Valid credentials");
		        }//if
		   }//try
		catch(SQLException se) {
	    	se.printStackTrace();
	    }
			catch(Exception e) {
				 e.printStackTrace();
			}
			finally {
				
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
