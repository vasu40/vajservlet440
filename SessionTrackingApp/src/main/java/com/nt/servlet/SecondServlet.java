package com.nt.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@WebServlet("/secondurl")
public class SecondServlet extends HttpServlet {
    
	public void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		//get PrintWriter
		PrintWriter pw=res.getWriter();
		//set response contet type
		res.setContentType("text/html");
		//read from2/req2 data
		String f2val1=req.getParameter("f2t1");
		String f2val2=req.getParameter("f2t2");
		//read from1/req1 data
		String name=req.getParameter("pname");
		String fname=req.getParameter("fname");
	    String ms=req.getParameter("ms");
	    
	    //dispaly dynamic web page having form1/req and form2/req2 data
	    pw.println("<h1>form1/req1 data::"+name+"....."+fname+"...."+ms+"</h1>");
	    pw.println("<h1>form2/read req data::"+f2val1+"...."+f2val2+"</h1>");
		
	    //add home hyperLink
	    pw.println("<br><a href='details.html'>home</a>");
		
	}

	
	public void doPost(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
	
		doGet(req, res);
	}

}
