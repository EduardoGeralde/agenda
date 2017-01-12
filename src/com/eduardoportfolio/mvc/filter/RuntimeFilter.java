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

@WebFilter("/*")
public class RuntimeFilter implements Filter {

	@Override
	public void destroy() {
		// TODO Auto-generated method stub
	}

	@Override
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
			throws IOException, ServletException {
		
		long initialTime = System.currentTimeMillis();
		
		chain.doFilter(request, response);
		
		long finalTime = System.currentTimeMillis();
		
		String uri = ((HttpServletRequest)request).getRequestURI();
		String parameters = ((HttpServletRequest)request).getParameter("logic");
		
		System.out.print("Requisition time for ");
                System.out.print(uri + "?logic= ");
                System.out.print(parameters + " took ");
                System.out.println(finalTime-initialTime + " ms");
	}

	@Override
	public void init(FilterConfig config) throws ServletException {
		// TODO Auto-generated method stub
	}

}
