package com.eduardoportfolio.mvc.filter;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;


/**
 * @author Eduardo Geralde Neto
 * 
 * This class is a filter, which all requisitions ("/*") of our application has to be filtered. This helps us not to 
 * need to put this logic in all our classes. In this specific case, this filter takes the current time before the 
 * logic/resource, and the time on returning way, when close this logic/resource, then, prints the
 * traced result in the console. Filters are good ways to errors handling, measure execution time, close 
 * doors, etc..
 */

@WebFilter("/*")
public class RuntimeFilter implements Filter {

	@Override
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
			throws IOException, ServletException {
		
		//Takes the initial time
		long initialTime = System.currentTimeMillis();
		
		//Indicates that request processing must proceed
		chain.doFilter(request, response);
		
		//Takes the final time, when the operation was done
		long finalTime = System.currentTimeMillis();
		
		//Parameters to trace the logic/resource
		String uri = ((HttpServletRequest)request).getRequestURI();
		String parameters = ((HttpServletRequest)request).getParameter("logic");
		
		//Printing results
		System.out.print("Requisition time for ");
                System.out.print(uri + "?logic= ");
                System.out.print(parameters + " took ");
                System.out.println(finalTime-initialTime + " ms");
	}

	//This method is to execute something when this filter is loaded by the container
	@Override
	public void init(FilterConfig config) throws ServletException {
		// TODO Auto-generated method stub
	}
	
	//This method is to execute something when this filter is unloaded by the container
	@Override
	public void destroy() {
		// TODO Auto-generated method stub
	}

}
