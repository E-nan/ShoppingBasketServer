package com.assignment.shoppingbasketserver.controller;

import com.assignment.shoppingbasketserver.dao.BasketDao;
import com.assignment.shoppingbasketserver.dao.ItemDao;
import com.assignment.shoppingbasketserver.dao.UserDao;
import com.assignment.shoppingbasketserver.dto.BasketDto;
import com.assignment.shoppingbasketserver.dto.BasketJoinItemDto;
import com.assignment.shoppingbasketserver.dto.ItemDto;
import com.assignment.shoppingbasketserver.dto.UserDto;
import com.assignment.shoppingbasketserver.util.Message;
import com.assignment.shoppingbasketserver.vo.BasketVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/basket")
public class BasketController {

    @Autowired
    private BasketDao basketDao;

    @Autowired
    private UserDao userDao;

    @Autowired
    private ItemDao itemDao;

    /**
     * 장바구니 상품 추가
     * @param basketVo
     * @return 성공, 실패 여부에 따라 메시지 및 결과 리턴
     */
    @PostMapping("")
    public ResponseEntity<Message> insertBasket(@RequestBody BasketVo basketVo){

        Message message = new Message();
        HttpStatus httpStatus = null;

        if(basketVo.getUserNo() == 0 || basketVo.getItemNo() == 0){
            message.setMessage("올바르지 않은 데이터입니다.");
            message.setData(basketVo);
            httpStatus = HttpStatus.BAD_REQUEST;
        }
        else{
            UserDto userDto = userDao.selectUserByNo(basketVo.getUserNo());
            ItemDto itemDto = itemDao.selectItemByNo(basketVo.getItemNo());

            if(userDto == null){
                message.setMessage("존재하지 않는 유저입니다.");
                message.setData(basketVo);
                httpStatus = HttpStatus.BAD_REQUEST;
            }
            else if(itemDto == null){
                message.setMessage("존재하지 않는 상품입니다.");
                message.setData(basketVo);
                httpStatus = HttpStatus.BAD_REQUEST;
            }
            else{
                List<BasketDto> basketDtoList = basketDao.selectBasket(basketVo);

                if(basketDtoList.size() != 0){
                    BasketDto basketDto = basketDtoList.get(0);

                    int result = basketDao.updateBasket(basketDto);

                    if(result != 0){
                        List<BasketDto> basketUpdateDtoList = basketDao.selectBasket(basketVo);
                        BasketDto basketUpdateDto = basketUpdateDtoList.get(0);

                        message.setMessage("기존 장바구니 상품 개수 증가하였습니다.");
                        message.setData(basketUpdateDto);
                        httpStatus = HttpStatus.OK;
                    }
                    else{
                        message.setMessage("기존 장바구니 상품 개수 증가 실패하셨습니다.");
                        message.setData(null);
                        httpStatus = HttpStatus.BAD_REQUEST;
                    }
                }
                else{
                    BasketDto basketDto = BasketDto.builder()
                            .userNo(basketVo.getUserNo())
                            .itemNo(basketVo.getItemNo())
                            .build();

                    int result = basketDao.insertBasket(basketDto);

                    if(result != 0){
                        message.setMessage("장바구니 상품 추가 성공하셨습니다.");
                        message.setData(basketDto);
                        httpStatus = HttpStatus.OK;
                    }
                    else{
                        message.setMessage("장바구니 상품 추가 실패하셨습니다.");
                        message.setData(basketDto);
                        httpStatus = HttpStatus.BAD_REQUEST;
                    }
                }
            }
        }

        return new ResponseEntity<>(message, httpStatus);
    }

    /**
     * 장바구니 상품 검색(상품번호가 없으면 전체 검색)
     * @param basketVo
     * @return
     */
    @GetMapping("")
    public ResponseEntity<Message> selectBasket(@RequestBody(required = false) BasketVo basketVo){

        Message message = new Message();
        HttpStatus httpStatus = null;

        List<BasketJoinItemDto> basketJoinItemDtoList = basketDao.selectBasketJoinItem(basketVo);

        if(basketJoinItemDtoList.size() == 0){
            message.setMessage("조건에 맞는 회원이 존재하지 않습니다.");
            message.setData(basketVo);
            httpStatus = HttpStatus.BAD_REQUEST;
        }
        else{
            message.setMessage("장바구니 조회 성공하셨습니다.");
            message.setData(basketJoinItemDtoList);
            httpStatus = HttpStatus.OK;
        }

        return new ResponseEntity<>(message, httpStatus);
    }

    /**
     * 장바구니 상품 삭제(상품번호가 없으면 전체 삭제)
     * @param basketvo
     * @return 성공, 실패 여부에 따라 메시지 및 결과 리턴
     */
    @DeleteMapping("")
    public ResponseEntity<Message> deleteBasket(@RequestBody(required = false) BasketVo basketvo){

        Message message = new Message();
        HttpStatus httpStatus = null;

        if(basketvo == null || basketvo.getUserNo() == 0){
            message.setMessage("올바르지 않은 입력 데이터입니다.");
            message.setData(basketvo);
            httpStatus = HttpStatus.BAD_REQUEST;
        }
        else{
            List<BasketDto> basketDtoList = basketDao.selectBasket(basketvo);

            if(basketDtoList.size() == 0){
                message.setMessage("조건에 맞는 회원이 존재하지 않습니다.");
                message.setData(basketvo);
                httpStatus = HttpStatus.BAD_REQUEST;
            }
            else{
                basketDao.deleteBasket(basketvo);

                message.setMessage("장바구니 삭제 성공하셨습니다.");
                message.setData(basketDtoList);
                httpStatus = HttpStatus.OK;
            }
        }

        return new ResponseEntity<>(message, httpStatus);
    }
}
