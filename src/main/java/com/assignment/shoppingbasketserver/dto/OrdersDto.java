package com.assignment.shoppingbasketserver.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;

import java.math.BigDecimal;
import java.sql.Timestamp;

@AllArgsConstructor
@Getter
public class OrdersDto {

    private String orderNo;         // 주문 번호
    private int userNo;             // 회원 번호
    private int itemNo;             // 상품 번호
    private int itemCount;          // 상품 개수
    private BigDecimal itemPrice;   // 상품 가격
    private Timestamp orderDate;    // 주문 날짜
}
