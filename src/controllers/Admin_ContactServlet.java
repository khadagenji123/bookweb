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

import daos.Admin_Contact;
import daos.BookDetailDAO;
import models.Book;
import models.Category;
import models.Contact;

/**
 * Servlet implementation class Admin_ContactServlet
 */
@WebServlet("/Admin_ContactServlet")
public class Admin_ContactServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	private Admin_Contact adcontact;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
	public void init(ServletConfig config) throws ServletException {
		String jdbcURL = "jdbc:mysql://localhost/BookStore";
    	String jdbcUsername = "root";
    	String jdbcPassword = "Root1234@";
    	adcontact= new Admin_Contact(jdbcURL, jdbcUsername, jdbcPassword);
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		try {
			List<Contact> contacts = adcontact.getContacts();
			request.setAttribute("list_contact", contacts);
			RequestDispatcher dispatcher = request.getRequestDispatcher("/view/admin-contact.jsp");
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
