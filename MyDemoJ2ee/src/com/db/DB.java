package com.db;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.model.Vendor;

public class DB {
  //establish the connection 
	String driver= "com.mysql.cj.jdbc.Driver";
	Connection con; 
	
	public void dbConnect() {
		//Step 1: Load the Driver 
		try {
			Class.forName(driver);
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
		//Step 2: Make a connection 
		try {
			con = DriverManager.getConnection("jdbc:mysql://localhost:3306/mavericks_boot_db", 
					"root", "");
		} catch (SQLException e) {
			e.printStackTrace();
		} 
	}
	
	public void dbClose(){
		try {
			con.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	public List<Vendor> fetchVendors() {
		dbConnect();
		String sql="select * from vendor";
		List<Vendor> list = new ArrayList<>();
		try {
			PreparedStatement pstmt = con.prepareStatement(sql);
			ResultSet rst = pstmt.executeQuery();
			while(rst.next()) {
				Vendor vendor = new Vendor();
				vendor.setId(rst.getInt("id"));
				vendor.setName(rst.getString("name"));
				vendor.setCity(rst.getString("city"));
				list.add(vendor);
				/*
				 * getInt
				 * getString
				 * getDouble
				 */
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		
		dbClose();
		return list;
	}
	
  //execute my queries 
	/*
	 * executeQuery() : select 
	 * executeUpdate() : update, delete, insert 
	 * ResultSet.next() 
	 */
	
}
