package com.frank.practice.spring.lifecycle;

import org.springframework.beans.BeansException;
import org.springframework.beans.PropertyValues;
import org.springframework.beans.factory.config.InstantiationAwareBeanPostProcessorAdapter;

import java.beans.PropertyDescriptor;
import java.lang.reflect.Constructor;

public class MyInstantiationBeanPostProcessorAdapter extends InstantiationAwareBeanPostProcessorAdapter {
    public MyInstantiationBeanPostProcessorAdapter() {
        super();
    }

    @Override
    public Class<?> predictBeanType(Class<?> beanClass, String beanName) {
        return super.predictBeanType(beanClass, beanName);
    }

    @Override
    public Constructor<?>[] determineCandidateConstructors(Class<?> beanClass, String beanName) throws BeansException {
        return super.determineCandidateConstructors(beanClass, beanName);
    }

    @Override
    public Object getEarlyBeanReference(Object bean, String beanName) throws BeansException {
        return super.getEarlyBeanReference(bean, beanName);
    }

    @Override
    public Object postProcessBeforeInstantiation(Class<?> beanClass, String beanName) throws BeansException {
        System.out.println("执行InstantiationAwareBeanPostprocessor的postProcessAfterInstantiation()方法");
        return null;
    }

    @Override
    public boolean postProcessAfterInstantiation(Object bean, String beanName) throws BeansException {
        System.out.println("执行InstantiationAwareBeanPostprocessor的postProcessAfterInstantiation()方法");
        return super.postProcessAfterInstantiation(bean, beanName);
    }

    @Override
    public PropertyValues postProcessPropertyValues(PropertyValues pvs, PropertyDescriptor[] pds, Object bean, String beanName) throws BeansException {
        System.out.println("执行InstantizaitonAwareBeanPostprocessor的postProcessPropertyValue()方法");
        return pvs;
    }

    @Override
    public Object postProcessBeforeInitialization(Object bean, String beanName) throws BeansException {
        System.out.println("执行InstantizaitonAwareBeanPostprocessor的postProcessBeforeInitialization()方法");
        return bean;
    }

    @Override
    public Object postProcessAfterInitialization(Object bean, String beanName) throws BeansException {
        System.out.println("执行InstantizaitonAwareBeanPostprocessor的postProcessAfterInitialization()方法");
        return bean;
    }
}
