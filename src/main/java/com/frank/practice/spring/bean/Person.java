package com.frank.practice.spring.bean;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.*;

public class Person implements BeanNameAware, BeanFactoryAware, InitializingBean,DisposableBean {
    private String name;
    private Integer age;
    private BeanFactory beanFactory;
    private String beanName;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
        System.out.println("执行Bean的setName()方法");
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
        System.out.println("执行Bean的setAge()方法");
    }

    @Override
    public void setBeanFactory(BeanFactory beanFactory) throws BeansException {
        this.beanFactory = beanFactory;
        System.out.println("执行BeanFactoryAware的setBeanFactory()方法");
    }

    @Override
    public void setBeanName(String s) {
        this.beanName = s;
        System.out.println("执行BeanNameAware的setBeanName()方法");
    }

    @Override
    public void destroy() throws Exception {
        System.out.println("执行DisposableBean接口的destory()方法");
    }

    @Override
    public void afterPropertiesSet() throws Exception {
        System.out.println("执行InitializingBean接口的afterPropertiesSet()方法");
    }

    public void myInit(){
        System.out.println("执行Bean的init()方法");
    }

    public void myDestory(){
        System.out.println("执行Bean的destory()方法");
    }
}
