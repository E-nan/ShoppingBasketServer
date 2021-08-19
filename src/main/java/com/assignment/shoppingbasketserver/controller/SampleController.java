package com.assignment.shoppingbasketserver.controller;

import com.assignment.shoppingbasketserver.dao.UserDao;
import com.assignment.shoppingbasketserver.dto.UserDto;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@MapperScan(basePackages = "com.assignment.shoppingbasketserver.dao")
public class SampleController {

    @Autowired
    private UserDao userDao;

    @RequestMapping("/user")
    public List<UserDto> selectUsers() throws Exception{
        List<UserDto> userDtoList = userDao.selectUsers();
        return userDtoList;
    }
}
