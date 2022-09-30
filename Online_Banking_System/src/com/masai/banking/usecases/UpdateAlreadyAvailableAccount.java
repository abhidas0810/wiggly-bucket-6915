package com.masai.banking.usecases;

import java.util.Scanner;

import com.masai.banking.bean.Customer;
import com.masai.banking.dao.AccountantDao;
import com.masai.banking.dao.AccountantDaoImpl;
import com.masai.banking.exceptions.CustomerException;

public class UpdateAlreadyAvailableAccount {

	public static void main(String[] args) {

		AccountantDao adao = new AccountantDaoImpl();
		try {

			Scanner in = new Scanner(System.in);

			System.out.println("Enter Customer Account Number");
			int account = in.nextInt();

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

			Customer customer = new Customer();
			customer.setAccount_no(account);
			customer.setPassword(password);
			customer.setCname(cname);
			customer.setEmail(email);
			customer.setMobile(mobile);
			customer.setBalance(balance);
			customer.setLoanammount(loanamount);

			in.close();

			Customer ucustomer = adao.updateCustomerAccount(customer);

			System.out.println(ucustomer);
		} catch (CustomerException e) {

			System.out.println(e.getMessage());
		}

	}
}
