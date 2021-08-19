package com.assignment.shoppingbasketserver.dao;

import com.assignment.shoppingbasketserver.dto.UserDto;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public interface UserDao {
    List<UserDto> selectUsers() throws Exception;
}
