package com.flipkart.model;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

public class DIOServiceImpl implements DIOService {
	
	private Connection connection;
	private Statement statement;
	
	@Override
	public void connectDB() {
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/regdb","root","Kanha@123");
			statement = connection.createStatement();
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		
	}
	
	@Override
	public boolean verifyLogin(String username, String password) {
		try {
			ResultSet result = statement.executeQuery
			("select * from login where email='"+username+"' and password='"+password+"'");
			
			if(result.next()) {
				return true;
			}
			else {
				return false;
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		return false;
	}
	
	@Override
	public void saveRegistration(String name, String city, String email, String mobile) {
		try {
			statement.executeUpdate
			("insert into registration values('"+name+"','"+city+"','"+email+"','"+mobile+"')");
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	@Override
	public void deleteRegistration(String email) {
		
	}

	@Override
	public void saveDetails(String email, String password) {
		try {
			statement.executeUpdate("insert into login values('"+email+"','"+password+"')");
		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}

	@Override
	public ResultSet listAll() {
		try {
			ResultSet result = statement.executeQuery("Select * from registration");
			return result;
		} catch (Exception e) {
		
			e.printStackTrace();
		}
		return null;
	}

}
