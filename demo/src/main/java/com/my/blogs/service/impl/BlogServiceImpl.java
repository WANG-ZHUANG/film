package com.my.blogs.service.impl;

import com.my.blogs.entity.Blog;
import com.my.blogs.mapper.BlogMapper;
import com.my.blogs.service.BlogService;
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
public class BlogServiceImpl extends ServiceImpl<BlogMapper, Blog> implements BlogService {

}
