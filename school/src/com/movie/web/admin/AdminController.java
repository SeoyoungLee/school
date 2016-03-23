package com.movie.web.admin;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.movie.web.global.Command;
import com.movie.web.global.Seperator;
import com.movie.web.grade.GradeMemberBean;

@WebServlet("/member/admin.do")
public class AdminController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	AdminService service = AdminServiceImpl.getInstance();
    
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String[] str = Seperator.doSomething(request);
		Command command = new Command();
		GradeMemberBean gradeMember = new GradeMemberBean();
		
		switch (str[1]) {
		case "admin":
			service.getMemberList();
			break;

		default:
			break;
		}
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
	}

}
