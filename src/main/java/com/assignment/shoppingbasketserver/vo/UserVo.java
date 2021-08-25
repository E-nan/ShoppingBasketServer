package com.assignment.shoppingbasketserver.vo;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class UserVo {

    private String userId;      // 회원 아이디
    private String userPw;      // 회원 비밀번호
    private String userName;    // 회원 이름
    private String userAddress; // 회원 주소
}
