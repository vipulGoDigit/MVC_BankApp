package com.digit.javaTraining.mvc.model;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class loan {
	int lid;
	String ltype;
	int intrest;
	int tenure;
	String description;
	private Connection con;
	
	public loan() {
		String url = "jdbc:mysql://localhost:3306/test25";

		String user = "root";

		String pwd = "Vipul@8800";

		try {

			Class.forName("com.mysql.cj.jdbc.Driver");
			con = DriverManager.getConnection(url, user, pwd);

		} catch (Exception e) {

			e.printStackTrace();
		}

	}
	
	
	
	
	
	
	public int getLid() {
		return lid;
	}






	public void setLid(int lid) {
		this.lid = lid;
	}






	public String getLtype() {
		return ltype;
	}






	public void setLtype(String ltype) {
		this.ltype = ltype;
	}






	public int getIntrest() {
		return intrest;
	}






	public void setIntrest(int intrest) {
		this.intrest = intrest;
	}






	public int getTenure() {
		return tenure;
	}






	public void setTenure(int tenure) {
		this.tenure = tenure;
	}






	public String getDescription() {
		return description;
	}






	public void setDescription(String description) {
		this.description = description;
	}






	public boolean applyLoan(String ltype) {
		String query="Select * from loan where ltype=?";
		
		try {
			PreparedStatement pstmt = con.prepareStatement(query);
			pstmt.setString(1, ltype);
			
			ResultSet rs=pstmt.executeQuery();
			
			if(rs.next()) {
				this.lid=rs.getInt("lid");
				this.ltype=rs.getString("ltype");
				this.intrest=rs.getInt("intrest");
				this.tenure=rs.getInt("tenure");
				this.description=rs.getString("description");
				
				return true;
			}
			
			
		
			
		} catch (Exception e) {
			
			e.printStackTrace();
		}
		return false;
	}

}
