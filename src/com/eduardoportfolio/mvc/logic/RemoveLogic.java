package com.eduardoportfolio.mvc.logic;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.eduardoportfolio.jdbc.dao.ContactDao;
import com.eduardoportfolio.jdbc.model.Contact;

/**
* @author Eduardo Geralde Neto
* 
* This class contains the logic to remove a contact in BD from a received id in the request, after that, it 
* return, as a String, where we want to be dispatched, to the ControllerServlet .
*/

public class RemoveLogic implements Logic {

	@Override
	public String execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		
		//Getting ID from the request
		long id = Long.parseLong(request.getParameter("id"));
		
		//Setting the ID to a contact object
		Contact contact = new Contact ();
		contact.setId(id);
		
		//Removing the respective contact
		ContactDao dao = new ContactDao();
		dao.delete(contact);
		
		System.out.println("Contact removed...");
		
		//Returning dispatch
		return "mvc?logic=ContactListLogic";
	}

}
