package com.bolsadeideas.springboot.backend.apirest.exceptions;

public class ElementNotFound extends RuntimeException {

	private static final long serialVersionUID = -6006502567800415172L;

	public ElementNotFound(String cause) {
		super(cause);
	}
}
