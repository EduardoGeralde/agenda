package com.eduardoportfolio.mvc.logic;

import java.sql.Connection;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.eduardoportfolio.jdbc.dao.ContactDao;
import com.eduardoportfolio.jdbc.model.Contact;

/**
 * @author Eduardo Geralde Neto
 * 
 * The ContactListLogic contains the logic responsible to create a list of all contacts, embed this list in the 
 * request, and return as a String to the ControllerServlet where we want to be dispatched.
 */

public class ContactListLogic implements Logic {

	@Override
	public String execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		
		//Getting the connection, hanging on the request (from the filter)
		Connection connection = (Connection) request.getAttribute("connection");
		
		List<Contact> contacts = new ContactDao(connection).getList();
		
		//Embedding the list
		request.setAttribute("contacts", contacts);
		
		//Returning dispatch
		return "/WEB-INF/jsp/contactListJSTL-DisplayTag.jsp";
	}

}
