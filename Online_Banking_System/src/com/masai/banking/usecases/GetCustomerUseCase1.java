package com.masai.banking.usecases;

import java.util.Scanner;

import com.masai.banking.bean.Customer;
import com.masai.banking.dao.AccountantDao;
import com.masai.banking.dao.AccountantDaoImpl;
import com.masai.banking.exceptions.CustomerException;

public class GetCustomerUseCase1 {

	public static void run() {

		Scanner in = new Scanner(System.in);

		System.out.println("Enter Customer Account Number :");
		int accountNo = in.nextInt();

		AccountantDao adao = new AccountantDaoImpl();
		try {
			Customer customer = adao.getCustomerByAccountno(accountNo);

			System.out.println(customer);
		} catch (CustomerException e) {

			System.out.println(e.getMessage());
		}

		in.close();
	}

}
