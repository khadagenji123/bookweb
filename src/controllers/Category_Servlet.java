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

import daos.BookListHomePageDAO;
import daos.CategoryDAO;
import daos.SearchingBook;
import models.Book;
import models.Category;

/**
 * Servlet implementation class Category_Servlet
 */
@WebServlet("/Category_Servlet")
public class Category_Servlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	private CategoryDAO category;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
	public void init(ServletConfig config) throws ServletException {
		String jdbcURL = "jdbc:mysql://localhost/BookStore";
    	String jdbcUsername = "root";
    	String jdbcPassword = "Root1234@";
    	category = new CategoryDAO(jdbcURL, jdbcUsername, jdbcPassword);
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		try {
			int theCategory = Integer.parseInt(request.getParameter("category"));
			List<Book> books = category.getBooks(theCategory);
			List<Category> categories = category.getCategories();
			request.setAttribute("categories", categories);
			request.setAttribute("list_book", books);
			RequestDispatcher dispatcher = request.getRequestDispatcher("view/findingbook.jsp");
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
