package com.senla.bookshop.servlet;

import java.util.List;

import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.google.gson.Gson;
import com.senla.bookshop.entity.Book;
import com.senla.bookshop.facade.Facade;

@Controller
@RestController
public class BookController {

	@RequestMapping(value = { "/books" }, method = { RequestMethod.GET })
	protected void getBooks(HttpServletResponse response) {
		response.setContentType("application/json;charset=utf-8");
		List<Book> books = null;
		try {
			books = Facade.getInstance().getBooks();
			if (books != null) {
				String json = new Gson().toJson(books);
				response.getWriter().print(json);
			}
		} catch (Exception e) {
			response.setStatus(404);
		}
	}

	@RequestMapping(value = "/newBook", method = RequestMethod.POST)
	protected void addNewBook(@RequestHeader String title, @RequestHeader Double price, @RequestHeader Integer year,
			HttpServletResponse response) {
		Book book = new Book(null, title, price, true, year);
		if (book != null) {
			try {
				Facade.getInstance().addBook(book);
			} catch (Exception e) {
				response.setStatus(404);
			}
		}
	}

	@RequestMapping(value = "/deletBook", method = RequestMethod.DELETE)
	protected void doDelete(@RequestHeader Integer id, HttpServletResponse response) {
		try {
			Facade.getInstance().deleteBook(id);
		} catch (Exception e) {
			response.setStatus(404);
		}
	}

}
