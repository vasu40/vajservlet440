package com.nt.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Scanner;

public class PrepareStatement_InsertTest {
	 private static final String STUDENT_INSERT_QUERY="INSERT INTO STUDENT VALUES(?,?,?,?)";

	public static void main(String[] args) {
		Scanner sc=null;
		Connection con=null;
		PreparedStatement ps=null;
		try {
			//read intputs
			sc=new Scanner(System.in);
			int count=0;
			if(sc!=null) {
				System.out.println("enter student count::");
				count=sc.nextInt();
			    }
			//register jdbc driver
			con=DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:XE","system","7825");
			   //create prepared ststement obj
			ps=con.prepareStatement(STUDENT_INSERT_QUERY);
			 //read input values from enduser,set them to query param values and execute the
			//sql query for multiple times
			if(ps!=null &&sc!=null) {
				for(int i=1;i<=count;i++) {
					//read each student input values
					System.out.println("enter"+i+"student values");
					System.out.println("enter student number::");
					int sno=sc.nextInt();
					System.out.println("enter the student name::");
					String sname=sc.next();
					System.out.println("enetr the student address::");
					String sadd=sc.next();
					System.out.println("enter the student avg::");
					float avg=sc.nextFloat();
					//set each student details as pre compiled sql query params
					ps.setInt(1, sno);ps.setString(2, sname);ps.setString(3, sadd);ps.setFloat(4, avg);
					//execute pre-compiled sql query each time
					int result=ps.executeUpdate();
					//process execution result of pre-compilred-sql query
					if(result==0)
						System.out.println(i+"student details not inserted");
					else
						System.out.println(i+"student details are insert");
					    }//for	
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
