package com.senla.bookshop.servlet;

import java.io.IOException;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.Logger;

import com.senla.bookshop.facade.Facade;

@WebServlet("/registration")
public class RegistrationServler extends HttpServlet {

	final static Logger LOGGER = Logger.getLogger(BookServlet.class);

	private static final long serialVersionUID = 1L;

	private static final String ERROR = "{error}";
	private static final String MESSAGE = "successful registration";
	private static final String NEXT_PAGE = "/login";
	private static final String NAME = "name";
	private static final String SURNAME = "surname";
	private static final String PASSWORD = "password";

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) {
		try {
			resp.setContentType("application/json;charset=utf-8");
			Facade.getInstance().registration(req.getParameter(NAME), req.getParameter(SURNAME),
					req.getParameter(PASSWORD));
			resp.getWriter().print(MESSAGE);
			resp.sendRedirect(NEXT_PAGE);
		} catch (Exception e) {
			try {
				resp.getWriter().print(ERROR);
			} catch (IOException e1) {
				LOGGER.error(e1.getMessage());
			}
		}
	}

}
