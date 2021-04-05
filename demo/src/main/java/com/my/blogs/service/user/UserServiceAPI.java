package com.my.blogs.service.user;

import com.my.blogs.controller.user.vo.EnrollUserVO;
import com.my.blogs.controller.user.vo.UserInfoVO;
import com.my.blogs.exception.CommonServiceExcetion;
import com.my.blogs.exception.DataTranctionException;
import com.my.blogs.exception.ParamErrorException;

public interface UserServiceAPI {
	//用户注册
	void userEnroll(EnrollUserVO enrollUserVO ) throws CommonServiceExcetion;
	//用户名校验
	boolean checkUserName(String userName) throws CommonServiceExcetion;
	//密码验证
	boolean userAuth(String userName , String userPwd) throws CommonServiceExcetion;
	//获取用户信息
	UserInfoVO describeUserInfo(String userId) throws CommonServiceExcetion;
	//更新用户信息
	UserInfoVO updateUserInfo(UserInfoVO userInfoVO) throws CommonServiceExcetion;
}
