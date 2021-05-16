package daos;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import models.Book;

public class BookDetailDAO extends Connect {
	
	public BookDetailDAO(String jdbcURL, String jdbcUserName, String jdbcPassword) {
		super();
		this.jdbcURL = jdbcURL;
		this.jdbcUserName = jdbcUserName;
		this.jdbcPassword = jdbcPassword;
	}
	
	public List<Book> getBookList(int theId) throws SQLException{
		Statement myStm = null;
		ResultSet myRs = null;
		List<Book> books = new ArrayList<>();
		try {
			connect();
			String sql = "select * from books b, categories c"
					+ " where b.category_id = c.category_id and book_id= "+theId;
			myStm = myConn.createStatement();
			myRs = myStm.executeQuery(sql);
			while(myRs.next()) {
				 int bookId = myRs.getInt("book_id");
				 String categoryName = myRs.getString("category_name");
				 String bookName = myRs.getString("book_name");
				 String publishingCompany = myRs.getString("publishing_company");
				 String author = myRs.getString("author");
				 float originalPrice = myRs.getFloat("original_price");
				 float saleOff = myRs.getFloat("sale_off");
				 float currentPrice = myRs.getFloat("current_price");
				 String detailDescription = myRs.getString("detail_description");
				 int amount = myRs.getInt("amount"); 
				 String image = myRs.getString("image");
				 
				 Book book = new Book(bookId, categoryName, bookName, publishingCompany, author, originalPrice, saleOff, currentPrice, detailDescription, amount, image);
				 books.add(book);
				 
			}
			return books;
		}
		finally {
			close();
		}
	}
}
