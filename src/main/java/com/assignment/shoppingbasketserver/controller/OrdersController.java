package com.assignment.shoppingbasketserver.controller;

import com.assignment.shoppingbasketserver.dao.BasketDao;
import com.assignment.shoppingbasketserver.dao.OrdersDao;
import com.assignment.shoppingbasketserver.dto.OrdersDto;
import com.assignment.shoppingbasketserver.vo.BasketVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/orders")
public class OrdersController {

    @Autowired
    private OrdersDao ordersDao;

    @Autowired
    private BasketDao basketDao;

    // 장바구니중 원하는 물품만 주문하는 기능 추가?
    @RequestMapping("/insert")
    public void insertOrders(@RequestParam Long userNo){

        int result = ordersDao.insertOrders(userNo);

        System.out.println("Order Success Count ==> " + result);

        // 삽입 성공하면 장바구니에서 제거
        if(result != 0){
//            basketDao.deleteBasket(new BasketVo({userNo = 1L}));
        }
    }

    @RequestMapping("/select")
    public List<OrdersDto> selectOrders(@RequestParam Long userNo){

        return ordersDao.selectOrders(userNo);
    }

    @RequestMapping("/delete")
    public void deleteOrders(@RequestParam Long userNo){

        int result = ordersDao.deleteOrders(userNo);
    }
}
