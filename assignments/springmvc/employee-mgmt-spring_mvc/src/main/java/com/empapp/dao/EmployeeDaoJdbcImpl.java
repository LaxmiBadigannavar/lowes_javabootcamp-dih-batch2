package com.empapp.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.StringTokenizer;

import org.springframework.context.annotation.Configuration;

import com.empapp.model.Employee;
import com.empapp.service.EmployeeService;
import com.mysql.cj.jdbc.MysqlDataSource;
import com.mysql.cj.xdevapi.PreparableStatement;

public class EmployeeDaoJdbcImpl implements EmployeeDao {

	MysqlDataSource datasource = null;
	Connection conn = null;
	Statement stmt = null;
	ResultSet rs = null;
	PreparedStatement prestmt = null;

	public void getConnection() {
		datasource = new MysqlDataSource();
		datasource.setServerName("localhost");
		datasource.setDatabaseName("jdbctraining");
		datasource.setUser("training");
		datasource.setPassword("training");

		try {
			conn = datasource.getConnection();
			System.out.println("Connection created successfully. " + conn);
			System.out.println("Creating statement...");
			stmt = conn.createStatement();

		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	public void insertTable(Employee emp) {
		try {
			if (stmt == null) {
				getConnection();
			}
			String insertQueryForPrepareStmt = "INSERT INTO emp5 (name,age,gender,contractor,skills,designation,department,address,country) VALUES (?, ?, ?,?,?, ?, ?,?,?)";
			System.out.println(insertQueryForPrepareStmt);

			System.out.println("Connection for test:" + conn);
			System.out.println(conn.prepareStatement(insertQueryForPrepareStmt));
			String contractor = null;
			if (emp.isContractor() == true) {
				contractor = "true";
			} else {
				contractor = "false";
			}
			String skills;
			if (emp.getSkills().size() != 0) {
				skills = emp.getSkills().toString();
				// System.out.println("Skills:"+skills);
			} else {
				skills = "No skills Updated";
			}
			// System.out.println("contractor value:"+contractor);
			prestmt = conn.prepareStatement(insertQueryForPrepareStmt);
			prestmt.setString(1, emp.getName());
			prestmt.setInt(2, emp.getAge());
			prestmt.setString(3, emp.getGender());
			prestmt.setString(4, contractor);
			prestmt.setString(5, skills);
			prestmt.setString(6, emp.getDesignation());
			prestmt.setString(7, emp.getDepartment());
			prestmt.setString(8, emp.getAddress());
			prestmt.setString(9, emp.getCountry());
			System.out.println("Preparestatement: " + prestmt);
			int insertCount = prestmt.executeUpdate();
			prestmt.close();
			System.out.println(insertCount + " Employee(s) inserted");

		} catch (Exception e) {
			e.printStackTrace();
		}

	}

	public List<Employee> getAllEmployees() {
		if (stmt == null) {
			getConnection();
		}
		String selectQuery = "SELECT * FROM emp5";
		System.out.println("Query excuting::" + selectQuery);
		List<Employee> listEmp = new ArrayList<>();
		try {
			rs = stmt.executeQuery(selectQuery);
			while (rs.next()) {
				// Retrieve by column name
				int id = rs.getInt("id");
				String eid = String.valueOf(id);
				String name = rs.getString("name");
				int age = rs.getInt("age");
				String contractor = rs.getString("contractor");
				String skills = rs.getString("skills");
				// System.out.println(skills);
				// String skills = rs.getString("skills");

				List<String> listSkills = new ArrayList<String>();

				if (skills != null) {
					String[] ski = skills.split(",");
					listSkills = Arrays.asList(ski);
				}
				// System.out.println(listSkills);
				String gender = rs.getString("gender");
				String designation = rs.getString("designation");
				String department = rs.getString("department");
				boolean contract;
				if ((contractor != null) && (contractor.equals("true")))
					contract = true;
				else
					contract = false;

				listEmp.add(new Employee(eid, name, age, gender, contract, listSkills, designation, department,
						designation, department));
				// System.out.format("\t%s \t%d \t%s \t%s \t%s \t%s \t%s\n", eid, age, name,
				// gender, skills,contractor,designation,
				// department);

			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.println("listemp:: " + listEmp);
		return listEmp;
	}
	// get emp on id

	public Employee getEmployee(int empId) {
		if (stmt == null) {
			getConnection();
		}

		Employee emp = new Employee();
		List<Employee> listEmp = new ArrayList<>();
		String selectQuery = "SELECT * FROM emp5 where id =" + empId;
		// System.out.println("Query excuting::" + selectQuery);
		try {
			rs = stmt.executeQuery(selectQuery);

			while (rs.next()) {
				// Retrieve by column name
				int id = rs.getInt("id");
				String eid = String.valueOf(id);
				String name = rs.getString("name");
				int age = rs.getInt("age");
				String contractor = rs.getString("contractor");
				String skills = rs.getString("skills");
				// System.out.println(skills);
				// String skills = rs.getString("skills");

				List<String> listSkills = new ArrayList<String>();

				if (skills != null) {
					String[] ski = skills.split(",");
					listSkills = Arrays.asList(ski);
				}
				// System.out.println(listSkills);
				String gender = rs.getString("gender");
				String designation = rs.getString("designation");
				String department = rs.getString("department");
				boolean contract;
				if ((contractor != null) && (contractor.equals("true")))
					contract = true;
				else
					contract = false;
				// System.out.println("contractor valur::"+contract);

				// String [] ski= null;

				emp = new Employee(eid, name, age, gender, contract, listSkills, designation, department, designation,
						department);

			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return emp;
	}
	// update employee

	public void updateEmployee(Employee emp) {

		if (stmt == null) {
			getConnection();
		}
		try {
			// System.out.println("Update is called");
			String updateQuery = "UPDATE emp5 SET name = ? , age = ? ,gender = ?,contractor=?, skills=?, designation = ? , department = ? , address = ?, country=? WHERE id = ?";
			prestmt = conn.prepareStatement(updateQuery);
			String contractor = null;
			if (emp.isContractor() == true) {
				contractor = "true";
			} else {
				contractor = "false";
			}
			String skills;
			if (emp.getSkills().size() != 0) {
				skills = emp.getSkills().toString();
				System.out.println("Skills:" + skills);
			} else {
				skills = "No skills Updated";
			}
			// System.out.println("contractor value:"+contractor);

			prestmt.setString(1, emp.getName());
			prestmt.setInt(2, emp.getAge());
			prestmt.setString(3, emp.getGender());
			prestmt.setString(4, contractor);
			prestmt.setString(5, skills);
			prestmt.setString(6, emp.getDesignation());
			prestmt.setString(7, emp.getDepartment());
			prestmt.setString(8, emp.getAddress());
			prestmt.setString(9, emp.getCountry());
			prestmt.setInt(10, Integer.parseInt(emp.getId()));
			// System.out.println("Preparestatement: " + prestmt);

			int updateCount = prestmt.executeUpdate();
			System.out.println(updateCount + " Employee(s) updated");
			prestmt.close();
		} catch (SQLException e) {
			System.out.println("query not updating:" + e.getMessage());
		}
	}

	// delete employee
	public void deleteEmployee(int empid) {
		if (stmt == null) {
			getConnection();
		}
		String deleteQuery = "DELETE FROM emp5 WHERE id = ?";
		try {
			// getConnection();
			prestmt = conn.prepareStatement(deleteQuery);
			prestmt.setInt(1, empid);
			int deleteCount = prestmt.executeUpdate();
			prestmt.close();
			System.out.println(deleteCount + " Employee(s) deleted");
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

}