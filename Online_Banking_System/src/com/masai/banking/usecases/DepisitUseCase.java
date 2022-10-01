package com.masai.banking.usecases;

import java.util.Scanner;

import com.masai.banking.dao.AccountantDao;
import com.masai.banking.dao.AccountantDaoImpl;
import com.masai.banking.exceptions.CustomerException;

public class DepisitUseCase {

	public static void run() {

		AccountantDao adao = new AccountantDaoImpl();

		try {

			Scanner in = new Scanner(System.in);

			System.out.println("Enter Customer Account Number");
			int account = in.nextInt();

			System.out.println("Enter Deposit Ammount");
			double ammount = in.nextDouble();

			adao.depositAmmount(account, ammount);

			in.close();

		} catch (CustomerException e) {

			System.out.println(e.getMessage());
		}
	}

}
