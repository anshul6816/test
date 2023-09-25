package com.form.Service;

import java.util.Date;
import java.util.Map;

import com.form.Entity.Person;

public interface PersonService {
	
	//To create a person
	Person createPerson(Person thePerson);
	

	Map<String,Object> getAllPersonInPage(int pageNo, int pageSize, String sortBy);	
	
	// To get all person info page wise and only display only those persons info those have joined between dateOfJoiningFrom and dateOfJoiningTo.
	Map<String, Object> getAllPersonByDateOfJoiningBetween(Date dateOfJoiningFrom, Date dateOfJoiningTo, int pageNo, int pageSize, String sortBy);
	
	//To update a specific person info and save it into database
	Person updatePerson(Person thePerson);
	
	//To delete all persons that belongs to a specific branch
	void deletePerson(String id);
}
