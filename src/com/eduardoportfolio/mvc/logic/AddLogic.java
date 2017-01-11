package com.eduardoportfolio.mvc.logic;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class AddLogic implements Logic {

	@Override
	public String execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		
		return "/WEB-INF/jsp/add-update-contact.jsp";
	}

}
