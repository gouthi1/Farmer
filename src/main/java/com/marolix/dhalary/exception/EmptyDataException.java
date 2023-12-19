package com.marolix.dhalary.exception;

public class EmptyDataException extends NullPointerException {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public EmptyDataException()
	{
		
	}
	
	public EmptyDataException(String msg)
	{
		super(msg);
	}
}
