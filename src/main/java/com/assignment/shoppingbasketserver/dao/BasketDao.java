package com.assignment.shoppingbasketserver.dao;

import com.assignment.shoppingbasketserver.dto.BasketDto;
import com.assignment.shoppingbasketserver.vo.BasketVo;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public interface BasketDao {

    void insertBasket(BasketDto basketDto);
//    List<BasketDto> selectBasket(Long userNo, Long itemNo);
    List<BasketDto> selectBasket(BasketVo basketVo);
    void deleteBasket(BasketVo basketVo);
}
