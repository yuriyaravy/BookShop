package com.senla.bookshop.servlet;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.gson.Gson;
import com.senla.bookshop.entity.Request;
import com.senla.bookshop.facade.Facade;

@WebServlet("/request")
public class RequestServler extends HttpServlet {
	
	private static final long serialVersionUID = 1L;
       
    public RequestServler() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String stringId = request.getParameter("id");
		if(stringId != null) {
			try {
				Integer id = Integer.parseInt(stringId);
				Request requEntity = Facade.getInstance().getRequestById(id);
				response.getWriter().print(new Gson().toJson(requEntity));
			} catch (Exception e) {
				response.getWriter().print("Errore");
			}
		}
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		Request req = new Request();
		try {
			Facade.getInstance().addRequest(req);
		} catch (SQLException e) {
			response.getWriter().print("Errore");
		}
	}
	
	protected void doDelete(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String stringId = request.getParameter("id");
		if(stringId != null) {
			try {
				Integer id = Integer.parseInt(stringId);
				Facade.getInstance().deleteRequest(id);
			} catch (Exception e) {
				response.getWriter().print("Errore");
			}
		}
		
	}

}
