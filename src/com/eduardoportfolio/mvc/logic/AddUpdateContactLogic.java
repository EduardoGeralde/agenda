package com.eduardoportfolio.mvc.logic;

import java.io.PrintWriter;
import java.sql.Connection;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.eduardoportfolio.jdbc.dao.ContactDao;
import com.eduardoportfolio.jdbc.model.Contact;

/**
 * @author Eduardo Geralde Neto
 * 
 * This logic class was made to identify if the user wants to add a new contact or just update a exiting one,
 * through the contact's id. If the request comes without id, this logic understand that the user wants to 
 * create a new contact. Instead, if the request comes with the id, this is interpreted as a update. After that,
 * it returns a String to the Controller, where we want to be dispatched.
 */

public class AddUpdateContactLogic implements Logic {

	@Override
	public String execute(HttpServletRequest request, HttpServletResponse response) throws Exception {

		PrintWriter out = response.getWriter();
		
		//If contains id, parse to long 
		Long id = null;
		String idString = request.getParameter("id");
		if (idString != ""){
		id = Long.parseLong(idString);
		}

		//Date conversion
		String dateInText = request.getParameter("birthDate");
		Calendar birthDate = null;
		try{
			Date date = new SimpleDateFormat("dd/MM/yyyy").parse(dateInText);
			birthDate = Calendar.getInstance();
			birthDate.setTime(date);
			
		} catch (ParseException e){
			out.println("Date Conversion Error");
		}
		
		//Filling contact
		Contact contact = new Contact();
		contact.setName(request.getParameter("name"));
		contact.setEmail(request.getParameter("email"));
		contact.setAddress(request.getParameter("address"));
		contact.setBirthDate(birthDate);
		
		//Getting the connection, hanging on the request (from the filter)
		Connection connection = (Connection) request.getAttribute("connection");
		
		//Creating access 
		ContactDao dao = new ContactDao(connection);
		
		//If contains id, set contact's id and create, otherwise create new contact
		if (id != null){
			contact.setId(id);
			dao.update(contact);
		} else {
			dao.create(contact);
		}
		
		//Returning dispatch
		return "mvc?logic=ContactListLogic";
	}
}
