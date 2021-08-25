package com.assignment.shoppingbasketserver.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;

import java.math.BigDecimal;

@AllArgsConstructor
@Getter
@Builder
public class ItemDto {

    private int itemNo;             // 상품 번호
    private String itemName;        // 상품 이름
    private BigDecimal itemPrice;   // 상품 가격
    private String itemDescription; // 상품 설명
}
