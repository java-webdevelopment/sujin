package com.codelifee.exercisecoach.exercisecoach.model;

public class Comments {
	
	private int com_id;
	private String contents;
	private String regdate;
	private String user_id;
	private String exer_id;
	
	public int getCom_id() {
		return com_id;
	}
	public void setCom_id(int com_id) {
		this.com_id = com_id;
	}
	public String getContents() {
		return contents;
	}
	public void setContents(String contents) {
		this.contents = contents;
	}
	public String getRegdate() {
		return regdate;
	}
	public void setRegdate(String regdate) {
		this.regdate = regdate;
	}
	public String getUser_id() {
		return user_id;
	}
	public void setUser_id(String user_id) {
		this.user_id = user_id;
	}
	public String getExer_id() {
		return exer_id;
	}
	public void setExer_id(String exer_id) {
		this.exer_id = exer_id;
	}
	
}
