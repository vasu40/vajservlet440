package com.nt.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Scanner;

public class PrepareStatement_Login_App_Test3 {
   private static final String LOGIN_QUERY="SELECT COUNT(*) FROM IRTC_TAB WHERE UNAME=? AND PWD=?";
   
	public static void main(String[] args) {
          	Scanner sc=null;
          	Connection con=null;
          	PreparedStatement ps=null;
          	ResultSet rs=null;
          	try {
          		//READ INPUTS 
          		sc=new Scanner(System.in);
          		String user=null,pass=null;
          		if(sc!=null)
          		{
          			System.out.println("enter login user name::");
          			   user=sc.next();
          			   System.out.println("netr login user pass::");
          			    pass=sc.next();
          			    }//if
          		//Load JDBC CONNECTION
          		con=DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:XE","system","7825");
          		//CREATE JDBC PREPARE STATEMENT 
          		 if(con!=null)
          			 ps=con.prepareStatement(LOGIN_QUERY);
          		 
          		 //set Vlaues to pramnof precompile sql query
          		 if(ps!=null) {
          			 ps.setString(1, user);
          		    ps.setString(2, pass);
          		 }
          		 //send and execute sql query in db s/w
          		   if(ps!=null)
          		 rs=ps.executeQuery();
          		   //process result set obj
          		   if(rs!=null) {
          			   rs.next();
          			   int count=rs.getInt(1);
          			   
             //PROCESS THE RESULT
          		   if(count==0)
          			   System.out.println("invalid credentials");
          		   else
          		   System.out.println("valid credentials");
          		   }//if
          			
          	}//try
          	catch(SQLException e) {
    			e.printStackTrace();
    		}
    		catch(Exception e) {
    			e.printStackTrace();
    			}
           finally {
        	   //close jdbc objs
        	   try {
        		   if(rs!=null)
        			   rs.close();
        	   }
        	   catch(SQLException e) {
        		   e.printStackTrace();
        	   }
        	   
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
         

	


