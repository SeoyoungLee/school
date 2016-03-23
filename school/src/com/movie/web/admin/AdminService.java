package com.movie.web.admin;

import java.util.ArrayList;

import com.movie.web.grade.GradeBean;
import com.movie.web.grade.GradeMemberBean;

public interface AdminService {

	public ArrayList<GradeMemberBean> getMemberList();

	public int addScore(GradeBean bean);

}
