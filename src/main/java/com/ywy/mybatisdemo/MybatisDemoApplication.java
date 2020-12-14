package com.ywy.mybatisdemo;

import com.ywy.mybatisdemo.config.MyConfig;
import com.ywy.mybatisdemo.interceptor.IdInterceptor;
import com.ywy.mybatisdemo.mapper.UserMapper;
import com.ywy.mybatisdemo.pojo.Person;
import com.ywy.mybatisdemo.vo.TestExecutor;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.scheduling.annotation.EnableAsync;

import java.util.concurrent.Executor;

@EnableAsync
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

    @Autowired
    private TestExecutor testExecutor;

    @Autowired
    private Executor myExecutor;

    @Override
    public void run(String... args) throws Exception {
        System.out.println("加了条件注解之后" + myConfig);
        startTest();// 第一次启动核心线程 my-executor-pool-0
        startTest();// 第二次加入等待队列 不执行
        startTest();// 第三次启动非核心线程 my-executor-pool-1
        startTest();// 第四次超出最大线程数量,执行当前线程回调策略 main
        System.out.println("启动线程完成");

    }

    private static int i = 0;

    private void startTest() throws InterruptedException {
        final int idx = i++;
        Thread.sleep(1000L);
        testExecutor.testRunnable(() -> {
            while (true) {
                System.out.println("执行顺序:" + idx + ", 执行线程" + Thread.currentThread().getName());
                try {
                    Thread.sleep(10000L);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        });
    }
}
