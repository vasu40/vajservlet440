package com.nt.servelt;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebServlet("/secondurl")
public class SecondServelt extends HttpServlet {
	 @Override
	public void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
	//get printWriter
	PrintWriter pw=res.getWriter();
	//set comtent type
	res.setContentType("text/html");
	
	  //read form2/re2 data
	  String f2val1=req.getParameter("f2t1");
	  String f2val2=req.getParameter("f2t2");
	  //get Access to the Session objec
	  HttpSession ses=req.getSession(false);
	  //read form/req1 data as Session attribute vlaues 
	  String name=(String)ses.getAttribute("name");
	  String fname=(String)ses.getAttribute("fname");
	  String addrs=(String)ses.getAttribute("addrs");
	  String ms=(String)ses.getAttribute("ms");
	  
	  
	  
	  //display form/req data
	  pw.println("<h1 style='color:red'>Two fors/requests data</h1>");
	  pw.println("<br><b>form/req1 daat::"+name+"..."+fname+"....."+addrs+"......"+ms);
	  pw.println("<br><b>form2/re2 data::"+f2val1+"....."+f2val2);
	  
	  //Invaldate the session
	  ses.invalidate();
	  
	  //add home hyperlink
	  pw.println("<br><b><a href='person_details.html'>home</a>");
	  //close stream
	  pw.close();
	 }//do get
	 
	   @Override
	public void doPost(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		doGet(req,res);
	}//do post
}//class
