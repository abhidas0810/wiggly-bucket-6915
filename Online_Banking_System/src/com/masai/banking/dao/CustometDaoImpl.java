package com.masai.banking.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.masai.banking.bean.Customer;
import com.masai.banking.exceptions.CustomerException;
import com.masai.banking.utility.DB;

public class CustometDaoImpl implements CustomerDao {

	@Override
	public Customer loginCustomer(int account_no, String password) throws CustomerException {

		Customer customer = null;

		try (Connection con = DB.provideConnection();) {

			PreparedStatement ps = con.prepareStatement("select * from customer where account_no = ? AND password = ?");

			ps.setInt(1, account_no);
			ps.setString(2, password);

			ResultSet rs = ps.executeQuery();

			if (rs.next()) {

				int userid = rs.getInt("account_no");
				String pass = rs.getString("password");
				String name = rs.getString("cname");
				String email = rs.getString("email");
				String mobile = rs.getString("mobile");
				double balance = rs.getDouble("balance");
				double loanammount = rs.getDouble("loanammount");

				customer = new Customer(userid, pass, name, email, mobile, balance, loanammount);

			} else {

				throw new CustomerException("Invalid Account number or Password.");
			}

		} catch (SQLException e) {

			throw new CustomerException(e.getMessage());
		}

		return customer;
	}

}
