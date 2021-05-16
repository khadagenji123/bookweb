package daos;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import models.Book;
import models.User;

public class Admin_Book extends Connect {
	
	public Admin_Book(String jdbcURL, String jdbcUserName, String jdbcPassword) {
		this.jdbcURL = jdbcURL;
		this.jdbcUserName = jdbcUserName;
		this.jdbcPassword = jdbcPassword;
	}
	
	public List<Book> getBooks() throws SQLException{
		Statement myStm = null;
		ResultSet myRs = null;
		List<Book> books = new ArrayList<>();
		try {
			connect();
			String sql = "select * from books";
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
				 String detailDescription = myRs.getString("detail_description");
				 int amount = myRs.getInt("amount"); 
				 String image = myRs.getString("image");
				 
				 Book book = new Book(bookId, categoryId, bookName, publishingCompany, author, originalPrice, saleOff, currentPrice, shortDescription,detailDescription, amount, image);
				 books.add(book);
			}
			return books;
		}
		finally {
			close();
		}
	}
	
	public static void main(String[] args) throws SQLException {
		String jdbcURL = "jdbc:mysql://localhost/BookStore";
    	String jdbcUsername = "root";
    	String jdbcPassword = "Root1234@";
    	Admin_Book adbook = new Admin_Book(jdbcURL, jdbcUsername, jdbcPassword);
    	Book book= new  Book(5,"hello",null, "", 0, 0, 0, null, null, 60, null);
    	System.out.println("add book");
    	adbook.addBook(book);
    	System.out.println("done");
	}

	public void updateBook(Book book) throws SQLException {
		PreparedStatement myStm = null;
		
		try {
			connect();
			String sql = "update books"+
					" set category_id = ?, book_name = ?, publishing_company = ?, author = ?, original_price = ?,"
					+ " sale_off = ?, current_price = ?, short_description = ?, detail_description = ?, amount = ?, image = ?"
					+ " where book_id = ?";	
			myStm = myConn.prepareStatement(sql);
			
			// set params
			myStm.setInt(1, book.getCategoryId());
			myStm.setString(2, book.getBookName());
			myStm.setString(3, book.getPublishingCompany());
			myStm.setString(4, book.getAuthor());
			myStm.setFloat(5, book.getOriginalPrice());
			myStm.setFloat(6, book.getSaleOff());
			myStm.setFloat(7, book.getCurrentPrice());
			myStm.setString(8, book.getShortDescription());
			myStm.setString(9, book.getDetailDescription());
			myStm.setInt(10, book.getAmount());
			myStm.setString(11, book.getImage());
			myStm.setInt(12, book.getBookId());
			
			
			myStm.execute();
		}
		finally {
			close();		
		}
	}

	public void addBook(Book book) throws SQLException {
		PreparedStatement myStm =null;
		
		try {
			connect();
			String sql = "insert into books "+
					" (category_id, book_name, publishing_company, author, original_price, sale_off, "
					+ "current_price, short_description, detail_description, amount, image )"+
					" values(?,?,?,?,?,?,?,?,?,?,?)";
					
			myStm = myConn.prepareStatement(sql);
			myStm.setInt(1, book.getCategoryId());
			myStm.setString(2, book.getBookName());
			myStm.setString(3, book.getPublishingCompany());
			myStm.setString(4, book.getAuthor());
			myStm.setFloat(5, book.getOriginalPrice());
			myStm.setFloat(6, book.getSaleOff());
			myStm.setFloat(7, book.getCurrentPrice());
			myStm.setString(8, book.getShortDescription());
			myStm.setString(9, book.getDetailDescription());
			myStm.setInt(10, book.getAmount());
			myStm.setString(11, book.getImage());
			
			myStm.execute();
			
		}
		finally {
			close();
		}
	}

	public void deleteBook(int bookId) throws SQLException {
		PreparedStatement myStm = null;
		try {
			connect();
			String sql = "delete from books where book_id =?";
			myStm = myConn.prepareStatement(sql);
			myStm.setInt(1, bookId);
			myStm.execute();
		}
		finally{
			close();
		}	
	}
}
