package com.nt.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.time.LocalDateTime;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class WishMessageServelt extends HttpServlet {
   public void service(HttpServletRequest req,HttpServletResponse res)throws ServletException,IOException{
	   //specify the response content ty[e\
	   res.setContentType("text/html");
	   //get print wruter
	   PrintWriter pw=res.getWriter();
	   //get System date and time
	   LocalDateTime ldt=LocalDateTime.now();
	   //get current hour
	   int hour=ldt.getHour();
	   //generate wish message
	   if(hour<12)
		pw.println("<h1 style='color:orange;text-align:center'>GoodMorning</h1>") ;  
	   if(hour<16)
			pw.println("<h1 style='color:Red;text-align:center'>GoodOfternoon</h1>") ;  
	   if(hour<20)
			pw.println("<h1 style='color:blue;text-align:center'>GoodEvening</h1>") ;  
	   if(hour<12)
			pw.println("<h1 style='color:yellow;text-align:center'>Goodnight</h1>") ;  
        
	   //add home hyper link
	   pw.println("<br><b><a href='http://localhost:4021/WishMessageGneerator/page.html'>home</a>");
	   //close stream
	   pw.close();
	   
   }//service(-,-)
}//class
