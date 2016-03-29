package com.movie.web.admin;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.movie.web.global.Command;
import com.movie.web.global.CommandFactory;
import com.movie.web.global.DispatcherServlet;
import com.movie.web.global.Seperator;
import com.movie.web.grade.GradeMemberBean;
import com.movie.web.member.MemberBean;

@WebServlet({ "/admin/admin_form.do", "/admin/admin_login_form.do" })
public class AdminController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	AdminService service = AdminServiceImpl.getInstance();

	@Override
	protected void service(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String[] str = Seperator.doSomething(request);
		AdminBean admin = new AdminBean();
		Command command = new Command();
		HttpSession session = request.getSession();

		switch (str[1]) {

		case "admin_login_form":
			command = CommandFactory.createCommand(str[0], str[1]);
			break;

		case "admin_form":
			admin = service.getAdmin(request.getParameter("id"), request.getParameter("password"));
			if (admin == null) {
				command = CommandFactory.createCommand(str[0], "admin_login_form");
			} else {
				session.setAttribute("admin", admin);
				command = CommandFactory.createCommand(str[0], "admin_form");
			}
			break;

		default:
			command = CommandFactory.createCommand(str[0], str[1]);
			break;
		}

		DispatcherServlet.dispatcher(request, response, command);
	}

}
