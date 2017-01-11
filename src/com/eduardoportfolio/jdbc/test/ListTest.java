package com.eduardoportfolio.jdbc.test;

import java.text.SimpleDateFormat;
import java.util.List;

import com.eduardoportfolio.jdbc.dao.ContactDao;
import com.eduardoportfolio.jdbc.model.Contact;

/**
 * @author Eduardo Geralde Neto
 * 
 * This class tests if the method getList() is returning a contact list with all contacts in DB.
 */

public class ListTest {

	public static void main(String[] args) {
		
		ContactDao dao = new ContactDao();
		
		SimpleDateFormat dateFormat = new SimpleDateFormat("dd MMM yyyy");
		
		//Getting the List
		List<Contact> contacts = dao.getList();
		
		//Iterating to show all contacts
		for (Contact contact : contacts) {
			System.out.println("Nome: "+ contact.getName());
			System.out.println("Email: "+ contact.getEmail());
			System.out.println("Address: "+ contact.getAddress());
			System.out.println("Date of birth: "+ dateFormat.format(contact.getBirthDate().getTime())+ "\n");
		}
	}
}
