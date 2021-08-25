package com.assignment.shoppingbasketserver.vo;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class OrdersVo {

    private String orderNo; // 주문 번호
    private int userNo;     // 회원 번호
}
