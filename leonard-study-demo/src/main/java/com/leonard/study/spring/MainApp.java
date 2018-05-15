package com.leonard.study.spring;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class MainApp {

    public static void main(String[] args) {
        ApplicationContext context =
                new ClassPathXmlApplicationContext("Beans.xml");
        HelloWorldSpring obj = (HelloWorldSpring) context.getBean("HelloWorldSpring");
        obj.getMessage();
        System.out.println(obj.getMessage());
    }
}
