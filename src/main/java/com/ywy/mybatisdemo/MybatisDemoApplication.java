package com.ywy.mybatisdemo;

import com.ywy.mybatisdemo.entity.User;
import com.ywy.mybatisdemo.mapper.UserMapper;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@MapperScan("com.ywy.mybatisdemo.mapper")
public class MybatisDemoApplication implements CommandLineRunner {

    public static void main(String[] args) {
        SpringApplication.run(MybatisDemoApplication.class, args);
    }

    @Autowired
    UserMapper userMapper;

    @Override
    public void run(String... args) throws Exception {
//        User user = userMapper.getById("ywy");
//        if(user != null) {
//            System.out.println(user.toString());
//        }
    }
}
