package com.ywy.mybatisdemo.pojo;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.BeansException;
import org.springframework.beans.PropertyValues;
import org.springframework.beans.factory.config.InstantiationAwareBeanPostProcessorAdapter;
import org.springframework.stereotype.Component;

import java.beans.PropertyDescriptor;

/**
 * @author 83425
 * @date 2020/11/25
 */
@Slf4j
@Component
public class MyInstantiationAwareBeanPostProcessorAdapter extends InstantiationAwareBeanPostProcessorAdapter {
    public MyInstantiationAwareBeanPostProcessorAdapter() {
        super();
        System.out.println("支持实例化的bean:后处理器适配器->实例化");
    }

    @Override
    public Object postProcessAfterInitialization(Object bean, String beanName) throws BeansException {
        System.out.println("支持实例化的bean:后处理器适配器->" + beanName + "->postProcessAfterInitialization");
        return bean;
    }

    @Override
    public PropertyValues postProcessPropertyValues(PropertyValues pvs, PropertyDescriptor[] pds, Object bean, String beanName) throws BeansException {
        System.out.println("支持实例化的bean:后处理器适配器->" + beanName + "->postProcessPropertyValues");
        return pvs;
    }
}
