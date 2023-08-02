package com.nt.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.Scanner;

public class RetriveDateObjects {
	  private static final String RETRIVE_DATE_QUERY="SELECT PID,PNAME,DOB,DOJ,DOM FROM PERSON_INFO_DATES";
	public static void main(String[] args) {
		Scanner sc=null;
		Connection con=null;
		PreparedStatement ps=null;
		ResultSet rs=null;
		try {
			//LOAD jdbc class
			Class.forName("oracle.jdbc.driver.OracleDriver");
			//establish connection
            con=DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:XE","system","7825");
			
		//create prepared statement obj
            if(con!=null)
            	  ps=con.prepareStatement(RETRIVE_DATE_QUERY);
			    //execte query
            if(ps!=null)
               rs=ps.executeQuery();
            //proces the result obj
            if(rs!=null) {
            	while(rs.next()) {
            		int pid=rs.getInt(1);
            		String name=rs.getString(2);
            		java.sql.Date sqdob=rs.getDate(3);
            		java.sql.Date sqdoj=rs.getDate(4);
            		java.sql.Date sqdom=rs.getDate(5);
            		//convert sql date to simple string format
            		SimpleDateFormat sdf=new SimpleDateFormat("dd-MM-yyyy");
            		String sdob=sdf.format(sqdob);
            		String sdoj=sdf.format(sqdoj);
            		String sdom=sdf.format(sqdom);
            		System.out.println(pid+" "+name+" "+sdob+" "+sdoj+" "+sdom);
            	}
            }
		}//try
		catch(SQLException e) {
			e.printStackTrace();
		}
		catch(Exception e) {
			e.printStackTrace();
			}
       finally {
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
