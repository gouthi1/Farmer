package com.marolix.dhalary.exception;

public class UserNotFountException  extends RuntimeException{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public UserNotFountException()
	{
		
	}
	
	public UserNotFountException(String msg)
	{
		super(msg);
	}
}
