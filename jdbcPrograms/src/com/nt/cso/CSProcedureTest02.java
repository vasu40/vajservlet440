package com.nt.cso;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Types;
import java.util.Scanner;


//SQL> create or replace procedure P_GET_EMP_DETAILS_BY_ID
//  2  (
//  3  NO IN NUMBER
//  4  ,NAME OUT VARCHAR2
//  5  ,DESG OUT VARCHAR2
//  6  ,SALARY OUT VARCHAR2
//  7  )
//  8  AS
//  9  BEGIN
// 10    SELECT ENAME,JOB,SAL INTO NAME,DESG,SALARY FROM EMP WHERE EMPNO=NO;
// 11  END;
// 12  /
public class CSProcedureTest02 {
	private static final String CALL_PROCEDURE="{CALLP_GET_EMP_DETAILS_BY_ID(?,?,?,?)}";

	public static void main(String[] args) {
		//READ inputs
		int number;
		try(Scanner scn=new Scanner(System.in)){
			System.out.println("Enter the employee number::");
			number=scn.nextInt();
			
		    try(Connection con=DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe","system","7825");
		  //create CallableStatement object having the query callin g pl/sql procedure  as the pre-compiled sql query
		    		CallableStatement cs=con.prepareCall(CALL_PROCEDURE);){
		    	//REGISTER OUT PARAMS WITH JDBC DATA TYPE
		    	cs.registerOutParameter(2, Types.VARCHAR);
		    	cs.registerOutParameter(3, Types.VARCHAR);
		    	cs.registerOutParameter(4, Types.FLOAT);
		    	//set valus to in params
		    	if(cs!=null) {
		    		cs.setInt(1, number);  
		        }
		    	//execute procedure
		    	if(cs!=null)
		    		cs.execute();
		    	//gateher result from Out param
		    
		    	if(cs!=null) {
		    	String name=cs.getString(2);
		    	String desg=cs.getString(3);
		    	float salary=cs.getFloat(4);
		    	  System.out.println("name::"+name+"desg="+desg+"salary="+salary);
		    	}
		    		
		    }//try2	
		}//try1
		catch(SQLException se) {
			System.out.println("no register num is not thre:");
			se.printStackTrace();
			
		}
		catch(Exception e) {
			e.printStackTrace();
		}
	

	}//main

}//class
