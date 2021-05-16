package controllers;

import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import daos.BookListHomePageDAO;
import daos.CategoryDAO;
import daos.SearchingBook;
import daos.SignInDAO;
import daos.SignUpDAO;
import models.Book;
import models.Category;

/**
 * Servlet implementation class HomePage
 */
@WebServlet("/HomePage")
public class HomePage extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	private BookListHomePageDAO bookList;
	private SearchingBook searchingBook;
	private CategoryDAO category;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
	public void init(ServletConfig config) throws ServletException {
		String jdbcURL = "jdbc:mysql://localhost/BookStore";
    	String jdbcUsername = "root";
    	String jdbcPassword = "Root1234@";
    	bookList= new BookListHomePageDAO(jdbcURL, jdbcUsername, jdbcPassword);
    	searchingBook = new SearchingBook(jdbcURL, jdbcUsername, jdbcPassword);
    	category = new CategoryDAO(jdbcURL, jdbcUsername, jdbcPassword);
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		try {
			String command = request.getParameter("command");
			if(command==null) {
				command="HOME";
			}
			switch(command) {
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
		List<Book> thebooks = bookList.getTheBookList();
		List<Category> categories = category.getCategories();
		request.setAttribute("categories", categories);
		request.setAttribute("list_book", books);
		request.setAttribute("list_thebook", thebooks);
		RequestDispatcher dispatcher = request.getRequestDispatcher("/trangchu.jsp");
										dispatcher.forward(request, response);
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
				case "HOME":{
					getBookList(request,response);
					break;
				}
				case "SEARCH":{
					searchBooks(request,response);
					break;
				}
			}
		}
		catch(Exception e) {
			throw new ServletException(e);
		}
	}

	private void searchBooks(HttpServletRequest request, HttpServletResponse response) throws SQLException, ServletException, IOException {
		String title = request.getParameter("title");
		Book theBook = new Book(title);
		List<Book> bookList = new ArrayList<Book>();
		bookList = searchingBook.getSearchBook(theBook);
		if(bookList.isEmpty()) {
			request.setAttribute("title", title);
			RequestDispatcher dispatcher = request.getRequestDispatcher("view/not-found.jsp");
											dispatcher.forward(request, response);
		}
		else {
			request.setAttribute("list_book", bookList);
			RequestDispatcher dispatcher = request.getRequestDispatcher("view/findingbook.jsp");
											dispatcher.forward(request, response);
		}
	}

}
