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

    private int userNo;         // 회원 번호
    private String userId;      // 회원 아이디
    private String userPw;      // 회원 비밀번호
    private String userName;    // 회원 이름
    private String userAddress; // 회원 주소
}
