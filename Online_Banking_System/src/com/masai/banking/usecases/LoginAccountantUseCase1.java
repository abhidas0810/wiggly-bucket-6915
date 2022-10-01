package com.masai.banking.usecases;

import java.util.Scanner;

import com.masai.banking.bean.Accountant;
import com.masai.banking.dao.AccountantDao;
import com.masai.banking.dao.AccountantDaoImpl;
import com.masai.banking.exceptions.AccountantException;

public class LoginAccountantUseCase1 {

	public static boolean run() {

		Scanner in = new Scanner(System.in);

		System.out.println("Enter Accountant UswrId :");
		int userId = in.nextInt();

		System.out.println("Enter Accountant Password :");
		String password = in.next();

		AccountantDao adao = new AccountantDaoImpl();

		try {

			Accountant accountant = adao.loginAccountant(userId, password);
			System.out.println("Welcome Accountant : " + accountant.getAname().toUpperCase());
			return true;
		} catch (AccountantException e) {

			System.out.println(e.getMessage());
		}

		in.close();
		return false;
	}
}
