package daos;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import models.Book;
import models.Contact;

public class Admin_Contact extends Connect {
	
	public Admin_Contact(String jdbcURL, String jdbcUserName, String jdbcPassword) {
		this.jdbcURL = jdbcURL;
		this.jdbcUserName = jdbcUserName;
		this.jdbcPassword = jdbcPassword;
	}
	
	public List<Contact> getContacts() throws SQLException{
		Statement myStm = null;
		ResultSet myRs = null;
		List<Contact> contacts = new ArrayList<>();
		try {
			connect();
			String sql = "select * from contacts";
			myStm = myConn.createStatement();
			myRs = myStm.executeQuery(sql);
			while(myRs.next()) {
				 int contactId = myRs.getInt("contact_id");
				 String name = myRs.getString("name");
				 String email = myRs.getString("email");
				 String subject = myRs.getString("subject");
				 String message = myRs.getString("message");
				 
				 Contact contact = new Contact(contactId, name, email, subject, message);
				 contacts.add(contact);
			}
			return contacts;
		}
		finally {
			close();
		}
	}
	
	public static void main(String[] args) throws SQLException {
		String jdbcURL = "jdbc:mysql://localhost/BookStore";
    	String jdbcUsername = "root";
    	String jdbcPassword = "Root1234@";
    	Admin_Contact adcontact = new Admin_Contact(jdbcURL, jdbcUsername, jdbcPassword);
    	System.out.println(adcontact.getContacts());
	}
}
