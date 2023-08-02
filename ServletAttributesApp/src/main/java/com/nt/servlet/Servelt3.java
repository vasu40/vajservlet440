package com.nt.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebServlet("/s3url")
public class Servelt3 extends HttpServlet {
	public void doGet(HttpServletRequest req,HttpServletResponse res)throws ServletException,IOException{
		//get Println
		PrintWriter pw=res.getWriter();
		//set contenttype
		res.setContentType("text/html");
		//create request attributes
	
		//read requst attribute values
		pw.println("<br><b>Servlet3::attr1(req)value::"+req.getAttribute("attr1")+"</b>");
		
		//To read and Access SessionAttribute vlaue
				HttpSession ses=req.getSession();
				pw.println("<br><b>Servelt2::attr2(ses)value::"+ses.getAttribute("attr2")+"</b>");
	
				//To read and access ServletContext Attribute vaue
				 ServletContext sc=getServletContext();
				 pw.println("<br><b>Servlet3::attr3(sc)value::"+sc.getAttribute("attr3")+"</b>");
				
	}
	public void doPost(HttpServletRequest req,HttpServletResponse res)throws ServletException,IOException{
          doGet(req,res);	
	}
}



