package daos;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class Connect {
	protected String jdbcURL;
	protected String jdbcUserName;
	protected String jdbcPassword;
	protected Connection myConn = null;
	protected Statement myStm = null;
	protected ResultSet myRs = null;
	
	
	protected void connect() throws SQLException {
		if(myConn==null || myConn.isClosed()) {
			try {
				Class.forName("com.mysql.cj.jdbc.Driver");
			} catch (ClassNotFoundException e) {
				throw new SQLException(e); 
			}
			myConn = DriverManager.getConnection(jdbcURL, jdbcUserName, jdbcPassword);
		}
	}
	
	protected void close() throws SQLException {
		
		try {
			if(myConn!=null && !myConn.isClosed()) {
				myConn.close();
			}
			if(myStm!=null && !myStm.isClosed()) {
				myStm.close();
			}
			if(myRs!=null && !myRs.isClosed()) {
				myRs.close();
			}
		}
		catch(Exception e) {
			throw new SQLException(e);
		}
	}
}
