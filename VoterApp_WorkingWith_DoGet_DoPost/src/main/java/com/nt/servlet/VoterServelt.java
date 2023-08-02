package com.nt.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Date;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class VoterServelt extends HttpServlet {
	public void doPost(HttpServletRequest req,HttpServletResponse res)throws ServletException,IOException{
		//get wruter
		PrintWriter pw=res.getWriter();
		//set content type
		res.setContentType("text/html");
		//requst logic
		String name=req.getParameter("pname");
		String uage=req.getParameter("page");
		int age=Integer.parseInt(uage);
		
		if(age>18) {
			pw.println("<h1 style='color:green;text-align:center'>Mr/Miss/Mrs."+name+" u r eligible to voteing</h1>");
		}
		else {
			pw.println("<h1 style='color:red;text-align:center;'>Mr/Mis/Mrs"+name+"U R not Eligible to voting</h1>");
		}
		//graphical inter face
		pw.println("<a href='http://localhost:4021/VoterApp_WorkingWith_DoGet_DoPost/details_form.html'><img src='Pictures/home.png' width='100' hegight='200'></a>");
		
		  //close stream
		pw.close();
	       }//do get
	  @Override
	public void doGet(HttpServletRequest req,HttpServletResponse res)throws ServletException,IOException{
		System.out.println("Voterservelt.doGet(-,-)");
		//get printWriter
		PrintWriter pw=res.getWriter();
		//set content type
		res.setContentType("text/html");
		//write content to response obj
		pw.println("<h1 style='color:red;text-align:center'>Date and time is::"+new Date()+"</h1>");
		//close stream
		pw.close();
	}//post

}//class
