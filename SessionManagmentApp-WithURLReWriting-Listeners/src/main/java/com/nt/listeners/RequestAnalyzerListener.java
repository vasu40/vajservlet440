package com.nt.listeners;

import javax.servlet.ServletContext;
import javax.servlet.ServletRequestEvent;
import javax.servlet.ServletRequestListener;
import javax.servlet.http.HttpServletRequest;

public class RequestAnalyzerListener implements ServletRequestListener {
	private long start,end;
	
	public  RequestAnalyzerListener() {
	System.out.println("RequestAnalyzerListener::0-param constructor");
	}
	@Override
	public void requestInitialized(ServletRequestEvent sre) {
		System.out.println("RequestAnalyzerListener.requestInitialized()");
		end=System.currentTimeMillis();
		
	}

	@Override
	public void requestDestroyed(ServletRequestEvent sre ) {
		System.out.println("RequestAnalyzerListener.requestDestroyed()");
		start=System.currentTimeMillis();
		//get HttpServeltRequest object
		HttpServletRequest req=(HttpServletRequest)sre.getServletRequest();
		//get servelt context object
		ServletContext sc=req.getServletContext();
		sc.log(req.getRequestURI()+"has taken"+(end-start)+"ms time to prcess the request");
		System.out.println(req.getRequestURI()+"has taken"+(end-start)+"ms time to process the request");
	}

}
