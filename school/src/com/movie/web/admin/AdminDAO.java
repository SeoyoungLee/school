package com.movie.web.admin;

import java.util.List;

import com.movie.web.grade.GradeBean;
import com.movie.web.grade.GradeMemberBean;

public interface AdminDAO {
	
	public List<GradeMemberBean> view();
	
	public int input(GradeBean bean);

}
