package com.movie.web.grade;

import java.util.ArrayList;
import java.util.Map;

/**
 * CRUD
 * C : create 생성
 * R : read 조회
 * U : update 수정
 * D : delete 삭제
 * 
 * */
public interface GradeService {
	
	//C : 성적표 등록 
	public int input(GradeBean grade); //추상 메소드
	
	//R : 성적표 리스트 출력
	public ArrayList<GradeMemberBean> getList();
	
	//R :성적표 조회(학번)
	public GradeMemberBean getGradeById(String id);

	//R :성적표 조회(이름)
	public ArrayList<GradeMemberBean> getGrades(String name);
	
	//R : 카운트 조회
	public int getCount();
	
	//R : 이름조회시 카운트 조회
	public void getCountByName();
	
	//U :성적표 수정
	public String update(GradeBean bean);
	
	//D :성적표 삭제
	public String delete(int hak);
	

}
