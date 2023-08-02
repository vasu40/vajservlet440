package com.nt.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class MarriageServlet extends HttpServlet{
	public void doGet(HttpServletRequest req,HttpServletResponse res)throws ServletException,IOException{
		//get printwriterobj
				PrintWriter pw=res.getWriter();
				//set content type
				res.setContentType("text/html");
			//read from data req param values from request obj
				String name=req.getParameter("pname");
				String cage=req.getParameter("page");
				int age=Integer.parseInt(cage);
				String gender=req.getParameter("pgender");
				
				//write b.logic
				if(age>=21) {
					pw.println("<h1 style='color:green;text-align:center'>Mr/Miss/Mrs."+name+" U R Eligible to Marriage </h1>");
					}
				else {
					pw.println("<h1 style='color:red;text-align:center'>Mr/Miss/Mrs."+name+" U R not Eligible to marriage</h1>");
					
				}
			//graphical hyperlink(image as the Hyperlink
				pw.println("<a href='http://localhost:4021/MarriageApp/details_from.html'><img src='Pictures/home.png'></a>");
				
				res.setHeader("refresh", "10");
						
				
	//close stream
		pw.close();
		
	   }//doget
		
	}//class


