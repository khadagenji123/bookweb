package controllers;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import daos.Admin_Cart;
import daos.Admin_Contact;
import models.Cart;
import models.Contact;

/**
 * Servlet implementation class Admin_CartServlet
 */
@WebServlet("/Admin_CartServlet")
public class Admin_CartServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	private Admin_Cart adcart;
    /**
     * @see HttpServlet#HttpServlet()
     */
	public void init(ServletConfig config) throws ServletException {
		String jdbcURL = "jdbc:mysql://localhost/BookStore";
    	String jdbcUsername = "root";
    	String jdbcPassword = "Root1234@";
    	adcart= new Admin_Cart(jdbcURL, jdbcUsername, jdbcPassword);
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		try {
			System.out.println("cart");
			List<Cart> carts = adcart.getCarts();
			request.setAttribute("list_cart", carts);
			RequestDispatcher dispatcher = request.getRequestDispatcher("/view/admin-cart.jsp");
											dispatcher.forward(request, response);
		}
		catch(Exception e) {
			throw new ServletException(e);
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
