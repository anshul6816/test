package com.mongoDB.crud.Service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.mongoDB.crud.Entity.Employee;
import com.mongoDB.crud.Exception.ResourceNotFound;


public interface EmployeeService {

	public Employee newEmployee(Employee emp );
	public Employee getEmployeeByName(String name)throws ResourceNotFound;
	public List<Employee> getAllEmployees();
	public Employee updateEmployee(Employee emp)throws ResourceNotFound;
	public void deleteEmployee(String id)throws ResourceNotFound;
}
