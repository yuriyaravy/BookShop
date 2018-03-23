package com.senla.bookshop.servlet;

import java.io.IOException;
import java.util.List;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.Logger;

import com.google.gson.Gson;
import com.senla.bookshop.entity.Order;
import com.senla.bookshop.facade.Facade;

@WebServlet("/order")
public class OrderServlet extends HttpServlet {

	final static Logger LOGGER = Logger.getLogger(OrderServlet.class);

	private static final long serialVersionUID = 1L;

	private static final String ERROR = "{error}";

	protected void doGet(HttpServletRequest request, HttpServletResponse response) {
		response.setContentType("application/json;charset=utf-8");
		List<Order> orders;
		try {
			orders = Facade.getInstance().getOrders();
			String json = new Gson().toJson(orders);
			response.getWriter().print(json);
		} catch (Exception e) {
			try {
				response.getWriter().print(ERROR);
			} catch (IOException e1) {
				LOGGER.error(e1.getMessage());
			}
		}
	}

	@Override
	protected void doPut(HttpServletRequest req, HttpServletResponse resp) {
		resp.setContentType("application/json;charset=utf-8");
		String stringId = req.getParameter("id");
		if (stringId != null) {
			try {
				Integer id = Integer.parseInt(stringId);
				Facade.getInstance().cloneOrder(id);
			} catch (Exception e) {
				try {
					resp.getWriter().print(ERROR);
				} catch (IOException e1) {
					LOGGER.error(e1.getMessage());
				}
			}
		}
	}
}
