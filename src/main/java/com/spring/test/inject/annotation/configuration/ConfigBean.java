package com.spring.test.inject.annotation.configuration;

import com.spring.test.inject.HelloWorld;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Lazy;

@Configuration
public class ConfigBean {
    @Bean("helloWorld")
    @Lazy
    public HelloWorld getHello(){
        HelloWorld helloWorld = new HelloWorld();
        helloWorld.setName("config helloWorld");
        return helloWorld;
    }
}
