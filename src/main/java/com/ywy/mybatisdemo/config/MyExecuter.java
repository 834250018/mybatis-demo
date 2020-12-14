package com.ywy.mybatisdemo.config;

import jodd.util.concurrent.ThreadFactoryBuilder;
import lombok.extern.slf4j.Slf4j;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.concurrent.*;

/**
 * @author 83425
 * @date 2020/12/14
 */
@Slf4j
@Configuration
public class MyExecuter {

    private static ThreadFactoryBuilder threadFactoryBuilder = new ThreadFactoryBuilder();

    private static int CORE_POOL_SIZE = 1; // 核心线程数,默认懒加载,常驻内存
    private static int MAXIMUM_POOL_SIZE = 2; // 最大线程数,包括核心线程数,有界队列满了之后创建,闲置后超过可用时间回收
    private static long KEEP_ALIVE_TIME = 1; // 非核心线程闲置后存活时间,可设置核心线程超时
    private static TimeUnit UNIT = TimeUnit.MINUTES; // 非核心线程闲置后存活时间单位
    private static BlockingQueue<Runnable> WORK_QUEUE = new ArrayBlockingQueue<>(1); // 任务队列,核心线程满了之后放入此队列
    private static ThreadFactory THREAD_FACTORY = threadFactoryBuilder.setNameFormat("my-executor-pool-%d").get(); // 自定义线程工厂,可以命名
    private static RejectedExecutionHandler HANDLER = new ThreadPoolExecutor.CallerRunsPolicy(); // 超出非核心线程后执行策略

    @Bean
    public Executor myExecutor() {

        ThreadPoolExecutor executor = new ThreadPoolExecutor(
                CORE_POOL_SIZE,
                MAXIMUM_POOL_SIZE,
                KEEP_ALIVE_TIME,
                UNIT,
                WORK_QUEUE,
                THREAD_FACTORY,
                HANDLER);
//        executor.allowCoreThreadTimeOut(true);
        return executor;

    }
}
