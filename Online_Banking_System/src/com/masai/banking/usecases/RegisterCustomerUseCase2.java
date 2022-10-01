package com.masai.banking.usecases;

import java.util.Scanner;

import com.masai.banking.bean.Customer;
import com.masai.banking.dao.AccountantDao;
import com.masai.banking.dao.AccountantDaoImpl;

public class RegisterCustomerUseCase2 {

	public static void run() {

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

		Customer customer = new Customer();
		customer.setPassword(password);
		customer.setCname(cname);
		customer.setEmail(email);
		customer.setMobile(mobile);
		customer.setBalance(balance);
		customer.setLoanammount(loanamount);

		String result = adao.registerCustomer2(customer);

		System.out.println(result);

		in.close();

	}
}
