package com.my.blogs.controller.user;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.my.blogs.controller.user.vo.EnrollUserVO;
import com.my.blogs.dto.Response;
import com.my.blogs.exception.CommonServiceExcetion;
import com.my.blogs.exception.DataTranctionException;
import com.my.blogs.exception.NextFilmException;
import com.my.blogs.exception.ParamErrorException;
import com.my.blogs.service.user.UserServiceAPI;
import com.my.blogs.utils.ToolUtils;

@RestController
@RequestMapping(value = "/user/")
public class UserController {
	@Autowired
	private UserServiceAPI userService;
	
	//用户名验证
	@RequestMapping(value = "check" , method = RequestMethod.POST)
	public Response checkUser(String userName) throws CommonServiceExcetion, NextFilmException {
		if(ToolUtils.isNullOrEmpty(userName)) throw new NextFilmException(1,"userName不能为空！");
		boolean isSuccess = userService.checkUserName(userName);
		if(isSuccess) return Response.success();
		return Response.serviceFailed("用户名已存在");
	}
	
	//用户注册
	@RequestMapping(value = "register" , method = RequestMethod.POST)
	public Response register(@RequestBody EnrollUserVO enrollUserVO) throws ParamErrorException, CommonServiceExcetion {
		enrollUserVO.checkParam();
		userService.userEnroll(enrollUserVO);
		return Response.success();
		
	}
}
