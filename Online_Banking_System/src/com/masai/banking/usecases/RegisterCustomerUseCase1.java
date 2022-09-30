package com.masai.banking.usecases;

import java.util.Scanner;

import com.masai.banking.dao.AccountantDao;
import com.masai.banking.dao.AccountantDaoImpl;

public class RegisterCustomerUseCase1 {

	public static void main(String[] args) {

		Scanner in = new Scanner(System.in);

		System.out.println("Enter Customer Password");
		String password = in.next();

		System.out.println("Enter Customer Name");
		in.nextLine();
		String cname = in.nextLine();

		System.out.println("Enter Customer Email");
		String email = in.next();

		System.out.println("Enter Customer Mobile");
		String mobile = in.next();

		System.out.println("Enter Customer Balance");
		double balance = in.nextDouble();

		System.out.println("Enter Customer Loan Ammount");
		double loanamount = in.nextDouble();

		AccountantDao adao = new AccountantDaoImpl();

		String result = adao.registerCustomer(password, cname, email, mobile, balance, loanamount);

		System.out.println(result);

		in.close();

	}
}
