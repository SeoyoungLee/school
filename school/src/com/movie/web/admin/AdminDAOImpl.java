package com.movie.web.admin;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.movie.web.global.Constants;
import com.movie.web.global.DatabaseFactory;
import com.movie.web.global.Vendor;
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
	
	public AdminDAOImpl() {
		conn = DatabaseFactory.getDatabase(Vendor.ORACLE, Constants.ID, Constants.PASSWORD).getConnection();
	}
	
	@Override
	public List<GradeMemberBean> view() {
		List<GradeMemberBean> list = new ArrayList<GradeMemberBean>();
		
		try {
			stmt = conn.createStatement();
			rs = stmt.executeQuery("SELECT * FROM GradeMember");
			
			while (rs.next()) {
				GradeMemberBean bean = new GradeMemberBean();
				
				bean.setId(rs.getString("id"));
				bean.setName(rs.getString("name"));
				bean.setPassword(rs.getString("password"));
				bean.setAddr(rs.getString("addr"));
				bean.setBirth(rs.getInt("birth"));
				bean.setScore_seq(rs.getInt("score_seq"));
				bean.setJava(rs.getInt("java"));
				bean.setJsp(rs.getInt("jsp"));
				bean.setSql(rs.getInt("sql"));
				bean.setSpring(rs.getInt("spring"));

				list.add(bean);
			}

		} catch (Exception e) {
			System.out.println("view()에서 에러 발생");
			e.printStackTrace();
		}

		return list;
	}
	
	

	@Override
	public int input(GradeBean bean) {
		int result = 0;
		
		return 0;
	}

	@Override
	public AdminBean selectAdmin(String id, String password) {
		AdminBean temp = new AdminBean();
		
		try {
			stmt = conn.createStatement();
			rs = stmt.executeQuery("select * from Admin where id = '"+id+"' and password = '"+password+"'");
			
			while(rs.next()){
				temp.setId(rs.getString("id"));
				temp.setName(rs.getString("name"));
				temp.setPassword(rs.getString("password"));
				temp.setAddr(rs.getString("addr"));
				temp.setBirth(rs.getInt("birth"));
				temp.setrole(rs.getString("role"));
			}
			
		} catch (Exception e) {
			System.out.println("selectAdmin()에서 에러 발생");
			e.printStackTrace();
		}
		if(temp.getrole()!=null){
			return temp;
		}else{
			return null;
		}
	}



	

}
