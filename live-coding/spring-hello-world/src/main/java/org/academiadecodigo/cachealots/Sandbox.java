package org.academiadecodigo.cachealots;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Sandbox {

    public static void main(String[] args) {

        ApplicationContext context = new ClassPathXmlApplicationContext("/spring-config.xml");

        HelloWorld h1 = context.getBean("hello", HelloWorld.class);
        HelloWorld h2 = context.getBean("constructor", HelloWorld.class);
        h1.sayHello();
        h2.sayHello();
    }
}
