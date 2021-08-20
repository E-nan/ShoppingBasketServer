package com.assignment.shoppingbasketserver.controller;

import com.assignment.shoppingbasketserver.dao.UserDao;
import com.assignment.shoppingbasketserver.dto.UserDto;
import com.assignment.vo.UserVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
public class UserController {

    @Autowired
    private UserDao userDao;

    /**
     * 유저 회원가입 기능
     * @param userVo
     */
    @RequestMapping("/user/signUp")
    public void signUpUser(UserVo userVo){

        UserDto userDto = UserDto.builder()
                .user_id(userVo.getUser_id())
                .user_pw(userVo.getUser_pw())
                .user_name(userVo.getUser_name())
                .user_address(userVo.getUser_address())
                .build();

        userDao.insertUser(userDto);
    }

    /**
     * 유저 회원탈퇴 기능
     */
    @RequestMapping("/user/signOut")
    public void signOutUser(@RequestParam Long user_no){
        userDao.deleteUser(user_no);
    }

}
