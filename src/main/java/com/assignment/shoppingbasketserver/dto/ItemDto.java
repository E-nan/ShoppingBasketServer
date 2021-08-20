package com.assignment.shoppingbasketserver.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;

import java.math.BigDecimal;

@AllArgsConstructor
@Getter
@Builder
public class ItemDto {

    private Long itemNo;
    private String itemName;
    private BigDecimal itemPrice;
    private String itemDescription;
}
