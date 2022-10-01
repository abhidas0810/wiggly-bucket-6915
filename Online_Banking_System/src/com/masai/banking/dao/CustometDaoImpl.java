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

	@Override
	public void transferAmmount(int withdeawlAccount_no, String password, int transferToAccount_no, double ammount)
			throws CustomerException {

		try (Connection con = DB.provideConnection();) {

			PreparedStatement ps = con.prepareStatement("select * from customer where account_no = ?;");
			ps.setInt(1, withdeawlAccount_no);

			ResultSet rs = ps.executeQuery();

			if (rs.next()) {

				double balance = rs.getDouble("balance");
				String pass = rs.getString("password");

				if (pass.equals(password)) {
					PreparedStatement ps2 = con.prepareStatement("select * from customer where account_no = ?;");
					ps2.setInt(1, transferToAccount_no);

					ResultSet rs2 = ps2.executeQuery();

					if (rs2.next()) {

						double depositBalance = rs2.getDouble("balance");

						if (balance >= ammount) {
							balance = balance - ammount;
							PreparedStatement ps3 = con
									.prepareStatement("update customer set balance = ? where account_no = ?;");

							ps3.setDouble(1, balance);
							ps3.setInt(2, withdeawlAccount_no);

							int x = ps3.executeUpdate();

							if (x > 0) {
								depositBalance = depositBalance + ammount;
								PreparedStatement ps4 = con
										.prepareStatement("update customer set balance = ? where account_no = ?;");

								ps4.setDouble(1, depositBalance);
								ps4.setInt(2, transferToAccount_no);

								ps4.executeUpdate();

								System.out.println("Transfer successfull! available balance is : " + balance);
							}
						} else {
							throw new CustomerException("Account number " + withdeawlAccount_no
									+ " does not have sufficient balance for transaction.");
						}
					} else {
						throw new CustomerException("Account number " + transferToAccount_no + " does not exists.");
					}

				} else {
					throw new CustomerException("Incorrect password.");
				}

			} else {

				throw new CustomerException("Account number " + withdeawlAccount_no + " does not exists.");
			}

		} catch (SQLException e) {

			throw new CustomerException(e.getMessage());
		}
	}

}
