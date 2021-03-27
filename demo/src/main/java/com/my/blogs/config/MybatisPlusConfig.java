<<<<<<< HEAD
package com.my.blogs.config;
=======
package com.next.jiangzh.springbootdemo.config;
>>>>>>> 5d746e6e9ae1a4ec9f99e4aa165f89c9c6b5e5a4


import com.alibaba.druid.pool.DruidDataSource;
import com.baomidou.mybatisplus.extension.plugins.OptimisticLockerInterceptor;
import com.baomidou.mybatisplus.extension.plugins.PaginationInterceptor;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.transaction.annotation.EnableTransactionManagement;

@Configuration
@EnableTransactionManagement
<<<<<<< HEAD
@MapperScan(basePackages = {"com.my.blogs.example..dao.mapper"})
=======
@MapperScan(basePackages = {"com.next.jiangzh.springbootdemo.dao.mapper"})
>>>>>>> 5d746e6e9ae1a4ec9f99e4aa165f89c9c6b5e5a4
public class MybatisPlusConfig {

    @Bean
    public DruidDataSource dataSource(DruidProperties druidProperties) {
        DruidDataSource dataSource = new DruidDataSource();
        druidProperties.config(dataSource);
        return dataSource;
    }

    /**
     * mybatis-plus分页插件
     */
    @Bean
    public PaginationInterceptor paginationInterceptor() {
        return new PaginationInterceptor();
    }

    /**
     * 乐观锁mybatis插件
     */
    @Bean
    public OptimisticLockerInterceptor optimisticLockerInterceptor() {
        return new OptimisticLockerInterceptor();
    }


}
