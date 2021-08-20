package com.assignment.shoppingbasketserver.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;

import java.sql.Timestamp;

@AllArgsConstructor
@Getter
public class OrdersDto {

    private Long order_no;
    private Long user_no;
    private Long item_no;
    private Timestamp order_date;
}
