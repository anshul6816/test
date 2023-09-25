package com.mysql.crud.Service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.mysql.crud.Entity.Employee;
import com.mysql.crud.Exception.ResourceNotFoundException;
import com.mysql.crud.Repository.EmpRepository;

@Service
public class EmpServiceImpl implements EmployeeService {

	@Autowired
	private EmpRepository empRepository;
	
	

	@Override
	public Employee newEmployee(Employee emp) {

		empRepository.save(emp);
		return emp;
	}

	
	@Override
	public Employee getEmployeeById(String empId) throws ResourceNotFoundException{
		
		Employee emp = empRepository.findById(empId)
									.orElseThrow( 
													() ->  new ResourceNotFoundException("Employee Id not Found!!!!!!")
												);					     
		return emp;
	}

	
	@Override
	public List<Employee> getAllEmployees() {

		List<Employee> findAllEmployees = empRepository.findAll();
		return findAllEmployees;
	}

	
	@Override
	public void removeEmployee(String empId) throws ResourceNotFoundException {
		
		Employee emp = empRepository.findById(empId)
				   .orElseThrow( 
						   			() ->  new ResourceNotFoundException("Employee Id not Found!!!!!!")
						   		);	
		
		empRepository.deleteById(empId);
	}

	@Override
	public Employee updateEmployee(Employee emp) throws ResourceNotFoundException {

		Employee updateEmployee= new Employee();
		empRepository.findById(emp.getEmpId())
					 .orElseThrow(
										() -> new ResourceNotFoundException("Employee Id not Found!!!!!!")
								  );
		updateEmployee.setEmpId(emp.getEmpId());
		updateEmployee.setEmpName(emp.getEmpName());
		updateEmployee.setEmpAge(emp.getEmpAge());
		updateEmployee.setEmpDoB(emp.getEmpDoB());
		
		empRepository.save(updateEmployee);
		return updateEmployee;
	}

}
