package com.my.blogs;

import java.util.List;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.my.blogs.dao.entity.NextUser;
import com.my.blogs.dao.mapper.NextUserMapper;
import com.my.blogs.dao.mapper.NextUserTMapper;
import com.my.blogs.utils.MD5Util;

import lombok.extern.log4j.Log4j;

@SpringBootTest
@Log4j
class BlogsApplicationTests {
	@Autowired
	private NextUserTMapper nextUserTMapper;
    @Test
    void contextLoads() {
//    	List<NextUser> list = nextUser.selectList(null);
//    	list.get(0).getUuid();
//    	list.forEach(System.out::println);
//    	System.out.println("haha");
    }
    @Test
    void queryByPage() {
    	QueryWrapper queryWrapper = new QueryWrapper();
    	queryWrapper.eq("user_name", "admin");
		queryWrapper.eq("user_pwd","0192023a7bbd73250516f069df18b500");
		int hasUserAuth = nextUserTMapper.selectCount(queryWrapper);
		System.out.println(hasUserAuth);
		
    }
}
