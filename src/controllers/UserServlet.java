package controllers;

import java.io.IOException;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.sql.DataSource;

import org.json.JSONObject;

import com.mysql.cj.Session;

import daos.CartDAO;
import daos.SignInDAO;
import daos.SignUpDAO;
import models.Cart;
import models.Order;
import models.User;

/**
 * Servlet implementation class SignUpServlet
 */
@WebServlet("/UserServlet")
public class UserServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	private SignUpDAO signUp;
	private SignInDAO signIn;
	private CartDAO cartDao;

	/**
	 * @see Servlet#init(ServletConfig)
	 */
	public void init(ServletConfig config) throws ServletException {
		String jdbcURL = "jdbc:mysql://localhost/BookStore";
    	String jdbcUsername = "root";
    	String jdbcPassword = "Root1234@";
    	signUp = new SignUpDAO(jdbcURL, jdbcUsername, jdbcPassword);
    	signIn = new SignInDAO(jdbcURL, jdbcUsername, jdbcPassword);
    	cartDao = new CartDAO(jdbcURL, jdbcUsername, jdbcPassword);
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
				case "LOGOUT":{
					logOutUser(request,response);
					break;
				}
				case "HOME":{
					String url = "http://localhost:8080/bookweb/HomePage";
					response.sendRedirect(url);
					break;
				}
			}
		}
		catch(Exception e) {
			throw new ServletException(e);
		}
	}

	private void logOutUser(HttpServletRequest request, HttpServletResponse response) throws IOException {
		HttpSession session = request.getSession();
		session.removeAttribute("userName");
		String url = "http://localhost:8080/bookweb/HomePage";
		response.sendRedirect(url);
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
				case "SIGNUP":{
					signUpUser(request,response);
					break;
				}
				case "SIGNIN":{
					signInUser(request,response);
					break;
				}
				case "CHECKBUY":{
					checkBuy(request,response);
					break;
				}
				case "SIGNINTOBUY":{
					signInToBuy(request,response);
					break;
				}
				case "HOME":{
					String url = "http://localhost:8080/bookweb/HomePage";
					response.sendRedirect(url);
					break;
				}
			}
		}
		catch(Exception e) {
			throw new ServletException(e);
		}
	}

	private void signInToBuy(HttpServletRequest request, HttpServletResponse response) throws SQLException, IOException {
		String userName = request.getParameter("userName");
		String password = request.getParameter("password");
		User user = new User(userName,password );
		int checkUser = signIn.signInToBuy(user);
		if(checkUser == 2) {
			HttpSession session = request.getSession();
			session.setAttribute("userName",userName);
		}
		System.out.println(checkUser);

		response.setContentType("application/json");
		JSONObject obj = new JSONObject();
		obj.put("checkUser", checkUser);
		response.getWriter().write(obj.toString());
		
	}

	private void checkBuy(HttpServletRequest request, HttpServletResponse response) throws IOException, SQLException {
		String bookId = request.getParameter("bookId");
		String amount = request.getParameter("amount");
		HttpSession session = request.getSession();
		String userName = (String) session.getAttribute("userName");
		int theBookId = Integer.parseInt(bookId);
		int theAmount = Integer.parseInt(amount);
		Cart cart = new Cart(theBookId, userName, theAmount);
		cartDao.addBookIntoCart(cart);
		
		
		response.setContentType("application/json");
		JSONObject obj = new JSONObject();
		obj.put("userName", userName);
		response.getWriter().write(obj.toString());
		
	}

	private void signInUser(HttpServletRequest request, HttpServletResponse response) throws SQLException, IOException, ServletException {
		String userName = request.getParameter("userName");
		String password = request.getParameter("password");
		User user = new User(userName,password );
		int checkUser = signIn.signIn(user);
		if(checkUser == 2) {
			HttpSession session = request.getSession();
			session.setAttribute("userName",userName);
		}
		response.setContentType("application/json");
		JSONObject obj = new JSONObject();
		obj.put("checkUser", checkUser);
		response.getWriter().write(obj.toString());

		
	}

	private void signUpUser(HttpServletRequest request, HttpServletResponse response) throws SQLException, IOException {
		String userName = request.getParameter("userName");
		String password = request.getParameter("password");
		String name = request.getParameter("name");
		String phone = request.getParameter("phone");
		String email = request.getParameter("email");
		String address = request.getParameter("address");
		int checkUser = 2;
		
		String message = "valid";
		boolean checkUserName = true;
		if(userName.equals("")|| password.equals("")|| name.equals("") || address.equals("") || phone.equals("") || email.equals("") || address.equals("") ){
			message = "null";
		}
		else {
			checkUserName =  signUp.checkUserName(userName);
			if(!checkUserName) {
				User user = new User(userName, password, name, phone, email, address, checkUser);
				signUp.signUp(user);
			}
		}
		response.setContentType("application/json");
		JSONObject obj = new JSONObject();
		obj.put("checkUserName", checkUserName);
		obj.put("message", message);
		response.getWriter().write(obj.toString());

	}

}
