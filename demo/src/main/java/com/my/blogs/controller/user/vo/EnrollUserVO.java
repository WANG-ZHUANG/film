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

        if(ToolUtils.isNullOrEmpty(this.getUserName())) throw new ParamErrorException(400,"用户名不能为空！");
        
        if(ToolUtils.isNullOrEmpty(this.getUserPwd())) throw new ParamErrorException(400,"密码不能为空！");
        
        if(!ToolUtils.isEmail(this.getEmail())) throw new ParamErrorException(400,"邮箱格式不正确！");
        
        // 用户名不能超过50位,一个汉字占3位
        if(!ToolUtils.validateStrByLength(this.getUserName(),50,30)) throw new ParamErrorException(400,"用户名长度错误！");
        
        //电话只能是数字
        if(!ToolUtils.isInteger(this.getPhone())) throw new ParamErrorException(400,"电话号码只能是数字！");
        
        //电话长度不能超过11
        if(!ToolUtils.validateStrByLength(this.getPhone(),11,11)) throw new ParamErrorException(400,"电话号码只能是11位手机号！");

    }
}
