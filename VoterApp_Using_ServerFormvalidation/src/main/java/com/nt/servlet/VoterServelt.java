package com.nt.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

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
		
	
		//read form data(req param values from request obj)
		String name=req.getParameter("pname");
		String uage=req.getParameter("page");
		
		//server side form validation logic
		  List<String> errorsList=new ArrayList();
		 if(name==null ||name.equals("")||name.length()==0 ) //requried rule on name
			 errorsList.add("Person Name is requried");
		 else if(name.length()<5 ||name.length()>10)//min and max length of name
		     errorsList.add("Person name must be min 5 chars and max 10 chars");
		 
		 float age=0.0f;
		  
		 if(uage==null || uage.equals("")||uage.length()==0)
		    errorsList.add("Person age is required");
		 
		 else {
			 try {
				 age=Float.parseFloat(uage);
				 if(age<0 || age>120) { //age range rule
					 errorsList.add("person age must o throug 120");
				 }
			 }
			catch(NumberFormatException nfe) {
				errorsList.add("person age must be numeric value");//age must numeric
			}
		 }
		 //dispaly from validation error message
		 if(errorsList.size()>0) {
			 for(String msg:errorsList) {
				 pw.println("<li style='color:red'><b>"+msg+"</li></b>");
			 }//for
			 return; //if form validation errors are raised this return <without  value>returns the cotrol back to caller
		 }
		 
		 
		 //write b.logic
		 
		if(age>18) {
			pw.println("<h1 style='color:green;text-align:center'>Mr/Miss/Mrs."+name+" u r eligible to voteing</h1>");
		}
		else {
			pw.println("<h1 style='color:red;text-align:center;'>Mr/Mis/Mrs"+name+"U R not Eligible to voting</h1>");
		}
		//graphical inter face
		pw.println("<a href='http://localhost:4021/VoterApp_Using_ServerFormvalidation/details_form.html'><img src='Pictures/home.png' width='100' hegight='200'></a>");
		
		  //close stream
		pw.close();
	       }//do pot
	  @Override
	public void doGet(HttpServletRequest req,HttpServletResponse res)throws ServletException,IOException{
		System.out.println("Voterservelt.formValidation doget(-,-)");
		//get printWriter
		PrintWriter pw=res.getWriter();
		//set content type
		res.setContentType("text/html");
		//write content to response obj
		pw.println("<h1 style='color:red;text-align:center'>Date and time is::"+new Date()+"</h1>");
		//close stream
		pw.close();
	}//doget

}//class
