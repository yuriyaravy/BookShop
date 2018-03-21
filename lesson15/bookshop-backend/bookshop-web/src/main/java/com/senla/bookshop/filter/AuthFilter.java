package com.senla.bookshop.filter;

import java.io.IOException;
import java.util.Arrays;
import java.util.List;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.xml.ws.spi.WebServiceFeatureAnnotation;

import org.apache.commons.lang3.StringUtils;
import org.apache.log4j.Logger;

import com.senla.bookshop.entity.User;
import com.senla.bookshop.utils.web.TokenHandler;

public class AuthFilter implements Filter{
	
	private static final Logger LOGGER = Logger.getLogger(AuthFilter.class);
	
	private List<String> pathFilter = Arrays
			.asList(new String[] { "deleteBook", "getBooks", "getOrders", "getRequests"
					, "putBookTo" , "putOrder" , "request" , "login" , "logout"});
	
	private FilterConfig filterConfig;
	

	@Override
	public void init(FilterConfig filterConfig) throws ServletException {
		this.filterConfig = filterConfig;
	}

	@Override
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)throws IOException, ServletException {
		
		HttpServletRequest req = (HttpServletRequest) request;
		String uri = ((HttpServletRequest)request).getRequestURI();
		String path  = StringUtils.substringAfterLast(uri, "/");
		
		Integer id = TokenHandler.getInstance().extractToken(req.getHeader("id"));
		
		if(!pathFilter.contains(path) && id != null) {
			chain.doFilter(request, response);
			return;
		}
	}

	@Override
	public void destroy() {
		this.filterConfig = null;
	}

}
