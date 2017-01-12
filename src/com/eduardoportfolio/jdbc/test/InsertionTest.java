package com.eduardoportfolio.jdbc.test;

import java.sql.Connection;
import java.util.Calendar;

import com.eduardoportfolio.jdbc.ConnectionFactory;
import com.eduardoportfolio.jdbc.dao.ContactDao;
import com.eduardoportfolio.jdbc.model.Contact;

/**
 * @author Eduardo Geralde Neto
 * 
 * This class tests insertion of the contact in DB through the create() method.
 */

public class InsertionTest {

	public static void main(String[] args) {
		
		//Data to record
		Contact contact = new Contact();
		contact.setName("Andreia Silva");
		contact.setEmail("andreia_silva@gmail.com");
		contact.setAddress("Everton Street, 1200 - Glowville");
		contact.setBirthDate(Calendar.getInstance());
		
		//Getting the connection
		Connection connection = new ConnectionFactory().getConnection();
		
		//Record in this connection
		ContactDao dao = new ContactDao(connection);
		
		//Method to create
		dao.create(contact);
		
		System.out.println("Data recorded !");
	}

}
