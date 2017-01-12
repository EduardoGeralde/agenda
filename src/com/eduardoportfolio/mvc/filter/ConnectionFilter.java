package com.eduardoportfolio.mvc.filter;

import java.io.IOException;
import java.sql.Connection;
import java.sql.SQLException;
import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import com.eduardoportfolio.jdbc.ConnectionFactory;

/**
 * @author Eduardo Geralde Neto
 * 
 * This class is a filter, which provides a connection for each requisition, and just close this connection 
 * in the end (return) of this resource.
 */

@WebFilter("/*")
public class ConnectionFilter implements Filter {

	@Override
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
			throws IOException, ServletException {
		
		try{
			Connection connection = new ConnectionFactory().getConnection();
			
			//Hanging the connection in the request
			request.setAttribute("connection", connection);
			
			//Request processing must proceed
			chain.doFilter(request, response);
			
			//Closing connection
			connection.close();
			
		} catch (SQLException e){
			throw new ServletException (e);
		}

	}

	@Override
	public void init(FilterConfig arg0) throws ServletException {
		// TODO Auto-generated method stub

	}
	
	@Override
	public void destroy() {
		// TODO Auto-generated method stub

	}

}
