package com.eduardoportfolio.mvc.servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import com.eduardoportfolio.mvc.logic.Logic;

/**
 * @author Eduardo Geralde Neto
 * 
 * This ControllerServlet controls which class to instantiate, based on the received parameters (logic and 
 * id), consequently, it runs the action (business rule) that must be executed by the execute () method of the, 
 * instantiated class. Finally, this Servlet dispatch to the specified JSP. Now all the responsibility of choosing 
 * the right action and the correct dispatch is only for the ControllerServlet. 
 */

@WebServlet ("/mvc")
public class ControllerServlet extends HttpServlet  {
	private static final long serialVersionUID = 1L;

	@Override
	protected void service(HttpServletRequest request, HttpServletResponse response) 
													throws ServletException, IOException {
		String parameter = request.getParameter("logic");
		String className = "com.eduardoportfolio.mvc.logic." + parameter;
		
		try{
			Class<?> create = Class.forName(className);
			
			Logic logic = (Logic) create.newInstance();
			String page = logic.execute(request, response);
			
			request.getRequestDispatcher(page).forward(request, response);
			
		} catch (Exception e) {
			
			throw new ServletException ("The business rules has caused a exception",e);
		}
	}

}
