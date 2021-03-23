package com.my.blogs.controller;


import com.baomidou.mybatisplus.extension.service.additional.query.impl.QueryChainWrapper;
import com.my.blogs.entity.Blog;
import com.my.blogs.service.BlogService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import org.springframework.web.bind.annotation.RestController;

/**
 * <p>
 *  前端控制器
 * </p>
 *
 * @author 壮壮是个智障啊
 * @since 2021-03-21
 */
@RestController
@RequestMapping("/blog")
public class BlogController {
    @Autowired
    BlogService blogService;
    @GetMapping("/blogs")
    public QueryChainWrapper<Blog> query(){
        return blogService.query();
    }
}
