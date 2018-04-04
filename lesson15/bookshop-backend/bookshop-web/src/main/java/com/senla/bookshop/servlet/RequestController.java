package com.senla.bookshop.servlet;

import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.google.gson.Gson;
import com.senla.bookshop.entity.Book;
import com.senla.bookshop.entity.Request;
import com.senla.bookshop.facade.Facade;

@Controller
@RestController
public class RequestController {

	@RequestMapping(value = { "/request" }, method = { RequestMethod.GET })
	protected void getRequest(@RequestHeader Integer requestId, HttpServletResponse response) {
		if (requestId != null) {
			try {
				Request requEntity = Facade.getInstance().getRequestById(requestId);
				response.getWriter().print(new Gson().toJson(requEntity));
			} catch (Exception e) {
				response.setStatus(404);
			}
		}
	}

	@RequestMapping(value = { "/newRequest" }, method = { RequestMethod.POST })
	protected void doPost(@RequestHeader Integer bookId, HttpServletResponse response) {
		try {
			Book bookForRequest = Facade.getInstance().getBookById(bookId);
			Facade.getInstance().addRequest(new Request(bookForRequest));
		} catch (Exception e) {
			response.setStatus(404);
		}
	}

	@RequestMapping(value = { "/deleteRequest" }, method = { RequestMethod.DELETE })
	protected void doDelete(@RequestHeader Integer requestId, HttpServletResponse response) {
		if (requestId != null) {
			try {
				Facade.getInstance().deleteRequest(requestId);
			} catch (Exception e) {
				response.setStatus(404);
			}
		}

	}

}
