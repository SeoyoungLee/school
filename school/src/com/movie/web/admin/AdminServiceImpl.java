package com.movie.web.admin;

import java.util.ArrayList;
import java.util.List;

import com.movie.web.grade.GradeBean;
import com.movie.web.grade.GradeMemberBean;

public class AdminServiceImpl implements AdminService{
	private static AdminServiceImpl instance = new AdminServiceImpl();
	AdminDAO dao = AdminDAOImpl.getInstance();
	
	public static AdminServiceImpl getInstance() {
		return instance;
	}

	@Override
	public List<GradeMemberBean> getMemberList() {
		
		return dao.view();
	}

	@Override
	public int addScore(GradeBean bean) {
		
		return dao.input(bean);
	}

}
