package controllers;

import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.json.JSONObject;

import daos.CartDAO;
import daos.SignInDAO;
import daos.SignUpDAO;
import models.Book;
import models.Cart;

/**
 * Servlet implementation class BuyBook
 */
@WebServlet("/BuyBook")
public class BuyBook extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	private CartDAO cartDao;
       
	public void init(ServletConfig config) throws ServletException {
		String jdbcURL = "jdbc:mysql://localhost/BookStore";
    	String jdbcUsername = "root";
    	String jdbcPassword = "Root1234@";
    	cartDao = new CartDAO(jdbcURL, jdbcUsername, jdbcPassword);
	}
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		try {
			String command = request.getParameter("command");
			switch(command) {
				case "BUY":{
					getCart(request,response);
					break;
				}
				case "DELETE":{
					deleteCart(request,response);
					break;
				}
			}
		}
		catch(Exception e) {
			throw new ServletException(e);
		}
	}


	private void deleteCart(HttpServletRequest request, HttpServletResponse response) throws SQLException, ServletException, IOException {
		int bookId = Integer.parseInt(request.getParameter("bookId"));
		HttpSession session = request.getSession();
		String userName = (String) session.getAttribute("userName");
		cartDao.deleteCart(bookId, userName);
		getCart(request, response);
	}

	private void getCart(HttpServletRequest request, HttpServletResponse response) throws SQLException, ServletException, IOException {
		HttpSession session = request.getSession();
		String userName = (String) session.getAttribute("userName");
		List<Book> books = cartDao.getCart(userName);
		if(books.isEmpty()) {
			String url = "http://localhost:8080/bookweb/view/empty-cart.jsp";
			response.sendRedirect(url);
		}
		else {
			int amount = 0;
			float total = 0;
			int fee = 0;
			for(int i=0;i < books.size();i++) {
				amount += books.get(i).getAmount();
				total += books.get(i).getTotal();
			}
			if(total < 1000000) {
				fee = 25000;
				total += fee;
			}
			request.setAttribute("fee", fee);
			request.setAttribute("list_book", books);
			request.setAttribute("amount", amount);
			request.setAttribute("total", total);
			RequestDispatcher dispatcher = request.getRequestDispatcher("/view/cart.jsp");
											dispatcher.forward(request, response);
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		try {
			String command = request.getParameter("command");
			switch(command) {
				case "PAY":{
					payBill(request,response);
					break;
				}
			}
		}
		catch(Exception e) {
			throw new ServletException(e);
		}
	}

	private void payBill(HttpServletRequest request, HttpServletResponse response) throws IOException, SQLException {
		String name = request.getParameter("name");
		String address = request.getParameter("address");
		String phone = request.getParameter("phone");
		HttpSession session = request.getSession();
		String userName = (String) session.getAttribute("userName");
		int userId = cartDao.getUserId(userName);
		
		
		
		String message = "valid";
		if(name.equals("") || address.equals("") || phone.equals("")) {
			message = "null";
		}
		else {
			Cart cart = new Cart(userId,userName, name, address, phone);
			cartDao.payBill(cart);
		}
		response.setContentType("application/json");
		JSONObject obj = new JSONObject();
		obj.put("message", message);
		response.getWriter().write(obj.toString());
	}

}
