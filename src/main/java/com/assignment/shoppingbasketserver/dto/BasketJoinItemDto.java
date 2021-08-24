package com.assignment.shoppingbasketserver.dto;

import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;

@Getter
public class BasketJoinItemDto {

    private int basketNo;
    private String itemName;
    private BigDecimal itemPrice;
    private int itemCount;
}
