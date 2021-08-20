package com.assignment.shoppingbasketserver.dao;


import com.assignment.shoppingbasketserver.dto.UserDto;
import org.springframework.stereotype.Component;

@Component
public interface UserDao {

    void insertUser(UserDto userDto);

    void deleteUser(Long userNo);
}
