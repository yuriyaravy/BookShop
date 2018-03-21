package com.senla.bookshop.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.senla.bookshop.facade.Facade;

public class RegistrationServler extends HttpServlet{

	private static final long serialVersionUID = 1L;
	
	public RegistrationServler() {
		
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		try {
			Facade.getInstance().registration(req.getParameter("name"), req.getParameter("surname"), req.getParameter("password"));
		} catch (Exception e) {
			resp.getWriter().print("Errore");
		}
	}
	
	

}
