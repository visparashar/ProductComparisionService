package com.relayr.productcomparisonservice.exceptions;

public class CategoryNotFoundException extends Exception {

	/**
	 * 
	 */
	private static final long serialVersionUID = 4601556626105320434L;

	public CategoryNotFoundException() {
		super("No Category Found in data store");
	}
	
	public CategoryNotFoundException(String message) {
		super(message);
	}
	
}
