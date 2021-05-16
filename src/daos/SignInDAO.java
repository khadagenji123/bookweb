package daos;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import models.User;

public class SignInDAO extends Connect {
	
	public SignInDAO(String jdbcURL, String jdbcUserName, String jdbcPassword) {
		super();
		this.jdbcURL = jdbcURL;
		this.jdbcUserName = jdbcUserName;
		this.jdbcPassword = jdbcPassword;
	}
	
	public int signIn(User user) throws SQLException {
		Statement myStm = null;
		ResultSet myRs = null;
		User theUser = null;
		try {
			connect();
			myStm = myConn.createStatement();
			myRs = myStm.executeQuery("select*from users");
			
			while(myRs.next()) {
				int userId = myRs.getInt("user_id");
				int checkUser = myRs.getInt("check_user");
				String userName = myRs.getString("user_name");
				String password = myRs.getString("password");
				if(user.getUserName().equals(userName) &&
						user.getPassword().equals(password)) {
					if(checkUser==2) {
						return 2;
					}
					else {
						return 1;
					}
				}
			}
			return 0;
		}
		finally{
			close();
		}
	}

	public int signInToBuy(User user) throws SQLException {
		Statement myStm = null;
		ResultSet myRs = null;
		try {
			connect();
			myStm = myConn.createStatement();
			myRs = myStm.executeQuery("select*from users");
			
			while(myRs.next()) {
				int checkUser = myRs.getInt("check_user");
				String userName = myRs.getString("user_name");
				String password = myRs.getString("password");
				if(user.getUserName().equals(userName) &&
						user.getPassword().equals(password)) {
					if(checkUser==2) {
						return 2;
					}
					return 1;
				}
			}
			return 0;
		}
		finally{
			close();
		}
	}
}
