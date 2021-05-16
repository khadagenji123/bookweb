package daos;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import models.Contact;

public class ContactDAO extends Connect{
	
	public ContactDAO(String jdbcURL, String jdbcUserName, String jdbcPassword) {
		super();
		this.jdbcURL = jdbcURL;
		this.jdbcUserName = jdbcUserName;
		this.jdbcPassword = jdbcPassword;
	}
	
	public void contactCompany(Contact contact) throws SQLException {
		PreparedStatement myPStm = null;
		
		try {
			connect();
			String sql = "insert into contacts "
						+"(name,email,subject,message) "
						+"values(?,?,?,?)";
			
			myPStm = myConn.prepareStatement(sql);
			myPStm.setString(1, contact.getName());
			myPStm.setString(2, contact.getEmail());
			myPStm.setString(3, contact.getSubject());
			myPStm.setString(4, contact.getMessage());
			
			myPStm.execute();
		}
		finally {
			close();
		}
	}
}
