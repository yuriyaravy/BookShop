package com.senla.bookshop.servlet;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.senla.bookshop.entity.User;
import com.senla.bookshop.facade.Facade;


@WebServlet("/logout")
public class LogoutServlet extends HttpServlet{

	private static final long serialVersionUID = 1L;
	
	public LogoutServlet(){
	}

	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		try {
			HttpSession session = request.getSession();
			User user = (User) session.getAttribute("User");
			Facade.getInstance().saveLog(user, "logout");
			session.invalidate();
			RequestDispatcher reqDisp = getServletContext().getRequestDispatcher("/login");
			reqDisp.forward(request, response);
		} catch (Exception e) {
			response.getWriter().print("Error");
		}
	}
	
	

}
