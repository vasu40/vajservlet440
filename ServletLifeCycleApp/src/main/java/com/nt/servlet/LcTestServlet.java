package com.nt.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class LcTestServlet extends HttpServlet {
	static {
		System.out.println("LCTestStatic Block:");
	}
	public LcTestServlet() {
		System.out.println("LCTestServlet:0 param constructor");
	}
	@Override
	public void init(ServletConfig cfg)throws ServletException{
		System.out.println("LcTestServelt Init(-,-)");
	   

}
	@Override
	public void service(HttpServletRequest areq, HttpServletResponse res) throws ServletException, IOException {
		System.out.println("LcTestServelt Service(-,-)");
	destroy();
	init();
		//get printwriter
		PrintWriter pw=res.getWriter();
		//set content type
		res.setContentType("text/html");
		//wrter outptu toresponse object
		pw.println("<h1>Date and Time::"+ new java.util.Date()+"</h1>");
		//cose stream
		pw.close();
	}//service
	@Override
	public void destroy() {
		System.out.println("LcTestServeltDestroy()");
	}
}
  