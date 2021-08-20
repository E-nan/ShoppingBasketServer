package com.assignment.shoppingbasketserver.vo;

import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;

@Getter
@Setter
public class ItemVo {

    private String itemName;
    private BigDecimal itemPrice;
    private String itemDescription;
}
