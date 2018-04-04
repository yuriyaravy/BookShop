package com.senla.bookshop.servlet;

import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.senla.bookshop.facade.Facade;

@Controller
@RestController
public class RegistrationController {

	private static final String MESSAGE = "successful registration";
	private static final String NEXT_PAGE = "/login";

	@RequestMapping(value = "/newBook", method = RequestMethod.POST)
	protected void registration(@RequestHeader String name, @RequestHeader String surname,
			@RequestHeader String password, HttpServletResponse response) {
		try {
			response.setContentType("application/json;charset=utf-8");
			Facade.getInstance().registration(name, surname, password);
			response.getWriter().print(MESSAGE);
			response.sendRedirect(NEXT_PAGE);
		} catch (Exception e) {
			response.setStatus(404);
		}
	}

}
