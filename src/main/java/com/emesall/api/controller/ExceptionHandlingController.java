package com.emesall.api.controller;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.client.HttpClientErrorException.NotFound;
import org.springframework.web.client.HttpClientErrorException.UnsupportedMediaType;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import com.emesall.api.exception.ResourceNotFoundException;

@ControllerAdvice
public class ExceptionHandlingController extends ResponseEntityExceptionHandler {

	@ExceptionHandler(value = NotFound.class)
	@ResponseBody
    @ResponseStatus(HttpStatus.NOT_FOUND)
	public ResourceNotFoundException handleNotFoundException(Exception ex) {
		return new ResourceNotFoundException("404","User not Found");
		
	}
	
	@ExceptionHandler(value = UnsupportedMediaType.class)
	@ResponseBody
    @ResponseStatus(HttpStatus.NOT_ACCEPTABLE)
	public ResourceNotFoundException handleNotAcceptableException(Exception ex) {
		return new ResourceNotFoundException("406","Unsupported media type, please use application/json");
		
	}
	
	

}
