package daos;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import models.Cart;
import models.Contact;

public class Admin_Cart extends Connect {
	
	public Admin_Cart(String jdbcURL, String jdbcUserName, String jdbcPassword) {
		this.jdbcURL = jdbcURL;
		this.jdbcUserName = jdbcUserName;
		this.jdbcPassword = jdbcPassword;
	}
	
	public List<Cart> getCarts() throws SQLException{
		Statement myStm = null;
		ResultSet myRs = null;
		List<Cart> carts = new ArrayList<>();
		try {
			connect();
			String sql = "select * from carts";
			myStm = myConn.createStatement();
			myRs = myStm.executeQuery(sql);
			while(myRs.next()) {
				 int cartId = myRs.getInt("cart_id");
				 int userId = myRs.getInt("user_id");
				 int bookId = myRs.getInt("book_id");
				 String userName = myRs.getString("user_name");
				 java.sql.Date date = myRs.getDate("date");
				 String name = myRs.getString("name");
				 String address = myRs.getString("address");
				 String phone = myRs.getString("phone");
				 int amount = myRs.getInt("amount");
				 float total = myRs.getFloat("total");
				 
				 Cart cart = new Cart(cartId, userId, bookId, userName, date, name, address, phone, amount, total);
				 carts.add(cart);
			}
			return carts;
		}
		finally {
			close();
		}
	}
	
	public static void main(String[] args) throws SQLException {
		String jdbcURL = "jdbc:mysql://localhost/BookStore";
    	String jdbcUsername = "root";
    	String jdbcPassword = "Root1234@";
    	Admin_Cart adcart = new Admin_Cart(jdbcURL, jdbcUsername, jdbcPassword);
    	System.out.println(adcart.getCarts());
	}
}
