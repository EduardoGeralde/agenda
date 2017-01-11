package com.eduardoportfolio.mvc.logic;

import java.io.PrintWriter;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.eduardoportfolio.jdbc.dao.ContactDao;
import com.eduardoportfolio.jdbc.model.Contact;

public class AddUpdateContactLogic implements Logic {

	@Override
	public String execute(HttpServletRequest request, HttpServletResponse response) throws Exception {

		PrintWriter out = response.getWriter();
		
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
		
		Contact contact = new Contact();
		contact.setName(request.getParameter("name"));
		contact.setEmail(request.getParameter("email"));
		contact.setAddress(request.getParameter("address"));
		contact.setBirthDate(birthDate);
		
		ContactDao dao = new ContactDao();
		
		if (id != null){
			contact.setId(id);
			dao.update(contact);
		} else {
			dao.create(contact);
		}
		
		return "mvc?logic=ContactListLogic";
	}
}
