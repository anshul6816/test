package com.form.Entity;

import java.util.Date;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import com.fasterxml.jackson.annotation.JsonFormat;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Size;

@Document(value = "Person")
public class Person {

	@Id
	private String id;

	@NotBlank(message = "Please enter proper employee name")
	private String email;
	@NotEmpty(message="First Name must Not be Empty")
	private String firstName;
	private String lastName;
	@Size(min = 5, message = "Name should be atleast 5 characters")
	private String branch;
	@JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd")
	private Date dob;
	@JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd")
	private Date dateOfJoining;

	public Person() {
		super();
	}

	public Person(String email, String firstName, String lastName, String branch, Date dob, Date dateOfJoining) {
		super();
		this.email = email;
		this.firstName = firstName;
		this.lastName = lastName;
		this.branch = branch;
		this.dob = dob;
		this.dateOfJoining = dateOfJoining;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getBranch() {
		return branch;
	}

	public void setBranch(String branch) {
		this.branch = branch;
	}

	public Date getDob() {
		return dob;
	}

	public void setDob(Date dob) {
		this.dob = dob;
	}

	public Date getDateOfJoining() {
		return dateOfJoining;
	}

	public void setDateOfJoining(Date dateOfJoining) {
		this.dateOfJoining = dateOfJoining;
	}
}
