package com.main.exception;

public class MarksException extends Exception{
	private static final long serialVersionUID = 8306621221763287325L;
	private String message;

	public MarksException(String message) {
		super();
		this.message = message;
	}

	public String getMessage() {
		return message;
	}
	
	
}
