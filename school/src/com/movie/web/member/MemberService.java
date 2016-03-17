package com.movie.web.member;

public interface MemberService {
	//인터페이스는 추상메소드만 와야 한다는 문법이 있어서 abstract를 생략 가능하다.
	//그러나 추상클래스는 구상 메소드가 존재하므로 둘을 구분하기 위해서 반드시 abstract를 붙여야 한다.

	public void join(MemberBean member);

	public String login(String id, String password);

	public MemberBean detail(String id);

	public void update();

	public void remove(String id);
}
