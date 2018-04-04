package com.senla.bookshop.servlet;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.senla.bookshop.entity.User;
import com.senla.bookshop.facade.Facade;
import com.senla.bookshop.utils.web.TokenStorage;

@Controller
@RestController
public class LogoutController {

	private static final String ATTRIBUT = "User";
	private static final String LOGOUT = "logout";
	private static final String NEXT_PAGE = "/login";

	@RequestMapping(value = { "/logout" }, method = { RequestMethod.GET })
	protected void logout(HttpServletRequest request, HttpServletResponse response) {
		try {
			HttpSession session = request.getSession();
			User user = (User) session.getAttribute(ATTRIBUT);
			Facade.getInstance().saveLog(user, LOGOUT);
			TokenStorage.getInstance().getToken(user);
			session.invalidate();
			response.sendRedirect(NEXT_PAGE);
		} catch (Exception e) {
			response.setStatus(404);
		}
	}

}
