package com.assignment.shoppingbasketserver.controller;

import com.assignment.shoppingbasketserver.dao.UserDao;
import com.assignment.shoppingbasketserver.dto.UserDto;
import com.assignment.shoppingbasketserver.vo.UserVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class UserController {

    @Autowired
    private UserDao userDao;

    /**
     * 유저 회원가입
     * @param userVo
     */
    @RequestMapping("/user/insert")
    public void insertUser(UserVo userVo){

        UserDto userDto = UserDto.builder()
                .userId(userVo.getUserId())
                .userPw(userVo.getUserPw())
                .userName(userVo.getUserName())
                .userAddress(userVo.getUserAddress())
                .build();

        userDao.insertUser(userDto);
    }

    /**
     * 유저 검색(파라미터 값이 없으면 전체 검색)
     * @param userId
     * @return
     */
    @RequestMapping("/user/select")
    public List<UserDto> selectUser(@RequestParam(required = false) String userId){

        List<UserDto> userDtoList = userDao.selectUser(userId);

        return userDtoList;
    }

    /**
     * 유저 회원탈퇴
     * @param userNo
     */
    @RequestMapping("/user/delete")
    public void deleteUser(@RequestParam Long userNo){

        userDao.deleteUser(userNo);
    }

}
