package com.assignment.shoppingbasketserver;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@MapperScan(basePackages = "com.assignment.shoppingbasketserver.dao")
public class ShoppingbasketserverApplication {

    public static void main(String[] args) {
        SpringApplication.run(ShoppingbasketserverApplication.class, args);
    }

}
