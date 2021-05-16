package daos;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import models.Book;

public class SearchingBook extends Connect {
	
	public SearchingBook(String jdbcURL, String jdbcUserName, String jdbcPassword) {
		super();
		this.jdbcURL = jdbcURL;
		this.jdbcUserName = jdbcUserName;
		this.jdbcPassword = jdbcPassword;
	}
	
	public List<Book> getSearchBook(Book theBook) throws SQLException{
		Statement myStm = null;
		ResultSet myRs = null;
		
		List<Book> books = new ArrayList<Book>(); 
		
		try {
			connect();
			String sql = "select * from books "
						+"where book_name like '%"+theBook.getBookName()+"%'";
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
				 
				 Book book = new Book(bookId, categoryId, bookName, publishingCompany, author, originalPrice, saleOff, currentPrice, shortDescription, amount, image);
				 books.add(book);
			}
			return books;
		}
		finally{
			close();
		}
			
	}
	
	public static void main(String[] args) throws SQLException {
		Scanner scanner = new Scanner(System.in);
		String jdbcURL = "jdbc:mysql://localhost/BookStore";
    	String jdbcUsername = "root";
    	String jdbcPassword = "Root1234@";
		SearchingBook bookList = new SearchingBook(jdbcURL, jdbcUsername, jdbcPassword);
		System.out.println("Nhap ten sach");
		String bookName = scanner.nextLine();
		Book theBook = new Book(bookName);
		System.out.println(bookList.getSearchBook(theBook));
	}
}
