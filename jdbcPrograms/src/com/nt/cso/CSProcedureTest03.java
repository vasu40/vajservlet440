package com.nt.cso;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Types;
import java.util.Scanner;



//SQL> create or replace procedure P_GET_STUDENT_DETAILS_BY_NO
//2  (
//3  NO IN NUMBER
//4  ,
//5  NAME OUT VARCHAR2
//6  ,ADDRESS OUT VARCHAR2
//7  ,FEE OUT VARCHAR2
//8  )
//9  AS
//10  BEGIN
//11  SELECT NAME,SADDRES,SFEE INTO NAME,ADDRESS,FEE FROM STUDENT1 WHERE SNO=NO;
//12  END;
//13  /

public class CSProcedureTest03 {
	private static final String CALL_PROCEDURE="{CALL P_GET_STUDENT_DETAILS_BY_NO(?,?,?,?)}";

	public static void main(String[] args) {
		//READ inputs
		int sno=0;
		try(Scanner scn=new Scanner(System.in)){
			if(scn!=null) {
			System.out.println("Enter the STUDENT number::");
			sno=scn.nextInt();
			}
		//establish the connection
		    try(Connection con=DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe","system","7825");
		  //create CallableStatement object having the query callin g pl/sql procedure  as the pre-compiled sql query
		    		CallableStatement cs=con.prepareCall(CALL_PROCEDURE);){
		    	//REGISTER OUT PARAMS WITH JDBC DATA TYPE
		    	if(cs!=null) {
		    	cs.registerOutParameter(2, Types.VARCHAR);
		    	cs.registerOutParameter(3, Types.VARCHAR);
		    	cs.registerOutParameter(4, Types.FLOAT);
		    	}
		    	//set valus to in params
		    	if(cs!=null) {
		    		cs.setInt(1, sno);  
		        }
		    	//execute procedure
		    	if(cs!=null) {
		    		System.out.println("execute query");
		    	cs.execute();
		    	
		    	}
		    	//gateher result from Out param
		    
		    	if(cs!=null) {
		    	String name=cs.getString(2);
		    	String address=cs.getString(3);
		    	float sfee=cs.getFloat(4);
		    	  System.out.println("name::"+name+"address="+address+"sfee="+sfee);
		    	}
		    		
		    }//try2	
		}//try1
		catch(SQLException se) {
			System.out.println("no register number is not there:");
			se.printStackTrace();
			
		}
		catch(Exception e) {
			e.printStackTrace();
		}
	

	}//main

}//class
