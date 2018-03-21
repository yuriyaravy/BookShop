package com.senla.bookshop.servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.senla.bookshop.entity.Book;
import com.senla.bookshop.facade.Facade;

@WebServlet("/putBookTo")
public class PutBookServler extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public PutBookServler() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	}
	
	@SuppressWarnings("unused")
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String title = request.getParameter("title");
		Double price = Double.parseDouble(request.getParameter("price"));
		Boolean status = true;
		Integer year = Integer.parseInt(request.getParameter("year"));
		Book book = new Book(null, title, price, status, year);
		Integer id = Integer.parseInt(request.getParameter("id"));
		if(id == null && book != null) {
			try {
				Facade.getInstance().addBook(book);
			} catch (Exception e) {
				response.getWriter().print("Errore");
			}
		}else {
			
		}
	}

}
