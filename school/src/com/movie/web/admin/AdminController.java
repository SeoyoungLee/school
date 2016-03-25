package com.movie.web.admin;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.movie.web.global.Command;
import com.movie.web.global.CommandFactory;
import com.movie.web.global.DispatcherServlet;
import com.movie.web.global.Seperator;
import com.movie.web.grade.GradeMemberBean;
import com.movie.web.member.MemberBean;

@WebServlet("/admin/admin_form.do")
public class AdminController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	AdminService service = AdminServiceImpl.getInstance();
	
	@Override
	protected void service(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String[] str = Seperator.doSomething(request);
		
		Command command = new Command();

		switch (str[1]) {
		
		case "admin_form" : 
			request.setAttribute("student", service.getMemberList());
			command = CommandFactory.createCommand(str[0], str[1]); break;
		
		default:
			command = CommandFactory.createCommand(str[0], str[1]);
			break;
		}

		DispatcherServlet.dispatcher(request, response, command);
	}



	

}
