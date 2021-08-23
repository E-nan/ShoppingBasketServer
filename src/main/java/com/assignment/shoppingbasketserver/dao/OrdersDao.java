package com.assignment.shoppingbasketserver.dao;

import com.assignment.shoppingbasketserver.dto.OrdersDto;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public interface OrdersDao {

    int insertOrders(Long userNo);
    List<OrdersDto> selectOrders(Long userNo);
    int deleteOrders(Long userNo);
}
