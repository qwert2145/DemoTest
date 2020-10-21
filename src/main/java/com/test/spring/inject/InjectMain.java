package com.test.spring.inject;

import com.test.spring.inject.annotation.component.ComponentHelloWorld;
import com.test.spring.inject.annotation.configuration.ConfigBean;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class InjectMain {
    public static void main(String[] args) {
        // 纯xml 格式
        //1.创建Spring IOC 容器对象
        ApplicationContext applicationContext = new ClassPathXmlApplicationContext("spring-config.xml");
        //2.通过IOC容器对象来得到helloworld对应的对象，利用bean id来唯一标识这个对象
        HelloWorld helloWorld = (HelloWorld) applicationContext.getBean("helloWorld");
        //3.调用sayHello()方法
        helloWorld.sayHello();

        //configuration 纯注解
        AnnotationConfigApplicationContext ctx = new AnnotationConfigApplicationContext();
        ctx.register(ConfigBean.class);
        ctx.refresh();
        HelloWorld configHelloWorld = (HelloWorld) ctx.getBean("helloWorld");
        //3.调用sayHello()方法
        configHelloWorld.sayHello();
        ctx.close();

        //Component 注解
        //1.创建Spring IOC 容器对象
        ApplicationContext applicationContext1 = new ClassPathXmlApplicationContext("spring-config.xml");
        //2.通过IOC容器对象来得到Helloworld对应的对象
        ComponentHelloWorld componentHelloWorld = applicationContext1.getBean(ComponentHelloWorld.class);
        //3.调用sayHello()方法
        componentHelloWorld.sayHello();
    }
}
