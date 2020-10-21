package com.test.spring.inject.annotation.component;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.beans.factory.annotation.Value;

@Component
public class ComponentHelloWorld {
    private final DependHelloWorld dependHelloWorld;
    @Autowired
    public ComponentHelloWorld(DependHelloWorld dependHelloWorld) {
        this.dependHelloWorld = dependHelloWorld;
    }

    @Value("component HelloWorld")
    private String name ;

    private  int age;

    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public void sayHello(){
        dependHelloWorld.sayHello();
        System.out.println("Hello"+" "+name);
    }
}
