package com.movie.web.grade;

import java.util.ArrayList;
import java.util.Vector;

public class GradeServiceImpl implements GradeService {
	// 멤버 필드
	ArrayList<GradeBean> gradeList;

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
	public ArrayList<GradeBean> getList() {
		// R : 성적표 리스트 출력

		return gradeList;

	}

	@Override
	public GradeBean getGradeByHak(int hak) {
		// R :성적표 조회(학번)
		String temp = "";
		GradeBean tempGrade = new GradeBean();
		for (int i = 0; i < gradeList.size(); i++) {
			// arr[i](배열문법) == gradeList.get(i)(백터문법)

			int searchHak = gradeList.get(i).getHak();
			if (searchHak == hak) {
				tempGrade = gradeList.get(i);
				break;
			}
		}
		return tempGrade;
	}

	@Override
	public ArrayList<GradeBean> getGrades(String name) {
		// R :성적표 조회(이름)
		ArrayList<GradeBean> tempList = new ArrayList<GradeBean>();
		for (int i = 0; i < gradeList.size(); i++) {
			if (name.equals(gradeList.get(i).getName())) {
				tempList.add(gradeList.get(i));
			}
		}
		return tempList;
	}

	@Override
	public String update(GradeBean grade) {
		// U 성적표 수정

		String temp = "수정 실패";
		if (gradeList.contains(getGradeByHak(grade.getHak()))) {
			GradeBean searchedGrade = getGradeByHak(grade.getHak());
			searchedGrade.setJava(grade.getJava());
			searchedGrade.setSql(grade.getSql());
			searchedGrade.setJsp(grade.getJsp());
			searchedGrade.setSpring(grade.getSpring());

			temp = "수정 성공";
		}
		/*
		 * this.delete(grade.getHak()); this.input(grade);
		 */

		return temp;
	}

	@Override
	public String delete(int hak) {
		// D :성적표 삭제
		return (gradeList.remove(this.getGradeByHak(hak))) ? "삭제성공" : "삭제실패";
	}

	@Override
	public int getCount() {
		// R : 카운트 조회
		return gradeList.size();

	}

	@Override
	public void getCountByName() {
		// R : 이름조회시 카운트 조회

	}

}
