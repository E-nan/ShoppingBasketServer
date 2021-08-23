package com.assignment.shoppingbasketserver.dao;

import com.assignment.shoppingbasketserver.dto.BasketDto;
import com.assignment.shoppingbasketserver.dto.BasketJoinItemDto;
import com.assignment.shoppingbasketserver.vo.BasketVo;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public interface BasketDao {

    int insertBasket(BasketDto basketDto);
    int updateBasket(BasketDto basketDto);
    List<BasketDto> selectBasket(BasketVo basketVo);
    List<BasketJoinItemDto> selectBasketJoinItem(BasketVo basketVo);
    int deleteBasket(BasketVo basketVo);
}
