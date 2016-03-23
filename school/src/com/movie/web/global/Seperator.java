package com.movie.web.global;

import javax.servlet.http.HttpServletRequest;

public class Seperator {
	
	public static String[] doSomething(HttpServletRequest request){
		String id = "", password="";
		String[] arr = new String[2];
		
		boolean isMember = false;
		System.out.println("인덱스에서 들어옴");
		String path = request.getServletPath();
		String temp = path.split("/")[2];
		
		String directory= path.split("/")[1];
		String action=temp.split("\\.")[0];
		
		arr[0] = directory;
		arr[1] = action;
		
		return arr;
	}
}
