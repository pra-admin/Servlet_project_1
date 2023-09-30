package com.flipkart.model;

import java.sql.ResultSet;

public interface DIOService {
	
	public void connectDB();
	
	public boolean verifyLogin(String username, String password);
	
	public void saveRegistration(String name, String city, String email, String mobile);
	
	public void deleteRegistration(String email);
	
	public void saveDetails(String email, String password);
	
	public ResultSet listAll();

}
