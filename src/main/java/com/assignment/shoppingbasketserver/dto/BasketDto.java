package com.assignment.shoppingbasketserver.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;

@AllArgsConstructor
@Getter
@Builder
public class BasketDto {

    private int basketNo;
    private int userNo;
    private int itemNo;
    private int itemCount;
}
