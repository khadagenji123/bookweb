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

import daos.BookListHomePageDAO;
import daos.ContactDAO;
import daos.SearchingBook;
import models.Book;
import models.Contact;

/**
 * Servlet implementation class ContactServlet
 */
@WebServlet("/ContactServlet")
public class ContactServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	private ContactDAO contactDAO;
	private BookListHomePageDAO bookList;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
	public void init(ServletConfig config) throws ServletException {
		String jdbcURL = "jdbc:mysql://localhost/BookStore";
    	String jdbcUsername = "root";
    	String jdbcPassword = "Root1234@";
    	contactDAO= new ContactDAO(jdbcURL, jdbcUsername, jdbcPassword);
    	bookList= new BookListHomePageDAO(jdbcURL, jdbcUsername, jdbcPassword);
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		try {
			String command = request.getParameter("command");
			if(command==null) {
				command="HOME";
			}
			switch(command) {
				case "CONTACT":{
					contactCompany(request,response);
					break;
				}
				case "HOME":{
					getBookList(request,response);
					break;
				}
			}
		}
		catch(Exception e) {
			throw new ServletException(e);
		}
	}

	private void getBookList(HttpServletRequest request, HttpServletResponse response) throws SQLException, ServletException, IOException {
		List<Book> books = bookList.getBookList();
		request.setAttribute("list_book", books);
		RequestDispatcher dispatcher = request.getRequestDispatcher("/trangchu.jsp");
										dispatcher.forward(request, response);
	}

	private void contactCompany(HttpServletRequest request, HttpServletResponse response) throws SQLException {
		String name = request.getParameter("name"); 
		String email = request.getParameter("email");
		String subject = request.getParameter("subject");
		String message = request.getParameter("message");
		
		
		Contact contact = new Contact(name,email,subject,message);
		contactDAO.contactCompany(contact);
	}

}
