package com.masai.banking.usecases;

import java.util.Scanner;

import com.masai.banking.dao.AccountantDao;
import com.masai.banking.dao.AccountantDaoImpl;
import com.masai.banking.exceptions.CustomerException;

public class RemoveAccountUseCase {

	public static void run() {

		AccountantDao adao = new AccountantDaoImpl();

		Scanner in = new Scanner(System.in);

		System.out.println("Enter Customer Account Number");
		int account = in.nextInt();

		try {
			String message = adao.closeCustomerAccount(account);

			System.out.println(message);
		} catch (CustomerException e) {
			System.out.println(e.getMessage());
		}

		in.close();
	}

}
