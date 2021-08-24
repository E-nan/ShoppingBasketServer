package com.assignment.shoppingbasketserver.dao;

import com.assignment.shoppingbasketserver.dto.OrdersDto;
import com.assignment.shoppingbasketserver.vo.BasketVo;
import com.assignment.shoppingbasketserver.vo.OrdersVo;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public interface OrdersDao {

    int insertOrders(BasketVo basketVo);
    List<OrdersDto> selectOrders(OrdersVo ordersVo);
    int deleteOrders(OrdersVo ordersVo);
}
