package com.assignment.shoppingbasketserver.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;

import java.math.BigDecimal;
import java.sql.Timestamp;

@AllArgsConstructor
@Getter
public class OrdersDto {

    private String orderNo;
    private int userNo;
    private int itemNo;
    private int itemCount;
    private BigDecimal itemPrice;
    private Timestamp orderDate;
}
