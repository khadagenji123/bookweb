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

import daos.Admin_Contact;
import daos.Admin_User;
import models.Contact;
import models.User;

/**
 * Servlet implementation class Admin_UserServlet
 */
@WebServlet("/Admin_UserServlet")
public class Admin_UserServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	private Admin_User aduser;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
	public void init(ServletConfig config) throws ServletException {
		String jdbcURL = "jdbc:mysql://localhost/BookStore";
    	String jdbcUsername = "root";
    	String jdbcPassword = "Root1234@";
    	aduser= new Admin_User(jdbcURL, jdbcUsername, jdbcPassword);
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
					getUsers(request,response);
					break;
				}
				case "ADD":{
					addAdmin(request,response);
					break;
				}
			}
		}
		catch(Exception e) {
			throw new ServletException(e);
		}
		
	}

	private void addAdmin(HttpServletRequest request, HttpServletResponse response) throws SQLException, ServletException, IOException {
		String userName = request.getParameter("userName");
		String password = request.getParameter("password");
		String name = request.getParameter("name");
		String phone = request.getParameter("phone");
		String email = request.getParameter("email");
		String address = request.getParameter("address");
		int checkUser = 1;
		User user = new User(userName, password, name, phone, email, address, checkUser);
		aduser.addAdmin(user);
		getUsers(request, response);
		
	}

	private void getUsers(HttpServletRequest request, HttpServletResponse response) throws SQLException, ServletException, IOException {
		List<User> users = aduser.getUsers();
		request.setAttribute("list_user", users);
		RequestDispatcher dispatcher = request.getRequestDispatcher("/view/admin-user.jsp");
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
