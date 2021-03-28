package com.my.blogs.controller;

import com.my.blogs.exception.ParamErrorException;

public abstract class BaseVO {
	public abstract void checkParam() throws ParamErrorException;
}
