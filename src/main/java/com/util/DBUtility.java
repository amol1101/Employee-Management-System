package com.util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DBUtility {
	private static final String URL ="jdbc:mysql://localhost:3306/empdb01";
	private static final String USERNAME = "root";
	private static final String PASSWORD = "Amol@1101";

	static {
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			System.out.println("Driver Loded....");
		} catch (ClassNotFoundException e) {
			System.out.println("Driver Loading Failed");
		}
	}
		
	/*
	public DBUtility() {
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			System.out.println("Driver Loded....");
		} catch (ClassNotFoundException e) {
			System.out.println("Driver Loading Failed");
		}
	} 
	*/
	public static Connection getConnection() {
		Connection con = null;
		try {
			con = DriverManager.getConnection(URL, USERNAME, PASSWORD);
			System.out.println("Connection Success..");

		} catch (SQLException e) {
			System.out.println("Connection failed");
			e.printStackTrace();
		}
		return con;
	}

}
