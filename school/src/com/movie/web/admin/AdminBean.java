package com.movie.web.admin;

import com.movie.web.member.MemberBean;

public class AdminBean extends MemberBean {
	private String role;

	public String getrole() {
		return role;
	}

	public void setrole(String role) {
		this.role = role;
	}

}
