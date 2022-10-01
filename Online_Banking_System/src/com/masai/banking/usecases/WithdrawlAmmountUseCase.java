package com.masai.banking.usecases;

import java.util.Scanner;

import com.masai.banking.dao.AccountantDao;
import com.masai.banking.dao.AccountantDaoImpl;
import com.masai.banking.exceptions.CustomerException;

public class WithdrawlAmmountUseCase {

	public static void main(String[] args) {

		AccountantDao adao = new AccountantDaoImpl();

		try {

			Scanner in = new Scanner(System.in);

			System.out.println("Enter Customer Account Number");
			int account = in.nextInt();
			
			System.out.println("Enter Password");
			String password = in.next();

			System.out.println("Enter Withdrawl Ammount");
			double ammount = in.nextDouble();			

			adao.withdrawAmmount(account, password, ammount);

			in.close();

		} catch (CustomerException e) {

			System.out.println(e.getMessage());
		}

	}
}
