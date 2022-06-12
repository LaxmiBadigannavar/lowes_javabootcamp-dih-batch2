package com.spring.boot.empapp.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.spring.boot.empapp.model.Employee;

public interface EmployeeRepository extends JpaRepository<Employee, Integer>{

}
