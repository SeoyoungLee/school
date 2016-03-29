package com.movie.web.grade;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

import com.movie.web.global.Constants;
import com.movie.web.global.DatabaseFactory;
import com.movie.web.global.Vendor;
import com.movie.web.member.MemberBean;

public class GradeDAOImpl implements GradeDAO {
	private Connection conn; // 오라클 연결 객체
	private Statement stmt; // 쿼리 전송 객체
	private PreparedStatement pstmt; // 쿼리 전송 객체2
	private ResultSet rs; // 리턴값 회수 객체
	public static GradeDAO instance = new GradeDAOImpl();
	
	public static GradeDAO getInstance() {
		return instance;
	}
	public GradeDAOImpl() {
		conn = DatabaseFactory.getDatabase(Vendor.ORACLE, Constants.ID, Constants.PASSWORD).getConnection();
	}

	@Override
	public int insert(GradeBean grade) {
		int msg = 0;
		try {
			pstmt = conn.prepareStatement("INSERT INTO Grade(score_seq, id, java, sql, jsp, spring) VALUES(score_seq.NEXTVAL,?, ?,?,?,?)");
			pstmt.setString(1, grade.getId());
			pstmt.setInt(2, grade.getJava() );
			pstmt.setInt(3,  grade.getSql());
			pstmt.setInt(4, grade.getJsp());
			pstmt.setInt(5, grade.getSpring());

			msg = pstmt.executeUpdate();
		} catch (SQLException e) {
			System.out.println("insert()에서 에러 발생");
			e.printStackTrace();
		}
		System.out.println("insert 성공여부 : " + msg);
		return msg;
	}

	@Override
	public ArrayList<GradeMemberBean> selectAll() {
		ArrayList<GradeMemberBean> temp = new ArrayList<GradeMemberBean>();
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

				temp.add(bean);
			}

		} catch (Exception e) {
			System.out.println("selectAll()에서 에러 발생");
			e.printStackTrace();
		}

		return temp;
	}

	@Override
	public GradeMemberBean selectGradeById(String id) {
		MemberBean member = new MemberBean();
		GradeBean grade = new GradeBean();
		GradeMemberBean bean = new GradeMemberBean();
		Map<String, Object> map = new HashMap<String, Object>();

		try {
			stmt = conn.createStatement();
			rs = stmt.executeQuery("SELECT * FROM GradeMember WHERE id ='" + id + "'");
			while (rs.next()) {

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
			}
		} catch (Exception e) {
			System.out.println("selectGradeByHak()에서 에러 발생");
			e.printStackTrace();
		}
		map.put("member", member);
		map.put("grade", grade);

		return bean;
	}

	@Override
	public ArrayList<GradeMemberBean> selectGradeByName(String name) {
		ArrayList<GradeMemberBean> temp = new ArrayList<GradeMemberBean>();
		try {
			stmt = conn.createStatement();
			rs = stmt.executeQuery("SELECT * FROM GradeMember WHERE name ='" + name + "'");
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

				temp.add(bean);
			}

		} catch (Exception e) {
			System.out.println("selectGradeByName()에서 에러 발생");
			e.printStackTrace();
		}

		return temp;
	}

	@Override
	public int count() {
		int num = 0;
		try {
			stmt = conn.createStatement();
			/*
			 * rs = stmt.executeQuery(
			 * "SELECT COUNT(*) AS count FROM GradeMember");
			 * 
			 * while(rs.next()){ num = rs.getInt("count"); }
			 */

			/*
			 * rs = stmt.executeQuery("SELECT * FROM GradeMember"); rs.last();
			 * num = rs.getRow();
			 */
			rs = stmt.executeQuery("SELECT COUNT(*) FROM GradeMember");
			while (rs.next()) {
				num = rs.getInt(1);
			}
		} catch (Exception e) {
			System.out.println("count()에서 에러 발생");
			e.printStackTrace();
		}
		return num;
	}

	@Override
	public String update(GradeBean bean) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String delete(int hak) {
		try {
			stmt = conn.createStatement();
			rs = stmt.executeQuery("DELETE FROM GradeMember WHERE hak=" + hak);
			System.out.println("삭제완료");

		} catch (Exception e) {
			System.out.println("delete()에서 에러 발생");
			e.printStackTrace();
		}
		return null;
	}

}
