package com.ywy.mybatisdemo;

import com.ywy.mybatisdemo.config.MyConfig;
import com.ywy.mybatisdemo.interceptor.IdInterceptor;
import com.ywy.mybatisdemo.mapper.UserMapper;
import com.ywy.mybatisdemo.pojo.Person;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;

@SpringBootApplication
@MapperScan("com.ywy.mybatisdemo.mapper")
public class MybatisDemoApplication
        implements CommandLineRunner {

    @Autowired
    UserMapper userMapper;
    @Autowired(required = false)
    MyConfig myConfig;

    public static void main(String[] args) {
        System.out.println("开始初始化容器...");
        ConfigurableApplicationContext run = SpringApplication.run(MybatisDemoApplication.class, args);
        System.out.println("容器初始化成功");
        //得到Preson，并使用
        Person person = run.getBean("person", Person.class);
        System.out.println(person);
//        System.out.println("现在开始关闭容器...");
//        run.registerShutdownHook();
    }

    /**
     * 拦截查询语句拼接id=11
     *
     * @return
     */
//    @Bean
    public IdInterceptor sensitivePlugin() {
        return new IdInterceptor();
    }

    @Override
    public void run(String... args) throws Exception {
        System.out.println("加了条件注解之后" + myConfig);
    }
}
