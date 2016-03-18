package com.movie.web.grade;

import java.util.ArrayList;
import java.util.Map;
import java.util.Vector;

public class GradeServiceImpl implements GradeService {
	// 멤버 필드
	ArrayList<GradeBean> gradeList;
	GradeDAO dao = new GradeDAOImpl();
	public GradeServiceImpl() {
		gradeList = new ArrayList<GradeBean>();
	}

	// 멤버 메스드 에어리어
	@Override
	public void input(GradeBean grade) {
		// C : 성적표 등록
		gradeList.add(new GradeBean(2, "김유신", 100, 100, 100, 100));
		gradeList.add(new GradeBean(3, "김김김", 90, 90, 90, 90));
		gradeList.add(new GradeBean(4, "유유유", 80, 80, 80, 80));
		gradeList.add(new GradeBean(5, "신신신", 70, 70, 70, 70));
		gradeList.add(new GradeBean(6, "신유김", 60, 60, 60, 60));
		gradeList.add(grade);

	}

	@Override
	public ArrayList<GradeMemberBean> getList() {
		// R : 성적표 리스트 출력

		return dao.selectAll();

	}

	@Override
	public GradeMemberBean getGradeByHak(int hak) {
		// R :성적표 조회(학번)
		
		return dao.selectGradeByHak(hak);
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
