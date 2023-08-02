package com.nt.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class EmployeeSearchServlet extends HttpServlet {
	private static final String GET_EMP_BY_EN0="SELECT EMPNO,ENAME,JOB,SAL,DEPTNO FROM EMP WHERE EMPNO=?";
	@Override
	public void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		//getPrintwriter
		PrintWriter pw=res.getWriter();
		//set contentTyoe
		res.setContentType("text/html");
		//read form data
		int no=Integer.parseInt(req.getParameter("eno"));
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
		   }
		catch(ClassNotFoundException cnfe) {
			cnfe.printStackTrace();
		}
		//write jdbc code
		try(Connection con=DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe","system","7825");
		   PreparedStatement ps=con.prepareStatement(GET_EMP_BY_EN0)){
				if(ps!=null)
					ps.setInt(1,no);
				try(ResultSet rs=ps.executeQuery()){
			
			if(rs!=null) {
				if(rs.next()) {
					pw.println("<h1 style='color:blue;text-align:center'>Employee Details are</h1>");
					
					pw.println("<p style='color:red;text-align:center'><b>Employee number::"+rs.getInt(1)+"</b></br>");
					pw.println("<b>Employee name::"+rs.getString(2)+"</b></br>");
					pw.println("<b>Employee desg::"+rs.getString(3)+"</b></br>");
					pw.println("<b>Employee salary::"+rs.getFloat(4)+"</b></br>");
					pw.println("<b>Employee salary::"+rs.getInt(5)+"</b></p>");
				}//if
				else {
					pw.println("<h1 style='color:red;text-align:center'>Employee Not foUND</h1>");
					}//else
				}//if
			pw.println("<br><br><p style='text-align:center'><a href='search.html'>Home</a>");
			}//try2
					
		}//try1		
		catch(SQLException se) {
			se.printStackTrace();
			}//catch
		catch(Exception e) {
			e.printStackTrace();
		}//cathc
	}//doget
   @Override
public void doPost(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
	doGet(req,res);
   }//dopost
}//class
