package com.my.blogs.controller.user.vo;

import java.util.List;

import com.my.blogs.exception.ParamErrorException;
import com.my.blogs.utils.ToolUtils;

import lombok.Data;

@Data
public class UserInfoVO  {

    private Integer id;
    private Integer uuid;
    private String username;
    private String nickname;
    private String email;
    private String phone;
    private Integer sex;
    private String birthday;
    private String lifeState;
    private String biography;
    private String address;
    private String headAddress;
    private Long beginTime;
    private Long updateTime;
    private List<EnrollUserVO> enrollUserVOList;
    
    public List<EnrollUserVO> getEnrollUserVOList() {
		return enrollUserVOList;
	}
	public void setCount(List<EnrollUserVO> enrollUserVOList) {
		this.enrollUserVOList = enrollUserVOList;
	}

    public void checkParam() throws ParamErrorException {
    }
}
