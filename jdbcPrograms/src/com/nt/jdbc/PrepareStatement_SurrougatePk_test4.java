package com.nt.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Scanner;

public class PrepareStatement_SurrougatePk_test4 {
	
	//CRETAE SQL QURY
	private static String STUDENT_INSERT_QUEY="INSERT INTO STUDENT VALUES(SNO_SEQ1.NEXTVAL,?,?,?";

	public static void main(String[] args) {
		Scanner sc=null;
		Connection con=null;
		PreparedStatement ps=null;
		
	try {
		//read inputs
		sc=new Scanner(System.in);
		int count=0;
		if(sc!=null) {
			System.out.println("enter student s count::");
			count=sc.nextInt();
		      }//if
		//establish connextion
		con=DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:XE","system","7825");
		  
		//CREATE PREPARED STATEMENT OBJECT
		if(con!=null)
			ps=con.prepareStatement(STUDENT_INSERT_QUEY);
		//read input values from end user
		if(ps!=null && sc!=null) {
			for(int i=1;i<=count;++i) {
				//read exavch student input values
				System.out.println("enter"+i+"student details");
				System.out.println("enetr studnemt name::");
				  String sname=sc.next();
				  System.out.println("enetr student address::");
				  String add=sc.next();
				  System.out.println("enetr student avg::");
				  float avg=sc.nextFloat();
				  
				  //set eacjh studnet details as pre compiled code
				  ps.setString(1, sname);ps.setString(2, add);ps.setFloat(3,avg);
				  
				  //execute pre compiled sql query
				  int result=ps.executeUpdate();
				  //process execution result of pre compiled sql query
				  if(result==0)
					   System.out.println(i+"student details not inserted");
				  else
					  System.out.println(i+"studrnt details are inserted");
			} //for
				
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