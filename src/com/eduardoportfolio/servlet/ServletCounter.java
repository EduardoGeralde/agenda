package com.eduardoportfolio.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * This class is a simple example that help us to fill that in according to the specification of Servlets, by 
 * default, there is only a single instance of each Servlet declared. When the request arrives to the Servlet, 
 * a new THREAD is opened on that instance that already exists.
 * Therefore, sharing objects between threads can bring us serious problems.
 */

@WebServlet ("/counter")
public class ServletCounter extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	//instance variable
	private int counter = 0;
	
	@Override
	protected void service(HttpServletRequest request, HttpServletResponse response) 
								throws ServletException, IOException {
		
		//each  request, the same variable is increased
		counter ++;
		
		PrintWriter out = response.getWriter();
		
		out.println("<html>");
		out.println("<body>");
		out.println("The counter now is: " + counter);
		out.println("</body>");
		out.println("</html>");
	}
	
	

}
