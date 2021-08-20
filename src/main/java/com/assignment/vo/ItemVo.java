package com.assignment.vo;

import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;

@Getter
@Setter
public class ItemVo {

    private String item_name;
    private BigDecimal item_price;
    private String item_description;
}
