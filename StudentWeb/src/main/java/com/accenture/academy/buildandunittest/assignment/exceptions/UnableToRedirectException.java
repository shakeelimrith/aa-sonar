package com.accenture.academy.buildandunittest.assignment.exceptions;

public class UnableToRedirectException extends RuntimeException {

	private static final long serialVersionUID = -2984359565662801244L;

	public UnableToRedirectException(String errorMsg) {
		super(errorMsg);
	}
}
