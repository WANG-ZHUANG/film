package com.my.blogs.exception;

import lombok.Data;

@Data
public class ParamErrorException extends Exception{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1989478106049160662L;
	private Integer code;
	private String errMsg;
	
	public ParamErrorException(int code,String errMsg) {
		super(errMsg);
		this.code = code;
		this.errMsg = errMsg;
	}
}
