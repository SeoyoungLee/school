package com.movie.web.grade;

import java.util.ArrayList;
import java.util.Map;
import java.util.Vector;

public class GradeServiceImpl implements GradeService {
	// 멤버 필드
	ArrayList<GradeBean> gradeList;
	GradeDAO dao =GradeDAOImpl.getInstance();
	private static GradeService instance = new GradeServiceImpl();
	
	public static GradeService getInstance() {
		return instance;
	}

	public GradeServiceImpl() {
		gradeList = new ArrayList<GradeBean>();
	}

	// 멤버 메스드 에어리어
	@Override
	public int input(GradeBean grade) {
		// C : 성적표 등록
		return dao.insert(grade);

	}

	@Override
	public ArrayList<GradeMemberBean> getList() {
		// R : 성적표 리스트 출력

		return dao.selectAll();

	}

	@Override
	public GradeMemberBean getGradeById(String id) {
		// R :성적표 조회(아이디)
		
		return dao.selectGradeById(id);
	}

	@Override
	public ArrayList<GradeMemberBean> getGrades(String name) {
		// R :성적표 조회(이름)
		
		return dao.selectGradeByName(name);
	}

	@Override
	public String update(GradeBean grade) {
		// U 성적표 수정

		String temp = "수정 실패";
		
		/*
		 * this.delete(grade.getHak()); this.input(grade);
		 */

		return temp;
	}

	@Override
	public String delete(int hak) {
		// D :성적표 삭제
		return dao.delete(hak);
	}

	@Override
	public int getCount() {
		// R : 카운트 조회
		return dao.count();

	}

	@Override
	public void getCountByName() {
		// R : 이름조회시 카운트 조회

	}

}
