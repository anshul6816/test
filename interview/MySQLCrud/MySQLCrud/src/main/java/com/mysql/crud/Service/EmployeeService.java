package com.mysql.crud.Service;

import java.util.List;

import com.mysql.crud.Entity.Employee;
import com.mysql.crud.Exception.ResourceNotFoundException;


public interface EmployeeService {
	
	public Employee newEmployee(Employee emp);
	public Employee getEmployeeById(String id) throws ResourceNotFoundException;
	public List<Employee> getAllEmployees();
	public Employee updateEmployee(Employee emp) throws ResourceNotFoundException;
	public void removeEmployee(String empId) throws ResourceNotFoundException;
	
	

}
