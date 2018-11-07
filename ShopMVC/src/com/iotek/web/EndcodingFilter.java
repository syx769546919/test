package com.iotek.web;

import java.io.IOException;


import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;

public class EndcodingFilter implements Filter {

	@Override
	public void destroy() {
	

	}

	@Override
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
			throws IOException, ServletException {
		
		HttpServletRequest sr=(HttpServletRequest)request;
		if(sr.getServletPath().endsWith(".jsp")) {
			request.getRequestDispatcher("error.jsp").forward(request, response);
			return;
		}
		if(sr.getServletPath().endsWith(".html")) {
			request.getRequestDispatcher("error.jsp").forward(request, response);
			return;
		}
		System.out.println(1);
		request.setCharacterEncoding("UTF-8");
		response.setCharacterEncoding("UTF-8");
		chain.doFilter(request, response);
		
	}

	@Override
	public void init(FilterConfig inConfig) throws ServletException {
		

	}

}
