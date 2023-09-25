package com.form.Controller;

import java.util.Date;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.form.Entity.Person;
import com.form.Service.PersonService;

import jakarta.validation.Valid;



@RestController
public class PersonController {
	
	@Autowired
	private PersonService personService;
	

	//API TO CREATE A NEW PERSON
	@PostMapping("/person")
	ResponseEntity<Person> createEmployee(@Valid @RequestBody Person thePerson) {
		
	
        return ResponseEntity.status(HttpStatus.CREATED).body(this.personService.createPerson(thePerson));
    } 
	
	//API TO GET ALL PERSONS (USED PAGING AND SORTING)
	@GetMapping("/person/page")
	public ResponseEntity<Map<String,Object>> getAllPersonInPage(@RequestParam(name = "pageno", defaultValue= "0") int pageNo,
										@RequestParam(name = "pagesize", defaultValue= "3") int pageSize,
										@RequestParam(name = "sortby", defaultValue= "id") String sortBy){
						
		return 	ResponseEntity.status(HttpStatus.FOUND).body(personService.getAllPersonInPage(pageNo,pageSize,sortBy));
	}
	

	
	//API TO GET ALL PERSONS THAT HAVE JOINED BETWEEN TWO DATES
	@GetMapping("/person/page/dateOfJoining")
	public ResponseEntity<Map<String,Object>> getAllPersonByDateOfJoiningBetween(@RequestParam(name = "from") @DateTimeFormat(pattern="yyyy-MM-dd") Date dateOfJoiningFrom,
			@RequestParam(name = "to") @DateTimeFormat(pattern="yyyy-MM-dd") Date dateOfJoiningTo,
			@RequestParam(name = "pageno", defaultValue= "0") int pageNo,
			@RequestParam(name = "pagesize", defaultValue= "3") int pageSize,
			@RequestParam(name = "sortby", defaultValue= "id") String sortBy){
		
		
		return ResponseEntity.status(HttpStatus.FOUND).body(personService.getAllPersonByDateOfJoiningBetween(dateOfJoiningFrom, dateOfJoiningTo, pageNo, pageSize, sortBy));
	}
	
	//API TO UPDATE PERSON INFO USING ID
    @PutMapping("/person/{id}")
    public ResponseEntity<Person> updatePerson(@PathVariable String id, @RequestBody Person thePerson) {
        thePerson.setId(id);
        return ResponseEntity.status(HttpStatus.ACCEPTED).body(this.personService.updatePerson(thePerson));
    }
    
    //API TO DELETE ALL PERSONS THAT BELONGS TO A SPECIFIC BRANCH
    @DeleteMapping("/person/{branch}")
    public HttpStatus deletePerson(@PathVariable String branch) {
        this.personService.deletePerson(branch);
        return HttpStatus.OK;
    }
}
