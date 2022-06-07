package com.examples.empapp.dao;

import com.examples.empapp.model.User;
import com.mysql.cj.jdbc.MysqlDataSource;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;


public class UserDaoImpl {
	
	Connection conn = null;
	Statement stmt = null;
	PreparedStatement prestmt = null;
	ResultSet rs = null;
	public List<User> usersList = new ArrayList<>();
	  private void getConnection() {
		  MysqlDataSource dataSource = new MysqlDataSource(); 
		  dataSource.setDatabaseName("jdbctraining");
		  dataSource.setUser("training"); dataSource.setPassword("training");
		  dataSource.setServerName("localhost");
	  
	  
	  System.out.println("Connecting to database..."); try { conn =
	  dataSource.getConnection(); System.out.println("Connection estabilished: " +
	  conn); System.out.println("Creating statement..."); 
	  stmt =conn.createStatement(); 
	  } catch (SQLException e) { // TODO Auto-generated
		  e.printStackTrace(); }
	  
	 }
	  
	  public void insertUser(User user) {
			try {
				if(stmt==null) {
					getConnection();
				}
				String insertQueryForPrepareStmt = "INSERT INTO users (username,loginid,password,email) VALUES (?,?,?,?)";
				prestmt = conn.prepareStatement(insertQueryForPrepareStmt);
				prestmt.setString(1,null);
				prestmt.setString(2,user.getUserName());
				prestmt.setString(3,user.getPassword());
				prestmt.setString(4,null);
				
				int insertCount = prestmt.executeUpdate();
				System.out.println(prestmt);
				prestmt.close();
				System.out.println(insertCount + " Employee(s) inserted");
			}

			catch (SQLException se) {
				// Handle errors for JDBC
				se.printStackTrace();

			}

		}
	  
	  public List<User> getUsers() {
			if(stmt==null) {
				getConnection();
			}
			String selectQuery = "SELECT loginid,password FROM users";
			User user = new User();
			System.out.println("Query excuting::" + selectQuery);
			List<User> usersList = new ArrayList<>();
			try {
				rs = stmt.executeQuery(selectQuery);
				
				while (rs.next()) {
					// Retrieve by column name
					String loginid = rs.getString("loginid");
					String password = rs.getString("password");
					//user.setUserName(loginid);
					//user.setPassword(password);
					System.out.println("DAo output: "+loginid);
					usersList.add(new User(loginid,password));
					//System.out.println("UserList:"+user);
				}
				
				
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
			return usersList;
	
		}
	  
	  
	  
	  
	  
}
