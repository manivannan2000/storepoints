package com.storepoints.service.exception;

public class StoreTypeMissingException extends Exception {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	public StoreTypeMissingException(){
		super();
	}
	
	public StoreTypeMissingException(String message){
		super(message);
	}
	
}
