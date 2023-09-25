package com.mongoDB.crud.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.mongoDB.crud.Entity.Employee;
import com.mongoDB.crud.Exception.ResourceNotFound;
import com.mongoDB.crud.Service.EmployeeService;

@RestController
@RequestMapping("emp")
public class EmployeeController {

	@Autowired
	private EmployeeService employeeService;
	
	
	@PostMapping("/create")
	ResponseEntity<Employee> newEmployee(@RequestBody Employee newEmp){
		
		employeeService.newEmployee(newEmp);
		return ResponseEntity.status(HttpStatus.CREATED).body(newEmp);
	} 
	
	
	@GetMapping("/read/{empName}")
	ResponseEntity<Employee> getEmployee(@PathVariable String empName) throws ResourceNotFound{
		
		Employee employeeByName = employeeService.getEmployeeByName(empName);
		return ResponseEntity.status(HttpStatus.FOUND).body(employeeByName);
	}

	@GetMapping("/readAll")
	ResponseEntity<List<Employee>> getAllEmployee(){
		
		List<Employee> allEmployees = employeeService.getAllEmployees();
		return ResponseEntity.status(HttpStatus.FOUND).body(allEmployees);
	}
	
	@PutMapping("/update")
	ResponseEntity<Employee> updateEmployee(@RequestBody Employee updateEmp) throws ResourceNotFound{
		
		Employee updateEmployee = employeeService.updateEmployee(updateEmp);
		return ResponseEntity.status(HttpStatus.ACCEPTED).body(updateEmp);
	}
	
	@DeleteMapping("/delete")
	void deleteEmployee(@RequestParam(name="empId") String empId) throws ResourceNotFound{
		
		employeeService.deleteEmployee(empId);
	}
	


}



