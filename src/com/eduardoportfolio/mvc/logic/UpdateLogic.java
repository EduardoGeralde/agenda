package com.eduardoportfolio.mvc.logic;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.eduardoportfolio.jdbc.dao.ContactDao;
import com.eduardoportfolio.jdbc.model.Contact;

public class UpdateLogic implements Logic {

	@Override
	public String execute(HttpServletRequest request, HttpServletResponse response) throws Exception {

		long id = Long.parseLong(request.getParameter("id"));

		ContactDao dao = new ContactDao();
		Contact contact = dao.selectById(id);
		
		request.setAttribute("contact", contact);
		
		return "/WEB-INF/jsp/add-update-contact.jsp";
	}

}
