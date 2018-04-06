package com.senla.bookshop.facade;

import java.sql.SQLException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.List;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;

import com.senla.bookshop.api.facade.IFacade;
import com.senla.bookshop.api.service.IBookManager;
import com.senla.bookshop.api.service.ILoggerManager;
import com.senla.bookshop.api.service.IOrderManager;
import com.senla.bookshop.api.service.IRequestManager;
import com.senla.bookshop.api.service.IUserManager;
import com.senla.bookshop.entity.AuthUser;
import com.senla.bookshop.entity.Book;
import com.senla.bookshop.entity.Log;
import com.senla.bookshop.entity.Order;
import com.senla.bookshop.entity.Request;
import com.senla.bookshop.entity.User;

public class Facade implements IFacade {

	final static Logger LOGGER = Logger.getLogger(Facade.class);

	@Autowired
	private IRequestManager requestManager;

	@Autowired
	private IBookManager bookManager;

	@Autowired
	private IOrderManager orderManager;

	@Autowired
	private IUserManager userManager;

	@Autowired
	private ILoggerManager logUsers;

	private static Facade facade;

	public static Facade getInstance() {
		if (facade == null) {
			facade = new Facade();
		}
		return facade;
	}

	@Override
	public void addRequest(Request request) throws SQLException {
		try {
			requestManager.addRequest(request);
		} catch (Exception e) {
			LOGGER.error(e);
		}
	}

	@Override
	public Request getAllRequest() throws Exception {
		try {
			return (Request) requestManager.getAllBookRequestByName();
		} catch (Exception e) {
			LOGGER.error(e);
		}
		return null;
	}

	@Override
	public Book getBookById(int id) throws Exception {
		Book book = null;
		try {
			book = bookManager.getBookById(id);
		} catch (Exception e) {
			LOGGER.error(e);
		}
		return book;
	}

	@Override
	public double getProfitForAllOrders() throws Exception {
		double profit = 0;
		try {
			profit = orderManager.getProfitForAllOrders();
		} catch (Exception e) {
			LOGGER.error(e);
		}
		return profit;
	}

	@Override
	public void orderCompleate(int id) {
		try {
			orderManager.orderCompleate(id);
		} catch (Exception e) {
			LOGGER.error(e);
		}
	}

	@Override
	public void allOrderCompleate() {
		try {
			orderManager.allOrderCompleate();
		} catch (Exception e) {
			LOGGER.error(e);
		}

	}

	@Override
	public void getProfitByPeriodOfTime(int day) throws Exception {
		try {
			orderManager.getProfitByPeriodOfTime(day);
		} catch (Exception e) {
			LOGGER.error(e);
		}

	}

	@Override
	public Order getOrderById(int id) throws Exception {
		Order order = null;
		try {
			order = orderManager.getOrderById(id);
		} catch (Exception e) {
			LOGGER.error(e);
		}
		return order;
	}

	@Override
	public boolean addBookToOrder(List<Book> book) {
		try {
			orderManager.addBookToOrder((Book) book);
			return true;
		} catch (Exception e) {
			LOGGER.error(e);
			return false;
		}
	}

	@Override
	public boolean deleteBookToOrder(Order order) {
		try {
			orderManager.deleteOrder(order);
			return true;
		} catch (Exception e) {
			LOGGER.error(e);
			return false;
		}

	}

	@Override
	public boolean cancelOrder(int id) {
		try {
			orderManager.cancelOrder(id);
			return true;
		} catch (Exception e) {
			LOGGER.error(e);
			return false;
		}

	}

	@Override
	public int getCountOfOrder() throws Exception {
		int orders = 0;
		try {
			orders = orderManager.getCountOfOrder();
		} catch (Exception e) {
			LOGGER.error(e);
		}
		return orders;
	}

	@Override
	public List<Object[]> sortRequestByName() throws Exception {
		try {
			return requestManager.getAllBookRequestByName();
		} catch (Exception e) {
			LOGGER.error(e);
			return null;
		}
	}

	@Override
	public Double sortRequestAmounte() throws Exception {
		try {
			return requestManager.getAllBookRequestByAmount();
		} catch (Exception e) {
			LOGGER.error(e);
			return null;
		}
	}

	@Override
	public List<Order> sortOrderByDateOfDeliver() throws Exception {
		try {
			return orderManager.getOrderByDateOfDelivered();
		} catch (Exception e) {
			LOGGER.error(e);
			return null;
		}
	}

	@Override
	public Double sortOrderByPrice() throws Exception {
		try {
			return orderManager.getOrderByPrice();
		} catch (Exception e) {
			LOGGER.error(e);
			return null;
		}
	}

	@Override
	public List<Order> sortOrderByStatus() throws Exception {
		try {
			return orderManager.getOrderByStatus();
		} catch (Exception e) {
			LOGGER.error(e);
			return null;
		}
	}

