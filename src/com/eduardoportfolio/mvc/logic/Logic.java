package com.eduardoportfolio.mvc.logic;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public interface Logic {
	
	String execute (HttpServletRequest request, HttpServletResponse response) throws Exception;

}
