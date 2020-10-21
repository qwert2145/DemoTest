package com.spring.test.inject;

public class HelloWorld {
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

    private String name ;
    private  int age;

    public void sayHello(){
        System.out.println("Hello"+" "+name);
    }
}
