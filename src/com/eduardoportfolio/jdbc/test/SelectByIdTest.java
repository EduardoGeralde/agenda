package com.eduardoportfolio.jdbc.test;

import com.eduardoportfolio.jdbc.dao.ContactDao;
import com.eduardoportfolio.jdbc.model.Contact;

/**
 * @author Eduardo Geralde Neto
 * 
 * This class tests the selection of a contact in DB by a given ID using selectById() method.
 */

public class SelectByIdTest {

	public static void main(String[] args) {
		
		Contact contact = new Contact();
		
		ContactDao dao = new ContactDao();
		
		contact = dao.selectById((long) 1);
		
		System.out.println(contact.getName());
		System.out.println(contact.getEmail());
		System.out.println(contact.getAddress());
	}
}
