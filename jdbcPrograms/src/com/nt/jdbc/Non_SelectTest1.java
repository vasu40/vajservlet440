package com.nt.jdbc;

import java.sql.Connection;
import java.sql.Statement;
import java.util.Scanner;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Non_SelectTest1 {
	public static void main(String[] args) {
		Scanner sc=null;
		Statement st=null;
		Connection con=null;
		try {
			//READ INPUT VALUES
			sc=new Scanner(System.in);
		   String city=null;
		   if(sc!=null) {
			   System.out.println("Enter the city::");
			    city=sc.next();
		   }//if
         city="'"+city+"'"; //gives hyd
         //register jdbc driver by loading jdbc driver class
         //establish the connection
         con=DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:XE","system","7825");
         //cretae statement obj
         if(con!=null)
        	 st=con.createStatement();
         //prepare sqlstatement
         String query=" delete from student where SADD="+city;
         
         System.out.println(query);
         //send and execute sql query
         int count=0;
         if(st!=null)
        	  count=st.executeUpdate(query);
         //process the result
         if(count==0)
        	 System.out.println("No records found to delete");
         else
        	 System.out.println("no of record s that are effected::"+count);
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
