package com.api.salareunioes.exception;

import java.io.Serializable;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

/***
 * 
 * @author dionatan
 *
 */

@ResponseStatus(value=HttpStatus.NOT_FOUND)
public class ResourceNotFoundException extends Exception implements Serializable {
	
	private static final long serialVersionUID = 1L;
	
	public 	ResourceNotFoundException(String message) {
		super(message);
	}
	
}
