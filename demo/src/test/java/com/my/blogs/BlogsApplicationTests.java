package com.my.blogs;

import java.util.List;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.my.blogs.dao.entity.NextUser;
import com.my.blogs.dao.mapper.NextUserMapper;

import lombok.extern.log4j.Log4j;

@SpringBootTest
@Log4j
class BlogsApplicationTests {
	@Autowired
	private NextUserMapper nextUser;
    @Test
    void contextLoads() {
    	List<NextUser> list = nextUser.selectList(null);
    	list.get(0).getUuid();
    	list.forEach(System.out::println);
    	System.out.println("haha");
    }
    @Test
    void queryByPage() {
    	IPage<NextUser> iPage = new Page();
    	iPage.setCurrent(1);
    	iPage.setSize(2);
    	IPage<NextUser> page = nextUser.selectPage(iPage, null);
    	System.out.println("haha");
    	log.info(page);
    }
}
