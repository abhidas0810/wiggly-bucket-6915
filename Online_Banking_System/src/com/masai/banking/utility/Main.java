package com.masai.banking.utility;

import java.sql.Connection;

public class Main {

	public static void main(String[] args) {

		Connection conn = DB.provideConnection();

		System.out.println(conn);

	}

}
