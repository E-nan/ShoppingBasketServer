package com.assignment.shoppingbasketserver.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;

import java.math.BigDecimal;

@AllArgsConstructor
@Getter
public class ItemDto {

    private Long item_no;
    private String item_name;
    private BigDecimal item_price;
    private String item_description;
}
