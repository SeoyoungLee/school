package com.movie.web.member;

import java.util.HashMap;
import java.util.List;

import oracle.net.aso.f;

public class MemberServiceImpl implements MemberService {
	private static MemberService instance = new MemberServiceImpl();
	HashMap<String, MemberBean> map;
	MemberDAO dao = MemberDAOImpl.getInstance();

	
	public static MemberService getInstance() {
		return instance;
	}

	public MemberServiceImpl() {
		map = new HashMap<String, MemberBean>();
	}

	@Override
	public int join(MemberBean member) {
		// 회원가입
		return dao.insert(member);
		
		

	}

	@Override
	public MemberBean login(String id, String password) {
		// 로그인
		/*
		 * 아이디가 존재하지않아서 실패한 경우와 비번이 틀려서 실패한 경우에 따라서 메세지를 전달해야 함
		 */
		
		MemberBean member = new MemberBean();
		member = dao.selectById(id, password);
		
		if (member != null) {
			System.out.println("서비스 : 멤버가 널이 아님");
			return member;
		} else {
			System.out.println("서비스 : 멤버가 널임");
			return null;
		}
		
	}

	@Override
	public MemberBean detail(String id) {
		// 내정보보기
		return dao.selectMember(id);
	}

	@Override
	public int update(MemberBean member) {
		// 수정
		return dao.update(member);

	}

	@Override
	public int remove(String id) {
		// 삭제
		return dao.delete(id);

	}

	@Override
	public boolean isMember(String id) {
		return dao.isMember(id);
		
	}

	@Override
	public List<MemberBean> getList() {
		
		return dao.selectList();
	}

}
