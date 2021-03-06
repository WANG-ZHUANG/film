package com.my.blogs.dao.entity;
import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.extension.activerecord.Model;

import lombok.Data;

import com.baomidou.mybatisplus.annotation.TableId;
import java.time.LocalDateTime;
import java.io.Serializable;
/**
 * <p>
 * 用户表
 * </p>
 *
 * @author wangzhuang
 * @since 2021-03-29
 */
@Data
public class NextUserT extends Model<NextUserT> {

    private static final long serialVersionUID = 1L;

    /**
     * 主键编号
     */
    @TableId(value = "UUID", type = IdType.AUTO)
    private Integer uuid;

    /**
     * 用户账号
     */
    private String userName;

    /**
     * 用户密码
     */
    private String userPwd;

    /**
     * 用户昵称
     */
    private String nickName;

    /**
     * 用户性别 0-男，1-女
     */
    private Integer sex;

    /**
     * 出生日期
     */
    private String birthday;

    /**
     * 用户邮箱
     */
    private String email;

    /**
     * 用户手机号
     */
    private String phone;

    /**
     * 用户住址
     */
    private String address;

    /**
     * 头像URL
     */
    private String headAddress;

    /**
     * 个人介绍
     */
    private String biography;

    /**
     * 生活状态 0-单身，1-热恋中，2-已婚，3-为人父母
     */
    private Integer lifeState;

    /**
     * 创建时间
     */
    private LocalDateTime beginTime;

    /**
     * 修改时间
     */
    private LocalDateTime updateTime;

}

 
