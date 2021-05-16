package daos;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import models.Book;
import models.Category;
import models.User;

public class BookListHomePageDAO extends Connect  {
	
	public BookListHomePageDAO(String jdbcURL, String jdbcUserName, String jdbcPassword) {
		super();
		this.jdbcURL = jdbcURL;
		this.jdbcUserName = jdbcUserName;
		this.jdbcPassword = jdbcPassword;
	}
	
	public List<Book> getBookList() throws SQLException{
		Statement myStm = null;
		ResultSet myRs = null;
		List<Book> bookList = new ArrayList<>();
		try {
			connect();
			String sql = "select * from books where category_id = 1";
			myStm = myConn.createStatement();
			myRs = myStm.executeQuery(sql);
			while(myRs.next()) {
				 int bookId = myRs.getInt("book_id");
				 int categoryId = myRs.getInt("category_id");
				 String bookName = myRs.getString("book_name");
				 String publishingCompany = myRs.getString("publishing_company");
				 String author = myRs.getString("author");
				 float originalPrice = myRs.getFloat("original_price");
				 float saleOff = myRs.getFloat("sale_off");
				 float currentPrice = myRs.getFloat("current_price");
				 String shortDescription = myRs.getString("short_description");
				 int amount = myRs.getInt("amount");
				 String image = myRs.getString("image");
				 
				 Book book = new Book(bookId,categoryId, bookName, publishingCompany, author, originalPrice, saleOff, currentPrice, shortDescription, amount, image);
				 
				 bookList.add(book);
			}
			return bookList;
		}
		finally {
			close();
		}
	}
	public List<Book> getTheBookList() throws SQLException {
		Statement myStm = null;
		ResultSet myRs = null;
		List<Book> bookList = new ArrayList<>();
		try {
			connect();
			String sql = "select * from books where category_id = 3";
			myStm = myConn.createStatement();
			myRs = myStm.executeQuery(sql);
			while(myRs.next()) {
				 int bookId = myRs.getInt("book_id");
				 int categoryId = myRs.getInt("category_id");
				 String bookName = myRs.getString("book_name");
				 String publishingCompany = myRs.getString("publishing_company");
				 String author = myRs.getString("author");
				 float originalPrice = myRs.getFloat("original_price");
				 float saleOff = myRs.getFloat("sale_off");
				 float currentPrice = myRs.getFloat("current_price");
				 String shortDescription = myRs.getString("short_description");
				 int amount = myRs.getInt("amount");
				 String image = myRs.getString("image");
				 
				 Book book = new Book(bookId,categoryId, bookName, publishingCompany, author, originalPrice, saleOff, currentPrice, shortDescription, amount, image);
				 
				 bookList.add(book);
			}
			return bookList;
		}
		finally {
			close();
		}
	}
	
	
	
	public static void main(String[] args) throws SQLException {
		String jdbcURL = "jdbc:mysql://localhost/BookStore";
    	String jdbcUsername = "root";
    	String jdbcPassword = "Root1234@";
		BookListHomePageDAO bookList = new BookListHomePageDAO(jdbcURL, jdbcUsername, jdbcPassword);
//		System.out.println(bookList.getCategories());
	}

	
}
