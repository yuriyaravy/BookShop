package com.senla.bookshop.servlet;

import java.io.IOException;
import java.util.List;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.Logger;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.google.gson.Gson;
import com.senla.bookshop.entity.Book;
import com.senla.bookshop.facade.Facade;

@Controller
public class BookServlet extends HttpServlet {

	final static Logger LOGGER = Logger.getLogger(BookServlet.class);

	private static final long serialVersionUID = 8816970062504109878L;

	private static final String ERROR = "{error}";

	@RequestMapping(value = "/book", method = RequestMethod.GET)
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) {
		resp.setContentType("application/json;charset=utf-8");
		List<Book> books = null;
		try {
			books = Facade.getInstance().getBooks();
			String json = new Gson().toJson(books);
			resp.getWriter().print(json);
		} catch (Exception e) {
			try {
				resp.getWriter().print(ERROR);
			} catch (IOException e1) {
				LOGGER.error(e1.getMessage());
			}
		}
	}

	@RequestMapping(value = "/book", method = RequestMethod.POST)
	protected void doPost(HttpServletRequest request, HttpServletResponse response) {
		String title = request.getParameter("title");
		Double price = Double.parseDouble(request.getParameter("price"));
		Boolean status = true;
		Integer year = Integer.parseInt(request.getParameter("year"));
		Book book = new Book(null, title, price, status, year);
		if (book != null) {
			try {
				Facade.getInstance().addBook(book);
			} catch (Exception e) {
				try {
					response.getWriter().print(ERROR);
				} catch (IOException e1) {
					LOGGER.error(e1.getMessage());
				}
			}
		}
	}

	@RequestMapping(value = "/book", method = RequestMethod.DELETE)
	protected void doDelete(HttpServletRequest request, HttpServletResponse response) {
		String stringId = request.getParameter("id");
		if (stringId != null) {
			try {
				Integer id = Integer.parseInt(stringId);
				Facade.getInstance().deleteBook(id);
			} catch (Exception e) {
				try {
					response.getWriter().print(ERROR);
				} catch (IOException e1) {
					LOGGER.error(e1.getMessage());
				}
			}
		}
	}

}
