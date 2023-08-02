package com.nt.jdbc;

import java.io.FileInputStream;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Scanner;

public class Working_with_Large_Objects {
	private static final String INSERT_ARTIST1_QUERY="INSERT INTO ARTIST1_INFO VALUES(AID_SQL1.NEXTVAL,?,?,?)";
	

	public static void main(String[] args) {
		try(Scanner sc=new Scanner(System.in)) {
			  String name=null,addrs=null,photoLocation=null;
			   if(sc!=null) {
				     System.out.println("Enter artist name::");
				     name=sc.next();
				     System.out.println("enetr address::");
				     addrs=sc.next();
				     System.out.println("enetr artist location::");
				     photoLocation=sc.next();
			   }//if
			   //create InputStream pointing photofile
			   try(InputStream is=new FileInputStream(photoLocation)){
				   //establish connection
				  try(Connection con=DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:XE","system","7825")){
						  PreparedStatement ps=con.prepareStatement(INSERT_ARTIST1_QUERY);
						  //set values to query param
						  if(ps!=null) {
							  ps.setString(1,name);
							  ps.setString(2,addrs);
							  ps.setBinaryStream(3, is);
						  }//if
						  //execute the query
						  int count=0;
						  if(ps!=null)
							  count=ps.executeUpdate();
						  //process the result
						  if(count==0)
							  System.out.println("record not found");
						  else
							  System.out.println("record inserted");
						  
						  }//try3  
				  }//tyr2
			}//try1
		catch(SQLException se) {
		    se.printStackTrace();
		    System.out.println("problem in record insertion");
		}//catch1
		catch(Exception e) {
			e.printStackTrace();
			System.out.println("Error occor in program");
		}//catch2
		

	}//main

}//class
