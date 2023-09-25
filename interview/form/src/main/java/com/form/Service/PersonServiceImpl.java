package com.form.Service;

import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import com.form.Entity.Person;
import com.form.Repository.PersonRepository;

@Service
public class PersonServiceImpl implements PersonService {
	
	@Autowired
	private PersonRepository personRepository;
	
	@Override
	public Person createPerson(Person thePerson) {
		
		return personRepository.save(thePerson);	
	}


	@Override
	public Map<String, Object> getAllPersonInPage(int pageNo, int pageSize, String sortBy) {
		
		Map<String, Object> response = new HashMap<String, Object>();	
		Sort sort = Sort.by(sortBy);		
		Pageable page = PageRequest.of(pageNo, pageSize, sort);	
		Page<Person> personInPage = personRepository.findAll(page);	
		response.put("data", personInPage.getContent());	
		response.put("Total no of page", personInPage.getTotalPages()); 
		response.put("Total no of elements", personInPage.getTotalElements());
		response.put("current page no", personInPage.getNumber()); 
		return response;
	}



	@Override
	public Map<String, Object> getAllPersonByDateOfJoiningBetween(Date dateOfJoiningFrom, Date dateOfJoiningTo,
			int pageNo, int pageSize, String sortBy) {

		Map<String, Object> response = new HashMap<String, Object>();
		Sort sort = Sort.by(sortBy);
		Pageable page = PageRequest.of(pageNo, pageSize, sort);
		Page<Person> personInPage = personRepository.findByDateOfJoiningBetween(dateOfJoiningFrom, dateOfJoiningTo, page);
		response.put("data", personInPage.getContent());
		response.put("Total no of page", personInPage.getTotalPages());
		response.put("Total no of elements", personInPage.getTotalElements());
		response.put("current page no", personInPage.getNumber());

		return response;
	}


	@Override
	public Person updatePerson(Person thePerson) {
	
		Optional<Person> personId = personRepository.findById(thePerson.getId());	
		Person updatePerson= personId.get();			

		updatePerson.setId(thePerson.getId());
		updatePerson.setEmail(thePerson.getEmail());
		updatePerson.setFirstName(thePerson.getFirstName());
		updatePerson.setLastName(thePerson.getLastName());
		updatePerson.setBranch(thePerson.getBranch());
		updatePerson.setDob(thePerson.getDob());
		updatePerson.setDateOfJoining(thePerson.getDateOfJoining());
		
		return personRepository.save(updatePerson); 
		
	
	}


	@Override
	public void deletePerson(String branch) {
		
		List<Person> deletePerson= personRepository.findByBranchStartingWith(branch);
		personRepository.deleteAll(deletePerson);
		
		
	}

	
	
	














}
