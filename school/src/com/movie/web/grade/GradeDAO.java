package com.movie.web.grade;

import java.util.ArrayList;
import java.util.Map;

public interface GradeDAO {
	// C : 성적표 등록
	public void insert(GradeBean grade); // 추상 메소드

	// R : 성적표 리스트 출력
	public ArrayList<GradeMemberBean> selectAll();

	// R :성적표 조회(학번)
	public GradeMemberBean selectGradeById(String id);

	// R :성적표 조회(이름)
	public ArrayList<GradeMemberBean> selectGradeByName(String name);

	// R : 카운트 조회
	public int count();

	// U :성적표 수정
	public String update(GradeBean bean);

	// D :성적표 삭제
	public String delete(int hak);
}
