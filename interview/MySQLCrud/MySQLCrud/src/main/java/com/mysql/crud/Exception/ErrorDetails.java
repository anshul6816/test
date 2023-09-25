package com.mysql.crud.Exception;

public class ErrorDetails {

	private int status;
	private String message;

	public ErrorDetails(int status, String message) {
		super();
		this.status = status;
		this.message = message;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public ErrorDetails() {
		super();
	}

	public int getStatus() {
		return status;
	}

	public void setStatus(int status) {
		this.status = status;
	}

}
