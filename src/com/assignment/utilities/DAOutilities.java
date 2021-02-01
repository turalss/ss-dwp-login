package com.assignment.utilities;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

// database connection 

public class DAOutilities {

	private static final String DRIVER = "com.mysql.cj.jdbc.Driver";
	private static final String URL = "jdbc:mysql://localhost:3306/users";
	private static final String USERNAME = "root";
	private static final String PASSWORD = "rootroot";
	private static Connection connection = null;
	
	private DAOutilities() {};
	
	public static synchronized Connection getConnection() throws SQLException {
		if (connection == null) {
			try {
				Class.forName(DRIVER);
			} catch (ClassNotFoundException e) {
				System.out.println("Could not register driver!");
				e.printStackTrace();
			}
			connection = DriverManager.getConnection(URL, USERNAME, PASSWORD);
			System.out.println(connection + " connected");
		}
		
		//If connection was closed then retrieve a new connection
		if (connection.isClosed()){
			System.out.println("Opening new connection...");
			connection = DriverManager.getConnection(URL, USERNAME, USERNAME);
		}
		return connection;
	}

}
