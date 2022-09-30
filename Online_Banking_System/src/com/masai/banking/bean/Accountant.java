package com.masai.banking.bean;

public class Accountant {

	private int userId;
	private String password;
	private String aname;

	public Accountant() {
		// TODO Auto-generated constructor stub
	}

	public Accountant(int userId, String password, String aname) {
		super();
		this.userId = userId;
		this.password = password;
		this.aname = aname;
	}

	public int getUserId() {
		return userId;
	}

	public void setUserId(int userId) {
		this.userId = userId;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getAname() {
		return aname;
	}

	public void setAname(String aname) {
		this.aname = aname;
	}

	@Override
	public String toString() {
		return "Accountant [userId=" + userId + ", password=" + password + ", aname=" + aname + "]";
	}
}
