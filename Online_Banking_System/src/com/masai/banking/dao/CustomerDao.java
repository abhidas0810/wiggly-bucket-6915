package com.masai.banking.dao;

import com.masai.banking.bean.Customer;
import com.masai.banking.exceptions.CustomerException;

public interface CustomerDao {

	public Customer loginCustomer(int account_no, String password) throws CustomerException;

	public void transferAmmount(int withdeawlAccount_no, String password, int transferToAccount_no, double ammount)
			throws CustomerException;
}
