package com.assignment.shoppingbasketserver.controller;

import com.assignment.shoppingbasketserver.dao.BasketDao;
import com.assignment.shoppingbasketserver.dao.OrdersDao;
import com.assignment.shoppingbasketserver.dao.UserDao;
import com.assignment.shoppingbasketserver.dto.BasketDto;
import com.assignment.shoppingbasketserver.dto.UserDto;
import com.assignment.shoppingbasketserver.util.Message;
import com.assignment.shoppingbasketserver.util.StringToInteger;
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
    @PostMapping("")
    public ResponseEntity<Message> insertUser(@RequestBody UserVo userVo){

        Message message = new Message();
        HttpStatus httpStatus = null;

        if(userVo.getUserId() == null || userVo.getUserName() == null || userVo.getUserPw() == null || userVo.getUserAddress() == null){
            message.setMessage("올바르지 않은 입력 데이터입니다.");
            message.setData(userVo);
            httpStatus = HttpStatus.BAD_REQUEST;
        }
        else{
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
        }

        return new ResponseEntity<>(message, httpStatus);
    }

    /**
     * 유저 검색
     * @param userId
     * @return 성공, 실패 여부에 따라 메시지 및 결과 리턴
     */
    @GetMapping({"", "/{userId}"})
    public ResponseEntity<Message> selectUser(@PathVariable(required = false) String userId){

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
    @DeleteMapping("/{userNo}")
    public ResponseEntity<Message> deleteUser(@PathVariable String userNo){

        Message message = new Message();
        HttpStatus httpStatus = null;

        if(!StringToInteger.isInteger(userNo)){
            message.setMessage("입력한 값이 정수형이 아닙니다.");
            message.setData("입력한 값 : " + userNo);
            httpStatus = HttpStatus.BAD_REQUEST;
        }
        else{
            UserDto userCheckDto = userDao.selectUserByNo(Integer.parseInt(userNo));

            if(userCheckDto == null){
                message.setMessage("조건에 맞는 유저가 없습니다.");
                message.setData("입력한 회원번호 : " + userNo);
                httpStatus = HttpStatus.BAD_REQUEST;
            }
            else{
                int result = userDao.deleteUser(Integer.parseInt(userNo));

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
        }

        return new ResponseEntity<>(message, httpStatus);
    }
}