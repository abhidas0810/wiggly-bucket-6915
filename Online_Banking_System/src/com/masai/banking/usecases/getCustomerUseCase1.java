package com.masai.banking.usecases;

import java.util.Scanner;

import com.masai.banking.bean.Customer;
import com.masai.banking.dao.AccountantDao;
import com.masai.banking.dao.AccountantDaoImpl;

public class getCustomerUseCase1 {

	public static void main(String[] args) {

		Scanner in = new Scanner(System.in);

		System.out.println("Enter Customer Account Number :");
		int accountNo = in.nextInt();

		AccountantDao adao = new AccountantDaoImpl();
		Customer customer = adao.getCustomerByAccountno(accountNo);

		if (customer != null) {
			System.out.println(customer);
		} else {
			System.out.println("Customer does not exists.");
		}

		in.close();
	}

}
