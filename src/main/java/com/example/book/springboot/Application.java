package com.example.book.springboot;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

//You can't have two @SpringBootConfiguration (@SpringBootApplication) in the same package.
@EnableJpaAuditing //JPA 활성화
@SpringBootApplication
public class Application {
    public static void main(String[] args) {SpringApplication.run(Application.class,args);}
}

