package com.masai.banking.dao;

import java.util.List;

import com.masai.banking.bean.Accountant;
import com.masai.banking.bean.Customer;
import com.masai.banking.exceptions.AccountantException;
import com.masai.banking.exceptions.CustomerException;

public interface AccountantDao {

	public String registerCustomer(String password, String cname, String email, String mobile, double balance,
			double loanammount);

	public String registerCustomer2(Customer customer);

	public Customer getCustomerByAccountno(int account_no) throws CustomerException;

	public Accountant loginAccountant(int userId, String password) throws AccountantException;

	public List<Customer> getAllCustomer() throws CustomerException;

	public Customer updateCustomerAccount(Customer customer) throws CustomerException;

	public String closeCustomerAccount(int account_no) throws CustomerException;

}
