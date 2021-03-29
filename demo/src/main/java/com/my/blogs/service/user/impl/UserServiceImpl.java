package com.my.blogs.service.user.impl;

import java.time.LocalDateTime;
import java.time.ZoneOffset;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.my.blogs.controller.user.vo.EnrollUserVO;
import com.my.blogs.controller.user.vo.UserInfoVO;
import com.my.blogs.dao.entity.NextUserT;
import com.my.blogs.dao.mapper.NextUserTMapper;
import com.my.blogs.exception.CommonServiceExcetion;
import com.my.blogs.exception.DataTranctionException;
import com.my.blogs.service.user.UserServiceAPI;
import com.my.blogs.utils.MD5Util;

@Service("userService")
public class UserServiceImpl implements UserServiceAPI{

	@Autowired
	private NextUserTMapper nextUserTMapper;
	
	@Override
	public void userEnroll(EnrollUserVO enrollUserVO) throws DataTranctionException, CommonServiceExcetion {
		NextUserT nextUserT = new NextUserT();
		BeanUtils.copyProperties(enrollUserVO, nextUserT);
		nextUserT.setUserPwd(MD5Util.encrypt(nextUserT.getUserPwd()));
		int isSuccess = nextUserTMapper.insert(nextUserT);
		if(isSuccess!=1) {
			throw new CommonServiceExcetion(501,"用户登记失败！");
		}
	}

	@Override
	public boolean checkUserName(String userName) throws CommonServiceExcetion {
		QueryWrapper queryWrapper = new QueryWrapper();
		queryWrapper.eq("user_name", userName);
		int hasUserName = nextUserTMapper.selectCount(queryWrapper);
		return hasUserName != 1 ? false:true;
	}

	@Override
	public boolean userAuth(String userName, String userPwd) throws CommonServiceExcetion {
		QueryWrapper queryWrapper = new QueryWrapper();
		queryWrapper.eq("user_name", userName);
		queryWrapper.eq("user_pwd", MD5Util.encrypt(userPwd));
		int hasUserAuth = nextUserTMapper.selectCount(queryWrapper);
		return hasUserAuth != 1 ? false:true;
	}

	@Override
	public UserInfoVO describeUserInfo(String userId) throws CommonServiceExcetion {
		NextUserT nextUserT = nextUserTMapper.selectById(userId);
		if(nextUserT != null && nextUserT.getUuid() != null){
			UserInfoVO UserInfo = new UserInfoVO();
			UserInfo.setUsername(nextUserT.getUserName());
			UserInfo.setNickname(nextUserT.getNickName());
	
			UserInfo.setBeginTime(nextUserT.getBeginTime().toEpochSecond(ZoneOffset.of("+8")));
			UserInfo.setUpdateTime(nextUserT.getUpdateTime().toEpochSecond(ZoneOffset.of("+8")));
	
			UserInfo.setLifeState(nextUserT.getLifeState()+"");
			BeanUtils.copyProperties(nextUserT, UserInfo);
			return UserInfo;
		}else{
            throw new CommonServiceExcetion(404,"用户编号为["+userId+"]的用户不存在");
        }
	}

	@Override
	public UserInfoVO updateUserInfo(UserInfoVO userInfoVO) throws CommonServiceExcetion {
		 NextUserT nextUserT = info2user(userInfoVO);
	        if(nextUserT != null && nextUserT.getUuid() != null){
	            int isSuccess = nextUserTMapper.updateById(nextUserT);
	            if(isSuccess==1){
	                UserInfoVO result = describeUserInfo(userInfoVO.getUuid()+"");
	                return result;
	            }else{
	                throw new CommonServiceExcetion(500,"用户信息修改失败");
	            }
	        }else{
	            throw new CommonServiceExcetion(404,"用户编号为["+userInfoVO.getUuid()+"]的用户不存在");
	        }
	}
	private NextUserT info2user(UserInfoVO userInfoVO){
        NextUserT nextUserT = new NextUserT();

        nextUserT.setUserName(userInfoVO.getUsername());
        nextUserT.setNickName(userInfoVO.getNickname());

        nextUserT.setUpdateTime(LocalDateTime.now());
        // 最好是用正则表达式判断是否为数字类型之后再转换
        if(Optional.ofNullable(userInfoVO.getLifeState()).isPresent()){
            nextUserT.setLifeState(Integer.parseInt(userInfoVO.getLifeState()));
        }

        BeanUtils.copyProperties(userInfoVO,nextUserT);

        return nextUserT;
    }
}
