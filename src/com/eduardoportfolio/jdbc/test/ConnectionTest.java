package com.eduardoportfolio.jdbc.test;

import java.sql.Connection;
import java.sql.SQLException;

import com.eduardoportfolio.jdbc.ConnectionFactory;

/**
 * @author Eduardo Geralde Neto
 * 
 * This class tests if the ConnectionFactory class through the getConnection() method is opening a 
 * connection
 */

public class ConnectionTest {

	public static void main(String[] args) throws SQLException {
		
		Connection connection = new ConnectionFactory().getConnection();
		System.out.println("Connection Open!");
		connection.close();

	}

}
