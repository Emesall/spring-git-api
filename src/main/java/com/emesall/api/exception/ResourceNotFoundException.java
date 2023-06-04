package com.emesall.api.exception;

import lombok.Data;

@Data
public class ResourceNotFoundException {

	private String status;
	private String message;

	public ResourceNotFoundException() {
	}

	public ResourceNotFoundException(String status, String message) {
		this.status = status;
		this.message = message;
	}

}