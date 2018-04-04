package com.senla.bookshop.servlet;

import java.util.List;

import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.Logger;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.google.gson.Gson;
import com.senla.bookshop.entity.Order;
import com.senla.bookshop.facade.Facade;

@Controller
@RestController
public class OrderController {

	final static Logger LOGGER = Logger.getLogger(OrderController.class);

	@RequestMapping(value = { "/order" }, method = { RequestMethod.GET })
	protected void getOrder(HttpServletResponse response) {
		response.setContentType("application/json;charset=utf-8");
		List<Order> orders = null;
		try {
			orders = Facade.getInstance().getOrders();
			String json = new Gson().toJson(orders);
			response.getWriter().print(json);
		} catch (Exception e) {
			response.setStatus(404);
		}
	}

	@RequestMapping(value = "/cloneOrder", method = RequestMethod.POST)
	protected void doPut(@RequestHeader Integer cloneId, HttpServletResponse response) {
		response.setContentType("application/json;charset=utf-8");
		if (cloneId != null) {
			try {
				Facade.getInstance().cloneOrder(cloneId);
			} catch (Exception e) {
				response.setStatus(404);
			}
		}
	}
}
