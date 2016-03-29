package com.movie.web.grade;

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
import com.movie.web.member.MemberBean;
import com.movie.web.member.MemberService;
import com.movie.web.member.MemberServiceImpl;

@WebServlet({ "/grade/my_grade.do", "/grade/add_form.do", "/grade/add.do" })
public class GradeController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	GradeService service = GradeServiceImpl.getInstance();

	protected void service(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		Command command = new Command();
		MemberBean member = new MemberBean();
		GradeBean grade = new GradeBean();
		MemberService memberService = new MemberServiceImpl();
		
		String[] str = Seperator.doSomething(request);

		switch (str[1]) {
		case "my_grade":
			request.setAttribute("grade", service.getGradeById(request.getParameter("id")));
			command = CommandFactory.createCommand(str[0], str[1]);
			break;

		case "add_form":
			request.setAttribute("member", memberService.detail(request.getParameter("id")));
			command = CommandFactory.createCommand(str[0], str[1]);
			break;

		case "add":
			grade.setId(request.getParameter("id"));
			grade.setJava(Integer.parseInt(request.getParameter("java")));
			grade.setJsp(Integer.parseInt(request.getParameter("jsp")));
			grade.setSql(Integer.parseInt(request.getParameter("sql")));
			grade.setSpring(Integer.parseInt(request.getParameter("spring")));
			if(service.input(grade)==1){
				command = CommandFactory.createCommand("admin", "admin_form");
			}else{
				command = CommandFactory.createCommand(str[0], str[1]);
			}
			break;

		default:
			command = CommandFactory.createCommand(str[0], str[1]);
			break;
		}
		DispatcherServlet.dispatcher(request, response, command);

	}
}
