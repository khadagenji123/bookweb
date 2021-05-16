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

import daos.Admin_Category;
import daos.Admin_Contact;
import models.Category;
import models.Contact;

/**
 * Servlet implementation class Admin_CategoryServlet
 */
@WebServlet("/Admin_CategoryServlet")
public class Admin_CategoryServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	private Admin_Category adcategory;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
	public void init(ServletConfig config) throws ServletException {
		String jdbcURL = "jdbc:mysql://localhost/BookStore";
    	String jdbcUsername = "root";
    	String jdbcPassword = "Root1234@";
    	adcategory= new Admin_Category(jdbcURL, jdbcUsername, jdbcPassword);
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
					getCategories(request,response);
					break;
				}
				case "ADD":{
					addCategory(request,response);
					break;
				}
				case "UPDATE":{
					updateCategory(request,response);
					break;
				}
				case "DELETE":{
					deleteCategory(request,response);
					break;
				}
			}
		}
		catch(Exception e) {
			throw new ServletException(e);
		}
	}

	private void deleteCategory(HttpServletRequest request, HttpServletResponse response) throws SQLException, ServletException, IOException {
		int categoryId = Integer.parseInt(request.getParameter("categoryId"));
		adcategory.deleteCategory(categoryId);
		getCategories(request, response);
	}

	private void updateCategory(HttpServletRequest request, HttpServletResponse response) throws SQLException, ServletException, IOException {
		int categoryId = Integer.parseInt(request.getParameter("categoryId")); 
		String categoryName = request.getParameter("categoryName");
		
		Category category = new Category(categoryId, categoryName);
		adcategory.updateCategory(category);
		
		getCategories(request, response);
	}


	private void addCategory(HttpServletRequest request, HttpServletResponse response) throws SQLException, ServletException, IOException {
		String categoryName = request.getParameter("categoryName");
		adcategory.addCategory(categoryName);
		getCategories(request, response);
	}

	private void getCategories(HttpServletRequest request, HttpServletResponse response) throws SQLException, ServletException, IOException {
		List<Category> categories = adcategory.getCategories();
		request.setAttribute("list_category", categories);
		RequestDispatcher dispatcher = request.getRequestDispatcher("/view/admin-category.jsp");
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
