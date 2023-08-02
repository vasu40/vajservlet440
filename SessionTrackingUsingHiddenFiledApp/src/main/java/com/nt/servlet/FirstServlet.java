package com.nt.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@WebServlet("/firsturl")
public class FirstServlet extends HttpServlet {
	
	public void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		//get PrintWriter
	PrintWriter pw=res.getWriter();
	//set content type
	res.setContentType("text/html");
	//read form data
	String name=req.getParameter("pname");
	String fname=req.getParameter("fname");
    String ms=req.getParameter("ms");
    //generate dynamic from page based on the marital status
    if(ms.equalsIgnoreCase("single")) {
    	pw.println("<form action='secondurl' method='POST'>");
    	pw.println("<table border='0' bgcolor='cyan' align=center'>");
    	pw.println("<tr><td>when do u want to marry?</td>");
    	pw.println("<td><input type='text' name='f2t1'></td></tr>");
    	pw.println("<tr><td>why do u want to marry?</td>");
    	pw.println("<td><input type='text' name='f2t2'></td></tr>");
    	pw.println("<tr><td colspan='2'><input type='submit' value='submit'></td></tr>");
    	pw.println("</table>");
    	pw.println("<input type='hidden' name='hname' value="+name+">");
    	pw.println("<input type='hidden' name='hfname' value="+fname+">");
    	pw.println("<input type='hidden' name='hms' value="+ms+">");
    	pw.println("</form>");
    }	
    else {
    	pw.println("<form action='secondurl' method='POST'>");
    	pw.println("<table border='0' bgcolor='cyan' align=center'>");
    	pw.println("<tr><td>spouse name::</td>");
    	pw.println("<td><input type='text' name='f2t1'></td></tr>");
    	pw.println("<tr><td>No of children::</td>");
    	pw.println("<td><input type='text' name='f2t2'></td></tr>");
    	pw.println("<tr><td colspan='2'><input type='submit' value='submit'></td></tr>");
    	pw.println("</table>");
    	pw.println("<input type='hidden' name='hname' value="+name+">");
    	pw.println("<input type='hidden' name='hfname' value="+fname+">");
    	pw.println("<input type='hidden' name='hms' value="+ms+">");
    	pw.println("</form>"); 	
    	
    }//else
     //close stream
    pw.close();
    
	}//do get

	
	public void doPost(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		doGet(req, res);
	}

}
