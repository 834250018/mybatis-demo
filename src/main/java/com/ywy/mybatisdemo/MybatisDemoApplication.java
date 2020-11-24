package com.ywy.mybatisdemo;

import com.ywy.mybatisdemo.interceptor.IdInterceptor;
import com.ywy.mybatisdemo.mapper.UserMapper;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
@MapperScan("com.ywy.mybatisdemo.mapper")
public class MybatisDemoApplication
        implements CommandLineRunner {
    @Autowired
    UserMapper userMapper;

    public static void main(String[] args) {
        SpringApplication.run(MybatisDemoApplication.class, args);
    }

    @Bean
    public IdInterceptor sensitivePlugin() {
        return new IdInterceptor();
    }

    @Override
    public void run(String... args) throws Exception {

    }
}
