package com.masai.banking.usecases;

import java.util.List;

import com.masai.banking.bean.Customer;
import com.masai.banking.dao.AccountantDao;
import com.masai.banking.dao.AccountantDaoImpl;
import com.masai.banking.exceptions.CustomerException;

public class GetAllCustomerUseCase {

	public static void run() {

		AccountantDao adao = new AccountantDaoImpl();

		try {
			List<Customer> customers = adao.getAllCustomer();

			customers.forEach(c -> {
				System.out.println(c);
				System.out.println(
						"=================");
			});
		} catch (CustomerException e) {

			System.out.println(e.getMessage());
		}

	}
}
