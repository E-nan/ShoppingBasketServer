package com.assignment.shoppingbasketserver.controller;

import com.assignment.shoppingbasketserver.dao.OrdersDao;
import com.assignment.shoppingbasketserver.dto.OrdersDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class OrdersController {

    @Autowired
    private OrdersDao ordersDao;
}
