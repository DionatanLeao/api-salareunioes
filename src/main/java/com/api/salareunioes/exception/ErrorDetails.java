package com.api.salareunioes.exception;

import java.util.Date;

import lombok.AllArgsConstructor;
import lombok.Getter;

/***
 * 
 * @author dionatan
 *
 */

@Getter
@AllArgsConstructor
public class ErrorDetails {
	
	private Date timestamp;
	private String message;
	private String details;
}
