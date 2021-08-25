package com.assignment.shoppingbasketserver.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;

@AllArgsConstructor
@Getter
@Builder
public class BasketDto {

    private int basketNo;   // 장바구니 번호
    private int userNo;     // 유저 번호
    private int itemNo;     // 상품 번호
    private int itemCount;  // 상품 개수
}
