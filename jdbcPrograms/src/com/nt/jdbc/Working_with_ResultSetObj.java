package com.nt.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class Working_with_ResultSetObj {
	private static final String EMP_SELECT_QUERY="SELECT EMPNO,ENAME,JOB,SAL FROM EMP";

	public static void main(String[] args) {
		try(Connection con=DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:XE","system","7825");
				Statement st=con.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE,ResultSet.CONCUR_UPDATABLE);
				ResultSet rs=st.executeQuery(EMP_SELECT_QUERY);){
			if(rs!=null) {
				System.out.println("Rs records top to bottom");
				while(rs.next()) {
					System.out.println(rs.getRow()+" "+rs.getInt(1)+""+rs.getString(2)+" "+rs.getString(3)+" "+rs.getFloat(4));
				}
				System.out.println(" ================");
				System.out.println("Rs records to top");
				rs.afterLast();
				while(rs.previous()) {
					System.out.println(rs.getRow()+" "+rs.getInt(1)+""+rs.getString(2)+" "+rs.getString(3)+" "+rs.getFloat(4));
				}
				rs.first();
				System.out.println(rs.getRow()+" "+rs.getInt(1)+""+rs.getString(2)+" "+rs.getString(3)+" "+rs.getFloat(4));
				System.out.println("=============================");
				rs.last();
				System.out.println(rs.getRow()+" "+rs.getInt(1)+""+rs.getString(2)+" "+rs.getString(3)+" "+rs.getFloat(4));
				System.out.println("=============================");
				rs.absolute(3);
				System.out.println(rs.getRow()+" "+rs.getInt(1)+""+rs.getString(2)+" "+rs.getString(3)+" "+rs.getFloat(4));
				rs.absolute(-6);
				System.out.println(rs.getRow()+" "+rs.getInt(1)+""+rs.getString(2)+" "+rs.getString(3)+" "+rs.getFloat(4));
				System.out.println("=======================================");
				rs.relative(3);
				System.out.println(rs.getRow()+" "+rs.getInt(1)+""+rs.getString(2)+" "+rs.getString(3)+" "+rs.getFloat(4));
				System.out.println("========================================");
				rs.relative(-6);
				System.out.println(rs.getRow()+" "+rs.getInt(1)+""+rs.getString(2)+" "+rs.getString(3)+" "+rs.getFloat(4));
				System.out.println("========================================");
			}//if
				
				}//try
		catch(SQLException se) {
			se.printStackTrace();
				
			}//catch
		catch(Exception e) {
			e.printStackTrace();
			
			
		}//catch
		

	}//main

}//class
