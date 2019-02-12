package com.frank.practice.spring.lifecycle;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.config.BeanDefinition;
import org.springframework.beans.factory.config.BeanFactoryPostProcessor;
import org.springframework.beans.factory.config.ConfigurableListableBeanFactory;

public class MyBeanFactoryPostProcessor implements BeanFactoryPostProcessor {


    public MyBeanFactoryPostProcessor() {
        super();
        System.out.println("执行BeanFacotyPostProcessor的构造方法");
    }

    @Override

    public void postProcessBeanFactory(ConfigurableListableBeanFactory configurableListableBeanFactory) throws BeansException {
        System.out.println("执行BeanFactoryPostProcessor的postProcessBeanFactory()方法");
        BeanDefinition beanDefinition = configurableListableBeanFactory.getBeanDefinition("person");
        beanDefinition.getPropertyValues().addPropertyValue("age", 50);
    }
}
