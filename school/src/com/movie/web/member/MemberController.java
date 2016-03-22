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

@WebServlet({"/member/login_form.do","/member/join_form.do","/member/join.do","/member/login.do","/member/update_form.do"}) //web.xml
public class MemberController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	// 페이지 이동시에는 doGet
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
			Command command = new Command();
			MemberService service = new MemberServiceImpl();
			MemberBean member = new MemberBean();
			String id = "", password="";
			boolean isMember = false;
			System.out.println("인덱스에서 들어옴");
			String path = request.getServletPath();
			String temp = path.split("/")[2];
			
			String directory= path.split("/")[1];
			String action=temp.split("\\.")[0];
			//arr[1] = temp3.substring(0, temp3.indexOf("."));
			command = CommandFactory.createCommand(directory, action);
			
			
			switch (action) {
			case "join":
				
				break;
			case "login":
				
				if(service.isMember(request.getParameter("id"))){
					member = service.login(request.getParameter("id"), request.getParameter("password"));
					if(member==null){
						command = CommandFactory.createCommand(directory, "login_form");
					}else{
						request.setAttribute("member", member);
						command = CommandFactory.createCommand(directory, "detail");
					}
				}else {
					command = CommandFactory.createCommand(directory, "login_form");
				}
				break;
			case "update_form" :
				System.out.println("==수정폼으로 진입==");
				id = request.getParameter("id");
				request.setAttribute("member", service.detail(request.getParameter("id")));
				command = CommandFactory.createCommand(directory, action);
				break;
			
			default:
				command = CommandFactory.createCommand(directory, action);
				break;
			}
			RequestDispatcher dis = request.getRequestDispatcher(command.getView());
			dis.forward(request, response);
			
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

	}

}
