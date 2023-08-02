package com.nt.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.time.LocalDateTime;
import java.util.Locale;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class LinksServlet extends HttpServlet {
	@Override
	public void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
	  //get printWriter
		PrintWriter pw=res.getWriter();
		//set contenttype
		res.setContentType("text/html");
		//read additional req param
	   String pval=req.getParameter("p1");
		//get AValiable ocales
		Locale locales[]=Locale.getAvailableLocales();
		//Differentiate logics  for hyperlinks
		if(pval.equalsIgnoreCase("link1")) {
		pw.println("<h1>All languges are</h1>");
		  for(Locale l:locales)
			  pw.println(l.getDisplayLanguage()+",");
		}//if
		else if(pval.equalsIgnoreCase("link2")) {
			pw.println("<h1>All Countries are</h1>");
			  for(Locale l:locales)
				  pw.println(l.getDisplayCountry()+",");
			}//else if
		else {
			pw.println("<h1>System Date and Time::"+LocalDateTime.now()+"</h1>");
		}
		//add home hyperlInk
		pw.println("<br><a href='links.html'>home</a>");
		
		//close stream
		pw.close();
	}//doget(-,-);
	
	 @Override
	public void doPost(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		doGet(req,res);
		
	}//dopost
		
		
		
	}//class


