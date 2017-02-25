package com.eduardoportfolio.jdbc.exception;

import java.sql.SQLException;

/**
 * @author Eduardo Geralde Neto
 * 
 * DAOException was created to use in our CRUD methods in ContactDao
 */

public class DAOException extends RuntimeException {
	private static final long serialVersionUID = 1L;

	//This is a exception created for our ContactDAO class
	public DAOException(SQLException e){
		super(e);
	}

}
