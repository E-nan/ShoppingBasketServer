package com.assignment.shoppingbasketserver.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;

@AllArgsConstructor
@Getter
@Builder
public class BasketDto {

    private Long basketNo;
    private Long userNo;
    private Long itemNo;
    private Long itemCount;
}
