package com.eduardoportfolio.mvc.logic;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * @author Eduardo Geralde Neto
 * 
 * This is our Interface for all logic classes. The Logic Interface the ControllerServlet can instantiate and
 * execute the logic classes methods through polymorphism.
 */

public interface Logic {
	
	String execute (HttpServletRequest request, HttpServletResponse response) throws Exception;

}
