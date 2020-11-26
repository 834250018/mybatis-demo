package com.ywy.mybatisdemo.pojo;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.BeansException;
import org.springframework.beans.factory.*;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;

/**
 * Person->构造器
 * 支持实例化的bean:后处理器适配器->person->postProcessPropertyValues
 * Person->注入属性phone
 * Person->setBeanName
 * Person->setBeanFactory
 * bean:后处理器->person->postProcessBeforeInitialization
 * Person->【init-method】调用<bean>的init-method属性指定的初始化方法
 * Person->afterPropertiesSet
 * bean:后处理器->person->postProcessAfterInitialization
 * 支持实例化的bean:后处理器适配器->person->postProcessAfterInitialization
 *
 * @author 83425
 * @date 2020/11/25
 */
@Slf4j
@Component
public class Person implements BeanFactoryAware, BeanNameAware, InitializingBean, DisposableBean {

    private String name;
    private String address;
    private Integer phone;

    public Person() {
        System.out.println("Person->构造器");
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        System.out.println(1);
        ok:
        for (int i = 0; i < 100; i++) {
            for (int i1 = 0; i1 < 100; i1++) {
                System.out.println(2);
                break ok;
            }
        }
        System.out.println(3);
        System.out.println("Person->注入属性name");
        this.name = name;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        System.out.println("Person->注入属性address");
        this.address = address;
    }

    public Integer getPhone() {
        return phone;
    }

    public void setPhone(Integer phone) {
        System.out.println("Person->注入属性phone");
        this.phone = phone;
    }

    @Override
    public void setBeanFactory(BeanFactory beanFactory) throws BeansException { // BeanFactoryAware
        System.out.println("Person->setBeanFactory");
    }

    @Override
    public void setBeanName(String name) { // bean构造后依赖注入完,调用出方法让实例察觉自己的beanName(name或者id),可以存到属性中
        System.out.println("Person->setBeanName");
    }

    @Override
    public void afterPropertiesSet() throws Exception { // bean构造后依赖注入完,调用出方法让实例察觉自己的beanFactory,可以存到属性中
        System.out.println("Person->afterPropertiesSet");
    }

    @Override
    public void destroy() throws Exception { // DisposableBean
        System.out.println("Person->destroy");
    }


    // 通过<bean>的init-method属性指定的初始化方法
    @PostConstruct
    public void myInit() {
        System.out.println("Person->【init-method】调用<bean>的init-method属性指定的初始化方法");
    }

    // 通过<bean>的destroy-method属性指定的初始化方法
    @PreDestroy
    public void myDestory() {
        System.out.println("Person->【destroy-method】调用<bean>的destroy-method属性指定的初始化方法");
    }
}
