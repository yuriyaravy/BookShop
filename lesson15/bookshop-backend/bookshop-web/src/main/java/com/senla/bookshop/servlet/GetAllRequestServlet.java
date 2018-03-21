package com.senla.bookshop.servlet;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.gson.Gson;
import com.senla.bookshop.entity.Request;
import com.senla.bookshop.facade.Facade;

@WebServlet("/getRequests")
public class GetAllRequestServlet extends HttpServlet {
	
	private static final long serialVersionUID = 1L;
       
    public GetAllRequestServlet() {
        super();
    }
    
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("application/json;charset=utf-8");
		List<Request> requests;
		try {
			requests = Facade.getInstance().getRequests();
			String json = new Gson().toJson(requests);
			response.getWriter().print(json);
		} catch (Exception e) {
			response.getWriter().print("Errore");
		}
	}

}
