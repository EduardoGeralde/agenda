package com.eduardoportfolio.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnectionFactory {
	
	public Connection getConnection(){
		try {
			//create new connection
			Class.forName("com.mysql.jdbc.Driver");
			return DriverManager.getConnection("jdbc:mysql://localhost/jdbc", "root", "password");
		} catch (SQLException | ClassNotFoundException e) {
			throw new RuntimeException (e);
		}
	}

}
