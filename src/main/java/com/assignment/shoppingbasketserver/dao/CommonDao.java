package com.assignment.shoppingbasketserver.dao;

import com.assignment.shoppingbasketserver.dto.BasketDto;
import com.assignment.shoppingbasketserver.dto.ItemDto;
import com.assignment.shoppingbasketserver.dto.OrdersDto;
import com.assignment.shoppingbasketserver.dto.UserDto;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public interface CommonDao {
    List<UserDto> selectUsers() throws Exception;
    List<ItemDto> selectItems() throws Exception;
    List<BasketDto> selectBaskets() throws Exception;
    List<OrdersDto> selectOrders() throws Exception;
}
