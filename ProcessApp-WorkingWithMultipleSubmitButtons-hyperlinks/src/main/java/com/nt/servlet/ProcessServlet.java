package com.nt.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.time.LocalDateTime;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class ProcessServlet extends HttpServlet {
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		//get PrintWriter
		PrintWriter pw=res.getWriter();
		//set content type
		res.setContentType("text/html");
		//read special request param value(s1)
		String s1val=req.getParameter("s1");
		//read from data(text box value)
		int val1=0,val2=0;
		//read text box value only when request is not from hyperlinks
		if(!s1val.equalsIgnoreCase("link1")&& !s1val.equalsIgnoreCase("link2")) {
			val1=Integer.parseInt(req.getParameter("t1"));
			val2=Integer.parseInt(req.getParameter("t2"));
		}
		//different logics for submit buttons and hyperlinks
		if(s1val.equalsIgnoreCase("add"))
			 pw.println("<h1 style='color:red'>Sum of "+val1+"and"+val2+"is::"+(val1+val2)+"</h1>");
		else if(s1val.equalsIgnoreCase("sub"))
			pw.println("<h1 style='color:red'>Sub of "+val1+"and"+val2+"is::"+(val1-val2)+"</h1>");
		else if(s1val.equalsIgnoreCase("mul"))
			pw.println("<h1 style='color:red'>Mul of "+val1+"and"+val2+"is::"+(val1*val2)+"</h1>");
		else if(s1val.equalsIgnoreCase("div"))
			pw.println("<h1 style='color:red'>Div of "+val1+"and"+val2+"is::"+((float)val1/val2)+"</h1>");
		else if(s1val.equalsIgnoreCase("link1")) {
			pw.println("<h1>System properties are</h1>");
			pw.println("<b style='color:pink'>"+System.getProperties()+"</b>");
		}
		else {
			pw.println("<h1 style='color:red'>System date and time::"+LocalDateTime.now()+"</h1>");
		}
		//add home hyperlink
		pw.println("<br><a href='form.html'>home</a>");
		//close stream
		pw.close();	
		}//doget
	 @Override
	public void doPost(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		doGet(req,res);
	   }//dopost
	}//class


