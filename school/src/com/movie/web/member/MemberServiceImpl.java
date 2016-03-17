package com.movie.web.member;

import java.util.HashMap;

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
	public String login(String id, String password) {
		// 로그인
		/*
		 * 아이디가 존재하지않아서 실패한 경우와 비번이 틀려서 실패한 경우에 따라서 메세지를 전달해야 함
		 */
		String msg = "";
		if (!map.containsKey(id)) {
			msg = "아이디 없어";
		} else {
			MemberBean memberBean = map.get(id);
			if (password.equals(memberBean.getPassword())) {
				msg = "로그인성공";
			} else {
				msg = "비밀번호 불일치";
			}

		}

		return msg;

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

}
