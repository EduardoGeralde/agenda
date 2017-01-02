package com.eduardoportfolio.jdbc.test;

import com.eduardoportfolio.jdbc.dao.ContactDao;
import com.eduardoportfolio.jdbc.model.Contact;

public class SelectByIdTest {

	public static void main(String[] args) {
		
		Contact contact = new Contact();
		
		ContactDao dao = new ContactDao();
		
		contact = dao.selectById(1);
		
		System.out.println(contact.getName());
		System.out.println(contact.getEmail());
		System.out.println(contact.getAddress());
	}
}
