package com.senla.bookshop.servlet;

import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.senla.bookshop.entity.User;
import com.senla.bookshop.facade.Facade;
import com.senla.bookshop.utils.web.TokenHandler;
import com.senla.bookshop.utils.web.TokenStorage;

@Controller
@RestController
public class LoginController {

	private static final String LOGIN = "login";

	@RequestMapping(value = {"/login"}, method = {RequestMethod.POST})
	protected void auth(@RequestHeader String login, @RequestHeader String pass, HttpServletResponse response) {
			try {
				User user = Facade.getInstance().getUserByPasswordAndLogin(login, pass);
				if (user != null) {
					String token = TokenHandler.getInstance().generateToken(user.getName(),
							user.getAuthUser().getPassword());
					TokenStorage.getInstance().setCache(user, token);
					Facade.getInstance().saveLog(user, LOGIN);
				}
			} catch (Exception e) {
				response.setStatus(404);
			}
			
	}

}
