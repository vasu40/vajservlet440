package com.nt.servelt;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/secondurl")
public class SecondServelt extends HttpServlet {
	 @Override
	public void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
	//get printWriter
	PrintWriter pw=res.getWriter();
	//set comtent type
	res.setContentType("text/html");
	//read form/req1 data from cookies of request
	Cookie cookies[]=req.getCookies();
	  String name=null,fname=null,ms=null,addrs=null;
	  if(cookies!=null) {
	name=cookies[0].getValue();
	fname=cookies[1].getValue();
	addrs=cookies[2].getValue();
	ms=cookies[3].getValue();
	  }
	  //read form2/re2 data
	  String f2val1=req.getParameter("f2t1");
	  String f2val2=req.getParameter("f2t2");
	  //display form/req data
	  pw.println("<h1 style='color:red'>Two fors/requests data</h1>");
	  pw.println("<br><b>form/req1 daat::"+name+"..."+fname+"....."+addrs+"......"+ms);
	  pw.println("<br><b>form2/re2 data::"+f2val1+"....."+f2val2);
	  
	  //add home hyperlink
	  pw.println("<br><b><a href='person_details.html'>home</a>");
	  //close stream
	  pw.close();
	 }//do get
	   @Override
	public void doPost(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		doGet(req,res);
	}
}
