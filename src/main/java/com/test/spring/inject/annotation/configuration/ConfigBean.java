package com.test.spring.inject.annotation.configuration;

import com.test.spring.inject.HelloWorld;
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
