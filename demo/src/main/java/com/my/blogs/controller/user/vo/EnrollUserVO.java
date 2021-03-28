package com.my.blogs.controller.user.vo;

import com.my.blogs.controller.BaseVO;
import com.my.blogs.exception.ParamErrorException;
import com.my.blogs.utils.ToolUtils;

import lombok.Data;

@Data
public class EnrollUserVO extends BaseVO {

    private String username;
    private String password;
    private String email;
    private String phone;
    private String address;

    public void checkParam() throws ParamErrorException {

        if(ToolUtils.isEmpty(this.getUsername())){
            throw new ParamErrorException(400,"用户名不能为空");
        }
        if(ToolUtils.isEmpty(this.getPassword())){
            throw new ParamErrorException(400,"密码不能为空");
        }

        // 用户名不能超过20位，切格式为...


    }
}
