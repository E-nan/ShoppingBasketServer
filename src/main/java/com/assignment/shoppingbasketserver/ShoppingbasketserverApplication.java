package com.assignment.shoppingbasketserver;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;

@SpringBootApplication
@MapperScan(basePackages = "com.assignment.shoppingbasketserver.dao")
public class ShoppingbasketserverApplication extends SpringBootServletInitializer {

    @Override
    protected SpringApplicationBuilder configure(SpringApplicationBuilder builder){
        return builder.sources(ShoppingbasketserverApplication.class);
    }

    public static void main(String[] args) {
        SpringApplication.run(ShoppingbasketserverApplication.class, args);
    }

}
