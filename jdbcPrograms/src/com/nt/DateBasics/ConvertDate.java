package com.nt.DateBasics;

import java.text.SimpleDateFormat;

public class ConvertDate {

	public static void main(String[] args)throws Exception {
	  String s1="19-11-1999";
	  SimpleDateFormat sdf=new SimpleDateFormat("dd-MM-yyyy");
	  java.util.Date ud1=sdf.parse(s1);
	  System.out.println("stringDate:"+s1);
	  System.out.println("utilDate:"+ud1);
	  System.out.println("==============");
	  //conver java.util.date to java.sql.date class obj
	  long ms=ud1.getTime();//gives no.of millisec
	  
	  java.sql.Date sd1=new java.sql.Date(ms);
	  
	  System.out.println("sqldate:"+sd1);
	  System.out.println("stringDate:"+s1);
	  System.out.println("utilDate:"+ud1);
	  System.out.println("======================");
	  java.util.Date ud2=sd1;
	  System.out.println("util date:"+ud2);
	  java.util.Date ud3=new java.util.Date(sd1.getTime());
	  System.out.println(ud3);
	  
	  String s2=sdf.format(ud3);
	  System.out.println("sitrinDate:"+s2);
	  String s3=sdf.format(sd1);
	  System.out.println("stringdate::"+s3);
	  
	  
	}

}
