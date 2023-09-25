package com.form.Repository;

import java.util.Date;
import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import com.form.Entity.Person;

@Repository
public interface PersonRepository extends MongoRepository<Person, String>{


	List<Person> findByBranchStartingWith(String branch);
	
	Page<Person> findByDateOfJoiningBetween(Date dateOfJoiningFrom, Date dateOfJoiningTo, Pageable page);
	
}
