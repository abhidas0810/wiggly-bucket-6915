package com.masai.banking.dao;

import com.masai.banking.bean.Customer;

public interface AccountantDao {

	public String registerCustomer(String password, String cname, String email, String mobile, double balance,
			double loanammount);

	public String registerCustomer2(Customer customer);

	public Customer getCustomerByAccountno(int account_no);

}
