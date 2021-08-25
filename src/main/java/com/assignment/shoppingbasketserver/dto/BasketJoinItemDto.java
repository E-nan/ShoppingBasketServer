package com.assignment.shoppingbasketserver.dto;

import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;

@Getter
public class BasketJoinItemDto {

    private int basketNo;           // 장바구니 번호
    private String itemName;        // 상품 이름
    private BigDecimal itemPrice;   // 상품 가격
    private int itemCount;          // 상품 개수
}
