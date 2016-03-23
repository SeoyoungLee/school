package com.movie.web.global;

import javax.servlet.RequestDispatcher;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class DispatcherServlet {

	public static void dispatcher(HttpServletRequest request, HttpServletResponse response, Command command) {
		RequestDispatcher dis = request.getRequestDispatcher(command.getView());
		try {
			dis.forward(request, response);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}