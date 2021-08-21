package com.assignment.shoppingbasketserver.dao;

import com.assignment.shoppingbasketserver.dto.BasketDto;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public interface BasketDao {

    void insertBasket(BasketDto basketDto);
}
