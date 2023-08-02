package com.nt.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class TestServlet extends HttpServlet{
	@Override
	public void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		//get writer
		PrintWriter pw=res.getWriter();
		//set content type
		res.setContentType("text/html");
//		ServletConfig cg=getServletConfig();
//		pw.println("<br><b>ServletConfig object class name::"+cg.getClass()+"</b>");
//	   pw.println("<br><b>servelt name::"+cg.getServletName()+"</b>");
//	   pw.println("<br><b>servelt user::"+cg.getInitParameter("dbuser"));
		
		ServletContext cs=getServletContext();
		pw.println("<br><b>ServletConfig object class name::"+cs.getClass()+"</b>");
	   //pw.println("<br><b>servelt name::"+cs.getServletName()+"</b>");
		   pw.println("<br><b>servelt user::"+cs.getInitParameter("dbuser"));
		
	}

}
