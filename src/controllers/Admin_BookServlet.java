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

import daos.Admin_Book;
import daos.Admin_User;
import models.Book;
import models.Category;
import models.User;

/**
 * Servlet implementation class Admin_BookServlet
 */
@WebServlet("/Admin_BookServlet")
public class Admin_BookServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	private Admin_Book adbook;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
	public void init(ServletConfig config) throws ServletException {
		String jdbcURL = "jdbc:mysql://localhost/BookStore";
    	String jdbcUsername = "root";
    	String jdbcPassword = "Root1234@";
    	adbook = new Admin_Book(jdbcURL, jdbcUsername, jdbcPassword);
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		try {
			String command = request.getParameter("command");
			if(command == null) {
				command = "DISPLAY";
			}
			switch(command) {
				case "DISPLAY":{
					getBooks(request,response);
					break;
				}
				case "ADD":{
					addBook(request,response);
					break;
				}
				case "UPDATE":{
					updateBook(request,response);
					break;
				}
				case "DELETE":{
					deleteBook(request,response);
					break;
				}
			}
		}
		catch(Exception e) {
			throw new ServletException(e);
		}
	}

	private void deleteBook(HttpServletRequest request, HttpServletResponse response) throws SQLException, ServletException, IOException {
		int bookId = Integer.parseInt(request.getParameter("bookId"));
		System.out.println(bookId);
		adbook.deleteBook(bookId);
		getBooks(request, response);
	}

	private void addBook(HttpServletRequest request, HttpServletResponse response) throws SQLException, ServletException, IOException {
		int categoryId = Integer.parseInt(request.getParameter("categoryId")); 
		String bookName = request.getParameter("bookName");
		String publishingCompany = request.getParameter("publishingCompany");
		String author = request.getParameter("author");
		float originalPrice = Float.parseFloat(request.getParameter("originalPrice")); 
		float saleOff = Float.parseFloat(request.getParameter("saleOff"));
		float currentPrice = Float.parseFloat(request.getParameter("currentPrice"));  
		if(saleOff != 0) {
			currentPrice = originalPrice - (originalPrice*saleOff)/100;
		}
		String shortDescription = request.getParameter("shortDescription");
		String detailDescription = request.getParameter("detailDescription");
		int amount =  Integer.parseInt(request.getParameter("amount"));
		String image = request.getParameter("image");
		
		Book book = new Book(categoryId, bookName, publishingCompany, author, originalPrice, saleOff, currentPrice, shortDescription, detailDescription, amount, image);
		adbook.addBook(book);
		getBooks(request, response);
	}

	private void updateBook(HttpServletRequest request, HttpServletResponse response) throws SQLException, ServletException, IOException {
		int bookId = Integer.parseInt(request.getParameter("bookId")); 
		int categoryId = Integer.parseInt(request.getParameter("categoryId")); 
		String bookName = request.getParameter("bookName");
		String publishingCompany = request.getParameter("publishingCompany");
		String author = request.getParameter("author");
		float originalPrice = Float.parseFloat(request.getParameter("originalPrice")); 
		float saleOff = Float.parseFloat(request.getParameter("saleOff"));
		float currentPrice = Float.parseFloat(request.getParameter("currentPrice"));  
		if(saleOff != 0) {
			currentPrice = originalPrice - (originalPrice*saleOff)/100;
		}
		String shortDescription = request.getParameter("shortDescription");
		String detailDescription = request.getParameter("detailDescription");
		int amount =  Integer.parseInt(request.getParameter("amount"));
		String image = request.getParameter("image");
		
		Book book = new Book(bookId, categoryId, bookName, publishingCompany, author, originalPrice, saleOff, currentPrice, shortDescription, detailDescription, amount, image);
		adbook.updateBook(book);
		
		getBooks(request, response);
	}

	private void getBooks(HttpServletRequest request, HttpServletResponse response) throws SQLException, ServletException, IOException {
		List<Book> books = adbook.getBooks();
		request.setAttribute("list_book", books);
		RequestDispatcher dispatcher = request.getRequestDispatcher("/view/admin-book.jsp");
										dispatcher.forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
