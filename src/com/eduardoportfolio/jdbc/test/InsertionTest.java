package com.eduardoportfolio.jdbc.test;

import java.util.Calendar;

import com.eduardoportfolio.jdbc.dao.ContactDao;
import com.eduardoportfolio.jdbc.model.Contact;

public class InsertionTest {

	public static void main(String[] args) {
		
		//data to record
		Contact contact = new Contact();
		contact.setName("Andreia Silva");
		contact.setEmail("andreia_silva@gmail.com");
		contact.setAddress("Everton Street, 1200 - Glowville");
		contact.setBirthDate(Calendar.getInstance());
		
		//record in this connection
		ContactDao dao = new ContactDao();
		
		//method to create
		dao.create(contact);
		
		System.out.println("Data recorded !");
	}

}
