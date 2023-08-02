package com.nt.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Date;

import javax.servlet.GenericServlet;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;

public class DateServlet extends GenericServlet{
	public void service(ServletRequest req,ServletResponse res)throws ServletException,IOException{
		//getprintwriter
		PrintWriter pw=res.getWriter();
		//set content type
		res.setContentType("text/html");
	//witre b.logic
		Date d=new Date();
		//writethe bloigc resuts to response obj using println
		pw.println("<h1 style='color:red;text-align:center'>Date and time is::"+d+"</h1>");
		pw.println("<br><b> req object hashcode::"+req.hashCode());
		pw.println("<br><b>res object hashcode::"+res.hashCode());
		pw.println("<br><b>our servlet class obj::"+this.hashCode());
		pw.println("<br><b>current  req-thread hashcode::"+Thread.currentThread());
		//close stream
		pw.close();

		
	}

}
