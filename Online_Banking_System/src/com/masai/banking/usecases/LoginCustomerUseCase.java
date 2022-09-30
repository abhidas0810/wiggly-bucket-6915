package com.masai.banking.usecases;

import java.util.Scanner;

import com.masai.banking.bean.Customer;
import com.masai.banking.dao.CustomerDao;
import com.masai.banking.dao.CustometDaoImpl;
import com.masai.banking.exceptions.CustomerException;

public class LoginCustomerUseCase {

	public static void main(String[] args) {

		Scanner in = new Scanner(System.in);

		System.out.println("Enter Accountant UswrId :");
		int userId = in.nextInt();

		System.out.println("Enter Accountant Password :");
		String password = in.next();

		CustomerDao adao = new CustometDaoImpl();

		try {

			Customer customer = adao.loginCustomer(userId, password);
			System.out.println("Welcome Account Holder : " + customer.getCname().toUpperCase());

		} catch (CustomerException e) {

			System.out.println(e.getMessage());
		}

		in.close();

	}

}
