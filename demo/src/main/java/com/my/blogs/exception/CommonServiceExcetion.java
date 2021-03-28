package com.my.blogs.exception;

import lombok.Data;

@Data
public class CommonServiceExcetion extends Exception{
	/**
	 * 
	 */
	private static final long serialVersionUID = -3561092389467963076L;
	private Integer code;
	private String errMsg;
	
	public CommonServiceExcetion(int code,String errMsg) {
		super(errMsg);
		this.code = code;
		this.errMsg = errMsg;
	}
}
