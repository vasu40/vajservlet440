package com.nt.cso;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Types;
import java.util.Scanner;

//create or replace procedure first_pro(x in number,y in number,z out number)as
//2  begin
//3  z:=x+y;
//4  end;
//5  /
public class CSProcedureTest {
	private static final String CALL_PROCEDURE="{CALL FIRST_PRO(?,?,?)}";

	public static void main(String[] args) {
		//READ inputs
		int first=0;
		int second=0;
		try(Scanner scn=new Scanner(System.in)){
			System.out.println("Enter the first value::");
			first=scn.nextInt();
			System.out.println("Enter the second value::");
			second=scn.nextInt();
		    try(Connection con=DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe","system","7825");
		  //create CallableStatement object having the query callin g pl/sql procedure  as the pre-compiled sql query
		    		CallableStatement cs=con.prepareCall(CALL_PROCEDURE);){
		    	//REGISTER OUT PARAMS WITH JDBC DATA TYPE
		    	cs.registerOutParameter(3, Types.INTEGER);
		    	//set valus to in params
		    	if(cs!=null) {
		    		cs.setInt(1, first);
		    	    cs.setInt(2, second);
		        }
		    	//execute procedure
		    	if(cs!=null)
		    		cs.execute();
		    	//gateher result from Out param
		    	int result=0;
		    	if(cs!=null)
		    		result=cs.getInt(3);
		    	System.out.println("sum is::"+result);	
		    }//try2	
		}//try1
		catch(SQLException se) {
			se.printStackTrace();
			
		}
		catch(Exception e) {
			e.printStackTrace();
		}
	

	}//main

}//class
