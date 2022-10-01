package com.masai.banking.usecases;

import java.util.Scanner;

import com.masai.banking.bean.Customer;
import com.masai.banking.dao.CustomerDao;
import com.masai.banking.dao.CustometDaoImpl;
import com.masai.banking.exceptions.CustomerException;

public class LoginCustomerUseCase {

	public static boolean run() {

		Scanner in = new Scanner(System.in);

		System.out.println("Enter Account Number :");
		int userId = in.nextInt();

		System.out.println("Enter Account Password :");
		String password = in.next();

		CustomerDao cdao = new CustometDaoImpl();

		try {

			Customer customer = cdao.loginCustomer(userId, password);
			System.out.println("Welcome Account Holder : " + customer.getCname().toUpperCase());
			return true;
		} catch (CustomerException e) {

			System.out.println(e.getMessage());
		}

		in.close();
		return false;
	}

}
