package com.stage.demo.exception;

import org.springframework.http.*;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value =HttpStatus.NOT_FOUND)
public class ResourceNoFoundException extends RuntimeException{

	private static final long serialVersionUID = 1L;
	public  ResourceNoFoundException(String message) {
		super("Ressource not found");
	}

}
