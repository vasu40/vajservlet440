package com.nt.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class VoterServlet extends HttpServlet {

	
public void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
	//get printlwriter
	PrintWriter pw=res.getWriter();
	//get content type
		res.setContentType("text/html");
		//read from data(req param values from req obj
		String name=req.getParameter("pname");
		String vage=req.getParameter("page");
		int age=Integer.parseInt(vage);
		//write b.logic
		if(age>=18) {
			pw.println("<h1 style='color:green;text-align:center'>Mr/Miss/Mrs."+name+"u r eligible to voteing</h1>");
		}
			else {
				pw.println("<h1 style='color:red;text-align:center'>Mr/Miss/Mrs."+name+"  u r NOT  eligible to vote</h1>");
			}
		//graphical inter face
		pw.println("<a href='http://localhost:4021/VoterApp/details_form.html'><img src='Pictures/home.png' width='100' hegight='200'></a>");
		
		//close stream
		pw.close();
		}//do get
		
	}//class
	


