package com.nt.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class FindCapitalServelt extends HttpServlet{


	public void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		//printwriter
		PrintWriter pw=res.getWriter();
		//set content type
		res.setContentType("text/html");
		//read from dat
		int countryCode=Integer.parseInt(req.getParameter("country"));
		//prepare capitals
		String countries[]=new String[] {"INDIA","USA","CHINA","CANADA"};
		String capitals[]=new String[] {"New Delhi","WashingtonDc","Bejing","Ottawa"};
		//dispaly captitals
		pw.println("<h1 style='color:red;text-align:center'>The Capital city name of"+countries[countryCode]+"is::"+capitals[countryCode]+"</h1>");
		
		//add home hyperlink
		pw.println("<a href='input.html'><h2 style='text=align:center'>home</h2></a>");
		
		//close stream
		pw.close();
		
		
	}//doget(-,-);
	
 
}//class
