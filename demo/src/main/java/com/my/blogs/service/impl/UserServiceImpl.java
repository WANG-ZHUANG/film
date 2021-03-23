package com.my.blogs.service.impl;

import com.my.blogs.entity.User;
import com.my.blogs.mapper.UserMapper;
import com.my.blogs.service.UserService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author 壮壮是个智障啊
 * @since 2021-03-21
 */
@Service
public class UserServiceImpl extends ServiceImpl<UserMapper, User> implements UserService {

}
