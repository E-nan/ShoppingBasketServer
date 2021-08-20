package com.assignment.shoppingbasketserver.controller;

import com.assignment.shoppingbasketserver.dao.ItemDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ItemController {

    @Autowired
    private ItemDao itemDao;
}
