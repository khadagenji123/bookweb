package daos;

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
}
