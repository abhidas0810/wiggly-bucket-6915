package com.masai.banking.bean;

public class Customer {

	private int account_no;
	private String password;
	private String cname;
	private String email;
	private String mobile;
	private double balance;
	private double loanammount;

	public Customer() {
		// TODO Auto-generated constructor stub
	}

	public Customer(int account_no, String password, String cname, String email, String mobile, double balance,
			double loanammount) {
		super();
		this.account_no = account_no;
		this.password = password;
		this.cname = cname;
		this.email = email;
		this.mobile = mobile;
		this.balance = balance;
		this.loanammount = loanammount;
	}

	public int getAccount_no() {
		return account_no;
	}

	public void setAccount_no(int account_no) {
		this.account_no = account_no;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getCname() {
		return cname;
	}

	public void setCname(String cname) {
		this.cname = cname;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getMobile() {
		return mobile;
	}

	public void setMobile(String mobile) {
		this.mobile = mobile;
	}

	public double getBalance() {
		return balance;
	}

	public void setBalance(double balance) {
		this.balance = balance;
	}

	public double getLoanammount() {
		return loanammount;
	}

	public void setLoanammount(double loanammount) {
		this.loanammount = loanammount;
	}

	@Override
	public String toString() {
		return "Customer [account_no = " + account_no + ", password = " + password + ", cname = " + cname + ", email = "
				+ email + ", mobile = " + mobile + ", balance = " + balance + ", loanammount = " + loanammount + "]";
	}
}
