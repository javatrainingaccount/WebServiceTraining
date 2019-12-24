package com.example.trainingProject3;

public class InvalidRequestException extends Exception {
	private String code;

	public InvalidRequestException(String code, String message) {
		super(message);
		this.code = code;
	}
}
