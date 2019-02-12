package com.frank.practice.spring;

import com.frank.practice.spring.bean.Person;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;


public class MyApplicationContext {
    public static void main(String[] args) {
        System.out.println("开始初始化容器------------------------");
        ApplicationContext factory = new ClassPathXmlApplicationContext("Beans.xml");
        System.out.println("容器初始化成功------------------------");
        Person person = (Person) factory.getBean("person");
        System.out.println(person);
        System.out.println("开始关闭容器---------------------------");
        ((ClassPathXmlApplicationContext) factory).registerShutdownHook();
        System.out.println("容器关闭成功----------------------------");
    }
}
