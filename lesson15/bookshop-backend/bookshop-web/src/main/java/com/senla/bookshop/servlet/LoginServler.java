package com.senla.bookshop.servlet;

import java.io.IOException;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.Logger;

import com.senla.bookshop.entity.User;
import com.senla.bookshop.facade.Facade;
import com.senla.bookshop.utils.web.TokenHandler;
import com.senla.bookshop.utils.web.TokenStorage;

@WebServlet("/login")
public class LoginServler extends HttpServlet {

	final static Logger LOGGER = Logger.getLogger(LoginServler.class);

	private static final long serialVersionUID = 1L;

	private static final String ERROR = "{error}";
	private static final String LOGIN = "login";
	private static final String PASSWORD = "password";
	private static final String ATTRIBUT = "User";

	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) {
		String login = request.getParameter(LOGIN);
		String password = request.getParameter(PASSWORD);
		if (login != null && password != null) {
			try {
				User user = Facade.getInstance().getUserByPasswordAndLogin(login, password);
				if (user != null) {
					String token = TokenHandler.getInstance().generateToken(user.getName(),
							user.getAuthUser().getPassword());
					TokenStorage.getInstance().setCache(user, token);
					request.getSession().setAttribute(ATTRIBUT, user);
					Facade.getInstance().saveLog(user, LOGIN);
				} else {
					response.setStatus(404);
				}
			} catch (Exception e) {
				try {
					response.getWriter().print(ERROR);
				} catch (IOException e1) {
					LOGGER.error(e1.getMessage());
				}
			}
		}
	}

}
