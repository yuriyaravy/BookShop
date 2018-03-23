package com.senla.bookshop.servlet;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.Logger;

import com.google.gson.Gson;
import com.senla.bookshop.entity.Request;
import com.senla.bookshop.facade.Facade;

@WebServlet("/request")
public class RequestServler extends HttpServlet {

	final static Logger LOGGER = Logger.getLogger(RequestServler.class);

	private static final long serialVersionUID = 1L;

	private static final String ERROR = "{error}";
	private static final String ID = "id";

	protected void doGet(HttpServletRequest request, HttpServletResponse response) {
		String stringId = request.getParameter(ID);
		if (stringId != null) {
			try {
				Integer id = Integer.parseInt(stringId);
				Request requEntity = Facade.getInstance().getRequestById(id);
				response.getWriter().print(new Gson().toJson(requEntity));
			} catch (Exception e) {
				try {
					response.getWriter().print(ERROR);
				} catch (IOException e1) {
					LOGGER.error(e1.getMessage());
				}
			}
		}
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) {
		Request req = new Request();
		try {
			Facade.getInstance().addRequest(req);
		} catch (SQLException e) {
			try {
				response.getWriter().print(ERROR);
			} catch (IOException e1) {
				LOGGER.error(e1.getMessage());
			}
		}
	}

	protected void doDelete(HttpServletRequest request, HttpServletResponse response) {
		String stringId = request.getParameter(ID);
		if (stringId != null) {
			try {
				Integer id = Integer.parseInt(stringId);
				Facade.getInstance().deleteRequest(id);
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
