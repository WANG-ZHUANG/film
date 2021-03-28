package com.my.blogs.exception;

import lombok.Data;

@Data
public class DataTranctionException extends Exception{
	/**
	 * 
	 */
	private static final long serialVersionUID = 3779824607404021779L;
	private Integer code;
	private String errMsg;
	
	public DataTranctionException(int code,String errMsg) {
		super(errMsg);
		this.code = code;
		this.errMsg = errMsg;
	}
}
