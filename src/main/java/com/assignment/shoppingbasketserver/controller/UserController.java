package com.assignment.shoppingbasketserver.controller;

import com.assignment.shoppingbasketserver.dao.UserDao;
import com.assignment.shoppingbasketserver.dto.UserDto;
import com.assignment.shoppingbasketserver.util.Message;
import com.assignment.shoppingbasketserver.vo.UserVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/user")
public class UserController {

    @Autowired
    private UserDao userDao;

    /**
     * 유저 회원가입
     * @param userVo
     * @return 성공, 실패 여부에 따라 메시지 및 결과 리턴
     */
    @RequestMapping("/insert")
    public ResponseEntity<Message> insertUser(UserVo userVo){

        Message message = new Message();
        HttpStatus httpStatus = null;

        List<UserDto> userCheckDtoList = userDao.selectUserById(userVo.getUserId());

        if(userCheckDtoList.size() != 0){

            message.setMessage("이미 존재하는 아이디입니다.");
            message.setData(userCheckDtoList);
            httpStatus = HttpStatus.BAD_REQUEST;
        }
        else{
            UserDto userDto = UserDto.builder()
                    .userId(userVo.getUserId())
                    .userPw(userVo.getUserPw())
                    .userName(userVo.getUserName())
                    .userAddress(userVo.getUserAddress())
                    .build();

            int result = userDao.insertUser(userDto);

            if(result != 0){
                message.setMessage("유저 회원가입 성공하셨습니다.");
                message.setData(userDto);
                httpStatus = HttpStatus.OK;
            }
            else{
                message.setMessage("유저 회원가입 실패하셨습니다.");
                message.setData(null);
                httpStatus = HttpStatus.BAD_REQUEST;
            }
        }

        return new ResponseEntity<>(message, httpStatus);
    }

    /**
     * 유저 검색(파라미터 값이 없으면 전체 검색)
     * @param userId
     * @return 성공, 실패 여부에 따라 메시지 및 결과 리턴
     */
    @RequestMapping("/select")
    public ResponseEntity<Message> selectUser(@RequestParam(required = false) String userId){

        Message message = new Message();
        HttpStatus httpStatus = null;

        List<UserDto> userDtoList = userDao.selectUserById(userId);

        if(userDtoList.size() == 0){
            message.setMessage("조건에 맞는 유저가 없습니다.");
            message.setData("입력한 유저 아이디 : " + userId);
            httpStatus = HttpStatus.BAD_REQUEST;
        }
        else{
            message.setMessage("유저 목록 조회 성공하셨습니다.");
            message.setData(userDtoList);
            httpStatus = HttpStatus.OK;
        }

        return new ResponseEntity<>(message, httpStatus);
    }

    /**
     * 유저 회원탈퇴
     * @param userNo
     * @return 성공, 실패 여부에 따라 메시지 및 결과 리턴
     */
    @RequestMapping("/delete")
    public ResponseEntity<Message> deleteUser(@RequestParam Long userNo){

        Message message = new Message();
        HttpStatus httpStatus = null;

        UserDto userCheckDto = userDao.selectUserByNo(userNo);

        if(userCheckDto == null){
            message.setMessage("조건에 맞는 유저가 없습니다.");
            message.setData("입력한 회원번호 : " + userNo);
            httpStatus = HttpStatus.BAD_REQUEST;
        }
        else{
            int result = userDao.deleteUser(userNo);

            if(result != 0){
                message.setMessage("유저 회원탈퇴 성공하셨습니다.");
                message.setData(userCheckDto);
                httpStatus = HttpStatus.OK;
            }
            else{
                message.setMessage("유저 회원탈퇴 실패하셨습니다.");
                message.setData(userCheckDto);
                httpStatus = HttpStatus.BAD_REQUEST;
            }
        }

        return new ResponseEntity<>(message, httpStatus);
    }
}