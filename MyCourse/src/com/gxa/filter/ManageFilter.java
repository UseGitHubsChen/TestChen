package com.gxa.filter;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;


@WebFilter(urlPatterns="/sys/*")
public class ManageFilter implements Filter {

	@Override
	public void destroy() {

	}

	@Override
	public void doFilter(ServletRequest sre, ServletResponse srep,
			FilterChain chain) throws IOException, ServletException {
		    HttpServletRequest request = (HttpServletRequest) sre;
			HttpServletResponse response = (HttpServletResponse) srep;
			HttpSession session =  request.getSession(false);
		
		if (session!=null && session.getAttribute("adminname")!=null) {
			if (session.getAttribute("adminname").equals("admin")||session.getAttribute("adminname").equals("a")) {
				chain.doFilter(request, response);
		   }else{
			response.sendRedirect("../login/login.jsp");
			}
		}else{
			response.sendRedirect("../login/login.jsp");
		}
		
	}
	@Override
	public void init(FilterConfig arg0) throws ServletException {

	}

}
