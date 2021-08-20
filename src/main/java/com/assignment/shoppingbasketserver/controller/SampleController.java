package com.assignment.shoppingbasketserver.controller;

import com.assignment.shoppingbasketserver.dao.CommonDao;
import com.assignment.shoppingbasketserver.dto.BasketDto;
import com.assignment.shoppingbasketserver.dto.ItemDto;
import com.assignment.shoppingbasketserver.dto.OrdersDto;
import com.assignment.shoppingbasketserver.dto.UserDto;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@MapperScan(basePackages = "com.assignment.shoppingbasketserver.dao")
public class SampleController {

    @Autowired
    private CommonDao commonDao;

    @RequestMapping("/user")
    public List<UserDto> selectUsers() throws Exception{
        List<UserDto> userDtoList = commonDao.selectUsers();
        return userDtoList;
    }

    @RequestMapping("/item")
    public List<ItemDto> selectItems() throws Exception{
        List<ItemDto> itemDtoList = commonDao.selectItems();
        return itemDtoList;
    }

    @RequestMapping("/basket")
    public List<BasketDto> selectBaskets() throws Exception{
        List<BasketDto> basketDtoList = commonDao.selectBaskets();
        return basketDtoList;
    }

    @RequestMapping("/orders")
    public List<OrdersDto> selectOrders() throws Exception{
        List<OrdersDto> ordersDtoList = commonDao.selectOrders();
        return ordersDtoList;
    }
}
