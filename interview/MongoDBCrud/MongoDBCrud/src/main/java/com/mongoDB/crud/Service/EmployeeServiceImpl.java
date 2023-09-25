package com.mongoDB.crud.Service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import com.mongoDB.crud.Entity.Employee;
import com.mongoDB.crud.Exception.ResourceNotFound;
import com.mongoDB.crud.Repository.EmployeeRepository;

@Service
public class EmployeeServiceImpl implements EmployeeService{

	@Autowired
	private EmployeeRepository employeeRepository;
	
	@Override
	public Employee newEmployee(Employee emp) {
		employeeRepository.save(emp);
		return emp;
	}

	@Override
	public Employee getEmployeeByName(String name) throws ResourceNotFound {
	Employee empDetail = employeeRepository.findByEmpName(name);
					  
	if(empDetail== null) {
		
		throw new ResourceNotFound("Resource Not found for Given Name");
	}
	else
		return empDetail;
	
	
	
	}

	@Override
	public List<Employee> getAllEmployees() {
	
		return employeeRepository.findAll();
	}

	@Override
	public Employee updateEmployee(Employee emp) throws ResourceNotFound {
	
		Employee empDetails = employeeRepository.findById(emp.getEmpId())
						 .orElseThrow( () -> new ResourceNotFound("Resource Not found for Given Id"));
		
		Employee updateEmployee=  new Employee();
		
		updateEmployee.setEmpId(emp.getEmpId());
		updateEmployee.setEmpName(emp.getEmpName());
		updateEmployee.setEmpAge(emp.getEmpAge());
		updateEmployee.setEmpDoB(emp.getEmpDoB());
		
		return employeeRepository.save(updateEmployee);
	}

	@Override
	public void deleteEmployee(String id) throws ResourceNotFound {
		Employee empDetails = employeeRepository.findById(id)
				 .orElseThrow( () -> new ResourceNotFound("Resource Not found for Given Id"));
		
		employeeRepository.deleteById(id);
	}

}
