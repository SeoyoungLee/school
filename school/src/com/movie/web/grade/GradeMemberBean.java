package com.movie.web.grade;

public class GradeMemberBean {
	private String id, password, name, addr;
	private int score_seq, java, sql, jsp, spring, birth;
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getAddr() {
		return addr;
	}
	public void setAddr(String addr) {
		this.addr = addr;
	}
	
	public int getScore_seq() {
		return score_seq;
	}
	public void setScore_seq(int score_seq) {
		this.score_seq = score_seq;
	}
	public int getJava() {
		return java;
	}
	public void setJava(int java) {
		this.java = java;
	}
	public int getSql() {
		return sql;
	}
	public void setSql(int sql) {
		this.sql = sql;
	}
	public int getJsp() {
		return jsp;
	}
	public void setJsp(int jsp) {
		this.jsp = jsp;
	}
	public int getSpring() {
		return spring;
	}
	public void setSpring(int spring) {
		this.spring = spring;
	}
	public int getBirth() {
		return birth;
	}
	public void setBirth(int birth) {
		this.birth = birth;
	}
	@Override
	public String toString() {
		return "성적표 [id=" + id + ", password=" + password + ", name=" + name + ", addr=" + addr + ", score_seq="
				+ score_seq + ", java=" + java + ", sql=" + sql + ", jsp=" + jsp + ", spring=" + spring + ", birth=" + birth
				+ "]\n";
	}
	
	
}
