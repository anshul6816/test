package com.mysql.crud.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.mysql.crud.Entity.Employee;

@Repository
public interface EmpRepository extends JpaRepository<Employee,String> {


}
