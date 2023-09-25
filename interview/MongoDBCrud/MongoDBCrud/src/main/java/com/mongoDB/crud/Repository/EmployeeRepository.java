package com.mongoDB.crud.Repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import com.mongoDB.crud.Entity.Employee;
import com.mongoDB.crud.Exception.ResourceNotFound;

@Repository
public interface EmployeeRepository extends MongoRepository<Employee, String>{

	public Employee findByEmpName(String name);

}
