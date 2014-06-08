package com.storepoints.service.exception;

public class StorePointsServiceException extends Exception {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	public StorePointsServiceException(){
		super();
	}

	
	public StorePointsServiceException(String message){
		super(message);
	}
}
