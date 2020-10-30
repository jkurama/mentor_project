package com.eg.mod.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value = HttpStatus.NOT_FOUND)
public class ResourceExistException extends RuntimeException {

	private static final long serialVersionUID = 1L;
	private Exception ex;

	public ResourceExistException(String message) {
		super(message);
	}

	public ResourceExistException(Exception e, String message) {
		super(message);
		ex = e;
	}

	public Exception getEx() {
		return ex;
	}
}
