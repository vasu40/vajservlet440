package com.nt.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Arrays;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class StudentAnalyzerServlet extends HttpServlet {

	@Override
	public void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		//get PrintWriter
		PrintWriter pw=res.getWriter();
		
		//get response content type
		res.setContentType("text/html");
		//READ form data
		String name=req.getParameter("sname");
		String addrs=req.getParameter("sadd");
		String gender=req.getParameter("gender");
		String email=req.getParameter("email");
		String qlfy=req.getParameter("qlfy");
		long contactNo=Long.parseLong(req.getParameter("contectno"));
		String hobies[]=req.getParameterValues("hb");
		if(hobies==null)
			hobies=new String[] {"no hobies are selected"};
		String favColors[]=req.getParameterValues("favcolors");
		   if(favColors==null)
			   favColors=new String[] {"No favorite Colors are selected"};
		   String ms=req.getParameter("ms");
		   if(ms==null)
			   ms="single";
		   String dob=req.getParameter("dob");
		   String nickName=req.getParameter("petname");
		   String mob=req.getParameter("mob");
		   String tob=req.getParameter("tob");
		   String wob=req.getParameter("wob");
		   String scolor=req.getParameter("scolor");  
		   long salary=Long.parseLong(req.getParameter("salrange"));
		   String ss=req.getParameter("ss");
		  int favNo=Integer.parseInt(req.getParameter("favno"));
		  String fburl=req.getParameter("fburl");
		
		//calculate the age a person
		java.util.Date udob=java.sql.Date.valueOf(dob);
		java.util.Date sysDate=new java.util.Date();
		double age=(sysDate.getTime()-udob.getTime())/(1000.0*60.0*24.0*365.25);
		//write analyzation of data
		if(gender.equalsIgnoreCase("M")) {
			if(age<5)
			pw.println("<h1>Master."+name+"u r baby boy</h1>");
			else if(age<13)
				pw.println("<h1>Master."+name+"u r small boy</h1>");
			else if(age<20)
				pw.println("<h1>Master."+name+"u r teenage boy</h>");
			else if(age<35)
				pw.println("<h1>Master."+name+"u r young boy</h>");
			else if(age<50)
				pw.println("<h1>Master."+name+"u r Middle-aged man</h>");
			else
				pw.println("<h1>Master."+name+"u r old man</h>");
		   }//if
		else {
			if(age<5)
				pw.println("<h1>Master."+name+"u r baby girl</h1>");
				else if(age<13)
					pw.println("<h1>Master."+name+"u r small girl</h1>");
				else if(age<20)
					pw.println("<h1>Master."+name+"u r teenage girl</h>");
				else if(age<35) {
					if(ms.equalsIgnoreCase("married"))
					pw.println("<h1>Master."+name+"u r young woman</h>");
					else
						pw.println("<h1>>Mrs."+name+" u r young woman</h1>");
				}
				else if(age<50) {
					if(ms.equalsIgnoreCase("married"))
					pw.println("<h1>Master."+name+"u r middleaged woman</h>");
					else
						pw.println("<h1>>Mrs."+name+" u r middle aged woman</h1>");
				}
				else {
					if(ms.equalsIgnoreCase("married"))
					pw.println("<h1>Master."+name+"u r old woman</h>");
					else
						pw.println("<h1>>Mrs."+name+" u r old woman</h1>");
				}
				
		}
		//dispaly the recieved from data
		pw.println("<h1 style='color:blue'>The form data is </h1>");
		pw.println("<br><b>name::"+name+"</b>");
		pw.println("<br><b>address::"+addrs+"</b>");
		pw.println("<br><b>contact number::"+contactNo+"</b>");
		pw.println("<br><b>gender::"+gender+"</b>");
		pw.println("<br><b>materialStatus::"+ms+"</b>");
		pw.println("<br><b>email::"+email+"</b>");
		pw.println("<br><b>DOB::"+dob+"</b>");
		pw.println("<br><b>TmeOfBirth::"+tob+"</b>");
		pw.println("<br><b>MonthOfBirth::"+mob+"</b>");
		pw.println("<br><b>weekofBirth::"+wob+"</b>");
		pw.println("<br><b>qulification::"+qlfy+"</b>");
		pw.println("<br><b>FavoriteColors::"+Arrays.toString(favColors)+"</b>");
		pw.println("<br><b>hobies::"+Arrays.toString(hobies)+"</b>");
		pw.println("<br><b>nick name::"+nickName+"</b>");
		pw.println("<br><b>FavoriteNumber::"+favNo+"</b>");
		pw.println("<br><b>Sentiment Color::"+scolor+"</b>");
		pw.println("<br><b>Excepted salary::"+salary+"</b>");
		pw.println("<br><b>FB Url::"+fburl+"</b>");
		pw.println("<br><b>Google Search String::"+ss+"</b>");
		
		//add hyperlinks
		pw.println("<br><br><a href='student_registration.html'>Home</a>");
		//close the stream
		pw.close();
	}//doget(-,-);
	
	@Override
	public void doPost(HttpServletRequest req,HttpServletResponse res)throws ServletException,IOException{
		doGet(req,res);	
		
		
	}//dopost
	

}//class
