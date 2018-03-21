package com.senla.bookshop.servlet;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.gson.Gson;
import com.senla.bookshop.entity.Book;
import com.senla.bookshop.facade.Facade;

@WebServlet("/getBooks")
public class GetAllBookServlet extends HttpServlet{

	private static final long serialVersionUID = 8816970062504109878L;
	
	public GetAllBookServlet() {
        super();
    }

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		resp.setContentType("application/json;charset=utf-8");
		List<Book> books;
		try {
			books = Facade.getInstance().getBooks();
			String json = new Gson().toJson(books);
			resp.getWriter().print(json);
		} catch (Exception e) {
			resp.getWriter().print("Errore");
		}
	}
}
