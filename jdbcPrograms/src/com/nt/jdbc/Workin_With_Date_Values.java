package com.nt.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.Scanner;

public class Workin_With_Date_Values {
	  private static final String INSERT_DATE_QUERY="INSERT INTO PERSON_INFO_DATES VALUES(PID_SEQ.NEXTVAL,?,?,?,?)";

	public static void main(String[] args) {
		Scanner sc=null;
		Connection con=null;
		PreparedStatement ps=null;
		try {
			//read inputds
			sc=new Scanner(System.in);
			   String name=null,sdob=null,sdoj=null,sdom=null;
			   if(sc!=null) {
				    System.out.println("person name::");
				      name=sc.next();
				      System.out.println("person dob(dd-MM-yyyy)::");
				       sdob=sc.next();
				       System.out.println("person doj(yyyy-MM-dd)::");
				       sdoj=sc.next();
				       System.out.println("person sdom(MMM-dd-yyyy::");
				       sdom=sc.next();
			   }//if
			   //conver string date values to java.sql.Date class objs
			   //for Dob(dd-mm-yyyy)
			   //convert String date value to java.util.date class obj
			   SimpleDateFormat sdf1=new SimpleDateFormat("dd-MM-yyyy");
			   java.util.Date udob=sdf1.parse(sdob);
			   long ms=udob.getTime();
			   java.sql.Date sqdob=new java.sql.Date(ms);
			   java.sql.Date sqdoj=java.sql.Date.valueOf(sdoj);
			   SimpleDateFormat sdf2=new SimpleDateFormat("MMM-dd-yyyy");
			   java.util.Date udom=sdf2.parse(sdom);
			   ms=udom.getTime();
			   java.sql.Date sqdom=new java.sql.Date(ms);
			   //Class.forName("oracle.jdbc.driver.OracleDriver");
			   //establish connection
			   con=DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:XE","system","7825");
			     if(con!=null)
			    	 ps=con.prepareStatement(INSERT_DATE_QUERY);
			     if(ps!=null) {
			    	 ps.setString(1, name);
			    	 ps.setDate(2, sqdob);
			    	 ps.setDate(3, sqdoj);
			    	 ps.setDate(4, sqdom);
			     }
			     //execute query
			     int count=0;
			     if(ps!=null)
			    	 count=ps.executeUpdate();
			     if(count==0)
			    	 System.out.println("Record not insterted");
			     else
			    	 System.out.println("Record inserted");
		}//try
		catch(SQLException e) {
			e.printStackTrace();
		}
		catch(Exception e) {
			e.printStackTrace();
			}
       finally {
    	 
    	   
    	   try {
    		   if(ps!=null)
    			   ps.close();
    	   }
    	   catch(SQLException e) {
    		   e.printStackTrace();
    	   }
    	   //close jdbc objs
    	   try {
    		   if(con!=null)
    			   con.close();
    	   }
    	   catch(SQLException e) {
    		   e.printStackTrace();
    	   }
    	   //close jdbc objs
    	   try {
    		   if(sc!=null)
    			  sc.close();
    	   }
    	   catch(Exception e) {
    		   e.printStackTrace();
    	   }
       }
	}

}
     



			    	 
			   
			   
			   
			   
			  