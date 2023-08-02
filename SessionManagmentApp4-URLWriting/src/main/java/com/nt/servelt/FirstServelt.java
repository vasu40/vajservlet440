package com.nt.servelt;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

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
		//Create or locale Session Object
		HttpSession ses=req.getSession(true);
		//add from1/req1 data to Session obj as Session attribute values
		ses.setAttribute("name", name);
		ses.setAttribute("fname",fname);
		ses.setAttribute("addrs", addrs);
		ses.setAttribute("ms", ms);
		
		//generate form2  based on marital status value
		if(ms.equalsIgnoreCase("married")) {
			pw.println("<form action="+res.encodeURL("secondurl")+" method='POST'>");
			pw.println("<table align='center' bgcolor='pink'>");
			pw.println("<tr><td>Spouse name::</td> <td><input type='text' name='f2t1'></td></tr>");
			pw.println("<tr><td>NO OF Childern::</td> <td><input type='text' name='f2t2'></td></tr>");
			pw.println("<tr><td><input type='submit' value='register'></td><td><input type='reset' value='cancel'></td></tr>");
			pw.println("</table>");
			pw.println("</form>");
		}
		else {
			pw.println("<form action="+res.encodeURL("secondurl")+" method='POST'>");
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
