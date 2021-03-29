package com.example.book.springboot;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

//You can't have two @SpringBootConfiguration (@SpringBootApplication) in the same package.
@SpringBootApplication
public class Application {
    public static void main(String[] args) {SpringApplication.run(Application.class,args);}
}

