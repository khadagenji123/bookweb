package daos;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import models.Contact;
import models.User;

public class Admin_User extends Connect{
	
	public Admin_User(String jdbcURL, String jdbcUserName, String jdbcPassword) {
		this.jdbcURL = jdbcURL;
		this.jdbcUserName = jdbcUserName;
		this.jdbcPassword = jdbcPassword;
	}
	
	public List<User> getUsers() throws SQLException{
		Statement myStm = null;
		ResultSet myRs = null;
		List<User> users = new ArrayList<>();
		try {
			connect();
			String sql = "select * from users";
			myStm = myConn.createStatement();
			myRs = myStm.executeQuery(sql);
			while(myRs.next()) {
				 int userId = myRs.getInt("user_id");
				 String userName = myRs.getString("user_name");
				 String password = myRs.getString("password");
				 String name = myRs.getString("name");
				 String phone = myRs.getString("phone");
				 String email = myRs.getString("email");
				 String address = myRs.getString("address");
				 int checkUser = myRs.getInt("check_user");
				 
				User user = new  User(userId, userName, password, name, phone, email, address, checkUser);
				users.add(user);
			}
			return users;
		}
		finally {
			close();
		}
	}
	
	public static void main(String[] args) throws SQLException {
		String jdbcURL = "jdbc:mysql://localhost/BookStore";
    	String jdbcUsername = "root";
    	String jdbcPassword = "Root1234@";
    	Admin_User aduser = new Admin_User(jdbcURL, jdbcUsername, jdbcPassword);
    	System.out.println(aduser.getUsers());
	}

	public void addAdmin(User user) throws SQLException {
		PreparedStatement myPStm = null;
		try {
			connect();
			String sql = "insert into users(user_name,password,name,phone,email,address,check_user)  "
						+"values(?,?,?,?,?,?,?)";
			
			myPStm = myConn.prepareStatement(sql);
			myPStm.setString(1, user.getUserName());
			myPStm.setString(2, user.getPassword());
			myPStm.setString(3, user.getName());
			myPStm.setString(4, user.getPhone());
			myPStm.setString(5, user.getEmail());
			myPStm.setString(6, user.getAddress());
			myPStm.setInt(7, user.getCheckUser());
			
			myPStm.execute();
			
		}
		finally {
			close();
		}
	}
}
