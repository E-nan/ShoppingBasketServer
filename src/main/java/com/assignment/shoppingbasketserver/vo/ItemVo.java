package com.assignment.shoppingbasketserver.vo;

import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;

@Getter
@Setter
public class ItemVo {

    private String itemName;        // 상품 이름
    private BigDecimal itemPrice;   // 상품 가격
    private String itemDescription; // 상품 설명
}
