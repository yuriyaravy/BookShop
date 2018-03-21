package com.senla.bookshop.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.senla.bookshop.entity.User;
import com.senla.bookshop.facade.Facade;
import com.senla.bookshop.utils.web.TokenHandler;

@WebServlet("/login")
public class LoginServler extends HttpServlet{

	private static final long serialVersionUID = 1L;
	
	public LoginServler() {
	}
	
	

	@Override
	protected void doPut(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String login =   request.getParameter("login");
		String surname = request.getParameter("surname");
		String password = request.getParameter("password");
		if(login!= null && password != null && surname != null) {
			try {
				Facade.getInstance().registration(login, surname, password);
			} catch (Exception e) {
				response.getWriter().print("Errore");
			}
			
		}
	}



	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String login =request.getParameter("login");
		String password = request.getParameter("password");
		if(login != null && password != null) {
			try {
				User user = Facade.getInstance().getAuthUser(login, password);
				if(user != null) {
					String token = TokenHandler.getInstance().generateToken(user.getId());
					response.addHeader("User", token);
					request.getSession().setAttribute("User", user);
					Facade.getInstance().saveLog(user, "login");
					response.getWriter().println("login");
				}else {
					response.setStatus(404);
				}
			} catch (Exception e) {
				response.getWriter().print("Errore");
			}
		}
	}
	
	

}
