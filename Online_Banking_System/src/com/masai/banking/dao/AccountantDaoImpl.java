package com.masai.banking.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.masai.banking.bean.Customer;
import com.masai.banking.utility.DB;

public class AccountantDaoImpl implements AccountantDao {

	@Override
	public String registerCustomer(String password, String cname, String email, String mobile, double balance,
			double loanammount) {

		String message = "Not Incerted";

		try (Connection con = DB.provideConnection();) {

			PreparedStatement ps = con.prepareStatement(
					"insert into customer(password,cname,email,mobile,balance,loanammount) values(?,?,?,?,?,?)");
			ps.setString(1, password);
			ps.setString(2, cname);
			ps.setString(3, email);
			ps.setString(4, mobile);
			ps.setDouble(5, balance);
			ps.setDouble(6, loanammount);

			int x = ps.executeUpdate();

			if (x > 0) {

				message = "Account Created Sucessfully!";
			}

		} catch (SQLException e) {

			message = e.getMessage();
		}

		return message;
	}

	@Override
	public String registerCustomer2(Customer customer) {

		String message = "Not Incerted";

		try (Connection con = DB.provideConnection();) {

			PreparedStatement ps = con.prepareStatement(
					"insert into customer(password,cname,email,mobile,balance,loanammount) values(?,?,?,?,?,?)");
			ps.setString(1, customer.getPassword());
			ps.setString(2, customer.getCname());
			ps.setString(3, customer.getEmail());
			ps.setString(4, customer.getMobile());
			ps.setDouble(5, customer.getBalance());
			ps.setDouble(6, customer.getLoanammount());

			int x = ps.executeUpdate();

			if (x > 0) {

				message = "Account Created Sucessfully!";
			}

		} catch (SQLException e) {

			message = e.getMessage();
		}

		return message;
	}

	@Override
	public Customer getCustomerByAccountno(int account_no) {

		Customer customer = null;

		try (Connection con = DB.provideConnection();) {

			PreparedStatement ps = con.prepareStatement("select * from customer where account_no = ?");

			ps.setInt(1, account_no);

			ResultSet rs = ps.executeQuery();

			if (rs.next()) {

				int accountNo = rs.getInt("account_no");
				String password = rs.getString("password");
				String name = rs.getString("cname");
				String email = rs.getString("email");
				String mobile = rs.getString("mobile");
				double balance = rs.getDouble("balance");
				double loanammount = rs.getDouble("loanammount");

				customer = new Customer(accountNo, password, name, email, mobile, balance, loanammount);

			}

		} catch (SQLException e) {

			e.printStackTrace();
		}

		return customer;
	}

}
