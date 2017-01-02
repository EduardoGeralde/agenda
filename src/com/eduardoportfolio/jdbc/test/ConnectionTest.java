package com.eduardoportfolio.jdbc.test;

import java.sql.Connection;
import java.sql.SQLException;

import com.eduardoportfolio.jdbc.ConnectionFactory;

public class ConnectionTest {

	public static void main(String[] args) throws SQLException {
		
		Connection connection = new ConnectionFactory().getConnection();
		System.out.println("Connection Open!");
		connection.close();

	}

}
