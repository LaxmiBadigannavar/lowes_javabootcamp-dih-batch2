module employee_mgmt_spring_boot {
	exports com.empapp.dao;
	exports com.empapp.interceptor;
	exports com.empapp.test;
	exports createCalculator;
	exports com.empapp.exception;
	exports com.empapp.main;
	exports com.empapp.config;
	exports assignment.arrays;
	exports com.empapp.validator;
	exports com.empapp;
	exports com.empapp.controller;
	exports assignments.day1;
	exports com.empapp.model;
	exports com.empapp.service;
	exports com.empapp.Exception;

	requires emp.mgmt.with.spring.core;
	requires java.sql;
	requires mysql.connector.java;
	requires slf4j.api;
	requires spring.beans;
	requires spring.context;
	requires spring.core;
	requires spring.web;
	requires spring.webmvc;
}