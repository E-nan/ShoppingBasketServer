package com.assignment.shoppingbasketserver.dao;


import com.assignment.shoppingbasketserver.dto.UserDto;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public interface UserDao {

    int insertUser(UserDto userDto);
    UserDto selectUserByNo(Long userNo);
    UserDto selectUserById(String userId);
    int deleteUser(Long userNo);
}
