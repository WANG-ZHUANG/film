package com.my.blogs.controller.user.vo;

import com.my.blogs.controller.BaseVO;
import com.my.blogs.exception.ParamErrorException;
import com.my.blogs.utils.ToolUtils;

import lombok.Data;

@Data
public class EnrollUserVO extends BaseVO {

    private String userName;
    private String userPwd;
    private String email;
    private String phone;
    private String address;

    public void checkParam() throws ParamErrorException {

        if(ToolUtils.isNullOrEmpty(this.getUserName())){
            throw new ParamErrorException(400,"用户名不能为空");
        }
        if(ToolUtils.isNullOrEmpty(this.getUserPwd())){
            throw new ParamErrorException(400,"密码不能为空");
        }

        // 用户名不能超过20位，切格式为...


    }
}
