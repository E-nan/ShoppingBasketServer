package com.assignment.shoppingbasketserver.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import org.apache.ibatis.annotations.Param;

@AllArgsConstructor
@Getter
@Builder
public class UserDto {

    private Long userNo;
    private String userId;
    private String userPw;
    private String userName;
    private String userAddress;
}
