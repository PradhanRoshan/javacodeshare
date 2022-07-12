package com.persistence;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.model.User;

public class DB {
	Connection con;
	
	public void dbConnect() {
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			//System.out.println("Driver loaded..");
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}  
		
		try {
			con = DriverManager.getConnection("jdbc:mysql://localhost:3306/mavericks_hex"
					,"root","");
			//System.out.println("Connection Established..");
		} catch (SQLException e) {
			 
			e.printStackTrace();
		}
	}
	
	public void dbClose() {
		try {
			con.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	public boolean validateCredentials(String username,String password) {
		dbConnect();
		String sql="select * from user where username=? and password=?";
		boolean isPresent =false; 
		try {
			PreparedStatement pstmt = con.prepareStatement(sql);
			pstmt.setString(1, username);
			pstmt.setString(2, password);
		 
			ResultSet rst = pstmt.executeQuery();
			isPresent = rst.next();
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		 dbClose();
		return isPresent; 
	}

	public void insertUser(User user) {
		 dbConnect();
		 String sql="insert into user(name,username,password) "
		 		+ "values (?,?,?)";
		 
		 try {
			PreparedStatement pstmt = con.prepareStatement(sql);
			pstmt.setString(1, user.getName());
			pstmt.setString(2, user.getUsername());
			pstmt.setString(3, user.getPassword());
 			
			pstmt.executeUpdate();
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		 
		 dbClose();
		
	}
}










