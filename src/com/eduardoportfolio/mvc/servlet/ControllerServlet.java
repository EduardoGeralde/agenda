package com.eduardoportfolio.mvc.servlet;

import java.io.IOException;

import javax.servlet.AsyncContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import com.eduardoportfolio.mvc.logic.Logic;

/**
 * @author Eduardo Geralde Neto
 * 
 * This ControllerServlet controls which class to instantiate, based on the parameter "logic" received. 
 * After instantiate, it runs the action (business rule) by the execute method of the this class.
 * 
 * Finally, this Servlet dispatch to the specified JSP or class that arrives from ours logic classes as a String. 
 * Now all the responsibility to the right action and the correct dispatch is only for the ControllerServlet. 
 */

//Both servlets and filters can be written in a asynchronous manner with asyncSupported and startAsync
@WebServlet (asyncSupported=true, urlPatterns={"/mvc"})
public class ControllerServlet extends HttpServlet  {
	private static final long serialVersionUID = 1L;

	@Override
	protected void service(HttpServletRequest request, HttpServletResponse response) 
													throws ServletException, IOException {
		//Both servlets and filters can be written in a asynchronous manner
		@SuppressWarnings("unused")
		AsyncContext context = request.startAsync(request,response);
		
		//Getting the parameter "logic" and setting FQN
		String parameter = request.getParameter("logic");
		String className = "com.eduardoportfolio.mvc.logic." + parameter;
		
		try{
			Class<?> create = Class.forName(className);
			
			//Performing action by "execute" method
			Logic logic = (Logic) create.newInstance();
			String page = logic.execute(request, response);
			
			//Dispatching
			request.getRequestDispatcher(page).forward(request, response);
			
		} catch (Exception e) {
			
			throw new ServletException ("The business rules has caused a exception",e);
		}
	}

}
