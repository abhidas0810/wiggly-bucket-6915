package com.masai.banking.dao;

import com.masai.banking.bean.Customer;
import com.masai.banking.exceptions.CustomerException;

public interface CustomerDao {

	public Customer loginCustomer(int account_no, String password) throws CustomerException;

}
