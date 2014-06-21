package database.data;

import java.util.*;

public abstract class UserAdmin extends GuestLogs{
	ArrayList<String> adminUsername = new ArrayList<String>();
	ArrayList<String> adminPassword = new ArrayList<String>();
	
	public ArrayList<String> getAdminUsername() {
		return adminUsername;
	}
	
	public void setAdminUsername(String adminUsername) {
		this.adminUsername.add(adminUsername);
	}
	
	public ArrayList<String> getAdminPassword() {
		return adminPassword;
	}
	
	public void setAdminPassword(String adminPassword) {
		this.adminPassword.add(adminPassword);
	}
}
