package com.masai.banking.dao;

public interface AccountantDao {

	public String registerCustomer(String password, String cname, String email, String mobile, double balance,
			double loanammount);
}
