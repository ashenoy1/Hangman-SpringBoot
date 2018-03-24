package com.hangman.entity;

public class CustomError implements Response{
	
	private String error;
	
	
	public CustomError(String statusMessage) {
		this.error = statusMessage;
	}

	public String getError() {
		return error;
	}
	
	public void setResponse(String statusMessage) {
		this.error = statusMessage;
	}
	
}
