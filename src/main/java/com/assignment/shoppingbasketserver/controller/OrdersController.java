package com.assignment.shoppingbasketserver.controller;

import com.assignment.shoppingbasketserver.dao.BasketDao;
import com.assignment.shoppingbasketserver.dao.OrdersDao;
import com.assignment.shoppingbasketserver.dto.BasketDto;
import com.assignment.shoppingbasketserver.dto.OrdersDto;
import com.assignment.shoppingbasketserver.util.Message;
import com.assignment.shoppingbasketserver.vo.BasketVo;
import com.assignment.shoppingbasketserver.vo.OrdersVo;
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

    /**
     * 장바구니 상품 주문
     * @param basketVo
     * @return 성공, 실패 여부에 따라 메시지 및 결과 리턴
     */
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

    /**
     * 주문 내역 조회
     * @param ordersVo
     * @return 성공, 실패 여부에 따라 메시지 및 결과 리턴
     */
    @RequestMapping("/select")
    public ResponseEntity<Message> selectOrders(OrdersVo ordersVo){

        Message message = new Message();
        HttpStatus httpStatus = null;

        List<OrdersDto> ordersDtoList = ordersDao.selectOrders(ordersVo);

        if(ordersDtoList.size() == 0){
            message.setMessage("조건에 맞는 주문목록이 없습니다.");
            message.setData(ordersVo);
            httpStatus = HttpStatus.BAD_REQUEST;
        }
        else{
            message.setMessage("주문목록 검색 성공");
            message.setData(ordersDtoList);
            httpStatus = HttpStatus.OK;
        }

        return new ResponseEntity<>(message, httpStatus);
    }

    /**
     * 주문 내역 제거
     * @param ordersVo
     * @return 성공, 실패 여부에 따라 메시지 및 결과 리턴
     */
    @RequestMapping("/delete")
    public ResponseEntity<Message> deleteOrders(OrdersVo ordersVo){

        Message message = new Message();
        HttpStatus httpStatus = null;

        List<OrdersDto> ordersDtoList = ordersDao.selectOrders(ordersVo);

        if(ordersDtoList.size() == 0){
            message.setMessage("조건에 맞는 주문이 없습니다.");
            message.setData(ordersVo);
            httpStatus = HttpStatus.BAD_REQUEST;
        }
        else{

            int result = ordersDao.deleteOrders(ordersVo);

            if(result != 0){
                message.setMessage("주문 내역 삭제 성공하셨습니다.");
                message.setData(ordersDtoList);
                httpStatus = HttpStatus.OK;
            }
            else{
                message.setMessage("주문 내역 삭제 실패하셨습니다.");
                message.setData(ordersDtoList);
                httpStatus = HttpStatus.BAD_REQUEST;
            }
        }

        return new ResponseEntity<>(message, httpStatus);
    }
}
