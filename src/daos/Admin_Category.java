package daos;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import models.Category;
import models.Contact;

public class Admin_Category extends Connect {

	public Admin_Category(String jdbcURL, String jdbcUserName, String jdbcPassword) {
		this.jdbcURL = jdbcURL;
		this.jdbcUserName = jdbcUserName;
		this.jdbcPassword = jdbcPassword;
	}
	
	public List<Category> getCategories() throws SQLException{
		Statement myStm = null;
		ResultSet myRs = null;
		List<Category> categories = new ArrayList<>();
		try {
			connect();
			String sql = "select * from categories";
			myStm = myConn.createStatement();
			myRs = myStm.executeQuery(sql);
			while(myRs.next()) {
				 int categoryId = myRs.getInt("category_id");
				 String categoryName = myRs.getString("category_name");
				 
				 Category category = new Category(categoryId, categoryName);
				 categories.add(category);
			}
			return categories;
		}
		finally {
			close();
		}
	}
	
	public void addCategory(String categoryName) throws SQLException {
		PreparedStatement myStm =null;
		
		try {
			connect();
			String sql = "insert into categories "+
					" (category_name)"+
					" values(?)";
					
			myStm = myConn.prepareStatement(sql);
			myStm.setString(1, categoryName);
			
			myStm.execute();
			
		}
		finally {
			close();
		}
	}
	public Category getCategory(int categoryId) throws SQLException{
		Statement myStm = null;
		ResultSet myRs = null;
		Category category = null;
		try {
			connect();
			String sql = "select * from categories where category_id = " + categoryId ;
			myStm = myConn.createStatement();
			myRs = myStm.executeQuery(sql);
			while(myRs.next()) {
				 String categoryName = myRs.getString("category_name");
				 
				 category = new Category(categoryId, categoryName);
			}
			return category;
		}
		finally {
			close();
		}
	}
	
	
	public static void main(String[] args) throws SQLException {
		String jdbcURL = "jdbc:mysql://localhost/BookStore";
    	String jdbcUsername = "root";
    	String jdbcPassword = "Root1234@";
    	Admin_Category adcategory = new Admin_Category(jdbcURL, jdbcUsername, jdbcPassword);
//    	System.out.println(adcategory.getCategories());
    	System.out.println("delete");
    	adcategory.deleteCategory(14);
    	System.out.println("done");
	}

	public void updateCategory(Category category) throws SQLException {
		PreparedStatement myStm = null;
		
		try {
			connect();
			String sql = "update categories"+
					" set category_name = ?"+
					" where category_id = ?";	
			myStm = myConn.prepareStatement(sql);
			
			// set params
			myStm.setString(1, category.getCategoryName());
			myStm.setInt(2, category.getCategoryId());
			
			myStm.execute();
		}
		finally {
			close();		
		}
	}

	public void deleteCategory(int categoryId) throws SQLException {
		PreparedStatement myStm = null;
		PreparedStatement myStmm = null;
		try {
			connect();
			String sql = "delete from books where category_id =?";
			String sqlm = "delete from categories where category_id =?";
			myStm = myConn.prepareStatement(sql);
			myStmm = myConn.prepareStatement(sqlm);
			myStm.setInt(1, categoryId);
			myStmm.setInt(1, categoryId);
			myStm.execute();
			myStmm.execute();
		}
		finally{
			close();
		}	
	}
}
