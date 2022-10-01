package com.masai.banking.usecases;

import java.util.Scanner;

import com.masai.banking.dao.CustomerDao;
import com.masai.banking.dao.CustometDaoImpl;
import com.masai.banking.exceptions.CustomerException;

public class TransferMoneyUseCase {

	public static void main(String[] args) {

		CustomerDao cdao = new CustometDaoImpl();

		try {
			Scanner in = new Scanner(System.in);

			System.out.println("Enter Withdrawl Account Number");
			int withdrawlAccount = in.nextInt();

			System.out.println("Enter Withdrawl Account Password");
			String password = in.next();

			System.out.println("Enter Deposit Account Number");
			int depositAccount = in.nextInt();

			System.out.println("Enter Ammount");
			double ammount = in.nextDouble();

			cdao.transferAmmount(withdrawlAccount, password, depositAccount, ammount);

			in.close();
		} catch (CustomerException e) {

			System.out.println(e.getMessage());
		}

	}

}
