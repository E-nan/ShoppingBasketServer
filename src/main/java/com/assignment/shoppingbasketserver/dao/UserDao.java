package com.assignment.shoppingbasketserver.dao;


import com.assignment.shoppingbasketserver.dto.UserDto;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public interface UserDao {

    void insertUser(UserDto userDto);
    List<UserDto> selectUser(String userId);
    void deleteUser(Long userNo);
}
