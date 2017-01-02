package com.eduardoportfolio.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.annotation.WebInitParam;


@WebServlet(name = "HelloServlet", urlPatterns = {"/hello","/holla"},
initParams = { @WebInitParam(name= "param1", value= "Hello Servlet "),
		@WebInitParam(name="param2", value="World !!")})

public class HelloServletWorld extends HttpServlet {
	private static final long serialVersionUID = 1L;

	@Override
	protected void service(HttpServletRequest request, HttpServletResponse response) 
			throws ServletException ,IOException {
		
		PrintWriter out = response.getWriter();
		
		out.println("<html>");
		out.println("<head>");
		out.println("<title>First Servlet</title>");
		out.println("</head>");
		out.println("<body>");
		out.println(getServletConfig().getInitParameter("param1"));
		out.println(getServletConfig().getInitParameter("param2"));
		out.println("</body>");
		out.println("</html>");
	}

}
