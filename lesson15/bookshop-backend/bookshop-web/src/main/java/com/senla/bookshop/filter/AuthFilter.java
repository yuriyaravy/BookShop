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

import org.apache.commons.lang3.StringUtils;
import org.apache.log4j.Logger;

import com.senla.bookshop.entity.User;
import com.senla.bookshop.facade.Facade;
import com.senla.bookshop.utils.web.TokenStorage;

public class AuthFilter implements Filter {

	private static final Logger LOGGER = Logger.getLogger(AuthFilter.class);

	private static final String ATTRIBUTE_USER = "User";
	private static final String ATTRIBUTE_METHOD = "method";
	private static final String CONDITION = "/";

	private List<String> pathFilter = Arrays
			.asList(new String[] { "book", "order", "request", "request", "login", "logout" });

	private FilterConfig filterConfig;

	@Override
	public void init(FilterConfig filterConfig) throws ServletException {
		this.filterConfig = filterConfig;
	}

	@Override
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain filterChain)
			throws IOException, ServletException {

		String url = ((HttpServletRequest) request).getRequestURI();
		String path = StringUtils.substringAfterLast(((HttpServletRequest) request).getRequestURI(), CONDITION);

		if (!pathFilter.contains(path)) {
			filterChain.doFilter(request, response);
			return;
		}
		HttpServletRequest req = (HttpServletRequest) request;
		User user = (User) req.getSession().getAttribute(ATTRIBUTE_USER);
		if (user != null) {
			String token;
			try {
				token = TokenStorage.getInstance().getToken(user);
				if (token != null) {
					filterChain.doFilter(request, response);
					String action = url + " " + (String) req.getSession().getAttribute(ATTRIBUTE_METHOD);
					Facade.getInstance().saveLog(user, action);
				}
			} catch (Exception e) {
				LOGGER.error(e.getMessage());
			}
		}
	}

	@Override
	public void destroy() {
		this.filterConfig = null;
	}

}
