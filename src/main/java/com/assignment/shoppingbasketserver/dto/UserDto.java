package com.assignment.shoppingbasketserver.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;

@AllArgsConstructor
@Getter
@Builder
public class UserDto {

    private Long user_no;
    private String user_id;
    private String user_pw;
    private String user_name;
    private String user_address;
}
