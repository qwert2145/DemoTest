package com.test.spring.inject.beanfactory;

import com.test.spring.inject.HelloWorld;
import com.test.spring.inject.Rectangle;
import org.springframework.beans.factory.BeanFactory;
import org.springframework.beans.factory.support.BeanDefinitionReader;
import org.springframework.beans.factory.support.BeanDefinitionRegistry;
import org.springframework.beans.factory.support.DefaultListableBeanFactory;
import org.springframework.beans.factory.support.RootBeanDefinition;
import org.springframework.beans.factory.xml.XmlBeanDefinitionReader;

public class BeanContainer {
    public static void main(String[] args) {
        // 通常为BeanDefinitionRegistry的实现类，这里以DeFaultListabeBeanFactory为例
        BeanDefinitionRegistry beanRegistry = new DefaultListableBeanFactory();
        // XmlBeanDefinitionReader实现了BeanDefinitionReader接口，用于解析XML文件
        BeanDefinitionReader beanDefinitionReader = new XmlBeanDefinitionReader(beanRegistry);
        // 加载配置文件
        beanDefinitionReader.loadBeanDefinitions("classpath:spring-config.xml");
        // 从容器中获取bean实例
        BeanFactory container = (BeanFactory) beanRegistry;
        HelloWorld helloWorld = (HelloWorld) container.getBean("helloWorld");
        helloWorld.sayHello();

        RootBeanDefinition rootBeanDefinition = new RootBeanDefinition(Rectangle.class);
        // 注册名字rectangle的bean
        beanRegistry.registerBeanDefinition("rectangle", rootBeanDefinition);
        Rectangle rectangle = container.getBean(Rectangle.class);
        rectangle.sayHi();
    }
}
