package com.eduardoportfolio.mvc.logic;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.eduardoportfolio.jdbc.dao.ContactDao;
import com.eduardoportfolio.jdbc.model.Contact;

public class ContactListLogic implements Logic {

	@Override
	public String execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		
		List<Contact> contacts = new ContactDao().getList();
		
		request.setAttribute("contacts", contacts);
		
		return "/WEB-INF/jsp/contactListJSTL-DisplayTag.jsp";
	}

}
