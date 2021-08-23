package com.assignment.shoppingbasketserver.controller;

import com.assignment.shoppingbasketserver.dao.BasketDao;
import com.assignment.shoppingbasketserver.dto.BasketDto;
import com.assignment.shoppingbasketserver.vo.BasketVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

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

    // 다중 검색 고려 및 데이터타입 고려
//    @RequestMapping("/select")
//    public List<BasketDto> selectBasket(@RequestParam Long userNo, @RequestParam(required = false) Long itemNo){
//
//        return basketDao.selectBasket(userNo, itemNo);
//    }

    @RequestMapping("/select")
    public List<BasketDto> selectBasket(BasketVo basketVo){

        return basketDao.selectBasket(basketVo);
    }

    // 다중 삭제 고려 수정 예정
    @RequestMapping("/delete")
    public void deleteBasket(BasketVo basketvo){

        basketDao.deleteBasket(basketvo);
    }
}
