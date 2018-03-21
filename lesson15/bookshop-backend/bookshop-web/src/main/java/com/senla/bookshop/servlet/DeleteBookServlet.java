package com.senla.bookshop.servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.gson.Gson;
import com.senla.bookshop.entity.Book;
import com.senla.bookshop.facade.Facade;

@WebServlet("/deleteBook")
public class DeleteBookServlet extends HttpServlet {
	
	private static final long serialVersionUID = 1L;
	private static final String NULL = "{null}";
       
    public DeleteBookServlet() {
        super();
    }
    
    @Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String stringId = request.getParameter("id");
		System.out.println(stringId);
		Book book;
		if(stringId != null) {
			try {
				Integer id = Integer.parseInt(stringId);
				book = Facade.getInstance().getBookById(id);
				response.getWriter().print(new Gson().toJson(book));
			} catch (Exception e) {
				response.getWriter().print(NULL);
			}
		}
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
	}
	
	@Override
	protected void doDelete(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println(request.getParameter("id"));
		String stringId = request.getParameter("id");
		if(stringId != null) {
			try {
				Integer id = Integer.parseInt(stringId);
				Facade.getInstance().deleteBook(id);;
			} catch (Exception e) {
				response.getWriter().print("Errore");
			}
			}
	}

}
