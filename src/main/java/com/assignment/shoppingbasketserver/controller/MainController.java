package com.assignment.shoppingbasketserver.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class MainController {

    @GetMapping("/")
    public String goMain(){
        return "스프링 부트를 이용한 장바구니 서버입니다.";
    }
}
