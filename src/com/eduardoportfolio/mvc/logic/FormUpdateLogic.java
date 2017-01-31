package com.eduardoportfolio.mvc.logic;

import java.sql.Connection;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.eduardoportfolio.jdbc.dao.ContactDao;
import com.eduardoportfolio.jdbc.model.Contact;

/**
* @author Eduardo Geralde Neto
* 
* The update logic, in fact, is coupled with the add logic in another logic class. 
* This class, select a contact object in BD, just through the id that arrived in the request. Than, it set the 
* request attribute with this full contact object from BD. This object will be used to fill the update form with
* the information of the contact we choose. After that, it return as a String, where we want to be 
* dispatched, for the ControllerServlet
*/

public class FormUpdateLogic implements Logic {

	@Override
	public String execute(HttpServletRequest request, HttpServletResponse response) throws Exception {

		//Getting ID
		long id = Long.parseLong(request.getParameter("id"));

		//Getting the connection, hanging on the request (from the filter)
		Connection connection = (Connection) request.getAttribute("connection");
		
		//Selecting contact by ID
		ContactDao dao = new ContactDao(connection);
		Contact contact = dao.selectById(id);
		
		//Setting request's attribute
		request.setAttribute("contact", contact);
		
		//Returning dispatch
		return "/WEB-INF/jsp/add-update-contact.jsp";
	}

}
