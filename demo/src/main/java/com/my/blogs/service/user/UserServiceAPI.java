package com.my.blogs.service.user;

import com.my.blogs.controller.user.vo.EnrollUserVO;
import com.my.blogs.exception.CommonServiceExcetion;
import com.my.blogs.exception.DataTranctionException;

public interface UserServiceAPI {
	//用户注册
	void userEnroll(EnrollUserVO enrollUserVO ) throws DataTranctionException;
	//用户名校验
	boolean checkUserName(String userName) throws CommonServiceExcetion;
	//密码验证
	boolean userAuth(String userName , String userPwd) throws CommonServiceExcetion;
	//获取用户信息
}
