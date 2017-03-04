package com.eduardoportfolio.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 * @author Eduardo Geralde Neto
 * 
 * This ConnectionFactory is responsible to create new connections through the getConnection() method.
 * In this particular case, it returns a mySql connection.
 */

public class ConnectionFactory {
	
	public Connection getConnection(){
		
		try {
			Class.forName("com.mysql.jdbc.Driver");
			return DriverManager.getConnection("jdbc:mysql://localhost/jdbc", "root", "password");
			
		} catch (SQLException | ClassNotFoundException e) {
			throw new RuntimeException (e);
		}
	}

}
