/*package com.gxa.filter;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;

import com.gxa.wrapper.CharacterRequestWrapper;
@WebFilter("/*")
public class CharacterFilter implements Filter{

	@Override
	public void destroy() {
		
	}

	@Override
	public void doFilter(ServletRequest sreq, ServletResponse sreps, FilterChain chain)
			throws IOException, ServletException {
		//1.��ȡHttpServletRequest
		HttpServletRequest request = (HttpServletRequest)sreq;
		//2.��ȡHttpServletRequest�İ�װ�ࣨ��д������
		CharacterRequestWrapper requestWrapper = new CharacterRequestWrapper(request);
		//3.��������
		chain.doFilter(requestWrapper, sreps);
		
	}

	@Override
	public void init(FilterConfig arg0) throws ServletException {
		
	}

}
*/