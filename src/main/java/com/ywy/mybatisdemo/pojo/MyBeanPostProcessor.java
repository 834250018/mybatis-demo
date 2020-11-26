package com.ywy.mybatisdemo.pojo;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.BeansException;
import org.springframework.beans.factory.config.BeanPostProcessor;
import org.springframework.stereotype.Component;

/**
 * @author 83425
 * @date 2020/11/25
 */
@Slf4j
@Component
public class MyBeanPostProcessor implements BeanPostProcessor {
    public MyBeanPostProcessor() {
        super();
        System.out.println("bean:后处理器->实例化");
    }

    @Override
    public Object postProcessAfterInitialization(Object bean, String beanName) throws BeansException {
        System.out.println("bean:后处理器->" + beanName + "->postProcessAfterInitialization");
        return bean;
    }

    @Override
    public Object postProcessBeforeInitialization(Object bean, String beanName) throws BeansException {
        System.out.println("bean:后处理器->" + beanName + "->postProcessBeforeInitialization");
        return bean;
    }
}
