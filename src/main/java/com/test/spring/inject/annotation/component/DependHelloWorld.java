package com.test.spring.inject.annotation.component;

import org.springframework.stereotype.Component;

@Component
public class DependHelloWorld {
    public void sayHello(){
        System.out.println("DependHelloWorld");
    }
}
