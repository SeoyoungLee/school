package com.movie.web.jquery;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.movie.web.global.CommandFactory;
import com.movie.web.global.DispatcherServlet;
import com.movie.web.global.Seperator;

@WebServlet({ "/jQuery/dom.do","/jQuery/attr.do","/jQuery/core.do","/jQuery/event.do","/jQuery/traversing.do","/jQuery/selector.do"})
public class JqController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	@Override
	protected void service(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		DispatcherServlet.dispatcher(request, response,
				CommandFactory.createCommand(Seperator.doSomething(request)[0], Seperator.doSomething(request)[1]));
	}

}
