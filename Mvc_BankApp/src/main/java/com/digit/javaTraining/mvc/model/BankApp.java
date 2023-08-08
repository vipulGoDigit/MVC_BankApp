package com.digit.javaTraining.mvc.model;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class BankApp {
	int bank_id;
	String bank_name;
	String ifsc_code;
	int accno;
	int pin;
	int cust_id;
	String cust_name;
	int balance;
	String email;
	long phone;
	//int New_pin;
	//int Confirm_pin;
	

//	public int getConfirm_pin() {
//		return Confirm_pin;
//	}
//	public void setConfirm_pin(int confirm_pin) {
//		Confirm_pin = confirm_pin;
//	}

	private Connection con;
	private PreparedStatement pstmt;
	private ResultSet res2;
	private ResultSet res3;
	private Object resp;

	public BankApp() {
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

	public int getBank_id() {
		return bank_id;
	}

	public void setBank_id(int bank_id) {
		this.bank_id = bank_id;
	}

	public String getBank_name() {
		return bank_name;
	}

	public void setBank_name(String bank_name) {
		this.bank_name = bank_name;
	}

	public String getIfsc_code() {
		return ifsc_code;
	}

	public void setIfsc_code(String ifsc_code) {
		this.ifsc_code = ifsc_code;
	}

	public int getAccno() {
		return accno;
	}

	public void setAccno(int accno) {
		this.accno = accno;
	}

	public int getPin() {
		return pin;
	}

	public void setPin(int pin) {
		this.pin = pin;
	}

	public int getCust_id() {
		return cust_id;
	}

	public void setCust_id(int cust_id) {
		this.cust_id = cust_id;
	}

	public String getCust_name() {
		return cust_name;
	}

	public void setCust_name(String cust_name) {
		this.cust_name = cust_name;
	}

	public int getBalance() {
		return balance;
	}

	public void setBalance(int balance) {
		this.balance = balance;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public long getPhone() {
		return phone;
	}

	public void setPhone(long phone) {
		this.phone = phone;
	}

	public boolean register() {
		try {

			pstmt = con.prepareStatement("insert into bankapp values(?,?,?,?,?,?,?,?,?,?)");

			pstmt.setInt(1, bank_id);

			pstmt.setString(2, bank_name);

			pstmt.setString(3, ifsc_code);

			pstmt.setInt(4, accno);

			pstmt.setInt(5, pin);

			pstmt.setInt(6, cust_id);

			pstmt.setString(7, cust_name);

			pstmt.setInt(8, balance);

			pstmt.setString(9, email);

			pstmt.setLong(10, phone);

			int x = pstmt.executeUpdate();

			if (x > 0) {
				return true;
				// resp.sendRedirect("/BankingAppProject/RegisterSucess.html");

			}

			else {
				return false;
				// resp.sendRedirect("/BankingAppProject/RegisterFail.html");

			}

		}

		catch (Exception e) {

			e.printStackTrace();

		}
		return false;

	}

	public boolean login() {
		String query="Select * from bankapp where cust_id=? and pin=?";
		try {
			PreparedStatement pstmt=con.prepareStatement(query);

			pstmt.setInt(1, cust_id);
			pstmt.setInt(2, pin);
			ResultSet rs=pstmt.executeQuery();
			
			if(rs.next()) {
				this.setCust_id(rs.getInt("cust_id"));
				this.setPin(rs.getInt("pin"));
				this.setBank_id(rs.getInt("bank_id"));
				this.setBank_name(rs.getString("bank_name"));
				this.setIfsc_code(rs.getString("ifsc_code"));
				this.setAccno(rs.getInt("accno"));
				this.setCust_name(rs.getString("cust_name"));
				this.setEmail(rs.getString("email"));
				this.setBalance(rs.getInt("balance"));
				this.setPhone(rs.getLong("phone"));
				
				return true;
			}
			else {
				return false;
			}
		}
			catch(Exception e) {
				e.printStackTrace();
			}
			return false;
	}
	public boolean CheckBalance() {
		String query="select balance from bankapp where cust_id=?";
		try {
			
			PreparedStatement pstmt = con.prepareStatement(query);
			pstmt.setInt(1, cust_id);
			ResultSet rs=pstmt.executeQuery();
			if(rs.next()) {
				this.setCust_id(rs.getInt("cust_id"));
				
				return true;
			}else {
				return false;
			}
			
		}catch(Exception e){
			e.printStackTrace();
		}
		return false;
	}
	
	public boolean ChangePin( int New_pin) {
		String query="update bankapp set pin=? where cust_id=? and accno=?";
		try {
			
			PreparedStatement pstmt = con.prepareStatement(query);
			pstmt.setInt(1, New_pin);
			pstmt.setInt(2, cust_id);
			pstmt.setInt(3, accno);
			int x=pstmt.executeUpdate();
			if(x>0) {
				
				return true;
			}else {
				return false;
			}
			
		}catch(Exception e){
			e.printStackTrace();
		}
		return false;
	}

	public boolean Transferamount(int cust_id, int sender_accno, String ifsc, int amount, int receiver_accno,
			String receiver_ifsc, int pin) {
		
		String query = "SELECT * FROM BankUser WHERE accountNumber = ? AND ifscCode = ?";
		PreparedStatement ps;
		ResultSet rs;
		try {
			ps = con.prepareStatement(query);
			ps.setInt(1, receiver_accno);
			ps.setString(2, receiver_ifsc);

			rs = ps.executeQuery();
			if (rs.next()) {
				query = "UPDATE BankUser SET balance = balance - ? where accountNumber = ? and ifscCode = ?";
				ps.clearBatch();
				ps = con.prepareStatement(query);
				ps.setInt(1, amount);
				ps.setInt(2, sender_accno);
				ps.setString(3, ifsc);

				int statusCode = ps.executeUpdate();
				if (statusCode > 0) {
					query = "UPDATE BankUser SET balance = balance + ? WHERE accountNumber = ? and ifscCode = ?";
					ps.clearBatch();
					ps = con.prepareStatement(query);
					ps.setInt(1, amount);
					ps.setInt(2, receiver_accno);
					ps.setString(3, receiver_ifsc);

					statusCode = ps.executeUpdate();
					if (statusCode > 0) {
						ps.clearBatch();
						Long transactionID = 0L;
						while (true) {
							transactionID = (long) (Math.random() * (999999999999999L - 100000000000000L)
									+ 100000000000000L);
							query = "SELECT * FROM transactions WHERE transactionID = ?";
							ps = con.prepareStatement(query);
							ps.setLong(1, transactionID);

							rs = ps.executeQuery();
							if (rs.next()) {
								continue;
							}
							break;
						}

						query = "INSERT INTO transactions VALUES (?, ?, ?, ?, ?, ?, ?, ?)";
						ps.clearBatch();

						ps = con.prepareStatement(query);
						ps.setInt(1, cust_id);
						ps.setString(2, bank_name);
						ps.setString(3, ifsc);
						ps.setInt(4, sender_accno);
						ps.setString(5, receiver_ifsc);
						ps.setInt(6, receiver_accno);
						ps.setInt(7, amount);
						ps.setLong(8, transactionID);

						statusCode = ps.executeUpdate();
						if (statusCode > 0) {
							return true;
						}
					}
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return false;
	}
}