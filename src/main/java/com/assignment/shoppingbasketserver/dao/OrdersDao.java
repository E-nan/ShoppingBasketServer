package com.assignment.shoppingbasketserver.dao;

import com.assignment.shoppingbasketserver.dto.OrdersDto;
import com.assignment.shoppingbasketserver.vo.BasketVo;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public interface OrdersDao {

    int insertOrders(BasketVo basketVo);
    List<OrdersDto> selectOrders(Long userNo);
    int deleteOrders(Long userNo);
}
