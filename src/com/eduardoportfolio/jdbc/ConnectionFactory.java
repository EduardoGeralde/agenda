package com.eduardoportfolio.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnectionFactory {
	
	public Connection getConnection(){
		try {
			//create new connection
			return DriverManager.getConnection("jdbc:mysql://localhost/jdbc", "root", "password");
			
		} catch (SQLException e) {
			throw new RuntimeException (e);
		}
	}

}
