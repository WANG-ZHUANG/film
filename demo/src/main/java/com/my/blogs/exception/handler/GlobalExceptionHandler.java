package com.my.blogs.exception.handler;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;

import com.my.blogs.dto.Response;
import com.my.blogs.exception.CommonServiceExcetion;
import com.my.blogs.exception.NextFilmException;
import com.my.blogs.exception.ParamErrorException;

@ControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(NextFilmException.class)
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    @ResponseBody
    public Response nextFilmException(NextFilmException e){
        return Response.serviceFailed(e.getErrMsg());
    }

	@ExceptionHandler(CommonServiceExcetion.class)
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    @ResponseBody
    public Response commonServiceException(CommonServiceExcetion e){
        return Response.serviceFailed(e.getCode(),e.getErrMsg());
    }

    @ExceptionHandler(ParamErrorException.class)
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    @ResponseBody
    public Response paramErrorException(ParamErrorException e){
        return Response.serviceFailed(e.getCode(),e.getErrMsg());
    }


    @ExceptionHandler(Exception.class)
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    @ResponseBody
    public Response exception(ExceptionHandler e){
        return Response.systemError();
    }
}
