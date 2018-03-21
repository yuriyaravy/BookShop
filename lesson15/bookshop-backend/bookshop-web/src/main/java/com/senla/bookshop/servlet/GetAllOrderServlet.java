package com.senla.bookshop.servlet;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.gson.Gson;
import com.senla.bookshop.entity.Order;
import com.senla.bookshop.facade.Facade;

@WebServlet("/getOrders")
public class GetAllOrderServlet extends HttpServlet {
	
	private static final long serialVersionUID = 1L;
       
    public GetAllOrderServlet() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("application/json;charset=utf-8");
		List<Order> orders;
		try {
			orders = Facade.getInstance().getOrders();
			String json = new Gson().toJson(orders);
			response.getWriter().print(json);
		} catch (Exception e) {
			response.getWriter().print("Errore");
		}
	}
}
