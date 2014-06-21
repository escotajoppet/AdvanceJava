package pharmacy.system;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;

public abstract class Account extends DbConnect {
	private int logout = 0;
	private String username = "";
	private String password = "";
	
	public void setLogOut(int logout) {
	    this.logout = logout;
	}
	
	public void setUser(String user) {
	    this.username = user;
	}
	
	public void setPassword(String password) {
	    this.password = password;
	}
	
	public int getLogOut() {
		return this.logout;
	}
	
	public String getUser() {
		return this.username;
	}
	
	public String getPassword() {
		return this.password;
	}
	
	public String loginAccount(String username) {
    	String stat = "";
    	String acc = "";  	
    	try{
    		Connection conn = getConnection();
    		String query = "Select userName from account";
    		Statement st = conn.createStatement();
	    	ResultSet rs = st.executeQuery(query);
	   		while(rs.next()) {
	    		if( username.equals(rs.getString("userName"))) {
	    			acc = rs.getString("userName");
	    		}
	    	}
	    	if(acc.equals("")) {
	    		stat = "error";
	    	} 	   		
    	}catch (Exception e) {}
    	return stat;
    }
    
    
    public String checkPassword(String username, String password) {
    	String stat = "";
    	String pass = "";
    	try{
	    	Connection conn = getConnection();
	    	String query = "Select password from account where userName = '"+username+"'";
	    	Statement st = conn.createStatement();
		    ResultSet rs = st.executeQuery(query);
		   	while(rs.next()) {
		    	if( password.equals(rs.getString("password"))) {
		    		pass = rs.getString("password");
		    	}
		    }
		    if(pass.equals("")) {
		    	stat = "error";
		   	} 
    	} catch(Exception e) {
    		
    	}
	   	return stat;
    }
    
    public String checkUser(String username) {
    	String stat = "";
    	try{
	    	Connection conn = getConnection();
	    	String query = "Select `userName` from `account`";
	    	Statement st = conn.createStatement();
		    ResultSet rs = st.executeQuery(query);
		   	while(rs.next()) {
		    	if(username.equals(rs.getString("userName"))) {
		    		stat = "error";
		    	}
		    }
    	} catch(Exception e) {
    		
    	}
	   	return stat;
    }
    
    public void createAccount(String username, String password) {
		try{
			Connection conn = getConnection();
			String query = "INSERT INTO `account` (`userName`, `password`) VALUES('"+username+"', '"+password+"')";
			Statement st = conn.createStatement();
			st.execute(query);
			conn.commit();	
			conn.close();
		} catch(Exception e) {}	 	
    }
}
