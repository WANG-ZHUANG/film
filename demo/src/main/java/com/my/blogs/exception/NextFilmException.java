package com.my.blogs.exception;

import lombok.Data;

@Data
public class NextFilmException extends Exception{

    /**
	 * 
	 */
	private static final long serialVersionUID = 4118534956626428242L;
	private Integer code;
    private String errMsg;

    public NextFilmException(int code, String errMsg){
        super(errMsg);
        this.code = code;
        this.errMsg = errMsg;
    }

}
