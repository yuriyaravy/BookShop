package com.senla.bookshop.servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.senla.bookshop.facade.Facade;

@WebServlet("/putOrder")
public class PutOrderServler extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public PutOrderServler() {
        super();
    }

	@Override
	protected void doPut(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		resp.setContentType("application/json;charset=utf-8");
		String stringId = req.getParameter("id");
		if(stringId != null) {
			try {
				Integer id = Integer.parseInt(stringId);
				Facade.getInstance().cloneOrder(id);
			} catch (Exception e) {
				resp.getWriter().print("Errore");
			}
		}
	}

	

}
