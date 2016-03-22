package com.movie.web.member;

import java.util.HashMap;

import oracle.net.aso.f;

public class MemberServiceImpl implements MemberService {

	HashMap<String, MemberBean> map;
	MemberDAO dao = new MemberDAOImpl();

	public MemberServiceImpl() {
		map = new HashMap<String, MemberBean>();
	}

	@Override
	public void join(MemberBean member) {
		// 회원가입
		map.put(member.getId(), member);

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
	public void update() {
		// 수정

	}

	@Override
	public void remove(String id) {
		// 삭제

	}

	@Override
	public boolean isMember(String id) {
		return dao.isMember(id);
		
	}

}
