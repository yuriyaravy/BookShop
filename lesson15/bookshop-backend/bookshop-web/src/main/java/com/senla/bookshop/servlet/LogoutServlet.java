package com.senla.bookshop.servlet;

import java.io.IOException;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.log4j.Logger;

import com.senla.bookshop.entity.User;
import com.senla.bookshop.facade.Facade;
import com.senla.bookshop.utils.web.TokenStorage;

@WebServlet("/logout")
public class LogoutServlet extends HttpServlet {

	final static Logger LOGGER = Logger.getLogger(LogoutServlet.class);

	private static final long serialVersionUID = 1L;

	private static final String ERROR = "{error}";
	private static final String ATTRIBUT = "User";
	private static final String LOGOUT = "logout";
	private static final String NEXT_PAGE = "/login";

	public LogoutServlet() {
	}

	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) {
		try {
			HttpSession session = request.getSession();
			User user = (User) session.getAttribute(ATTRIBUT);
			Facade.getInstance().saveLog(user, LOGOUT);
			TokenStorage.getInstance().getToken(user);
			session.invalidate();
			response.sendRedirect(NEXT_PAGE);
		} catch (Exception e) {
			try {
				response.getWriter().print(ERROR);
			} catch (IOException e1) {
				LOGGER.error(e.getMessage());
			}
		}
	}

}
