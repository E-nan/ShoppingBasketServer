package com.assignment.shoppingbasketserver.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;

import java.sql.Timestamp;

@AllArgsConstructor
@Getter
public class OrdersDto {

    private Long orderNo;
    private Long userNo;
    private Long itemNo;
    private Timestamp orderDate;
}
