package com.nt.servelt;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/firsturl")
public class FirstServelt extends HttpServlet {
	@Override
	public void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		//get printWriter
		PrintWriter pw=res.getWriter();
		//set content type
		res.setContentType("text/html");
		//read form1/req1 data
		String name=req.getParameter("pname");
		String fname=req.getParameter("fname");
		String addrs=req.getParameter("address");
		String ms=req.getParameter("ms");
		//crreate Inmemory cookies having form1/req1 data
		Cookie ck1=new Cookie("name",name);
		Cookie ck2=new Cookie("fname",fname);
		Cookie ck3=new Cookie("addrs",addrs);
		Cookie ck4=new Cookie("ms",ms);
		
		//add cookie to response
		res.addCookie(ck1);
		res.addCookie(ck2);
		res.addCookie(ck3);
		res.addCookie(ck4);
		
		//generate form2  based on marital status value
		if(ms.equalsIgnoreCase("married")) {
			pw.println("<form action='secondurl' method='POST'>");
			pw.println("<table align='center' bgcolor='pink'>");
			pw.println("<tr><td>Spouse name::</td> <td><input type='text' name='f2t1'></td></tr>");
			pw.println("<tr><td>NO OF Childern::</td> <td><input type='text' name='f2t2'></td></tr>");
			pw.println("<tr><td><input type='submit' value='register'></td><td><input type='reset' value='cancel'></td></tr>");
			pw.println("</table>");
			pw.println("</form>");
		}
		else {
			pw.println("<form action='secondurl' method='POST'>");
			pw.println("<table align='center' bgcolor='pink'>");
			pw.println("<tr><td>When do u marry::</td> <td><input type='text' name='f2t1'></td></tr>");
			pw.println("<tr><td>why do u want marry::</td> <td><input type='text' name='f2t2'></td></tr>");
			pw.println("<tr><td><input type='submit' value='register'></td><td><input type='reset' value='cancel'></td></tr>");
			pw.println("</table>");
			pw.println("</form>");
		}
		//close stream
		pw.close();	
	}//doget
	@Override
	public void doPost(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		doGet(req,res);
	
	}

}
