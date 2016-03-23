package com.movie.web.admin;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;

import com.movie.web.grade.GradeBean;
import com.movie.web.grade.GradeMemberBean;

public class AdminDAOImpl implements AdminDAO{
	private Connection conn; // 오라클 연결 객체
	private Statement stmt; // 쿼리 전송 객체
	private PreparedStatement pstmt; // 쿼리 전송 객체2
	private ResultSet rs; // 리턴값 회수 객체
	private static AdminDAO instance = new AdminDAOImpl();
	ArrayList<GradeMemberBean> gmList = new ArrayList<GradeMemberBean>();
	public static AdminDAO getInstance() {
		return instance;
	}
	
	@Override
	public ArrayList<GradeMemberBean> view() {
		ArrayList<GradeMemberBean> list = new ArrayList<GradeMemberBean>();
		
	//	stmt = conn.createStatement();
		
		return list;
	}
	
	

	@Override
	public int input(GradeBean bean) {
		int result = 0;
		
		return 0;
	}



	

}
