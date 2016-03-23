package com.movie.web.admin;

import java.util.ArrayList;

import com.movie.web.grade.GradeBean;
import com.movie.web.grade.GradeMemberBean;

public interface AdminDAO {
	
	public ArrayList<GradeMemberBean> view();
	
	public int input(GradeBean bean);

}
