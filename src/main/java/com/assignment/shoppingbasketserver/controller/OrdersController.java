package com.assignment.shoppingbasketserver.controller;

import com.assignment.shoppingbasketserver.dao.BasketDao;
import com.assignment.shoppingbasketserver.dao.OrdersDao;
import com.assignment.shoppingbasketserver.dto.BasketDto;
import com.assignment.shoppingbasketserver.dto.OrdersDto;
import com.assignment.shoppingbasketserver.util.Message;
import com.assignment.shoppingbasketserver.vo.BasketVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
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
    public ResponseEntity<Message> insertOrders(BasketVo basketVo){

        Message message = new Message();
        HttpStatus httpStatus = null;

        List<BasketDto> basketDtoList = basketDao.selectBasket(basketVo);

        if(basketDtoList.size() == 0){
            message.setMessage("주문할 장바구니 목록이 없음");
            message.setData(basketDtoList);
            httpStatus = HttpStatus.BAD_REQUEST;
        }
        else{
            int result = ordersDao.insertOrders(basketVo);

            // 삽입 성공하면 장바구니에서 제거
            if(result != 0){
                basketDao.deleteBasket(basketVo);

                message.setMessage("장바구니 주문 성공");
                message.setData(basketDtoList);
                httpStatus = HttpStatus.OK;
            }
            else{
                message.setMessage("장바구니 주문 실패");
                message.setData(basketDtoList);
                httpStatus = HttpStatus.BAD_REQUEST;
            }
        }

        return new ResponseEntity<>(message, httpStatus);
    }

    @RequestMapping("/select")
    public List<OrdersDto> selectOrders(@RequestParam Long userNo){

        return ordersDao.selectOrders(userNo);
    }

//    @RequestMapping("/delete")
//    public ResponseEntity<Message> deleteOrders(@RequestParam Long userNo){
//
//        Message message = new Message();
//        HttpStatus httpStatus = null;
//
//        ordersDao.selectOrders(userNo)
//
//        int result = ordersDao.deleteOrders(userNo);
//
//        return new ResponseEntity<>(message, httpStatus);
//    }
}
