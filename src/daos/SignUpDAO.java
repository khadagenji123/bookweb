package daos;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import models.User;

public class SignUpDAO extends Connect {
	
	public SignUpDAO(String jdbcURL, String jdbcUserName, String jdbcPassword) {
		super();
		this.jdbcURL = jdbcURL;
		this.jdbcUserName = jdbcUserName;
		this.jdbcPassword = jdbcPassword;
	}
	
	public void signUp(User user) throws SQLException {
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
	
	public boolean checkUserName(String userName) throws SQLException {
		Statement myStm = null;
		ResultSet myRs = null;
		try {
			connect();
			myStm = myConn.createStatement();
			myRs = myStm.executeQuery("select user_name from users");
			
			while(myRs.next()) {
				String theUserName = myRs.getString("user_name");
				if(userName.equals(theUserName)) {
					return true;
				}
			}
			return false;
		}
		finally{
			close();
		}
	}
	
	public static void main(String[] args) throws SQLException {
		String jdbcURL = "jdbc:mysql://localhost/BookStore";
    	String jdbcUsername = "root";
    	String jdbcPassword = "Root1234@";
		SignUpDAO signUp = new SignUpDAO(jdbcURL, jdbcUsername, jdbcPassword);
		System.out.println(signUp.checkUserName("minh"));
//		System.out.println("Add user");
//		String userName = "quoc1234";
//		String password = "quoc123";
//		String name = "quoc";
//		String phone = "1234";
//		String email = "quoc@gmail.com";
//		String address = "thon 1";
//		int checkUser = 0;
//		User user = new User(userName, password, name, phone, email, address, checkUser);
//		signUp.signUp(user);
//		System.out.println("done");
	}
}
