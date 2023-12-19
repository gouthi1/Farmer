package com.marolix.dhalary.exception;

import java.time.LocalDateTime;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;


@RestControllerAdvice
public class GlobalException {
	
	@ExceptionHandler(value = UserNotFountException.class)
	public ResponseEntity<AppException> usernotfound(UserNotFountException e)
	{
		String msg= e.getMessage();
	
		AppException exception=new AppException();
		
		exception.setMsg(msg);
		exception.setCode(HttpStatus.BAD_REQUEST.value());
		exception.setTime(LocalDateTime.now());
	
		return new ResponseEntity<AppException>(exception,HttpStatus.BAD_REQUEST);	
	}
	
	@ExceptionHandler(value = EmptyDataException.class)
	public ResponseEntity<AppException> emptyData(EmptyDataException e)
	{
		
		String msg= e.getMessage();
         AppException exception=new AppException();
		
		exception.setMsg(msg);
		exception.setCode(HttpStatus.NO_CONTENT.value());;
		exception.setTime(LocalDateTime.now());
		
		return new ResponseEntity<AppException>(exception,HttpStatus.NO_CONTENT);
	}
	
	//@ExceptionHandler(value = Exception.class)
	public ResponseEntity<AppException> internalException(Exception e)
	{
		
		String msg= e.getMessage();
         AppException exception=new AppException();
		
		exception.setMsg(msg);
		exception.setCode(HttpStatus.INTERNAL_SERVER_ERROR.value());
		exception.setTime(LocalDateTime.now());
		
		return new ResponseEntity<AppException>(exception,HttpStatus.INTERNAL_SERVER_ERROR);
	}

}
