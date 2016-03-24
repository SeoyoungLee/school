package com.movie.web.member;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.movie.web.global.Command;
import com.movie.web.global.CommandFactory;
import com.movie.web.global.DispatcherServlet;
import com.movie.web.global.Seperator;

import javafx.scene.control.Separator;

@WebServlet({ "/member/login_form.do", "/member/join_form.do", "/member/join.do", "/member/login.do",
		"/member/update_form.do", "/member/update.do", "/member/delete.do" }) // web.xml
public class MemberController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	MemberService service = MemberServiceImpl.getInstance();

	@Override
	protected void service(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String[] str = Seperator.doSomething(request);
		Command command = new Command();
		MemberBean member = new MemberBean();

		switch (str[1]) {

		case "update_form":
			request.setAttribute("member", service.detail(request.getParameter("id")));
			command = CommandFactory.createCommand(str[0], str[1]);
			break;

		case "delete":
			if (service.remove(request.getParameter("id")) == 1) {
				command = CommandFactory.createCommand(str[0], "login_form");
			} else {
				request.setAttribute("member", service.detail(request.getParameter("id")));
				command = CommandFactory.createCommand(str[0], "detail");
			}
			break;

		case "join":
			member.setId(request.getParameter("id"));
			member.setName(request.getParameter("name"));
			member.setPassword(request.getParameter("password"));
			member.setAddr(request.getParameter("addr"));
			member.setBirth(Integer.parseInt(request.getParameter("birth")));

			if (service.join(member) == 1) {
				command = CommandFactory.createCommand(str[0], "login_form");
			} else {
				command = CommandFactory.createCommand(str[0], str[1]);
			}
			break;

		case "login":
			if (service.isMember(request.getParameter("id"))) {

				if (service.login(request.getParameter("id"), request.getParameter("password")) == null) {
					command = CommandFactory.createCommand(str[0], "login_form");
				} else {
					request.setAttribute("member",
							service.login(request.getParameter("id"), request.getParameter("password")));
					command = CommandFactory.createCommand(str[0], "detail");
				}
			} else {
				command = CommandFactory.createCommand(str[0], "login_form");
			}
			break;

		case "update":
			member.setId(request.getParameter("id"));
			member.setName(request.getParameter("name"));
			member.setPassword(request.getParameter("password"));
			member.setAddr(request.getParameter("addr"));
			member.setBirth(Integer.parseInt(request.getParameter("birth")));

			if (service.update(member) == 1) {
				request.setAttribute("member", service.detail(request.getParameter("id")));
				command = CommandFactory.createCommand(str[0], "detail");
			} else {
				request.setAttribute("member", service.detail(request.getParameter("id")));
				command = CommandFactory.createCommand(str[0], "update_form");
			}
			break;

		default:
			command = CommandFactory.createCommand(str[0], str[1]);
			break;
		}

		DispatcherServlet.dispatcher(request, response, command);
	}

}
