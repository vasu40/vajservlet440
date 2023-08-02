package com.nt.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class DBTestServlet extends HttpServlet {
	//ServletConfig cg;
	  
	static {
		System.out.println("LCTestStatic Block:");
	}
	public DBTestServlet() {
		System.out.println("LCTestServlet:0 param constructor");
	}
//	@Override
//	public void init()throws ServletException{
//		
//		System.out.println("LcTestServelt Init(-,-)");
//		//read init param values from servletConfig obj
//		System.out.println("driverclass name::"+getInitParameter("driverClass"));
//		System.out.println("jdbcurl::"+getInitParameter("url"));
//		System.out.println("jdbcUserName::"+getInitParameter("dbuser"));
//		System.out.println("jdbcPasword::"+getInitParameter("dbpwd"));
//		
//		
//
//}
	@Override
	public void init(ServletConfig cg)throws ServletException{
		//this.cg=cg;
		
		System.out.println("LcTestServelt Init(-,-)");
		//read init param values from servletConfig obj
		System.out.println("driverclass name::"+getInitParameter("driverClass"));
		System.out.println("jdbcurl::"+getInitParameter("url"));
		System.out.println("jdbcUserName::"+getInitParameter("dbuser"));
		System.out.println("jdbcPasword::"+getInitParameter("dbpwd"));
		
		

}
	
	@Override
	public void service(HttpServletRequest areq, HttpServletResponse res) throws ServletException, IOException {
		System.out.println("LcTestServelt Service(-,-)");
	//destroy();
	//init();
		
		//get printwriter
		PrintWriter pw=res.getWriter();
		//set content type
		res.setContentType("text/html");
		//wrter outptu toresponse object
		
		pw.println("<h1>Date and Time::"+ new java.util.Date()+"</h1>");
		//ServletConfig cg=getServletConfig();
		//cose stream
		pw.close();
	}//service
	@Override
	public void destroy() {
		System.out.println("LcTestServeltDestroy()");
	}
}
  