	@Override
	public List<Book> sortBookByDate() throws Exception {
		try {
			return bookManager.getBookByDate();
		} catch (Exception e) {
			LOGGER.error(e);
			return null;
		}
	}

	@Override
	public List<Book> sortBookByName() throws Exception {
		try {
			return bookManager.getBookByName();
		} catch (Exception e) {
			LOGGER.error(e);
			e.printStackTrace();
		}
		return null;
	}

	@Override
	public List<Book> sortBookByPrice() throws Exception {
		try {
			return bookManager.getBookByPrice();
		} catch (Exception e) {
			LOGGER.error(e);
			return null;
		}
	}

	@Override
	public List<Book> sortBookByStatus() throws Exception {
		try {
			return bookManager.getBookByStatus();
		} catch (Exception e) {
			LOGGER.error(e);
			return null;
		}
	}

	@Override
	public List<Book> sortBookByYearOfPublic() throws Exception {
		try {
			return bookManager.getBookByYearOfPublic();
		} catch (Exception e) {
			LOGGER.error(e);
			return null;
		}
	}

	@Override
	public List<Book> sortOldBook() throws Exception {
		try {
			return bookManager.sortOldBooks();
		} catch (Exception e) {
			LOGGER.error(e);
			return null;
		}
	}

	@Override
	public List<Book> getBooks() throws Exception {
		try {
			return bookManager.getBookByName();
		} catch (Exception e) {
			LOGGER.error(e);
			return null;
		}
	}

	@Override
	public List<Order> getOrders() throws Exception {
		try {
			return orderManager.getOrders();
		} catch (Exception e) {
			LOGGER.error(e);
			return null;
		}
	}

	@Override
	public List<Request> getRequests() throws Exception {
		try {
			return requestManager.getRequest();
		} catch (Exception e) {
			LOGGER.error(e);
			return null;
		}
	}

	@Override
	public List<Request> readObjectFromCSV() throws Exception {
		try {
			return requestManager.getRequest();
		} catch (Exception e) {
			LOGGER.error(e);
			return null;
		}
	}

	@Override
	public boolean booksAnnotationFromCSV() throws Exception {
		try {
			bookManager.getAnnotationBook();
			return true;
		} catch (Exception e) {
			LOGGER.error(e);
			return false;
		}
	}

	@Override
	public boolean orderAnnotationFromCSV() throws Exception {
		try {
			orderManager.getAnnotationOrder();
			return true;
		} catch (Exception e) {
			LOGGER.error(e);
			return false;
		}
	}

	@Override
	public boolean orderAnnotationToCSV() throws Exception {
		try {
			orderManager.saveAnnotationOrder();
			return true;
		} catch (Exception e) {
			LOGGER.error(e);
			return false;
		}
	}

	@Override
	public boolean requestAnnotationFromCSV() throws Exception {
		try {
			requestManager.getAnnotationRequest();
			return true;
		} catch (Exception e) {
			LOGGER.error(e);
			return false;
		}
	}

	@Override
	public void requestAnnotationToCSV() throws Exception {
		try {
			requestManager.saveAnnotationRequest();
		} catch (Exception e) {
			LOGGER.error(e);
		}
	}

	@Override
	public boolean addBook(Book book) throws Exception {
		try {
			bookManager.addBook(book);
			return true;
		} catch (Exception e) {
			LOGGER.error(e);
			return false;
		}
	}

	@Override
	public void cloneOrder(int id) throws Exception {
		try {
			orderManager.cloneOrder(id);
		} catch (Exception e) {
			LOGGER.error(e);
		}
	}

	@Override
	public void deleteBook(int id) throws Exception {
		try {
			bookManager.deleteBook(id);
		} catch (Exception e) {
			LOGGER.error(e);
		}
	}

	@Override
	public void deleteRequest(int id) throws Exception {
		try {
			requestManager.deleteRequest(id);
		} catch (Exception e) {
			LOGGER.error(e);
		}
	}

	@Override
	public Request getRequestById(int id) throws Exception {
		Request request = null;
		try {
			request = requestManager.getRequestById(id);
			return request;
		} catch (Exception e) {
			LOGGER.error(e);
			return null;
		}
	}

	@Override
	public void registration(String name, String surname, String password) throws Exception {
		try {
			userManager.registraton(name, surname, password);
		} catch (Exception e) {
			LOGGER.error(e);
		}
	}

	@Override
	public void saveLog(User user, String action) throws Exception {
		try {
			String date = LocalDateTime.now().format(DateTimeFormatter.ofPattern("dd-MM-yyyy HH:mm"));
			String userName = user.getName();
			logUsers.addLog(new Log(date, userName, action));
		} catch (Exception e) {
			LOGGER.error(e);
		}
	}

	@Override
	public User getUserByPasswordAndLogin(String login, String password) throws Exception {
		try {
			User user = userManager.getAuthUser(new AuthUser(null, login, password));
			return user;
		} catch (Exception e) {
			LOGGER.error(e);
			return null;
		}
	}
}
