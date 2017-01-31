package com.eduardoportfolio.mvc.logic;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * @author Eduardo Geralde Neto
 * 
 * The logic of add a contact, in fact, is coupled with the update's logic in another logic class. This class
 * only returns, as a String, where we want to be dispatched, to the Controller
 */

public class FormAddLogic implements Logic {

	@Override
	public String execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		
		//Returning dispatch
		return "/WEB-INF/jsp/add-update-contact.jsp";
	}

}
