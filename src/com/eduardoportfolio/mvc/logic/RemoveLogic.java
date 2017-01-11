package com.eduardoportfolio.mvc.logic;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.eduardoportfolio.jdbc.dao.ContactDao;
import com.eduardoportfolio.jdbc.model.Contact;

/**
 * @author Eduardo Geralde Neto
 * 
 * This implementation of execute method, removes the contact in DB based on the user choose in JSP form.
 * This class represents one of the actions (business rules) that will be instantiated when requested by our 
 * ControllerServlet. Notice that the execute() method returns a string after executing its logic, indicating
 * to our ControllerServlet to execute the ContactListLogic.
 */

public class RemoveLogic implements Logic {

	@Override
	public String execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		
		long id = Long.parseLong(request.getParameter("id"));
		
		Contact contact = new Contact ();
		contact.setId(id);
		
		ContactDao dao = new ContactDao();
		dao.delete(contact);
		
		System.out.println("Contact removed...");
		
		return "mvc?logic=ContactListLogic";
	}

}
