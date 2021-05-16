package daos;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import models.User;

public class UserList extends Connect {
	
	public UserList(String jdbcURL, String jdbcUserName, String jdbcPassword) {
		super();
		this.jdbcURL = jdbcURL;
		this.jdbcUserName = jdbcUserName;
		this.jdbcPassword = jdbcPassword;
	}
	public List<User> getUserList() throws SQLException{
		Statement myStm = null;
		ResultSet myRs = null;
		List<User> userlist = new ArrayList<>();
		try {
			connect();
			String sql = "select UserId,UserName,Password,Name,Phone,Email,Address from Users ";
			myStm = myConn.createStatement();
			myRs = myStm.executeQuery(sql);
			while(myRs.next()) {
				 int userId = myRs.getInt("UserId");
				 String userName = myRs.getString("UserName");
				 String password= myRs.getString("Password");
				 String name = myRs.getString("Name");
				 String phone = myRs.getString("Phone");
				 String email = myRs.getString("Email");
				 String address = myRs.getString("Address");
				 User user = new User(userId,userName,password,name,phone,email,address);
				 userlist.add(user);
			}
			return userlist;
		}
		finally {
			close();
		}
	}
	
	public static void main(String[] args) throws SQLException {
		String jdbcURL = "jdbc:mysql://localhost/BookStore";
    	String jdbcUsername = "root";
    	String jdbcPassword = "Root1234@";
		UserList userlist = new UserList(jdbcURL, jdbcUsername, jdbcPassword);
		System.out.println("user list");
		System.out.println(userlist.getUserList().toString());
		
	}
	
}
