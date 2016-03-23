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

@WebServlet("/grade/my_grade.do")
public class GradeController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	GradeService service = GradeServiceImpl.getInstance();

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		Command command = new Command();
		
		GradeMemberBean grade = new GradeMemberBean();
		
		String path = request.getServletPath();
		String temp = path.split("/")[2];
		
		String directory= path.split("/")[1];
		String action=temp.split("\\.")[0];
		command = CommandFactory.createCommand(directory, action);
		
		switch (action) {
		case "my_grade":
			request.setAttribute("grade",service.getGradeById(request.getParameter("id")));
			command = CommandFactory.createCommand(directory, action);
			break;
					
		default:
			command = CommandFactory.createCommand(directory, action);
			break;
		}
		RequestDispatcher dis = request.getRequestDispatcher(command.getView());
		dis.forward(request, response);

	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {


	}
}


