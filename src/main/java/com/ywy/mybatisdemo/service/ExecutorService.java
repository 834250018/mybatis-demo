package com.ywy.mybatisdemo.service;

import lombok.extern.slf4j.Slf4j;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Component;

/**
 * @author 83425
 * @date 2020/12/14
 */
@Slf4j
@Component
public class ExecutorService {

    @Async("myExecutor") // 异步执行逻辑,实际上就是一个代理模式
    public void testRunnable(Runnable runnable) { // 我这里传入一个runnable,是为了做各种测试用
        runnable.run();
    }
}
