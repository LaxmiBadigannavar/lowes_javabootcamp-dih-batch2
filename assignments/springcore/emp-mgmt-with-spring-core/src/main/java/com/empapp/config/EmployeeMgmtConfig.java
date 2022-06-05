package com.empapp.config;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.concurrent.ExecutorService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;
import org.springframework.context.annotation.Scope;

import com.empapp.Exception.EmpNotFoundException;
import com.empapp.dao.EmployeeDaoImpl;
import com.empapp.model.Employee;
import com.empapp.service.EmployeeServiceImpl;
import com.mysql.cj.jdbc.MysqlDataSource;

@Configuration
public class EmployeeMgmtConfig {
	@Bean
	public Employee employee() {
		return new Employee();
	}
	@Bean
	EmployeeServiceImpl empservice() {
		 return new EmployeeServiceImpl(new EmployeeDaoImpl());
	}
	
	@Bean(initMethod = "getConnection")
	EmployeeDaoImpl empimpl() {
		return new EmployeeDaoImpl(); 
	}
	
	@Bean
	EmpNotFoundException e() {
		return new EmpNotFoundException();
	}
	
	//public void init() {
		//System.out.println("Initialise Method");
		
	//}
		public void getConnection() {
		Connection conn = null;
		Statement stmt = null;
		MysqlDataSource dataSource = new MysqlDataSource();
		dataSource.setDatabaseName("jdbctraining");
		dataSource.setUser("training");
		dataSource.setPassword("training");
		dataSource.setServerName("localhost");

		
		System.out.println("Connecting to database...");
		try {
			conn = dataSource.getConnection();
			System.out.println("Connection estabilished: " + conn);
			System.out.println("Creating statement...");
			stmt = conn.createStatement();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	
		

	}
	
	
	
}
