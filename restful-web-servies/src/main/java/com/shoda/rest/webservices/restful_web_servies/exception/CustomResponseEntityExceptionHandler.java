package com.shoda.rest.webservices.restful_web_servies.exception;

import java.time.LocalDateTime;

import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.lang.Nullable;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import com.shoda.rest.webservices.restful_web_servies.user.UserNotFoundException;

//This class will be pickedup by Spring only when we add this
@ControllerAdvice
public class CustomResponseEntityExceptionHandler extends ResponseEntityExceptionHandler {
	
	//What kind of Exceptions shoud be handled 
	@ExceptionHandler(Exception.class)  // Handle All Exception
	public final ResponseEntity<ErrorDetails> handleAllException(Exception ex, WebRequest request) throws Exception
	{
		//Our Custom errordetails class format
		ErrorDetails errorDetails = new ErrorDetails(LocalDateTime.now(), ex.getMessage(), request.getDescription(false) );
		
		//Handling it as INTERNAL ERROR i.e 500 status code
		return new ResponseEntity<ErrorDetails>(errorDetails,HttpStatus.INTERNAL_SERVER_ERROR);
		/*
				O/p:  Response : 500
			{
			"timeStamp": "2024-08-23T19:27:51.5284248",
			"message": "id  :22",
			"details": "uri=/users/22"
		 */
	}
	
	
	
	// Now we need to handle indivual exception differently 
	@ExceptionHandler(UserNotFoundException.class)  // Handle All Exception
	public final ResponseEntity<ErrorDetails> handleUserNotFoundException(Exception ex, WebRequest request) throws Exception
	{
		//Our Custom errordetails class format
		ErrorDetails errorDetails = new ErrorDetails(LocalDateTime.now(), ex.getMessage(), request.getDescription(false) );
		
		//Handling it as NOT_FOUND i.e 404 status code
		return new ResponseEntity<ErrorDetails>(errorDetails,HttpStatus.NOT_FOUND);
		/*
				O/p:  Response : 404
			{
			"timeStamp": "2024-08-23T19:27:51.5284248",
			"message": "id  :22",
			"details": "uri=/users/22"
		 */
	}
	
	
	//Override "handleMethodArgumentNotValid" when user Provides wrong / missing fields
	@Override
	@Nullable
	protected ResponseEntity<Object> handleMethodArgumentNotValid(
			MethodArgumentNotValidException ex, HttpHeaders headers, HttpStatusCode status, WebRequest request) {

		//Our Custom errordetails class format
		ErrorDetails errorDetails = new ErrorDetails(LocalDateTime.now(), ex.getFieldError().getDefaultMessage(), request.getDescription(false) );
				
		//Handling it as NOT_FOUND i.e 404 status code
		return new ResponseEntity(errorDetails,HttpStatus.BAD_REQUEST);
	}

}


