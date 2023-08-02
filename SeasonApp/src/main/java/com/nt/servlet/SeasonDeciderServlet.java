package com.nt.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.time.LocalDate;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class SeasonDeciderServlet extends HttpServlet {
	public void service(HttpServletRequest req,HttpServletResponse res)throws ServletException,IOException{
	//set content type
		res.setContentType("text/html");
	//get printlnwriter
		PrintWriter pw=res.getWriter();
	//get system date and time
		LocalDate ldt=LocalDate.now();
	//get current hour
		int month=ldt.getMonthValue();
	//decide the season
		if(month>=3 && month<=6)
			pw.println("<h1 style='color:green;text-align:center'>Season name::SummerSeason</h1>");
		else if(month>=6 && month<=9 )
			pw.println("<h1 style='color:green;text-align:center'>Season name::RainySeason</h1>");
		else
			pw.println("<h1 styel='color:green;text-align:center'>Season name::WinterSeason/h1>");
		
		pw.println("<br><b><a href='http://localhost:4021/SeasonApp/page.html'>home</a>");
	}
	

}
