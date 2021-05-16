package daos;


import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.List;
import models.Book;
import models.Cart;
import models.User;

public class CartDAO extends Connect {
	
	public CartDAO(String jdbcURL, String jdbcUserName, String jdbcPassword) {
		this.jdbcURL = jdbcURL;
		this.jdbcUserName = jdbcUserName;
		this.jdbcPassword = jdbcPassword;
	}
	
	public void addBookIntoCart(Cart cart) throws SQLException {
		PreparedStatement myStm =null;
		Statement myStmt = null;
		ResultSet myRs = null;
		try {
			connect();
		
			String sql1 = "select distinct current_price"
					+ " from books b"
					+ " where b.book_id = "+ cart.getBookId();
			
			myStmt = myConn.createStatement();
			myRs = myStmt.executeQuery(sql1);
			float currentPrice = 0;
			while(myRs.next()) {
				currentPrice = myRs.getFloat("current_price");
			}
			
			
			long millis = System.currentTimeMillis();
	        java.sql.Date date = new java.sql.Date(millis);
			String sql = "insert into carts "+
					" (user_name,book_id,amount,date,total)"+
					" values(?,?,?,?,?)";
			
			myStm = myConn.prepareStatement(sql);
			myStm.setString(1, cart.getUserName());
			myStm.setInt(2, cart.getBookId());
			myStm.setInt(3, cart.getAmount());
			myStm.setDate(4, date);
			myStm.setFloat(5, currentPrice*cart.getAmount());
			
			myStm.execute();
			
		}
		finally {
			close();
		}
	}
	
	public List<Book> getCart(String userName) throws SQLException{
		Statement myStm = null;
		ResultSet myRs = null;
		List<Book> bookList = new ArrayList<>();
		try {
			connect();
			String sql = "select b.book_id, book_name, original_price, sale_off, current_price, c.amount, c.total,"
					+ " image, date"
					+ " from books b, carts c"
					+ " where b.book_id = c.book_id and c.date = curdate()"
					+ " and (user_name is null"
					+ " or user_name like '"+ userName + "')";
			myStm = myConn.createStatement();
			myRs = myStm.executeQuery(sql);
			while(myRs.next()) {
				 int bookId = myRs.getInt("book_id");
				 String bookName = myRs.getString("book_name");
				 float originalPrice = myRs.getFloat("original_price");
				 float saleOff = myRs.getFloat("sale_off");
				 float currentPrice = myRs.getFloat("current_price");
				 java.sql.Date currentDate = myRs.getDate("date");
				 int amount = myRs.getInt("amount");
				 String image = myRs.getString("image");
				 float total = myRs.getFloat("total");
				 Book book = new Book(bookId, bookName, originalPrice, saleOff, currentPrice, amount, image,total);
				 bookList.add(book);
			}
			return bookList;
		}
		finally {
			close();
		}
	}
	
	public void deleteCart(int bookId,String userName) throws SQLException {
		PreparedStatement myStm = null;
		try {
			connect();
			String sql = "delete from carts where date = curdate() and book_id = ?"
					+ " and (user_name is null or user_name = ?)";
			myStm = myConn.prepareStatement(sql);
			myStm.setInt(1, bookId);
			myStm.setString(2, userName);
			myStm.execute();
		}
		finally{
			close();
		}		
	}
	
	public void payBill(Cart cart) throws SQLException {
		PreparedStatement myStm = null;
		PreparedStatement myStmm = null;
		
		try {
			connect();
			String sql = "update carts"+
					" set user_id=?, user_name=?, name=?, address=?, phone=?"+
					" where date = curdate() and (user_name is null or user_name=?)";	
			myStm = myConn.prepareStatement(sql);
			
			// set params
			myStm.setInt(1, cart.getUserId());
			myStm.setString(2, cart.getUserName());
			myStm.setString(3, cart.getName());
			myStm.setString(4, cart.getName());
			myStm.setString(5, cart.getPhone());
			myStm.setString(6, cart.getUserName());
			
			myStm.execute();

			String sql1 = "update books b join carts c"
					+ " ON b.book_id = c.book_id"
					+ " set b.amount = b.amount - c.amount"
					+ " where c.date = curdate() and c.user_name like '"+cart.getUserName()+"'";
			myStmm = myConn.prepareStatement(sql1);
			myStmm.execute();
		}
		finally {
			close();
		}
	}
	
	public int getUserId(String userName) throws SQLException {
		Statement myStm = null;
		ResultSet myRs = null;
		try {
			connect();
			String sql = "select distinct user_id from users"
					+ " where user_name like '"+userName+"'";
			myStm = myConn.createStatement();
			myRs = myStm.executeQuery(sql);
			int userId = 1;
			while(myRs.next()) {
				 userId = myRs.getInt("user_id"); 
			}
			return userId;
		}
		finally {
			close();
		}	
	}
	
	
	public void selectCart() throws SQLException {
		Statement myStm = null;
		ResultSet myRs = null;
		try {
			connect();
			String sql = "select * from carts"
					+ " where date = curdate()";
			myStm = myConn.createStatement();
			myRs = myStm.executeQuery(sql);
			while(myRs.next()) {
				 int bookId = myRs.getInt("book_id"); 
				 int amount = myRs.getInt("amount");
				 System.out.println(bookId+"-"+amount);
			}
		}
		finally {
			close();
		}	
	}
	
	public static void main(String[] args) throws SQLException, ParseException {
		String jdbcURL = "jdbc:mysql://localhost/BookStore";
    	String jdbcUsername = "root";
    	String jdbcPassword = "Root1234@";
		CartDAO cartDao = new CartDAO(jdbcURL, jdbcUsername, jdbcPassword);
//		System.out.println("Add book into cart");
//		String userName = null;
//		int booId = 1;
//		int amount = 5;
//		Cart cart = new Cart(booId, userName , amount);
//		cartDao.addBookIntoCart(cart);
//		System.out.println("done");
//		System.out.println("desplay cart");
//		String userName = "quoc1234";
//		List<Book> bookList = cartDao.getCart(userName);
//		for(int i=0;i<bookList.size();i++) {
//			System.out.println( bookList.get(i).getTotal());
//		}
//		System.out.println("done");
		System.out.println("pay bill");
		Cart cart = new Cart(1,"quoc1234","khanh","thon 1","12345678");
		cartDao.payBill(cart);
		System.out.println("done");
//		System.out.println("selete cart");
//		System.out.println(cartDao.getUserId("faag"));
//		System.out.println("done");
	}



}
