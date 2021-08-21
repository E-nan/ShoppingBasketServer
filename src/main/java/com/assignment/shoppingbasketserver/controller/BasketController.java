package com.assignment.shoppingbasketserver.controller;

import com.assignment.shoppingbasketserver.dao.BasketDao;
import com.assignment.shoppingbasketserver.dto.BasketDto;
import com.assignment.shoppingbasketserver.vo.BasketVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/basket")
public class BasketController {

    @Autowired
    private BasketDao basketDao;

    @RequestMapping("/insert")
    public void insertBasket(BasketVo basketVo){

        BasketDto basketDto = BasketDto.builder()
                .userNo(basketVo.getUserNo())
                .itemNo(basketVo.getItemNo())
                .build();

        basketDao.insertBasket(basketDto);
    }
}
